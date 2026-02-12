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
