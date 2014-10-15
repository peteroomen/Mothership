package org.mothership.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

import org.mothership.protocol.Interpreter;

public class Connection extends Thread {
	private Socket sock;
	private InputStream input;
	private OutputStream output;

	/**
	 * Create new Connection
	 * @param sSock Socket connected to client
	 */
	public Connection(Socket sSock) {

		sock = sSock;
		try {
			output = sock.getOutputStream();
			input = sock.getInputStream();
		} catch (Exception e) {
			System.err.println("Failed to get streams for connection: " + e.getMessage());
		}
	}

	@Override
	public void run() {
		String line;
		Interpreter interpret = new Interpreter(this);	

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(input));
			while ((line = in.readLine()) != null) {
				//System.out.println(line);
				interpret.interpretLine(line);
			}
		} catch (Exception e) {
			System.err.println("Failed to interpret line: " + e.getMessage() + " " + e.getClass().toString());
		}
	}

	/**
	 * Send response by to client on this connection
	 * @param responseString response to be sent
	 */
	public void sendLine(String responseString) {
		PrintStream printStream = new PrintStream(output, true);
		printStream.println(responseString);
	}
	
	/**
	 * Send bytes to client
	 * @param responseBytes Byte array of data to be send to client
	 */
	public void sendBytes(byte[] responseBytes){
		try {
			output.write(responseBytes);
		} catch (IOException e) {
			System.err.println(e);
		} catch (NullPointerException np){
			System.err.println("responseByte Array Null");
		}
	}

	public void sendChar(char c) {
		try {
			output.write((byte)c);
		} catch (IOException e) {
		}		
	}

}