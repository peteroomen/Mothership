package org.mothership.protocol.responses;

import org.mothership.protocol.Response;

/**
 * A response used to indicate that a connection has finished, whether or not the
 * command was successful.
 * 
 * @author Peter Oomen
 */
public class ResponseDone extends Response {
	public ResponseDone() {
		super(100, "Done", false);
	}
}
