package org.mothership.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Session {
	private ServerSocket sSocket;
	private List<Connection> connectionList = new ArrayList<Connection>();
	/**
	 * Creates a new session and set up new Socket
	 */
	public Session() {
		try {
			sSocket = new ServerSocket(0); // new server socket on random port
			newConnection();
		} catch (IOException e) {

		}
	}

	
	private void newConnection() { // IDEA: rename to run for threading
		//NOTES may not need connectionList
		try {
			System.out.println(getPort()); // REMOVE FOR DEBUG use(won't matter when threaded)
			Socket sock = sSocket.accept();
			connectionList.add(new Connection(sock));
		} catch (Exception e) {

		}
	}

	/**
	 * Returns the port number for this session.
	 * 
	 * @return int Sessions port number
	 */
	public int getPort() {
		return sSocket.getLocalPort();
	}
	
	/**
	 * Closes this Session
	 */
	public void close() {
		try {
			sSocket.close();
		} catch (Exception e) {

		}
	}
}
