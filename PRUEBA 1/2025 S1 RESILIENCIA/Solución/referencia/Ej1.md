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
            int valor = Integer.valueOf(sc.nextLine());
        }
        
        int capicua = capicua(valor);
        if (capicua == 1) System.out.println("El número " + valor + " es capicúa.");
	else System.out.println("El número " + valor + " NO es capicúa.");
    }
    
    public static int capicua(int n) {
        
	if (n < 10) return 1;

    	int potencia = 1;

        while (potencia * 10 <= n) {
    	    potencia *= 10;
    	}

    	int primero = n / potencia;
    	int ultimo = n % 10;

    	if (primero != ultimo) return 0;

        int medio = (n % potencia) / 10;

    	return capicua(medio);
    }
}
```