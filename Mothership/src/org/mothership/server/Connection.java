package org.mothership.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
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

		}
	}

	@Override
	public void run() {
		String line;
		super.run();
		
		//Interpreter handle = new Interpreter(this);
		
		// All for testing purposes
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(input));
			while ((line = in.readLine()) != null) {
				System.out.println("Connection: " + line);
				// hand off to interpreter
			}
		} catch (Exception e) {

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

}