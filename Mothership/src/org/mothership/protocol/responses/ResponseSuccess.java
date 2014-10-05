package org.mothership.protocol.responses;

import org.mothership.protocol.Response;

/**
 * A response used to indicate a command completed successfully, with the args being the success message.
 * 
 * @author Peter Oomen
 */
public class ResponseSuccess extends Response {
	public ResponseSuccess() {
		super(101, "Success", true);
	}
}
