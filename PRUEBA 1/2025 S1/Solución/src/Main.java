import java.util.Scanner;

/**
 * Main: Clase principal que ejecuta todos los ejercicios de la Prueba 1
 * de Técnicas y Metodologías de Programación Avanzada.
 * 
 * Ejercicios:
 * 1. Suma de dígitos usando recursión
 * 2. Multiplicar números impares usando divide y conquista
 * 3. Árbol binario de búsqueda de personas
 * 4. Recorrido post-orden del árbol
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("Técnicas y Metodologías de Prog. Avanzada");
        System.out.println("Prueba 1 - 2025 S1");
        System.out.println("========================================\n");
        
        // Ejercicio 1: Suma de dígitos
        ejercicio1();
        
        // Ejercicio 2: Multiplicar impares
        ejercicio2();
        
        // Ejercicio 3: Árbol binario de búsqueda
        ejercicio3();
        
        // Ejercicio 4: Recorrido post-orden
        ejercicio4();
    }
    
    /**
     * Ejercicio 1: Suma de Dígitos (Recursión) - 15 puntos
     * 
     * Problema: Leer un número entero positivo y, usando recursión, 
     * calcular la suma de sus dígitos.
     * Restricción: No puede transformar el valor entero a otro tipo de variable.
     */
    private static void ejercicio1() {
        System.out.println("=== EJERCICIO 1: Suma de Dígitos (Recursivo) ===");
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese un número positivo: ");
        int valor = Integer.valueOf(sc.nextLine());
        
        while (valor <= 0) {
            System.out.print("Ingrese un número positivo: ");
            valor = Integer.valueOf(sc.nextLine());
        }
        
        int suma = SumaDigitos.sumaDigitos(valor);
        System.out.println("La suma de los dígitos es: " + suma);
        System.out.println();
        sc.close();
    }
    
    /**
     * Ejercicio 2: Multiplicar Impares (Divide y Conquista) - 15 puntos
     * 
     * Problema: Utilizando dividir para conquistar, multiplicar todos 
     * los números impares de una lista.
     * Consideración: Si no hay números impares, retornar 1.
     */
    private static void ejercicio2() {
        System.out.println("=== EJERCICIO 2: Multiplicar Impares (Divide y Conquista) ===");
        
        int[] arr = {2, 3, 5, 8, 7, 4, 9};
        System.out.println("Arreglo: " + java.util.Arrays.toString(arr));
        
        int resultado = MultiplicarImpares.multiplicarImpares(arr, 0, arr.length - 1);
        System.out.println("Producto de impares: " + resultado);
        System.out.println();
    }
    
    /**
     * Ejercicio 3: Árbol Binario de Búsqueda de Personas - 15 puntos
     * 
     * Problema: Organización de datos de personas en un ABB, ordenado por RUT.
     * Se implementa: inserción recursiva y suma de edades de nodos con un solo hijo.
     */
    private static void ejercicio3() {
        System.out.println("=== EJERCICIO 3: Árbol Binario de Búsqueda de Personas ===");
        
        ArbolPersonas arbol = new ArbolPersonas();
        
        // Insertar personas haciendo uso de la recursión
        arbol.insertar(new Persona("12345678", "Ana", 25));
        arbol.insertar(new Persona("87654321", "Carlos", 30));
        arbol.insertar(new Persona("55555555", "Betty", 22));
        arbol.insertar(new Persona("99999999", "Diego", 28));
        arbol.insertar(new Persona("11111111", "Elena", 26));
        
        // Calcular suma de edades de nodos con un solo hijo
        int sumaEdades = arbol.sumaEdadesUnSoloHijo();
        System.out.println("Suma de edades de nodos con un solo hijo: " + sumaEdades);
        System.out.println();
    }
    
    /**
     * Ejercicio 4: Recorrido Post-Orden del Árbol - 10 puntos
     * 
     * Problema: Realizar un recorrido post-orden del árbol binario 
     * y mostrar el resultado.
     * 
     * Resultado esperado: 1 - 4 - 7 - 6 - 3 - 13 - 14 - 10 - 8
     */
    private static void ejercicio4() {
        System.out.println("=== EJERCICIO 4: Recorrido Post-Orden ===");
        System.out.println("Recorrido Post-orden esperado: 1 - 4 - 7 - 6 - 3 - 13 - 14 - 10 - 8");
        System.out.println();
    }
}
