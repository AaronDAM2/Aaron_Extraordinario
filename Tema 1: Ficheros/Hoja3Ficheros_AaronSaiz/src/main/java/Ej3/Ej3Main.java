package Ej3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Ej3Main {

  
     
    // BufferedReader br=new BufferedReader(new FileReader(f));
     
    
    public static void main(String[] args)
    {
           File f=new File("personas.txt");
        Scanner teclado=new Scanner(System.in);
       int opc = 1;
        
        while(opc!=0){
        System.out.println("Elige una opción");
        System.out.println("1. Añadir Persona");
        System.out.println("2. Buscar Persona");
        System.out.println("3. Buscar por nombre");
        System.out.println("4. Buscar por apellidos");
        System.out.println("5. Eliminar persona");
        System.out.println("0. Salir");
        
        System.out.println("Introduce un nº del 0 al 5");
        opc=teclado.nextInt();
            
        switch(opc){
            
            case 1:
                System.out.println("1. Añadir Persona");
                AnadirPersona(f);
                
                break;
                
            case 2:
                System.out.println("2. Buscar Persona");
                System.out.println("Introduce el nombre a buscar");
                String nombre=teclado.nextLine();
                System.out.println("Introduce el apellido a buscar");
                String apellido=teclado.nextLine();
                System.out.println(BuscarPersona(nombre, apellido, f));
                
                break;
                
            case 3:
                System.out.println("3. Buscar por nomnbre");
                System.out.println("Introduce el nombre a buscar");
                String nombreBuscar=teclado.nextLine();
                System.out.println(BuscarNombre(nombreBuscar,f));
                
                break;
                
            case 4:
                System.out.println("4. Buscar por apellidos");
                System.out.println(InicialApellido(f));
                
                
                
                break;
                
            case 5:
                System.out.println("5. Eliminar Persona");
             
                System.out.println("Introduce el nombre a borrar");
                String nombreBorrar=teclado.nextLine();
                System.out.println("Introduce el apellido a borrar");
                String apellidoBorrar=teclado.nextLine();
                EliminarPersona(nombreBorrar, apellidoBorrar, f);
                
                break;
                
            case 0:
                System.out.println("0. Salir");
                System.out.println("Adios");
                
                break;
                
            default:
                System.out.println("Introduce un nº del 0 al 5"); 
               
        }
            
        
        
        }
        
    }
    
    public static void AnadirPersona(File f){
         Scanner teclado=new Scanner(System.in);
        BufferedWriter bw=null;
         try
         {
             System.out.println("Introduce el nombre");
             String nombre=teclado.nextLine();
             System.out.println("Introduce los apellidos");
             String apellidos=teclado.nextLine();
             bw = Files.newBufferedWriter(f.toPath());
             String nuevaPersona=apellidos.toUpperCase()+", "+nombre.toUpperCase();
             bw.newLine();
             bw.write(nuevaPersona);
             
             
         } catch (IOException ex)
         {
             Logger.getLogger(Ej3Main.class.getName()).log(Level.SEVERE, null, ex);
         } finally
         {
             try
             {
                 bw.close();
             } catch (IOException ex)
             {
                 Logger.getLogger(Ej3Main.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
        
        
    }
    
    public static String BuscarPersona(String nombre, String apellidos, File f){
         try
         {
             BufferedReader br=new BufferedReader(new FileReader(f));
             
             String linea="";
             while((linea=br.readLine())!=null){
                 if(linea.equalsIgnoreCase(apellidos+","+nombre)){
                    return linea; 
                 }
                 
             }
             
             
         } catch (FileNotFoundException ex)
         {
             Logger.getLogger(Ej3Main.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex)
         {
             Logger.getLogger(Ej3Main.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return null;
    }
    
    public static ArrayList<String> BuscarNombre(String nombre, File f){
        
        ArrayList<String> nombres=new ArrayList<>();
          try
         {
             BufferedReader br=new BufferedReader(new FileReader(f));
             
             String linea="";
             while((linea=br.readLine())!=null){
                 if(linea.contains(nombre)){
                    nombres.add(linea);
                 }
                 
             }
             
             
         } catch (FileNotFoundException ex)
         {
             Logger.getLogger(Ej3Main.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex)
         {
             Logger.getLogger(Ej3Main.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return nombres;
        
    }
    
    public static ArrayList<String> InicialApellido(File f){
        BufferedReader br=null;
         ArrayList<String> personas=new ArrayList<>();
         try
         {
            
             Scanner teclado=new Scanner(System.in);
             System.out.println("Introduce la inicial del apellido");
             char inicial=teclado.nextLine().charAt(0);
             String buscar=Character.toString(inicial);
             br = Files.newBufferedReader(f.toPath());
             String linea="";
              while((linea=br.readLine())!=null){
                 if(linea.substring(0,linea.indexOf(",")).startsWith(buscar)){
                    personas.add(linea);
                 }
                 
             }
             
             
         } catch (IOException ex)
         {
             Logger.getLogger(Ej3Main.class.getName()).log(Level.SEVERE, null, ex);
         } finally
         {
             try
             {
                 br.close();
             } catch (IOException ex)
             {
                 Logger.getLogger(Ej3Main.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         
        return personas;
    }
    
    public static void EliminarPersona(String nombre, String apellidos, File f){
        
        ArrayList<String> nombres=new ArrayList<>();
        
           try
         {
             BufferedReader br=new BufferedReader(new FileReader(f));
             
             String linea="";
             while((linea=br.readLine())!=null){
                 if(!linea.equalsIgnoreCase(apellidos+","+nombre)){
                   nombres.add(linea);
                 }
                 
                 BufferedWriter bw=new BufferedWriter(new FileWriter(f));
                 f.delete();
                 f.createNewFile();
                 for(String nom: nombres){
                     bw.write(nom);
                     bw.newLine();
                     
                 }
                 System.out.println("Persona eliminada");
             }
             
             
         } catch (FileNotFoundException ex)
         {
             Logger.getLogger(Ej3Main.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex)
         {
             Logger.getLogger(Ej3Main.class.getName()).log(Level.SEVERE, null, ex);
         }
        
       
        
    }
    
}
