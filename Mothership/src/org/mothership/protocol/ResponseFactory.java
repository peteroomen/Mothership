package org.mothership.protocol;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;


/**
 * A factory object used for creating response objects. Is a singleton, so it can be accessed from anywhere.
 * 
 * @author Peter Oomen
 */
public class ResponseFactory {
	/** Singleton instance of this class */
	private static ResponseFactory instance;
	
	/**
	 * Get the singleton instance of this class
	 * 
	 * @return the instance of this singleton class
	 */
	public static synchronized ResponseFactory getInstance() {
		if (instance == null) return new ResponseFactory();
		else return instance;
	}
	
	/** HashMap containing the response objects */
	HashMap<Class<Response>, Response> responses = new HashMap<>();

	/**
	 * Private default constructor for this class
	 */
	private ResponseFactory() { }
	
	/**
	 * Gets a response object of the given type
	 * 
	 * @param type
	 * @return response object of given type
	 */
	public Response getResponseOfType(Class type) {
		Class<Response> rType = (Class<Response>) type;
		
		if (responses.get(type) != null) return responses.get(type);
		else {
			try {
				Response res = rType.newInstance();
				responses.put(rType, res);
				return res;
			} catch (InstantiationException e) {
				System.err.println("ERROR: " + e);
				return null;
			} catch (IllegalAccessException e) {
				System.err.println("ERROR: " + e);
				return null;
			} catch (SecurityException e) {
				System.err.println("ERROR: " + e);
				return null;
			} catch (IllegalArgumentException e) {
				System.err.println("ERROR: " + e);
				return null;
			}
		}
	}
}
