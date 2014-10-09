package org.mothership.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
	private static Server instance = null;
	private static List<Session> sessionList = new ArrayList<Session>();

	public static void main(String arg[]) {

		try {
			ServerSocket sSocket = new ServerSocket(48080);

			while (true) {
				Socket connection = sSocket.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(
						connection.getInputStream()));
				PrintWriter out = new PrintWriter(connection.getOutputStream(), true);

				// check for new valid connection and setup new session
				if (in.readLine().startsWith("hello")) {
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
	public static Server getInstance() {
		if (instance == null) {
			instance = new Server();
		}
		return instance;
	}
}