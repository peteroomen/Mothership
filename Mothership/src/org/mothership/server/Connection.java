package org.mothership.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Connection extends Thread{
	private Socket sock;
	private InputStream input;
	private OutputStream output;
	
	//Testing Only
	public Connection(Socket sSock) {
		
		sock = sSock;
	}
	
	@Override
	public void run(){
		String line;
		super.run();
		// All for testing purposes
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					sock.getInputStream()));
			while ((line = in.readLine()) != null) {
				System.out.println("Connection: " + line); 
				// hand of to interpreter
			}
		} catch (Exception e) {

		}
	}
	
	public void sendLine(String responseString) {
		// TODO Auto-generated method stub
		
	}

}