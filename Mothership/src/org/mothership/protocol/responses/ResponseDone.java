package org.mothership.protocol.responses;

import org.mothership.protocol.Response;

/**
 * A response used to indicate that ?
 * 
 * @author Peter Oomen
 */
public class ResponseDone extends Response {
	protected ResponseDone(int code, String message) {
		super(100, "Done", false);
	}
}
