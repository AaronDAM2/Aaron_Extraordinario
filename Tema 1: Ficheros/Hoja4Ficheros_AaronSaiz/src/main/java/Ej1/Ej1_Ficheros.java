package Ej1;

import Ej1.Futbolista.Puesto;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Ej1_Ficheros {

   private File fichero;
   private ArrayList<Futbolista> futbolistas;
    Scanner teclado=new Scanner(System.in);
    int idActual;
    public Ej1_Ficheros()
    {
        fichero=new File("futbolsitas.dat");
        idActual=0;
    }
    
    public int sigId(){
        return idActual++;
    }
    
    
    public void aniadirFutbolista(){
       try
       {
           System.out.println("Introduce el alias del futbolista");
           String alias=teclado.nextLine();
           System.out.println("Introduce el codigo de equipo del jugador");
           String codEquipo=teclado.nextLine().substring(0, 3);
           int numPuesto=0;
           Puesto pue=null;
           while (numPuesto==0){
               System.out.println("Introduce un nº del 1 al 4 para elegir el puesto del jugador");
               System.out.println("1. Portero| 2. Defensa| 3. Centrocampista| 4. Delantero");
               numPuesto=teclado.nextInt();
               switch(numPuesto){
                   case 0:
                       System.out.println("Introduce un nº del 1 al 4 para elegir el puesto del jugador");
                       break;
                   case 1:
                       pue=Puesto.PORTERO;
                       break;
                   case 2:
                       pue=Puesto.DEFENSA;
                       break;
                   case 3:
                       pue=Puesto.CENTROCAMPISTA;
                       break;
                   case 4:
                       pue=Puesto.DELANTERO;
                       break;
                   default:
                       numPuesto=0;
                       System.out.println("Introduce un nº del 1 al 4 para elegir el puesto del jugador");
               }
           }
           System.out.println("Puesto guardado");
           System.out.println("Introduce la altura del futbolista");
           float alt=teclado.nextFloat();
           
           Futbolista f=new Futbolista(sigId(),alias,codEquipo,pue,alt);
           
           futbolistas.add(f);
           
           ObjectOutputStream escritor=new ObjectOutputStream(new FileOutputStream(fichero));
           
           escritor.writeObject(f);
           
           
           } catch (FileNotFoundException ex)
       {
           Logger.getLogger(Ej1_Ficheros.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex)
       {
           Logger.getLogger(Ej1_Ficheros.class.getName()).log(Level.SEVERE, null, ex);
       }
            
            
    }
    
    public void listarFutbolistas(){
        
        
            ObjectInputStream oi=null;
       try
       {
           oi = new ObjectInputStream(new FileInputStream(fichero));

           Futbolista f;
           while((f=(Futbolista) oi.readObject())!=null){
               System.out.println(f);
           }
       } catch (FileNotFoundException ex)
       {
           Logger.getLogger(Ej1_Ficheros.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex)
       {
           Logger.getLogger(Ej1_Ficheros.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex)
       {
           Logger.getLogger(Ej1_Ficheros.class.getName()).log(Level.SEVERE, null, ex);
       } finally
       {
           try
           {
               oi.close();
           } catch (IOException ex)
           {
               Logger.getLogger(Ej1_Ficheros.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
            
      
            
            }
    
     public void listarFutbolistasPorEquipo(){
           
         System.out.println("Introduce el codigo de equipo");
         String codEquipo=teclado.nextLine().substring(0, 3);
         boolean existe=false;
             
            ObjectInputStream oi=null;
       try
       {
           oi = new ObjectInputStream(new FileInputStream(fichero));
           
           Futbolista f;
           while((f=(Futbolista) oi.readObject())!=null){
               if (f.getCodEquipo().equalsIgnoreCase(codEquipo)){
                   System.out.println(f.toString());
                   existe=true;
               }
           }
           
           if(!existe){
               System.out.println("El equipo no existe o no tiene jugadores");
           }
         
       } catch (FileNotFoundException ex)
       {
           Logger.getLogger(Ej1_Ficheros.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex)
       {
           Logger.getLogger(Ej1_Ficheros.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex)
       {
           Logger.getLogger(Ej1_Ficheros.class.getName()).log(Level.SEVERE, null, ex);
       }
        
     }
     
     public void BuscarFutbolista(){
         
           System.out.println("Introduce el id del jugador");
         int idJugador =teclado.nextInt();
         boolean existe=false;
             
            ObjectInputStream oi=null;
       try
       {
           oi = new ObjectInputStream(new FileInputStream(fichero));
           
           Futbolista f;
           while((f=(Futbolista) oi.readObject())!=null){
               if (f.getId()==idJugador){
                   System.out.println(f.toString());
                   existe=true;
               }
           }
           
           if(!existe){
               System.out.println("el jugador no existe");
           }
         
     } catch (IOException ex)
       {
           Logger.getLogger(Ej1_Ficheros.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex)
       {
           Logger.getLogger(Ej1_Ficheros.class.getName()).log(Level.SEVERE, null, ex);
       }
     
     }
     
     public void modificarEquipoJugador(){
         
             System.out.println("Introduce el id del jugador");
         int idJugador =teclado.nextInt();
         boolean existe=false;
            
            ObjectInputStream oi=null;
            ObjectOutputStream escritor=null;
       try
       {
           oi = new ObjectInputStream(new FileInputStream(fichero));
           escritor=new ObjectOutputStream(new FileOutputStream(fichero));
           
           Futbolista f;
           while((f=(Futbolista) oi.readObject())!=null){
               if (f.getId()==idJugador){
                   
                   System.out.println(f.toString());
                   existe=true;
                   
                   System.out.println("Introduce el codigo del nuevo equipo");
                    String codEquipo=teclado.nextLine().substring(0, 3);
                  f.setCodEquipo(codEquipo);
                  escritor.writeObject(f);
               }
           }
           
           if(!existe){
               System.out.println("el jugador no existe");
           }
         
     } catch (IOException ex)
       {
           Logger.getLogger(Ej1_Ficheros.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex)
       {
           Logger.getLogger(Ej1_Ficheros.class.getName()).log(Level.SEVERE, null, ex);
       }
         
     }
     
     public void modificarFutbolista(){
         
               System.out.println("Introduce el id del jugador");
         int idJugador =teclado.nextInt();
         boolean existe=false;
            
            ObjectInputStream oi=null;
            ObjectOutputStream escritor=null;
       try
       {
           oi = new ObjectInputStream(new FileInputStream(fichero));
           escritor=new ObjectOutputStream(new FileOutputStream(fichero));
           
           Futbolista f;
           while((f=(Futbolista) oi.readObject())!=null){
               if (f.getId()==idJugador){
                   
                   System.out.println(f.toString());
                   existe=true;
                   
                   System.out.println("Introduce el alias del futbolista");
           String alias=teclado.nextLine();
           System.out.println("Introduce el codigo de equipo del jugador");
           String codEquipo=teclado.nextLine().substring(0, 3);
           int numPuesto=0;
           Puesto pue=null;
           while (numPuesto==0){
               System.out.println("Introduce un nº del 1 al 4 para elegir el puesto del jugador");
               System.out.println("1. Portero| 2. Defensa| 3. Centrocampista| 4. Delantero");
               numPuesto=teclado.nextInt();
               switch(numPuesto){
                   case 0:
                       System.out.println("Introduce un nº del 1 al 4 para elegir el puesto del jugador");
                       break;
                   case 1:
                       pue=Puesto.PORTERO;
                       break;
                   case 2:
                       pue=Puesto.DEFENSA;
                       break;
                   case 3:
                       pue=Puesto.CENTROCAMPISTA;
                       break;
                   case 4:
                       pue=Puesto.DELANTERO;
                       break;
                   default:
                       numPuesto=0;
                       System.out.println("Introduce un nº del 1 al 4 para elegir el puesto del jugador");
               }
           }
           System.out.println("Puesto guardado");
           System.out.println("Introduce la altura del futbolista");
           float alt=teclado.nextFloat();
           
           f.setAlias(alias);
           f.setPuesto(pue);
           f.setAltura(alt);
           f.setCodEquipo(codEquipo);
           
           escritor.writeObject(f);
           
           
               }
           }
           
           if(!existe){
               System.out.println("el jugador no existe");
           }
         
     } catch (IOException ex)
       {
           Logger.getLogger(Ej1_Ficheros.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex)
       {
           Logger.getLogger(Ej1_Ficheros.class.getName()).log(Level.SEVERE, null, ex);
       }
         
         
     }
     
     public void EliminarFutbolista(){
         ArrayList<Futbolista> nuevoDoc=new ArrayList<>();
               System.out.println("Introduce el id del jugador");
         int idJugador =teclado.nextInt();
         boolean existe=false;
             
            ObjectInputStream oi=null;
            ObjectOutputStream escritor=null;
       try
       {
           oi = new ObjectInputStream(new FileInputStream(fichero));
            escritor=new ObjectOutputStream(new FileOutputStream(fichero));
           
           Futbolista f;
           while((f=(Futbolista) oi.readObject())!=null){
               if (f.getId()==idJugador){
                   System.out.println(f.toString());
                   existe=true;
                   System.out.println("Este jugador será borrado");
               }else{
                   nuevoDoc.add(f);
               }
           }
           
           if(!existe){
               System.out.println("el jugador no existe");
           }
         
           fichero.delete();
           fichero.createNewFile();
           for(Futbolista aux:nuevoDoc){
               escritor.writeObject(aux);
           }
           System.out.println("Jugador borrado");
     } catch (IOException ex)
       {
           Logger.getLogger(Ej1_Ficheros.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex)
       {
           Logger.getLogger(Ej1_Ficheros.class.getName()).log(Level.SEVERE, null, ex);
       }

     }
     
     
     
}
