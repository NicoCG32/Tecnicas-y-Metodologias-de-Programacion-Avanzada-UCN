package abb;

// Nodo del Árbol Binario de Búsqueda
// Cada nodo almacena un valor y referencias a sus dos hijos
public class NodoABB {
    private int dato;               // Valor almacenado en el nodo
    private NodoABB hijoIzquierdo;  // Referencia al hijo izquierdo (null si no existe)
    private NodoABB hijoDerecho;    // Referencia al hijo derecho (null si no existe)

    // Constructor: crea un nodo con un valor específico
    // Los hijos se inicializan automáticamente en null
    public NodoABB(int dato) {
        this.dato = dato;
    }

    // GETTER: retorna el valor (dato) del nodo
    public int getDato() {
        return dato;
    }

    // GETTER: retorna la referencia al hijo izquierdo
    public NodoABB getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    // GETTER: retorna la referencia al hijo derecho
    public NodoABB getHijoDerecho() {
        return hijoDerecho;
    }

    // SETTER: asigna un nodo como hijo izquierdo
    public void setHijoIzquierdo(NodoABB n) {
        hijoIzquierdo = n;
    }

    // SETTER: asigna un nodo como hijo derecho
    public void setHijoDerecho(NodoABB n) {
        hijoDerecho = n;
    }
}
