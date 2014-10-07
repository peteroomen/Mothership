package org.mothership.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Connection {
	private Socket sock;
	private InputStream input;
	private OutputStream output;
	

	public Connection(Socket sSock) {
		String line;
		sock = sSock;
		
		System.out.println("Connection did execute");
		// All for testing purposes
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					sSock.getInputStream()));
			while ((line = in.readLine()) != null) {
				System.out.println("Connection: " + line);
			}
		} catch (Exception e) {

		}
	}
	
	public void sendLine(String responseString) {
		// TODO Auto-generated method stub
		
	}

}