package multiplicarimpares;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 2: Multiplicar Impares (Divide y Conquista) ===");
        
        int[] arr = {2, 3, 5, 8, 7, 4, 9};
        System.out.println("Arreglo: " + Arrays.toString(arr));
        
        int resultado = multiplicarImpares(arr, 0, arr.length - 1);
        System.out.println("Producto de impares: " + resultado);
    }

        // Multiplica todos los números impares del arreglo usando divide y conquista
    // Si no hay impares, retorna 1
    public static int multiplicarImpares(int[] arr, int inicio, int fin) {
        // Caso base: rango inválido
        if (inicio > fin) {
            return 1;
        }
        
        // Caso base: un solo elemento
        if (inicio == fin) {
            if (arr[inicio] % 2 == 1) {
                return arr[inicio];
            } else {
                return 1;
            }
        }
        
        // Divide y conquista: dividir el arreglo en dos mitades
        int mid = (inicio + fin) / 2;
        
        // Multiplicar los resultados de ambas mitades
        return multiplicarImpares(arr, inicio, mid) * multiplicarImpares(arr, mid + 1, fin);
    }
}
