package n3exercici1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Main {

	public static void main(String[] args) throws Exception {
		// Llegim fitxer i contrasenya
        Scanner teclat = new Scanner(System.in);
        System.out.print("Tria el fitxer: ");
        String nomFitxer = teclat.nextLine();
        File fitxer = new File(nomFitxer);
        //comprovem nomFitxer correcte
        if ( !fitxer.isFile() ) {
            System.out.println("No existeix aquest fitxer.");
            return;
        }
        System.out.print("Contrasenya: ");
        String password = teclat.nextLine();

        // Preparo el xifrador
        byte[] data = password.getBytes("UTF-8");
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(data);
        byte[] key = Arrays.copyOf(hash, 192/8);
        SecretKey clau = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        // Miro si haig de xifrar o desxifrar, segons l'extensió del nom del fitxer
        String nomFitxerNou;
        if (nomFitxer.endsWith(".aes")) {
            cipher.init(Cipher.DECRYPT_MODE, clau);
            nomFitxerNou = nomFitxer.substring(0, nomFitxer.length() - 4);
        } else {
            cipher.init(Cipher.ENCRYPT_MODE, clau);
            nomFitxerNou = nomFitxer + ".aes";
        }

 

        // Es llegeixen les dades i es van escrivint al nou fitxer xifrades/desxifrades
        byte[] dades = new byte[1024];
        FileOutputStream out = new FileOutputStream(nomFitxerNou);
        FileInputStream in = new FileInputStream(nomFitxer);
        
        // Reads a byte of data from this input stream. 
        // Devuelve -1 cuando se alcanza el final del flujo y no puede seguir leyendo bytes.
        int llegits = in.read(dades);
        while (llegits > 0) {
            out.write( cipher.doFinal(dades, 0, llegits) );
            llegits = in.read(dades);
        }
        in.close();
        out.close();

        // Esborrem el fitxer antic, sobreescrivint abans amb zeros
        RandomAccessFile rand = new RandomAccessFile(nomFitxer, "rw");
        for (int i=0; i< rand.length(); i++) {
            rand.write(0);
        }        
        rand.close();
        
        fitxer.delete();

	}

}
