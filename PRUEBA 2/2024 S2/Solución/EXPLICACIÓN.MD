# Explicación detallada - Técnicas y Metodologías de Programación Avanzada (PRUEBA 2, 2024 S2)

## Objetivo

Esta prueba evalúa tres técnicas fundamentales de programación: **Backtracking** (búsqueda con poda), **Árboles Binarios de Búsqueda (ABB)** con recursión, y **Concurrencia** con sincronización de hilos. Cada ejercicio representa un patrón algorítmico diferente con sus propias limitaciones, aplicabilidad y complejidad.

---

## Ejercicio 1: Selección de Dieta mediante Backtracking

### Modelamiento del Problema

Basado en el análisis presentado en [referencia/Ej1.md](../../referencia/Ej1.md):

**a) Raíz del árbol de búsqueda**
- El nodo raíz representa el estado inicial: **ningún alimento seleccionado**, caloría total en 0, todos los grupos con contador 0.

**b) Candidatos potenciales**
- Todos los alimentos cargados desde el archivo `alimentos.txt` (máximo 100).
- En cada nivel de profundidad `k`, los candidatos son **todos los alimentos desde la posición `k` hacia adelante** (evitando duplicados reutilizando alimentos previos).

**c) Estructura del árbol**
- Árbol de búsqueda donde cada rama representa la inclusión o exclusión de un alimento.
- Profundidad variable: depende de cuándo se alcanza una solución válida.
- Cada nivel representa la cantidad de alimentos evaluados/seleccionados.

**d) Predicado de aceptabilidad**
Un nodo es **aceptable** si cumple dos restricciones:
1. **Restricción de calorías**: Sumar las calorías del nuevo alimento no excede el `limiteSuperior`.
2. **Restricción de grupo**: El grupo del alimento tiene menos de 2 elementos seleccionados (máximo 1 adicional).

**e) Solución incompleta**
Una solución es **incompleta** si:
- La suma de calorías aún está por debajo del `limiteInferior`, O
- Falta al menos un alimento en alguno de los 7 grupos (no hay cobertura completa).

### Decisiones de Diseño

#### Estructuras de Datos

```
Grupo[] grupos[7]               // Cuenta de alimentos por grupo (0..6)
Alimento[] alimentos            // Base de datos de alimentos
Alimento[] solucion            // Alimentos seleccionados en la solución actual
int sumaCaloriasActual         // Suma incremental de calorías
int limiteInferior, limiteSuperior  // Restricciones del usuario
```

**Justificación**:
- Los grupos se indexan de 0 a 6 (mapeo desde el archivo donde grupos van de 1 a 7, necesitando `-1` al parsear).
- La suma de calorías se mantiene **incrementalmente**: se suma al registrar y se resta al cancelar, evitando recalcular cada vez.
- El array `solucion` actúa como un **registro dinámico** del camino actual.

#### Patrón de Backtracking con Registración y Cancelación

El backtracking implementa el patrón **registrar/cancelar**:

```java
// HACIA ADELANTE (Registración)
registrarSeleccion(idx) {
    solucion[cantAlimentosDieta++] = alimentos[idx];
    sumaCaloriasActual += alimentos[idx].calorias;
    grupos[alimentos[idx].grupo].cantAlimGrupo++;
}

// HACIA ATRÁS (Cancelación/Rollback)
cancelarSeleccion() {
    idx = alimentos[solucion[--cantAlimentosDieta]];
    sumaCaloriasActual -= idx.calorias;
    grupos[idx.grupo].cantAlimGrupo--;
}
```

**Justificación**: Las operaciones son **asimétricas y reversibles**. Al retroceder (backtrack), se deshace exactamente lo hecho al avanzar. Esto es crucial para que el algoritmo explore diferentes ramas sin contaminar el estado.

#### Poda (Pruning)

```java
esAceptable(idx) {
    return (sumaCaloriasActual + alimentos[idx].calorias <= limiteSuperior)
        && (grupos[alimentos[idx].grupo].cantAlimGrupo < 2);
}
```

La poda **elimina ramas imposibles** sin explorar sus descendientes, reduciendo dramáticamente el espacio de búsqueda.

### Implementación

**Ubicación**: [src/dieta/](../../../src/dieta/)

**Componentes**:
- [Alimento.java](../../../src/dieta/Alimento.java): Simple POJO con campos `nombre`, `calorias`, `grupo` (públicos).
- [Grupo.java](../../../src/dieta/Grupo.java): Contador de alimentos seleccionados por grupo.
- [DietaApp.java](../../../src/dieta/DietaApp.java): Lógica principal de backtracking.

**Flujo de ejecución** (método `main`):
1. Leer `limiteInferior` y `limiteSuperior` desde entrada estándar.
2. Inicializar los 7 grupos.
3. Cargar alimentos desde `src/dieta/alimentos.txt` (formato CSV).
4. Invocar `intenta(0)` para iniciar la búsqueda desde el primer alimento.
5. Imprimir la solución encontrada (si existe).

**Método recursivo `intenta(k)`**:
```java
intenta(k) {
    // Caso base: decidir si la solución actual es válida
    if (!solucionIncompleta()) {
        imprimirSolucion();
        return;
    }
    
    // Caso recursivo: probar cada alimento desde k
    for (int i = k; i < cantAlimentos; i++) {
        if (esAceptable(i)) {
            registrarSeleccion(i);
            intenta(i + 1);      // Explorar rama con alimento i
            cancelarSeleccion();  // Deshacer para probar otros
        }
    }
}
```

### Manejo de Restricciones

**Restricción de grupo (`cantAlimGrupo < 2`)**:
- Cada grupo admite máximo 1 alimento seleccionado.
- Imposibilita seleccionar dos "Frutas" en la misma dieta.

**Restricción de calorías**:
- Piso (`limiteInferior`): la dieta debe tener al menos estas calorías.
- Techo (`limiteSuperior`): no puede exceder estas calorías.

### Ejemplos de Ejecución

**Entrada**:
```
2000
3000
```

**Datos de archivo** (`src/dieta/alimentos.txt`, 15 items):
```
Pollo,250,2
Leche,100,1
Arroz,150,5
...
```

**Salida esperada** (ejemplo):
```
Solución encontrada:
1. Pollo (250 kcal) - Grupo 2
2. Leche (100 kcal) - Grupo 1
3. Arroz (150 kcal) - Grupo 5
...
Total: 2400 kcal
Grupos cubiertos: 7/7
```

---

## Ejercicio 2: Búsqueda del Mayor en Árbol Binario de Búsqueda (ABB)

### Modelamiento del Problema

Basado en el análisis presentado en [referencia/Ej2.md](../../referencia/Ej2.md):

**Propiedad ABB**:
- Para cada nodo, **todos los valores en el subárbol izquierdo son menores** que el nodo, **todos en el derecho son mayores o iguales**.
- Esta propiedad permite búsquedas eficientes sin explorar todo el árbol.

**Búsqueda del mayor**:
- El máximo siempre está en el **nodo más a la derecha** del árbol.
- Se alcanza siguiendo siempre la rama derecha hasta encontrar un nodo sin hijo derecho.

### Decisiones de Diseño

#### Estructura de Nodos

```java
class NodoABB {
    private int dato;
    private NodoABB hijoIzquierdo, hijoDerecho;
    
    // Getters y Setters para encapsulación
}
```

**Justificación**:
- Campos privados con accesores públicos **protegen la integridad** del nodo.
- El nodo es **autosuficiente**: contiene su dato y referencias a sus hijos.

#### Inserción Recursiva

```java
ingresarDato(actual, nuevo) {
    if (nuevo.getDato() < actual.getDato()) {
        // Ir izquierda
        if (actual.getHijoIzquierdo() == null)
            actual.setHijoIzquierdo(nuevo);
        else
            ingresarDato(actual.getHijoIzquierdo(), nuevo);
    } else {
        // Ir derecha
        if (actual.getHijoDerecho() == null)
            actual.setHijoDerecho(nuevo);
        else
            ingresarDato(actual.getHijoDerecho(), nuevo);
    }
}
```

**Patrón recursivo**:
1. Comparar el nuevo valor con el nodo actual.
2. Si es menor, explorar subárbol izquierdo; si no, explorar derecho.
3. Base: cuando encuentro un `null`, asigno el nuevo nodo.

#### Búsqueda del Máximo (Recursiva)

```java
mayor(nodo) {
    if (nodo == null) return null;
    if (nodo.getHijoDerecho() == null) 
        return nodo;  // Encontré el máximo
    return mayor(nodo.getHijoDerecho());  // Seguir hacia la derecha
}
```

**Estrategia**: Siempre descender hacia la derecha. El caso base es que no hay hijo derecho → ese nodo es el máximo.

### Implementación

**Ubicación**: [src/abb/](../../../src/abb/)

**Componentes**:
- [NodoABB.java](../../../src/abb/NodoABB.java): Estructura de nodo con getters/setters.
- [ABB.java](../../../src/abb/ABB.java): Árbol propiamente dicho.
- [AppABB.java](../../../src/abb/AppABB.java): Carga de datos y rutina principal.

**Flujo de ejecución**:
1. Crear instancia vacía de ABB.
2. Leer datos desde `src/abb/datos.txt` (formato CSV).
3. Insertar los valores manteniendo la propiedad ABB.
4. Encontrar el elemento máximo mediante `mayor()`.
5. Imprimir el resultado.

**Archivo de datos** (`src/abb/datos.txt`, ejemplo):
```
15,8,3,10,1,6,14,4,7,13,12,2,11,5,9
```
- Primer elemento: **15** (cantidad de datos a insertar).
- Restantes: **8, 3, 10, 1, 6, 14, 4, 7, 13, 12, 2, 11, 5, 9** (los 15 valores).

### Complejidad Temporal

- **Inserción**: O(log n) en promedio (árbol balanceado), O(n) en peor caso (árbol degenerado).
- **Búsqueda del máximo**: O(h) donde h es la altura (O(log n) en balanceado, O(n) en degenerado).

### Ejemplo de Ejecución

**Entrada** (`datos.txt`):
```
15,8,3,10,1,6,14,4,7,13,12,2,11,5,9
```

**Construcción del ABB**:
```
         8
       /   \
      3     10
     / \   /  \
    1   6 9    14
       /   \  /  \
      4     7 12 [null]
             /
            11
```

**Salida esperada**:
```
El mayor del ABB es: 14
```

---

## Ejercicio 3: Generación de Matriz con Concurrencia

### Modelamiento del Problema

Basado en el análisis presentado en [referencia/Ej3.md](../../referencia/Ej3.md):

**Objetivo**: Comparar el desempeño de llenar una matriz 5×5 de forma **secuencial vs concurrente**.

**Datos**:
- Vector de 25 elementos generados aleatoriamente (0..15).
- Matriz destino 5×5.
- Se distribuyen los 25 elementos del vector en la matriz fila por fila.

### Decisiones de Diseño

#### Paralelización por Filas

```java
AppHilos[] hilos = new AppHilos[cantHilos];

// Cada hilo se encarga de un rango de filas
hilos[0] = new AppHilos(0, 0);  // Fila 0
hilos[1] = new AppHilos(1, 1);  // Fila 1
...
hilos[4] = new AppHilos(4, 4);  // Fila 4
```

**Justificación**: 
- Dividir el trabajo por filas permite que múltiples hilos trabajen **sin contención** (si no hubiera sincronización requerida).
- Cada hilo maneja un rango específico `[filaIni, filaFin]`.

#### Sincronización con `synchronized(lock)`

```java
@Override
public void run() {
    synchronized (lock) {
        // Esta sección es mutuamente excluyente
        for (int i = filaIni; i <= filaFin; i++) {
            for (int j = 0; j < 5; j++) {
                matrizCC[i][j] = vectorGenerado[k++];
            }
        }
    }
}
```

**Justificación**:
- `synchronized(lock)` asegura que **solo un hilo** entre a la sección crítica a la vez.
- Sin sincronización, dos hilos podrían escribir en `matrizCC[i][j]` simultáneamente → **data race**.
- El lock es un `Object compartido` que actúa como "puerta" de exclusión mutua.

**Trade-off**: La sincronización **elimina la paralelización efectiva** porque los hilos deben esperar su turno. Por eso el desempeño concurrente a menudo es **peor** que el secuencial en este caso (el overhead de sincronización supera el beneficio).

#### Medición de Tiempo

```java
double t1 = System.nanoTime();
// ... operación ...
double elapsed_ms = (System.nanoTime() - t1) / 1_000_000;
```

**Justificación**:
- `System.nanoTime()` retorna nanosegundos (precisión alta).
- Dividir por `1_000_000` convierte a milisegundos.

#### Detección de Procesadores

```java
int cantHilos = Math.min(5, Runtime.getRuntime().availableProcessors());
```

**Justificación**:
- `Runtime.getRuntime().availableProcessors()` obtiene el número de núcleos disponibles.
- Se limita a máximo 5 (porque la matriz es 5×5, uno por fila).
- Si hay menos de 5 núcleos, se crean menos hilos (aprovechar el hardware disponible).

### Implementación

**Ubicación**: [src/hilos/](../../../src/hilos/)

**Componentes**:
- [AppHilos.java](../../../src/hilos/AppHilos.java): Extiende `Thread` para ejecución paralela.

**Flujo de ejecución**:

1. **Generación de vector**:
   ```java
   Random rand = new Random(System.nanoTime());
   for (int i = 0; i < 25; i++) {
       vectorGenerado[i] = rand.nextInt(16);  // Valores 0..15
   }
   ```
   - Se usa `System.nanoTime()` como semilla para variabilidad.

2. **Versión secuencial**:
   ```java
   generarMatrizSC(matrizSC);  // Sin concurrencia
   ```
   - Llena la matriz de forma lineal, sin hilos adicionales.

3. **Versión concurrente**:
   - Crear hilos según procesadores disponibles.
   - Llamar `start()` en cada hilo (no `run()` directamente).
   - `start()` lanza la ejecución en paralelo; `run()` ejecutaría en el hilo actual.
   - Esperar con `join()` para que todos terminen antes de medir tiempo.

4. **Comparación**:
   ```java
   System.out.println("Secuencial: " + (t1_elapsed) + " ms");
   System.out.println("Concurrente: " + (t2_elapsed) + " ms");
   ```

### Patrones Clave

| Patrón | Descripción | En el código |
|--------|-------------|-------------|
| **Thread.start()** | Lanza nuevo hilo en paralelo | `hilos[i].start()` |
| **Thread.run()** | Ejecuta en el hilo actual (NO usar para paralelismo) | Sobrescrito como `@Override` |
| **synchronized(lock)** | Exclusión mutua de sección crítica | Protege acceso a `matrizCC` |
| **Thread.join()** | Bloquea hasta que el hilo termine | `h.join()` |
| **System.nanoTime()** | Reloj de nanosegundos | Medir duración |

### Ejemplo de Ejecución

**Vector generado** (ejemplo):
```
5 - 12 - 3 - 14 - 8 - ...
```

**Matriz secuencial** (resultado):
```
5  12  3  14  8
9  2  11  6   7
...
```

**Matriz concurrente** (resultado idéntico, pero medido en paralelo):
```
5  12  3  14  8
9  2  11  6   7
...
```

**Salida esperada**:
```
Versión NO concurrente: 1.234 ms
Versión CON concurrencia: 2.456 ms

[Ambas matrices tienen contenido idéntico]
```

**Nota**: La versión concurrente es **más lenta** porque el overhead de sincronización (`synchronized`) y cambio de contexto de hilos supera el beneficio del paralelismo.

---

## Decisiones Generales de Implementación

### Uso de Archivos de Datos

- **Ej1**: `src/dieta/alimentos.txt` → CSV con nombre, calorías, grupo.
- **Ej2**: `src/abb/datos.txt` → CSV con cantidad seguida de valores.
- **Ej3**: Generación in-memory (no requiere archivo).

### Manejo de Excepciones

- `FileNotFoundException`: Capturada en `main()` si el archivo no existe.
- `NumberFormatException`: Implícita si el parseo de enteros falla.

### Encapsulación

- Campos privados en `NodoABB`, `Grupo`.
- Acceso vía getters/setters (excepto `Alimento` que usa campos públicos por simplicidad).

---

## Patrones Algorítmicos Aplicados

| Ejercicio | Patrón Principal | Tipo | Complejidad |
|-----------|------------------|------|-------------|
| **Dieta** | Backtracking con poda | Búsqueda exhaustiva | O(b^d) con poda |
| **ABB Mayor** | Recursión sobre estructura | Árbol binario | O(h) |
| **Concurrencia** | Secciones críticas sincronizadas | Paralelismo | O(n/p) + overhead |

---

## Observaciones Finales

1. **Backtracking es NP-completo**: La prueba de dieta es potencialmente exponencial. La poda (`esAceptable`) es crítica para eficiencia.

2. **ABB requiere balanceo**: Este ejercicio asume inserción aleatoria. Un árbol degenerado (ej: insertar en orden) sería O(n).

3. **Concurrencia requiere sincronización**: Sin `synchronized`, habría race conditions. Con él, la paralelización se pierde (mutex es un cuello de botella).

4. **Archivos CSV**: Todos usan parsing simple con `split(",")` e `Integer.parseInt()`. No se maneja escape de comas.

5. **Pruebas**:
   - Dieta: verificar que cubre todos los grupos y respeta límites de calorías.
   - ABB: confirmar que el máximo es realmente el mayor valor insertado.
   - Concurrencia: ambas matrices deben ser idénticas; la diferencia está solo en tiempo.
