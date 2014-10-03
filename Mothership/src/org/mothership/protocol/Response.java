package org.mothership.protocol;


/**
 * A response to a request from a client. Any response should inherit from this abstract class.
 * 
 * @author Peter Oomen
 */
public abstract class Response {
	/** The integer code for this response. */
	int code;
	
	/** The success/error message for this response. */
	String message;
	
	/** If true then this response can have arguments */
	boolean hasArgs;
	
	/**
	 * Creates a new Response with given parameters. hasArgs indicates if this
	 * response can have arguments
	 * 
	 * @param code
	 * @param message
	 * @param canHaveArgs
	 */
	protected Response(int code, String message, boolean hasArgs) {
		this.code = code;
		this.message = message;
		this.hasArgs = hasArgs;
	}
	
	/**
	 * Gets the integer code for this Response
	 * 
	 * @return int code of the Response
	 */
	public int getCode() { return code; }
	
	/**
	 * Gets the string representation of this Response, to be sent to a client.
	 * 
	 * @return The string representation of this Response
	 */
	public String getResponseString(String args) {
		return code + " " + message + " " + (hasArgs ? "" : ":" + args);
	}
}
