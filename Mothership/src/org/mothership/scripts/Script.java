package org.mothership.scripts;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

/**
 * Holds information about a Script
 * @author Nicholas Ross(nmr13)
 *
 */
public class Script {
	private String name;
	private String description;
	private Image icon;
	private String path;
	private Process proc;
	
	/**
	 * Creates a new instance of a script
	 * @param name 
	 * @param description 
	 * @param path script location(directory)
	 */
	public Script(String name, String description, String path){
		this.name = name;
		this.description = description;
		this.path = path + "/" + name + ".sh";
		
		//TODO set image icon
	}
	
	/**
	 * Execute this script
	 * @return int exit code this script
	 */
	public int execute() {
		try {
			proc = Runtime.getRuntime().exec(path); // executes script
			proc.waitFor();
			System.out.println(proc.exitValue());
		} catch (IOException e) {
			System.err.println("Execute IO: " + e.getMessage());
			return -1;
		} catch (InterruptedException e) {
			System.err.println("Execute Iterrupted: " + e.getMessage());
		}
		return proc.exitValue();
	}
	
	/**
	 * Get script Name
	 * @return String script Name
	 */
	public String getName(){
		return name;
	}

	/**
	 * Returns input stream for script executing
	 * @return InputStream gets input stream
	 */
	public InputStream getIn() {
		return proc.getInputStream();
	}
}