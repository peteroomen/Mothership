package org.mothership.protocol.commands;

import org.mothership.server.Connection;
import org.mothership.protocol.Command;

public class CommandKillScript extends Command {

	public CommandKillScript(Connection connection) {
		super("killScript", "Help!", connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int execute(String args) {
		// TODO Auto-generated method stub
		return 0;
	}

}
