# Ejercicio 2 - Mayor en ABB (Recursivo)

```java
class NodoABB {
    private int dato;
    private NodoABB hijoIzquierdo;
    private NodoABB hijoDerecho;

    public NodoABB(int dato) { this.dato = dato; }
    public int getDato() { return dato; }
    public NodoABB getHijoIzquierdo() { return hijoIzquierdo; }
    public NodoABB getHijoDerecho() { return hijoDerecho; }
    public void setHijoIzquierdo(NodoABB n) { hijoIzquierdo = n; }
    public void setHijoDerecho(NodoABB n) { hijoDerecho = n; }
}

public class ABB {
    private NodoABB raiz;

    public void ingresarDato(int dato) {
        NodoABB nuevo = new NodoABB(dato);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            ingresarDato(raiz, nuevo);
        }
    }

    private void ingresarDato(NodoABB actual, NodoABB nuevo) {
        if (nuevo.getDato() < actual.getDato()) {
            if (actual.getHijoIzquierdo() == null) {
                actual.setHijoIzquierdo(nuevo);
            } else {
                ingresarDato(actual.getHijoIzquierdo(), nuevo);
            }
        } else {
            if (actual.getHijoDerecho() == null) {
                actual.setHijoDerecho(nuevo);
            } else {
                ingresarDato(actual.getHijoDerecho(), nuevo);
            }
        }
    }

    public NodoABB mayor() {
        return mayor(raiz);
    }

    private NodoABB mayor(NodoABB nodo) {
        if (nodo == null) {
            return null;
        }
        if (nodo.getHijoDerecho() == null) {
            return nodo;
        }
        return mayor(nodo.getHijoDerecho());
    }
}

public class AppProblema2 {
    public static void ingresarDatosAlABB(ABB abb) throws IOException {
        File file = new File("datos.txt");
        Scanner scan = new Scanner(file);
        String[] elementos = scan.nextLine().split(",");
        int cantDatos = Integer.parseInt(elementos[0]);
        for (int i = 1; i <= cantDatos; i++) {
            int dato = Integer.parseInt(elementos[i]);
            abb.ingresarDato(dato);
        }
        scan.close();
    }

    public static void main(String[] args) throws IOException {
        ABB abb = new ABB();
        ingresarDatosAlABB(abb);
        NodoABB mayor = abb.mayor();
        if (mayor != null) {
            System.out.println("El mayor del ABB es: " + mayor.getDato());
        } else {
            System.out.println("El arbol esta vacio");
        }
    }
}
```