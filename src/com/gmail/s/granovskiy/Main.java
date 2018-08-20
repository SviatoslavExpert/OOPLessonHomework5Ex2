package com.gmail.s.granovskiy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	public static void main(String[] args) {
		
		/*  getting words from files  */
		String text1 = loadFromFile(new File("HelloJavaFile.txt")); // extension should be .txt !!!
		String text2 = loadFromFile(new File("HelloWorldFile.txt"));
		
		/*  splitting words in files  */
		String[] arrayOne = text1.split(" ");
		String[] arrayTwo = text2.split(" ");
		
		/*  making a File Of Common Elements */
		makeFileOfCommonElements(arrayOne, arrayTwo);
		System.out.println("The File Of Common Elements is created.");
	}

	public static void makeFileOfCommonElements(String[] a, String[] b) {		
		try (PrintWriter pw = new PrintWriter("c.txt")){
			for(int i = 0; i < a.length; i++) {
				for(int j = 0; j < a.length; j++) {
					if(a[i].equals(b[j])) {
						pw.println(a[i]);
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR FILE WRITE");
		}
	}

	public static String loadFromFile(File file) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				sb.append(text).append(System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return sb.toString();
	}
}
// cntrl+shift+f to format code
