package abb;

import java.io.File;        // Clase para manipular archivos
import java.io.IOException; // Excepción para errores de entrada/salida
import java.util.Scanner;   // Clase para leer desde archivos o consola

// Aplicación que carga datos desde archivo e inserta en un ABB
public class AppABB {
    // Lee datos del archivo y los inserta en el árbol
    public static void ingresarDatosAlABB(ABB abb) throws IOException {
        File file = new File("src/abb/datos.txt");
        Scanner scan = new Scanner(file);
        // Lee toda la línea del archivo
        String[] elementos = scan.nextLine().split(",");
        // split(",") divide por comas: "15,8,3,10,..." → ["15", "8", "3", "10", ...]
        
        // El primer elemento es la cantidad de datos
        // parseInt convierte String a número: "15" → 15
        int cantDatos = Integer.parseInt(elementos[0]);
        
        // Inserta los siguientes 'cantDatos' elementos en el árbol
        for (int i = 1; i <= cantDatos; i++) {
            // parseInt convierte cada elemento de string a int
            int dato = Integer.parseInt(elementos[i]);
            abb.ingresarDato(dato);  // Inserta recursivamente en el ABB
        }
        scan.close();  // Cierra el archivo
    }

    // Punto de entrada de la aplicación
    public static void main(String[] args) throws IOException {
        ABB abb = new ABB();  // Crea un árbol binario de búsqueda vacío
        ingresarDatosAlABB(abb);  // Carga datos desde el archivo
        
        // Busca el nodo con el valor máximo
        NodoABB mayor = abb.mayor();
        if (mayor != null) {
            System.out.println("El mayor del ABB es: " + mayor.getDato());
        } else {
            System.out.println("El arbol esta vacio");
        }
    }
}
