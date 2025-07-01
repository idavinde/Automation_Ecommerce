package com.ui.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.User;
import com.ui.pojo.UserData;


public class JSONReadUtility {
	
	@DataProvider(name="loginTestData")
	public Iterator<User> readJSON() {
		
		File file = new File(System.getProperty("user.dir")+"/testData/loginTestData.json");
		FileReader fileReader=null;
		try {
			 fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<User> dataToReturn = new ArrayList<User>();
		
		Gson gson = new Gson();
		UserData userData= gson.fromJson(fileReader, UserData.class);
		
		for(User user : userData.getLoginTestData()) {
			
			dataToReturn.add(user);
		}
		
		return dataToReturn.iterator();
		
	}

}
