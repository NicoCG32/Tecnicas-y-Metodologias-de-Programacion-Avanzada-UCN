package arbol;

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
