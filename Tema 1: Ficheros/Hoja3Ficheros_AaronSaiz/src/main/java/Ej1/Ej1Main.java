package Ej1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Ej1Main {

    public static void main(String[] args)
    {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce la ruta del archivo");
        String ruta=teclado.nextLine();
       
            try
            {
                 File f=new File(ruta);
                if(!f.exists()){
                f.createNewFile();
                }
                
                System.out.println("Introduce el nuevo texto");
                String nuevo=teclado.nextLine();
                
                BufferedReader br=Files.newBufferedReader(f.toPath());
                ArrayList<String> texto=new ArrayList<>();
                String linea="";
                while((linea=br.readLine())!=null){
                    texto.add(linea);
                }
                for(String cambiar:texto){
                    texto.remove(cambiar);
                    cambiar=cambiar.toUpperCase();
                    texto.add(cambiar);
                    
                }
                
                
            } catch (IOException ex)
            {
                Logger.getLogger(Ej1Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
    }
    
}
