package com.ssi.task5;

import java.io.File;
import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file name you want to rename");
		String file1 = sc.next();
		System.out.println("Enter new file name for file");
		String file2 = sc.next();
		File fis = new File(file1);
		File fis2 = new File(file2);
		if (fis.exists() && fis.isFile()) {
			if (fis2.exists() && fis.isFile()) {
				System.out.println("File aleady exits");
			} else if (fis.length() < 500) {
				fis.renameTo(fis2);
				System.out.println("File name changed successflly..");
			}
		} else {
			System.out.println("File does not  exits");
		}
		sc.close();
	}

}
