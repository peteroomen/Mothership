package org.mothership.scripts;

import java.awt.Image;

public class Script {
	private String name;
	private String description;
	private Image icon;
	
	public Script(String name, String description, Image icon){
		this.name = name;
		this.description = description;
		this.icon = icon;
	}
	
	/**
	 * Execute this script
	 * @return int exit code this script
	 */
	public int execute(){
		// Process p = Runtime.getRuntime().exec(file path/name);
		return 0;
	}
	
	public String getName(){
		return name;
	}
}
