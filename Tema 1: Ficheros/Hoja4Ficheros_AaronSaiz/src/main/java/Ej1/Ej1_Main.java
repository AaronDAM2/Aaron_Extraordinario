package Ej1;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ej1_Main {

    public static void main(String[] args)
    {
        Scanner teclado=new Scanner(System.in);
        int opc=1;
        while(opc!=0){
            System.out.println("Elige una opción:");
            System.out.println("1. Añadir Futbolista");
            System.out.println("2. Listar Futbolistas");
            System.out.println("3. Listar Futbolistas por equipos");
            System.out.println("4. Buscar Futbolista");
            System.out.println("5. Modificar equipo de Futbolista");
            System.out.println("6. Modificar datos de Futbolista");
            System.out.println("7. Eliminar Futbolista");
            System.out.println("0. Salir");
            System.out.println("Introduce un nº del 0 al 7");
            
            opc=teclado.nextInt();
            
            switch(opc){
                case 1:
                    System.out.println("1. Añadir Futbolista");
                    
                    
                    break;
                case 2:
                   System.out.println("2. Listar Futbolistas"); 
                    
                    break;
                case 3:
                    System.out.println("3. Listar Futbolistas por equipos");
                    
                    break;
                case 4:
                    System.out.println("4. Buscar Futbolista");
                    
                    break;
                case 5:
                    System.out.println("5. Modificar equipo de Futbolista");
                    
                    break;
                case 6:
                    System.out.println("6. Modificar datos de Futbolista");
                    
                    break;
                case 7:
                    System.out.println("7. Eliminar Futbolista");
                    
                    break;
                case 0:
                    System.out.println("0. Salir");
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Introduce un nº del 0 al 7");
         
            }
                    
            
            
        }
        
        
    }
}
