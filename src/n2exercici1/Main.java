package n2exercici1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties properties =new Properties();
	    properties.load(new FileInputStream(new File("configuracion.txt")));
        
        String fileCreado=(String) properties.get("FILECREADO");
        String fileRecorrer=(String) properties.get("FILERECORRER");

	}

}
