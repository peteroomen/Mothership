package org.mothership.protocol.commands;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.mothership.scripts.Script;
import org.mothership.scripts.ScriptManager;
import org.mothership.server.Connection;
import org.mothership.server.Server;
import org.mothership.protocol.Command;
import org.mothership.protocol.ResponseFactory;
import org.mothership.protocol.responses.ResponseDone;
import org.mothership.protocol.responses.ResponseOkText;

public class CommandRunScript extends Command {

	public CommandRunScript(Connection connection) {
		super("runScript", "Runs a script with given name", connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int execute(String args) {
		String res = ResponseFactory.getInstance().getResponseOfType(ResponseOkText.class).getResponseString("");
		connection.sendLine(res);
		
		Server serv = Server.getInstance();
		ScriptManager sm = serv.getScriptManager();
		Script s = sm.getScriptByName(args);

		s.execute();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getIn()));
		
		System.out.println("Execution complete");
		
		String line;
		try {
			while ((line = br.readLine()) != null) {
				connection.sendLine(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		connection.sendChar((char)27);
		res = ResponseFactory.getInstance().getResponseOfType(ResponseDone.class).getResponseString("");
		connection.sendLine(res);
		
		
		return 0;
	}

}
