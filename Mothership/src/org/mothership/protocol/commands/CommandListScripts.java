package org.mothership.protocol.commands;

import java.util.ArrayList;

import org.mothership.scripts.Script;
import org.mothership.scripts.ScriptManager;
import org.mothership.server.Connection;
import org.mothership.server.Server;
import org.mothership.protocol.Command;
import org.mothership.protocol.Response;
import org.mothership.protocol.ResponseFactory;
import org.mothership.protocol.responses.ResponseDone;
import org.mothership.protocol.responses.ResponseOkText;

public class CommandListScripts extends Command {
	
	public CommandListScripts(Connection connection) {
		super("listScripts", "help", connection);
	}

	@Override
	public int execute(String args) {
		String res = ResponseFactory.getInstance().getResponseOfType(ResponseOkText.class).getResponseString("");
		connection.sendLine(res);
		
		Server serv = Server.getInstance();
		ScriptManager sm = serv.getScriptManager();
		ArrayList<Script> scripts = sm.getScriptList();
		
		for (int i = 0; i < scripts.size(); i++)
			connection.sendLine(scripts.get(i).getName());
		
		connection.sendChar((char)27);
		res = ResponseFactory.getInstance().getResponseOfType(ResponseDone.class).getResponseString("");
		connection.sendLine(res);
		
		return 0;
	}

}
