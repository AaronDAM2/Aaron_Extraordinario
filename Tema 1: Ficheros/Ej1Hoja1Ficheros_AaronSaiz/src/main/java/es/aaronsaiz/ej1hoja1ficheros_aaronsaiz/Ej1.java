package es.aaronsaiz.ej1hoja1ficheros_aaronsaiz;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Ej1 {

    
    public static void main(String[] args)
    {
        Scanner tec=new Scanner(System.in);
        System.out.println("Introduce el archivo a leer");
        String ruta=tec.nextLine();
        File f=new File(ruta);
        if (!f.exists()){
            try
            {
                f.createNewFile();
            } catch (IOException ex)
            {
                Logger.getLogger(Ej1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println(f.getName());
        System.out.println(f.getTotalSpace());
        
        
    }
    
}
