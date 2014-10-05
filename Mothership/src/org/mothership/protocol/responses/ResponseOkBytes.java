package org.mothership.protocol.responses;

import org.mothership.protocol.Response;

/**
 * A response used to indicate a command was accepted, and the server is about to send an amount of
 * bytes to the client. This amount of bytes to be sent is included as args.
 * 
 * @author Peter Oomen
 */
public class ResponseOkBytes extends Response {
	public ResponseOkBytes() {
		super(103, "Ok, bytes", true);
	}
}
