package com.ssi.task5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MyFileReader {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter a file name");
		String fileName = sc.next();
		File file=new File(fileName);
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader bf=new BufferedReader(fr);
		int ch;
		while((ch=bf.read())!=-1)
		{
			System.out.print((char)ch);
		}
		fr.close();
		file.delete();
		
	}

}
