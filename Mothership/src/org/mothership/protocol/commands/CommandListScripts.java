package org.mothership.protocol.commands;

import org.mothership.server.Connection;
import org.mothership.protocol.Command;
import org.mothership.protocol.Response;
import org.mothership.protocol.ResponseFactory;
import org.mothership.protocol.responses.ResponseDone;

public class CommandListScripts extends Command {
	
	public CommandListScripts(Connection connection) {
		super("listScripts", "help", connection);
	}

	@Override
	public int execute(String args) {
		System.out.println("Listing scripts...");
		String res = ResponseFactory.getInstance().getResponseOfType(ResponseDone.class).getResponseString("");
		connection.sendLine(res);
		// TODO Auto-generated method stub
		return 0;
	}

}
