package com.jdbc.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws Exception {
		//��ȡ����
		Properties p = new Properties();
		//��ȡ�ļ�
		FileInputStream in = new FileInputStream("resource/db.properties");
		p.load(in);
		//
		p.getProperty("user");
		p.getProperty("url");
		
		
		//System.out.println(p.getProperty("user"));
		//System.out.println(p.getProperty("url"));
		
	}
}
