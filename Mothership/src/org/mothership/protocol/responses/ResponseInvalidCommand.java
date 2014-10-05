package org.mothership.protocol.responses;

import org.mothership.protocol.Response;

/**
 * A response used to indicate the server was given an invalid command.
 * 
 * @author Peter Oomen
 */
public class ResponseInvalidCommand extends Response {
	public ResponseInvalidCommand() {
		super(302, "Invalid command", false);
	}
}
