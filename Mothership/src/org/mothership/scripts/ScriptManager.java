package org.mothership.scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Finds scripts in scripts folder and keeps track of their details
 * @author Nicholas Ross(nmr13)
 *
 */
public class ScriptManager {
	private ArrayList<Script> scriptList = new ArrayList<Script>();
	private String scriptPath = System.getProperty("user.home") + "/Scripts"; // location of scripts
	
	public ScriptManager() {
		File scriptsDir = new File(scriptPath);
		File[] scriptArray;
		String scriptConfigPath;
		Properties prop = new Properties();
		
		// Detect if script folder exists
		if(scriptsDir.exists()){
			scriptArray = scriptsDir.listFiles(); // get all file/folders in script directory.
			
			// go through all subfolder looking for conf.properties
			for (int i = 0; i < scriptArray.length; i++) {
				if (scriptArray[i].isDirectory()) {
					scriptConfigPath = scriptArray[i].getPath()+ "/conf.properties";

					// read conf.properties file and generate script object from that.
					try {
						InputStream inputStream = new FileInputStream(scriptConfigPath); // get conf.properties file
						prop.load(inputStream);			
						scriptList.add(new Script(prop.getProperty("name"), 	// add new script to scriptList
								prop.getProperty("description"), scriptArray[i]
										.getPath()));
						
					} catch (FileNotFoundException notFound) {
						System.err.println("No conf.properties found in "
								+ scriptArray[i].getName());
					} catch (Exception e) {
						System.err.println(e);
					}
				}
			}
			
		}else{
			System.err.println("Can not find scripts directory");
		}
	}

	/**
	 * Gets all scripts available
	 * @return ArrayList<Script> Script List
	 */
	public ArrayList<Script> getScriptList(){
		return scriptList;
	}
	
	/**
	 * Given a name of a script return that script
	 * @param name Name of script to get
	 * @return Script Script object
	 */
	public Script getScriptByName(String name){
		// search for script
		for(Script s : scriptList){
			if(s.getName().equals(name))
				return s;
		}
		// no script found
		return null;	
	}
}
