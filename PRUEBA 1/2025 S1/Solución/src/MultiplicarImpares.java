/**
 * Ejercicio 2: Multiplicar Impares
 * 
 * Problema: Utilizando dividir para conquistar, multiplicar todos 
 * los números impares de una lista.
 * 
 * Consideración: Si no hay números impares, retornar 1.
 */
public class MultiplicarImpares {
    
    /**
     * Multiplica todos los números impares del arreglo usando divide y conquista.
     * 
     * @param arr el arreglo de números
     * @param inicio índice inicial del rango a procesar
     * @param fin índice final del rango a procesar
     * @return el producto de todos los números impares en el rango [inicio, fin]
     */
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
