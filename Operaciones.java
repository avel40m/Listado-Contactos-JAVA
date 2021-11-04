
package Mis_Contactos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Operaciones {
    
   public ArrayList<String> listaContacto = new ArrayList();
   private Scanner leer = new Scanner(System.in).useDelimiter("\n");
   
      public void leerOpciones(){
        
        int opcion;
        
        do {            
            System.out.println("Mis contactos - ("+listaContacto.size()+")");
            System.out.println("1. Agregar Contacto");
            System.out.println("2. Buscar Contacto");
            System.out.println("3. Modificar Contacto");
            System.out.println("4. Eliminar Contacto");
            System.out.println("5. Insertar Contacto");
            System.out.println("6. Mostrar Contactos");
            System.out.println("7. Ordenar Contacto de forma ascendente");
            System.out.println("8. Ordenar Contacto de forma descendente");
            System.out.println("9. Salir de mis contactos");
            System.out.println("Seleccionar un número");
            opcion = leer.nextInt();
            
            switch(opcion){
                case 1:
                    ingresarValor();
                    break;
                case 2:
                    buscarValor();
                    break;
                case 3:
                    modificar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    insertarDatos();
                    break;
                case 6: 
                    mostrarDatos();
                    break;
                case 7: 
                    ordenAscendente();
                    break;
                case 8:
                    ordenDescendente();
                    break;
                case 9:
                    System.out.println("Salio de la lista de contacto");
                    
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
            
        } while (opcion != 9);
    }
    
    public void ingresarValor(){
        System.out.println("Ingrese el nombre del nuevo contacto");
        String valor = leer.next();
        listaContacto.add(valor);
    }
    
    public void buscarValor(){
        System.out.println("Ingresar el contacto a buscar");
        String valor = leer.next();
        
        int indice = listaContacto.indexOf(valor);
        
        if(indice != 1){
            System.out.println("El contacto se encuentra en la posicion: "+ indice);
        }else{
            System.out.println("No se encontro el contacto "+valor);
        }
    }
    
    public void modificar(){
        System.out.println("Ingrese el contacto a modificar");
        String valor = leer.next();
        int indice = listaContacto.indexOf(valor);
        if(indice != 1){
            System.out.println("Ingresar el nuevo contacto");
            String nValor = leer.next();
            listaContacto.set(indice, nValor);
        }else{
            System.out.println("No se encontro el contacto");
        }
    }
    
    public void eliminar(){
        System.out.println("Ingresar el contacto a eliminar");
        String valor = leer.next();
        
        int indice = listaContacto.indexOf(valor);
        
        if(indice != 1){
            listaContacto.remove(indice);
            System.out.println("El contacto "+valor+" se ha eliminado");
        }else{
            System.out.println("No se encontro el contacto");
        }
    }
    
    public void insertarDatos(){
        System.out.println("Ingrese el contacto a insertar");
        String valor = leer.next();
        System.out.println("Ingrese en que posición lo va ha insertar");
        int indice = leer.nextInt();
        
        listaContacto.add(indice, valor);
    }
    
    public void mostrarDatos(){
        if(!listaContacto.isEmpty()){
            System.out.println("La lista cuenta con "+listaContacto.size()+" elementos");
            for (String lr : listaContacto) {
                System.out.println(lr.toString());
            }
        }else{
            System.out.println("La lista se encuentra vacia");
        }
    }
    
    public void ordenAscendente(){
        Collections.sort(listaContacto);
        mostrarDatos();
    }
    
    public void ordenDescendente(){
        Comparator<String> comparator = Collections.reverseOrder();
        Collections.sort(listaContacto, comparator);
        mostrarDatos();
    }
    
}
