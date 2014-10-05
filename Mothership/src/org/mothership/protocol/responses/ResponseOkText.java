package org.mothership.protocol.responses;

import org.mothership.protocol.Response;

/**
 * A response used to indicate a command was accepted, and the server is about to send an amount of
 * text to the client.
 * 
 * @author Peter Oomen
 */
public class ResponseOkText extends Response {
	public ResponseOkText() {
		super(102, "Ok, text", false);
	}
}
