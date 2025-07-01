package com.ui.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Environment;
import com.ui.pojo.Configuration;


public class JSONEnvriUtility {
	
public static Environment readJSON(Env name) {
		
		File file = new File(System.getProperty("user.dir")+"/config/envConfig.json");
		FileReader fileReader=null;
		try {
			 fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Gson gson = new Gson();
		Configuration congi= gson.fromJson(fileReader, Configuration.class);
		
		
		Environment env =  congi.getEnvironment().get(""+name+"");
		
		return env;
		
	}
}
