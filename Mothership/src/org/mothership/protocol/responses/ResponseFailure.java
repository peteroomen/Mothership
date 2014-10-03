package org.mothership.protocol.responses;

import org.mothership.protocol.Response;

/**
 * A response used to indicate a command failed, with the reason for failure given as args
 * 
 * @author Peter Oomen
 */
public class ResponseFailure extends Response {
	protected ResponseFailure() {
		super(301, "Failure", true);
	}
}
