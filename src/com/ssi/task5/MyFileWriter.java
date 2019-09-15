package com.ssi.task5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyFileWriter {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter city names as many as you know ...press any digit for exit");
		String city;
		File fis =  new File("city.txt");
		if(!fis.exists())
		fis.createNewFile();
		FileWriter fw = new FileWriter(fis,true);
		int i=0;
		
		Scanner sc = new Scanner(System.in);
		if(fis.length()==0)
		fw.write("S. NO \t\t City\n");
		while(i<5) {
			 city = sc.next();
			 city = (i+1) + "\t\t" + city+"\n"; 
			 fw.write(city);
			 i++;
			 
		}
		System.out.println("file size: "+fis.length());
		fw.close();
		sc.close();

	}

}
