/**
 * Clase Persona: Representa una persona con RUT, nombre y edad.
 * Utilizada en el Árbol Binario de Búsqueda del Ejercicio 3.
 */
public class Persona {
    public String rut;
    public String nombre;
    public int edad;
    
    public Persona(String rut, String nombre, int edad) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
    }
    
    @Override
    public String toString() {
        return String.format("Persona{rut='%s', nombre='%s', edad=%d}", rut, nombre, edad);
    }
}

/**
 * Clase Nodo: Representa un nodo en el Árbol Binario de Búsqueda.
 * Cada nodo contiene una Persona y referencias a nodos hijo.
 */
public class Nodo {
    public Persona persona;
    public Nodo izquierdo;
    public Nodo derecho;
    
    public Nodo(Persona persona) {
        this.persona = persona;
        this.izquierdo = null;
        this.derecho = null;
    }
}
