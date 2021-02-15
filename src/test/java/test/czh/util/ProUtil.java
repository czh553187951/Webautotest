package test.czh.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProUtil {
	public Properties Pro;
	public ProUtil(String FilePath){
		Pro=RedProperties(FilePath);
	}
	public Properties RedProperties(String FilePath){
		Properties properties=new Properties();
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(FilePath);
			BufferedInputStream In=new BufferedInputStream(fileInputStream);
			properties.load(In);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return properties;
	}
	
	public String GetPro(String key){
		String Value;
		if(Pro.containsKey(key)){
			Value=Pro.getProperty(key);
			return Value;
		}
		else{
			return "";
		}
	}
	
	public int Getlines(){
		return Pro.size();
	}
	
	public static void main(String[] args) {
		ProUtil ProU=new ProUtil("element.properties");
		System.out.println(ProU.GetPro("username"));
	}

}
