package org.mothership.protocol;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.mothership.server.Connection;
import org.mothership.protocol.commands.*;

/**
 * A factory object for creating command objects.
 * 
 * @author Peter Oomen
 */
public class CommandFactory {
	/** HashMap containing the command instances */
	HashMap<String, Command> commands = new HashMap<>();
	
	/** Connection this factory is creating commands for */
	private Connection connection;
	
	public CommandFactory(Connection connection) {
		this.connection = connection;
	}
 	
	/**
	 * Gets a command object with given name
	 * 
	 * @param name
	 * @return command object with given name
	 */
	public Command getCommandWithName(String name) {
		if (commands.get(name) != null) return commands.get(name);
		else {
			try {
				String nameCap = "org.mothership.protocol.commands.Command" + name.substring(0,1).toUpperCase() + name.substring(1);
				Class type = (Class<Command>) Class.forName(nameCap);
				Constructor c = type.getConstructor(Connection.class);
				Command com = (Command) c.newInstance(connection);
				commands.put(name, com);
				return com;
			} catch (InstantiationException e) {
				System.err.println("ERROR: " + e);
				return null;
			} catch (IllegalAccessException e) {
				System.err.println("ERROR: " + e);
				return null;
			} catch (ClassNotFoundException e) {
				System.err.println("ERROR: " + e);
				return null;
			} catch (NoSuchMethodException e) {
				System.err.println("ERROR: " + e);
				return null;
			} catch (SecurityException e) {
				System.err.println("ERROR: " + e);
				return null;
			} catch (IllegalArgumentException e) {
				System.err.println("ERROR: " + e);
				return null;
			} catch (InvocationTargetException e) {
				System.err.println("ERROR: " + e);
				return null;
			}
		}
	}
}
