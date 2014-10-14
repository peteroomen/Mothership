package org.mothership.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Session extends Thread {
	private ServerSocket sSocket;
	private List<Connection> connectionList = new ArrayList<Connection>();
	
	/**
	 * Creates a new session and set up new Socket
	 */
	public Session() {
		try {
			//sSocket = new ServerSocket(0); // new server socket on random port
			sSocket = new ServerSocket(48081); // temp
		} catch (IOException e) {
			
		}
	}

	@Override
	public void run() {
		super.run();
		while (true) {
			try {
				Connection newConnection = new Connection(sSocket.accept());
				newConnection.start();
				connectionList.add(newConnection);
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

