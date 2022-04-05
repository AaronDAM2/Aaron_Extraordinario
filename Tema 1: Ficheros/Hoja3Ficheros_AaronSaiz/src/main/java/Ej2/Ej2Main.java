package Ej2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Ej2Main {

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
        
                System.out.println("Introduce el caracter a leer");
                char buscar=teclado.nextLine().charAt(0);
                String caracter=Character.toString(buscar);
                int cont=0;
                
                BufferedReader br=Files.newBufferedReader(f.toPath());
                String linea;
                while((linea=br.readLine())!=null){
                    StringTokenizer st=new StringTokenizer(linea);
                    while(st.hasMoreTokens()){
                        if(st.nextToken().equalsIgnoreCase(caracter)){
                            cont++;
                        }
                    }
                    
                }
                
                System.out.println(caracter+" se repite "+cont+" veces");
                
                
        
    }   catch (IOException ex)
        {
            Logger.getLogger(Ej2Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
}
