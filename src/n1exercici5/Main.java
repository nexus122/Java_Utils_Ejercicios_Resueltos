package n1exercici5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

    //aqui esta la serializacion de escritura
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    	/*Persona personas[]= {new Persona("Isabel",43),
    			new Persona("Josep",12),
    			new Persona("Ana",46),
    			new Persona("Pepe",25)};
        File file=new File("c:/prova/prova.ser");     
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream dataOut=new ObjectOutputStream(fileOut);
        for(Persona p :personas) 
            dataOut.writeObject(p);        
        fileOut.close();
        dataOut.close();*/	        
        
        //aqui esta la serializacion de lectura
    	 File file=new File("c:/prova/prova.ser");     
         FileInputStream fileIn=new FileInputStream(file);
        ObjectInputStream dataIn = new ObjectInputStream(fileIn);
                 
        //mientras haya objetos leemos y sacamos por pantalla
        int i=0;
        while(i<4) {
        	Persona persona =(Persona) dataIn.readObject();
            System.out.println(persona.toString());
            i++;
        }	        
        fileIn.close();
        dataIn.close();
   }	
}
