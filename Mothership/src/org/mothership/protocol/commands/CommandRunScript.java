package org.mothership.protocol.commands;

import org.mothership.server.Connection;
import org.mothership.protocol.Command;

public class CommandRunScript extends Command {

	public CommandRunScript(Connection connection) {
		super("runScript", "Runs a script with given name", connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int execute(String args) {
		// TODO Auto-generated method stub
		return 0;
	}

}
