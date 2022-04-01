package Ej1;

import Ej1.Futbolista.Puesto;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

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
            
    }
    
    
}
