package org.mothership.scripts;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

public class Script {
	private String name;
	private String description;
	private Image icon;
	private String path;
	private ProcessBuilder proc;
	private InputStream in = null;
	
	public Script(String name, String description, String path){
		this.name = name;
		this.description = description;
		this.path = path + name + ".sh";
		proc = new ProcessBuilder("/bin/sh", path);
		
		//TODO set image icon
	}
	
	/**
	 * Execute this script
	 * @return int exit code this script
	 */
	public void execute(){
		Process p;
		try {
			p = proc.start();
			in = p.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getName(){
		return name;
	}

	public InputStream getIn() {
		return in;
	}
}
