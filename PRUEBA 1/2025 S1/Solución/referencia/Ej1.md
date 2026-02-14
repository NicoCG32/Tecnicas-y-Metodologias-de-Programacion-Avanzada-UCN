# Ejercicio 1

```java
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese un número positivo: ");
        int valor = Integer.valueOf(sc.nextLine());
        
        while (valor <= 0) {
            System.out.println("Ingrese un número positivo: ");
            valor = Integer.valueOf(sc.nextLine());
        }
        
        int suma = sumaDigitos(valor);
        System.out.println("La suma de los dígitos es: " + suma);
    }
    
    public static int sumaDigitos(int n) {
        int suma = 0;
        
        if (n / 10 == 0) {
            return (n % 10);
        }
        
        int modulo = n % 10;
        suma = sumaDigitos(n / 10) + modulo;
        return suma;
    }
}
```
