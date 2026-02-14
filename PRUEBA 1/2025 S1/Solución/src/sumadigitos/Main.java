package sumadigitos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== EJERCICIO 1: Suma de Dígitos (Recursivo) ===");
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese un número positivo: ");
        int valor = Integer.valueOf(sc.nextLine());
        
        while (valor <= 0) {
            System.out.print("Ingrese un número positivo: ");
            valor = Integer.valueOf(sc.nextLine());
        }
        
        int suma = sumaDigitos(valor);
        System.out.println("La suma de los dígitos es: " + suma);
        sc.close();
    }

    // Calcula la suma de dígitos de un número usando recursión
    // Ejemplos: 123 → 1+2+3=6, 502 → 5+0+2=7
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