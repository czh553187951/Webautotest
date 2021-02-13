package test.czh.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String FilePath;
		String user;
		Properties properties=new Properties();
		try {
			FileInputStream fileInputStream=new FileInputStream("element.properties");
			BufferedInputStream In=new BufferedInputStream(fileInputStream);
			try {
				properties.load(In);
				user=properties.getProperty("username");
				System.out.println(user);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
