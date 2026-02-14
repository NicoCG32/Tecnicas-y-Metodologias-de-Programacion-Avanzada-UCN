package abb;

// Árbol Binario de Búsqueda (ABB)
// Propiedad: Valor izquierda < Nodo < Valor derecha
public class ABB {
    private NodoABB raiz;  // Referencia a la raíz del árbol

    // Inserción pública: punto de entrada para agregar datos
    // Crea un nuevo nodo y lo inserta recursivamente
    public void ingresarDato(int dato) {
        NodoABB nuevo = new NodoABB(dato);
        if (raiz == null) {
            raiz = nuevo;  // Si el árbol está vacío, el nuevo nodo es la raíz
        } else {
            ingresarDato(raiz, nuevo);  // Recursión para encontrar la posición correcta
        }
    }

    // Inserción recursiva: encuentra la posición correcta del nuevo nodo
    // Mantiene la propiedad de ABB comparando valores
    private void ingresarDato(NodoABB actual, NodoABB nuevo) {
        // Si el nuevo valor es menor, va a la izquierda
        if (nuevo.getDato() < actual.getDato()) {
            if (actual.getHijoIzquierdo() == null) {
                // Encontró el lugar: hijo izquierdo está vacío
                actual.setHijoIzquierdo(nuevo);
            } else {
                // Continúa recursivamente hacia la izquierda
                ingresarDato(actual.getHijoIzquierdo(), nuevo);
            }
        } else {
            // El nuevo valor es mayor o igual, va a la derecha
            if (actual.getHijoDerecho() == null) {
                // Encontró el lugar: hijo derecho está vacío
                actual.setHijoDerecho(nuevo);
            } else {
                // Continúa recursivamente hacia la derecha
                ingresarDato(actual.getHijoDerecho(), nuevo);
            }
        }
    }

    // Encuentra el nodo con el valor máximo (mayor) del árbol
    // En un ABB, el máximo siempre está en el nodo más a la derecha
    public NodoABB mayor() {
        return mayor(raiz);
    }

    // Búsqueda recursiva del máximo
    // Estrategia: siempre ir a la derecha hasta encontrar un nodo sin hijo derecho
    private NodoABB mayor(NodoABB nodo) {
        if (nodo == null) {
            return null;  // Árbol vacío
        }
        if (nodo.getHijoDerecho() == null) {
            return nodo;  // Si no hay hijo derecho, este es el máximo
        }
        // Continúa recursivamente hacia la derecha
        return mayor(nodo.getHijoDerecho());
    }
}
