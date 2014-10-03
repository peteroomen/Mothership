package org.mothership.protocol.responses;

import org.mothership.protocol.Response;

public class ResponseInvalidCommand extends Response {

/**
 * A response used to indicate the server was given an invalid command
 * 
 * @author Peter Oomen
 */
	protected ResponseInvalidCommand() {
		super(302, "Invalid command", false);
	}
}
