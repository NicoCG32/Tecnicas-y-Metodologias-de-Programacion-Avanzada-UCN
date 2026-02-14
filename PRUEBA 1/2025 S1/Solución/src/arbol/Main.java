package arbol;

public class Main {
    public static void main(String[] args) {
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
    }
}
