package org.mothership.server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
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
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				PrintWriter out = new PrintWriter(connection.getOutputStream(),true);
				
				// check for new valid connection and setup new session
				if (in.readLine().startsWith("Hello")) {
					System.out.println("Creating new session");
					sessionList.add(new Session());
					System.out.println(sessionList.get(0).getPort());
					out.write("420 Hello 79090"); // send response
				}
				connection.close();
			}
			
		} catch (IOException e) {
			// Some exception
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public static Server getInstance() {
		if (instance == null) {
			instance = new Server();
		}
		return instance;
	}
}
