package org.mothership.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.mothership.scripts.ScriptManager;

/**
 * Sets up a server listing on port 48080 then creates sessions for each client
 * once authenticated. 
 * @author Nicholas Ross(nmr13)
 */
public class Server {
	private static Server instance = null;
	private static List<Session> sessionList = new ArrayList<Session>();
	private ScriptManager sm;

	public static void main(String arg[]) {
		instance = new Server();
	}
	
	public Server() {
		String line;
		sm = new ScriptManager();
		try {
			ServerSocket sSocket = new ServerSocket(48080);

			while (true) {
				Socket connection = sSocket.accept(); // accept connection
				BufferedReader in = new BufferedReader(new InputStreamReader(
						connection.getInputStream()));
				PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
				
				// input text (should be 'hello' for valid connection)
				line = in.readLine();
				
				// check for new valid connection and setup new session
				if (line != null && line.startsWith("hello")) {
					System.out.println("Creating new session");
					Session sesh = new Session();
					sesh.start(); // start session thread
					sessionList.add(sesh);
					out.println("420 Hello:" + sessionList.get(sessionList.size()-1).getPort()); // send response(420 Hello:<port>)
				}
				connection.close();
			}

		} catch (IOException e) {
			System.err.println("Server setup :" + e.getMessage());
		}
	}

	/**
	 * Gets instance of server
	 * @return Instance of this server
	 */
	public synchronized static Server getInstance() {
		if (instance == null) {
			instance = new Server();
		}
		return instance;
	}

	/**
	 * Gets scriptManger for this server
	 * @return ScriptManger scriptManger
	 */
	public ScriptManager getScriptManager() {
		return sm;
	}
}