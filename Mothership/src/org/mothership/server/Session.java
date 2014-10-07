package org.mothership.server;

import java.io.IOException;
import java.net.ServerSocket;

public class Session {
	private ServerSocket sSocket;

	/**
	 * Creates a new session and set up new Socket
	 */
	public Session() {
		try {
			sSocket = new ServerSocket(0);
		} catch (IOException e) {

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
