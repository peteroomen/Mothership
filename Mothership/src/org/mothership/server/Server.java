package org.mothership.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.mothership.scripts.ScriptManager;

public class Server {
	private static Server instance = null;
	
	private List<Session> sessionList = new ArrayList<Session>();
	private ScriptManager sm;

	public static void main(String arg[]) {
		instance = new Server();
		instance.start();
	}
	
	private void start() {
		String line;
		synchronized (Server.class) {
			sm = new ScriptManager();
		}
		
		try {
			ServerSocket sSocket = new ServerSocket(48080);

			while (true) {
				Socket connection = sSocket.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(
						connection.getInputStream()));
				PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
				
				// input text (should be 'hello' for valid connection)
				line = in.readLine();
				
				// check for new valid connection and setup new session
				if (line != null && line.startsWith("hello")) {
					System.out.println("Creating new session");
					Session sesh = new Session();
					sesh.start();
					sessionList.add(sesh);
					out.println("420 Hello:" + sessionList.get(sessionList.size()-1).getPort()); // send response(420 Hello:<port>)
				}
				connection.close();
			}

		} catch (IOException e) {
			// Some exception
		}
	}

	/**
	 * Gets instance of server
	 * @return Instance of this server
	 */
	public static synchronized Server getInstance() {
		return instance;
	}

	public ScriptManager getScriptManager() {
		return sm;
	}
}