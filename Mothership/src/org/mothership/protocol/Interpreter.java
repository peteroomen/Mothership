package org.mothership.protocol;

import org.mothership.Connection;
import org.mothership.protocol.responses.ResponseInvalidCommand;

/**
 * Class used to interpret lines sent to the server from a client
 * 
 * @author Peter Oomen
 */
public class Interpreter {
	
	/** Factory for command objects */
	private CommandFactory cf;
	private Connection connection;
	
	/** Connection object used to send responses to the client */
	public Interpreter(Connection connection) {
		this.connection = connection;
		cf = new CommandFactory(connection);
	}
	
	/**
	 * Interpret a line sent to the server by a client. Executes a command 
	 * 
	 * @param line
	 * @return int exit value for the command that was executed
	 */
	public int interpretLine(String line) {
		String name;
		String args;
		String[] sLine = line.split(" ");
		name = sLine[0];
		if (sLine.length > 1) args = sLine[1];
		else args = "";
		
		Command c = cf.getCommandWithName(name);
		if (c == null) {
			Response r = ResponseFactory.getInstance().getResponseOfType(ResponseInvalidCommand.class);
			connection.sendLine(r.getResponseString(name));
			return 1;
		}
		return c.execute(args);
	}
}
