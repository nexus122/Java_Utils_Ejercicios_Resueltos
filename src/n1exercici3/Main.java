package n1exercici3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static FileWriter fw;
	
	public static void main(String args[]) throws IOException {
		Scanner sc =new Scanner(System.in);
		System.out.println("1.Listar elementos directorio");
		System.out.println("2.Leer un fichero");
		System.out.print("Introduce opcion:");
		int opcion = sc.nextInt();
		switch (opcion) {
			case 1:
				fw = new FileWriter(new File("listado.txt"));
				System.out.print("Escribe la ruta:");
				String path=sc.next();
				listar(path);
				fw.close();	
				break;
			case 2:
				System.out.print("Escribe la ruta del fichero:");
				String fichero=sc.next();
				BufferedReader fr = new BufferedReader(new FileReader(fichero));
				String s;
				while((s=fr.readLine())!=null) {
					System.out.println(s); 					
				}
				break;				
		}
			
	}
	
	public static void listar(String path) throws IOException {
		File dir = new File(path);
		String[] ficheros = dir.list();
		for(String s:ficheros) {
			File pepe = new File(path+"/"+s);
			if (pepe.isDirectory()) {
				System.out.println("<DIR> \t"+path+"/"+s);
				fw.write(path+"/"+s);
				listar(path+"/"+s);
			}else {
				System.out.println("<FILE>\t"+path+"/"+s);
				fw.write(path+"/"+s);
			}		
		}
	}
}
