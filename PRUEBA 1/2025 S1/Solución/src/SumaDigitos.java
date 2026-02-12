/**
 * Ejercicio 1: Suma de Dígitos
 * 
 * Problema: Leer un número entero positivo y, usando recursión, 
 * calcular la suma de sus dígitos.
 * 
 * Ejemplos:
 * - 123 → 1 + 2 + 3 = 6
 * - 502 → 5 + 0 + 2 = 7
 * - 9 → 9
 */
public class SumaDigitos {
    
    /**
     * Calcula la suma de los dígitos de un número usando recursión.
     * 
     * @param n el número del que se desea sumar los dígitos
     * @return la suma de todos los dígitos de n
     */
    public static int sumaDigitos(int n) {
        // Caso base: si solo queda un dígito, retornar ese dígito
        if (n / 10 == 0) {
            return (n % 10);
        }
        
        // Caso recursivo: obtener el último dígito y sumar con la recursión del resto
        int modulo = n % 10;
        return sumaDigitos(n / 10) + modulo;
    }
}
