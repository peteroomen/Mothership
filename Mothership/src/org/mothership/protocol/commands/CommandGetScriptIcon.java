package org.mothership.protocol.commands;

import org.mothership.Connection;
import org.mothership.protocol.Command;

public class CommandGetScriptIcon extends Command {

	public CommandGetScriptIcon(String name, String help,
			Connection connection) {
		super("getScriptIcon", "help", connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int execute(String args) {
		// TODO Auto-generated method stub
		return 0;
	}

}
