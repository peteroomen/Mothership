package org.mothership.scripts;

import java.awt.Image;
import java.io.IOException;

public class Script {
	private String name;
	private String description;
	private Image icon;
	private String path;
	
	public Script(String name, String description, String path){
		this.name = name;
		this.description = description;
		this.path = path + name + ".sh";
		
		//TODO set image icon
	}
	
	/**
	 * Execute this script
	 * @return int exit code this script
	 */
	public int execute(){
		Process proc;
		try {
			proc = Runtime.getRuntime().exec(path); // executes scripts
		} catch (IOException e) {
			return -1;
		}
		return proc.exitValue();
	}
	
	public String getName(){
		return name;
	}
}
