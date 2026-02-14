package arbol;

public class ArbolPersonas {
    private Nodo raiz;
    
    public ArbolPersonas() {
        raiz = null;
    }
    
    // Inserta una persona en el árbol, ordenando por RUT (alfabéticamente)
    public void insertar(Persona persona) {
        raiz = insertarRec(raiz, persona);
    }
    
    // Inserta recursivamente una persona en el árbol
    // Si RUT nodo > RUT nuevo va a izquierda, sino a derecha
    private Nodo insertarRec(Nodo nodo, Persona persona) {
        if (nodo == null) {
            return new Nodo(persona);
        } else {
            String nodoRut = nodo.persona.rut;
            String personaRut = persona.rut;
            
            if (nodoRut.compareTo(personaRut) > 0) {
                nodo.izquierdo = insertarRec(nodo.izquierdo, persona);
            } else {
                nodo.derecho = insertarRec(nodo.derecho, persona);
            }
        }
        return nodo;
    }
    
    // Suma edades de personas con exactamente un solo hijo
    public int sumaEdadesUnSoloHijo() {
        return sumaEdadesUnSoloHijoRec(raiz);
    }
    
    // Recorre el árbol y suma edades de nodos con un solo hijo
    private int sumaEdadesUnSoloHijoRec(Nodo nodo) {
        int suma = 0;
        if (nodo != null) {
            // Sumar recursivamente sobre ambos subárboles
            suma += sumaEdadesUnSoloHijoRec(nodo.izquierdo);
            suma += sumaEdadesUnSoloHijoRec(nodo.derecho);
            
            // Verificar si el nodo actual tiene exactamente un solo hijo
            if ((nodo.izquierdo == null && nodo.derecho != null) || 
                (nodo.izquierdo != null && nodo.derecho == null)) {
                suma += nodo.persona.edad;
            }
        }
        return suma;
    }
}
