package n1exercici2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) throws IOException {
		Scanner sc =new Scanner(System.in);
		System.out.println("Introduce Path:");
		String path = sc.next();
		listar(path);			
	}
	
	public static void listar(String path) throws IOException {
		File dir = new File(path);
		String[] ficheros = dir.list();
		for(String s:ficheros) {
			File pepe = new File(path+"/"+s);
			if (pepe.isDirectory()) {
				System.out.println("<DIR> \t"+path+"/"+s);
				listar(path+"/"+s);
			}else {
				System.out.println("<FILE>\t"+path+"/"+s);
			}		
		}
	}
}
