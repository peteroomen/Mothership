package org.mothership.scripts;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

public class Script {
	private String name;
	private String description;
	private Image icon;
	private String path;
	private Process proc;
	
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
			proc = Runtime.getRuntime().exec(path); // executes scripts
			proc.waitFor();
			System.out.println(proc.exitValue());
		} catch (IOException e) {
			return -1;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return proc.exitValue();
	}
	
	public String getName(){
		return name;
	}

	public InputStream getIn() {
		return proc.getInputStream();
	}
}