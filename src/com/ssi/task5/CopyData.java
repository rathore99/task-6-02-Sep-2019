package com.ssi.task5;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopyData {

	public void copyContent(File dest, File src) throws IOException {
		FileReader fr = null;
		FileWriter fw = null;
		fr = new FileReader(src);
		fw = new FileWriter(dest);
		char ch ; 
		while(true) {
			ch = (char) fr.read();
			if(ch==-1)
				break;
			fw.append(ch);
		}
		fr.close();
		fw.close();
		

	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		CopyData obj = new CopyData();
		System.out.println("Enter source file name");
		// file from which data should be copied
		String srcfile = sc.next();
		System.out.println("Enter destination file name");
		// file to which data should be copy
		String destFile = sc.next();
		File fisSrc = new File(srcfile);
		File fisDist = new File(destFile);
	    
		
		
		if (fisSrc.exists() && fisSrc.isFile()) {
			if (fisDist.exists() && fisDist.isFile() ) {
				if(fisDist.canWrite()) {
				obj.copyContent(fisDist, fisSrc);
				System.out.println("file copied");
				}
				else
					System.out.println("Dont have permission to write in file");
			} else {
				System.out.println("Dest file not exists ..Creating new one");
				fisDist.createNewFile();
				obj.copyContent(fisDist, fisSrc);

			}
		} else {
			System.out.println("Source file doesn't exists");
		}
		sc.close();

	}

}
