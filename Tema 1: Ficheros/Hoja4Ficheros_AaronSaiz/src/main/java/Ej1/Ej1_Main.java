package Ej1;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ej1_Main {

    public static void main(String[] args)
    {
        Ej1_Ficheros f=new Ej1_Ficheros();
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
                    f.aniadirFutbolista();
                    
                    break;
                case 2:
                   System.out.println("2. Listar Futbolistas"); 
                    f.listarFutbolistas();
                    break;
                case 3:
                    System.out.println("3. Listar Futbolistas por equipos");
                    f.listarFutbolistasPorEquipo();
                    break;
                case 4:
                    System.out.println("4. Buscar Futbolista");
                    f.BuscarFutbolista();
                    break;
                case 5:
                    System.out.println("5. Modificar equipo de Futbolista");
                    f.modificarEquipoJugador();
                    break;
                case 6:
                    System.out.println("6. Modificar datos de Futbolista");
                    f.modificarFutbolista();
                    break;
                case 7:
                    System.out.println("7. Eliminar Futbolista");
                    f.EliminarFutbolista();
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
