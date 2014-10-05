package org.mothership.protocol.responses;

import org.mothership.protocol.Response;

/**
 * A response used to indicate a command failed catastrophically.
 * 
 * @author Peter Oomen
 */
public class ResponseCatastrophicFailure extends Response {
	public ResponseCatastrophicFailure() {
		super(300, "Catastropic failure!", false);
	}
}
