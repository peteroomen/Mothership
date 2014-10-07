package org.mothership.protocol;

import java.io.InputStream;

import org.mothership.server.Connection;

/**
 * Abstract base class for all command objects. Command objects represent commands that can
 * be given to the server.
 * 
 * @author Peter Oomen
 */
public abstract class Command {
	/** Name of the command */
	protected String name;
	
	/** Help text for the command */
	protected String help;
	
	/** Connection the command is coming from */
	protected Connection connection;
		
	/** Protected constructor for a command */
	protected Command(String name, String help, Connection connection) {
		this.name = name;
		this.help = help;
		this.connection = connection;
	}
	
	/**
	 * Execute a command with given arguments
	 * 
	 * @param args
	 * @return int exit code for the command
	 */
	public abstract int execute(String args);
	public String getName() { return name; }
	public String getHelp() { return help; }
}
