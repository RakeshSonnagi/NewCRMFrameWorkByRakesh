package com.comcast.crm.FileUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility{
	
	public String getDataFromJSON(String key) throws FileNotFoundException, IOException, ParseException {
	
	JSONParser par= new JSONParser();
	Object obj = par.parse(new FileReader("./Utility_Files/data1.json"));
	JSONObject jobj=(JSONObject) obj;
	Object data = jobj.get(key);
	return (String) data;
	
}
}