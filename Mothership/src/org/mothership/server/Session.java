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
			// newConnection();

			// Socket sock = sSocket.accept();
			newConnectionThread c1 = new newConnectionThread(sSocket);
			c1.start();

		} catch (IOException e) {
		}
	}

	class newConnectionThread extends Thread {
		ServerSocket sock;

		public newConnectionThread(ServerSocket sSock) {
			sock = sSock;
		}

		public void run() {
			System.out.println("Thread running");
			try {
				connectionList.add(new Connection(sock.accept()));
			} catch (Exception e) {

			}
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
