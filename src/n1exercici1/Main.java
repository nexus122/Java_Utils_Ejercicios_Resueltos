package n1exercici1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce path fichero:");
		String path = sc.next();
		File dir = new File(path);
		String[] ficheros = dir.list();
		for(String s:ficheros) {
			File pepe = new File(path+"/"+s);
			if (pepe.isDirectory()) {
				System.out.println("<DIR> \t"+path+"/"+s);
			}else {
				System.out.println("<FILE>\t"+path+"/"+s);
			}		
		}
	}
}
