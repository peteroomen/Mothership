package org.mothership.scripts;

import java.util.ArrayList;
import java.util.List;

public class ScriptManager {
	List<Script> scriptList = new ArrayList<Script>();
	
	public ScriptManager(){
		// populate scripts list
	}
	
	/**
	 * Given a name of a script return that script
	 * @param name Name of script to get
	 * @return Script Script object
	 */
	public Script getScriptByName(String name){
		// search for script
		for(Script s : scriptList){
			if(s.getName().contains(name))
				return s;
		}
		// no script found
		return null;	
	}
}
