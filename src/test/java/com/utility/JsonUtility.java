package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojos.Config;
import com.ui.pojos.Environment;

public class JsonUtility {

	public static Environment readJson(Env env)
	{
		Gson gson = new Gson();
		
		File jsonFile = new File(System.getProperty("user.dir")+File.separator+"config"+File.separator+"Config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Config config =	gson.fromJson(fileReader , Config.class);
		Environment environment =	config.getEnvironments().get("QA");
		return environment;
	}
}
