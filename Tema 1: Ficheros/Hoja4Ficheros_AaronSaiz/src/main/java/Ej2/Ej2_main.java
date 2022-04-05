package Ej2;

import Ej1.Futbolista;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Ej2_main {

    public static void main(String[] args)
    {
        ObjectInputStream lector=null;
        try
        {
            File fichero=new File("futbolistas.dat");
            File fOrdenado=new File("futbolistas_ordenados.dat");
           List<Futbolista> futbolistas=new ArrayList<>();
          
            
                 futbolistas=(List<Futbolista>) Files.lines(fichero.toPath()).sorted();
                 
          
                 ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(fOrdenado));
                 
                 for(Futbolista f:futbolistas){
                     out.writeObject(f);
                 }
            
            
            
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(Ej2_main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(Ej2_main.class.getName()).log(Level.SEVERE, null, ex);
         
        } finally
        {
            try
            {
                lector.close();
            } catch (IOException ex)
            {
                Logger.getLogger(Ej2_main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
