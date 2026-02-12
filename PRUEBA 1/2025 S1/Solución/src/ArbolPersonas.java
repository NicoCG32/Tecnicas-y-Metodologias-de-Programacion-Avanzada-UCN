/**
 * Ejercicio 3: Árbol Binario de Búsqueda de Personas
 * 
 * Problema: Organización de datos de personas en un ABB, ordenado por RUT.
 * Cada nodo contiene una Persona (RUT, nombre, edad).
 * 
 * Se implementa:
 * - Inserción recursiva en el árbol
 * - Suma de edades de personas con exactamente un solo hijo
 */
public class ArbolPersonas {
    private Nodo raiz;
    
    public ArbolPersonas() {
        raiz = null;
    }
    
    /**
     * Ejercicio 3.1: Inserta una persona en el árbol binario de búsqueda.
     * La inserción se ordena por RUT (alfabéticamente).
     * 
     * @param persona la persona a insertar
     */
    public void insertar(Persona persona) {
        raiz = insertarRec(raiz, persona);
    }
    
    /**
     * Método recursivo para insertar una persona en el árbol.
     * Mantiene la propiedad de ABB: RUT menor a la izquierda, mayor a la derecha.
     * 
     * @param nodo nodo actual en la recursión
     * @param persona persona a insertar
     * @return el nodo (actual o nuevo) después de la inserción
     */
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
    
    /**
     * Ejercicio 3.2: Calcula la suma de edades de las personas que tienen 
     * exactamente un solo hijo (un solo hijo izquierdo o un solo hijo derecho).
     * 
     * @return la suma total de edades de nodos con un solo hijo
     */
    public int sumaEdadesUnSoloHijo() {
        return sumaEdadesUnSoloHijoRec(raiz);
    }
    
    /**
     * Método recursivo para sumar edades de nodos con un solo hijo.
     * Recorre recursivamente el árbol y suma la edad cuando encuentra un nodo
     * con exactamente un hijo.
     * 
     * @param nodo nodo actual en la recursión
     * @return la suma de edades de nodos con un solo hijo en el subárbol
     */
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
