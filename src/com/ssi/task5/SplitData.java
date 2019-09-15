package com.ssi.task5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class SplitData {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file name");
		String file = sc.next();
		System.out.println("Enter no of splits");
		int splits = sc.nextInt();
		InputStream is = null;
		OutputStream os = null;
		byte[] bufr;
		File fl = new File(file);
		if (fl.exists() && fl.isFile()) {
			int rem = (int) (fl.length() % splits);
			int splitFileSize = (int) ((fl.length() - rem) / splits);
			int off = 0;
			bufr = new byte[splitFileSize];
			is = new FileInputStream(file);
			for (int i = 1; i <= splits; ++i) {
				String fileName = file.substring(0, file.indexOf('.')) + i + file.substring(file.indexOf('.'));
				fl = new File(fileName);
				fl.createNewFile();
				try {
					os = new FileOutputStream(fileName);
					is.read(bufr,0, splitFileSize);
					os.write(bufr);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO: handle exception
				}
				off += splitFileSize+1;
				if (i == splits - 1) {
					splitFileSize += rem;
					bufr = new byte[splitFileSize];

				} else
					bufr = new byte[splitFileSize];
			}
		}

		else {
			System.out.println("File Not Found");
		}

		sc.close();

	}

}
