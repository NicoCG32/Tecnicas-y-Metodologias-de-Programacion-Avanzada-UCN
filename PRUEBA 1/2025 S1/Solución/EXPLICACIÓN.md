# Explicación Detallada - Técnicas y Metodologías de Programación Avanzada

## Ejercicio 1: Suma de Dígitos (Recursión)

### Problema
Dado un número entero positivo, calcular la suma de sus dígitos utilizando **recursión**.

**Ejemplo:**
- 123 → 1 + 2 + 3 = 6
- 502 → 5 + 0 + 2 = 7

### Estrategia Recursiva

La clave para resolver este problema recursivamente es descomponer el número en:
1. **El dígito más a la derecha** (obtenido con `n % 10`)
2. **El resto del número** (obtenido con `n / 10`)

#### Desglose Visual:
```
sumaDigitos(123)
├─ 3 (123 % 10)
└─ sumaDigitos(12)           // 123 / 10
   ├─ 2 (12 % 10)
   └─ sumaDigitos(1)         // 12 / 10
      ├─ 1 (1 % 10)
      └─ sumaDigitos(0)      // 1 / 10 = 0

Resultado: 3 + (2 + (1 + 0)) = 6
```

### Función Recursiva

```java
public static int sumaDigitos(int n) {
    // Caso base: si solo queda un dígito
    if (n / 10 == 0) {
        return (n % 10);
    }
    
    // Caso recursivo: sumar último dígito + recursión del resto
    int modulo = n % 10;
    return sumaDigitos(n / 10) + modulo;
}
```

#### Explicación:
- **Caso base:** `n / 10 == 0` significa que `n` es un número de un solo dígito (0-9). Retornamos `n % 10` (el dígito mismo).
- **Caso recursivo:** Extraemos el último dígito con `n % 10` y lo sumamos con el resultado de la recursión sobre el resto del número (`n / 10`).

#### ⚠️ Nota importante - División de enteros en Java:
En Java, cuando se dividen dos números enteros (int), el resultado **descarta los decimales** automáticamente. Por ejemplo:
- `123 / 10 = 12` (no 12.3)
- `12 / 10 = 1` (no 1.2)
- `1 / 10 = 0` (no 0.1)

Esta es una característica fundamental de la división entera y es lo que permite que el caso base `n / 10 == 0` funcione correctamente para detectar cuando solo queda un dígito.

---

## Ejercicio 2: Multiplicar Números Impares (Divide y Conquista)

### Problema
Dado un arreglo de enteros, multiplicar todos los números impares usando la estrategia de **divide y conquista**.

**Consideración:** Si no hay números impares, retornar 1.

### Estrategia Divide y Conquista

Esta técnica divide el problema en subproblemas más pequeños:
1. **Divide:** Dividir el arreglo en dos mitades
2. **Conquista:** Resolver recursivamente cada mitad
3. **Combina:** Multiplicar los resultados de ambas mitades

#### Ejemplo de ejecución:
```
multiplicarImpares([2, 3, 5, 8, 7], 0, 4)
├─ Izquierda: multiplicarImpares([2, 3, 5, 8, 7], 0, 2)
│  ├─ Izquierda: multiplicarImpares([2, 3], 0, 1)
│  │  ├─ Izquierda: multiplicarImpares([2], 0, 0) = 1
│  │  └─ Derecha: multiplicarImpares([3], 1, 1) = 3
│  │  Resultado: 1 * 3 = 3
│  ├─ Derecha: multiplicarImpares([5], 2, 2) = 5
│  Resultado: 3 * 5 = 15
├─ Derecha: multiplicarImpares([8, 7], 3, 4)
│  ├─ Izquierda: multiplicarImpares([8], 3, 3) = 1
│  └─ Derecha: multiplicarImpares([7], 4, 4) = 7
│  Resultado: 1 * 7 = 7
Resultado Final: 15 * 7 = 105
```

### Función Recursiva

```java
public static int multiplicarImpares(int[] arr, int inicio, int fin) {
    // Caso base: rango inválido
    if (inicio > fin) {
        return 1;
    }
    
    // Caso base: un solo elemento
    if (inicio == fin) {
        if (arr[inicio] % 2 == 1) {
            return arr[inicio];
        } else {
            return 1;
        }
    }
    
    // Divide y conquista
    int mid = (inicio + fin) / 2;
    return multiplicarImpares(arr, inicio, mid) * 
           multiplicarImpares(arr, mid + 1, fin);
}
```

#### Explicación:
- **Caso base 1:** Si `inicio > fin`, el rango es inválido, retornar 1 (elemento neutro de la multiplicación).
- **Caso base 2:** Si hay un solo elemento, verificar si es impar. Si lo es, retornarlo; si no, retornar 1.
- **Divide y Conquista:** Calcular el punto medio y resolver recursivamente ambas mitades, multiplicando resultados.

---

## Ejercicio 3: Árbol Binario de Búsqueda (ABB)

### Problema
Organizar datos de personas en un **Árbol Binario de Búsqueda** ordenado por RUT, e implementar:
1. **Inserción recursiva** de personas
2. **Suma de edades** de nodos con exactamente un solo hijo

### Estructura de Datos

```
Persona: { rut, nombre, edad }
Nodo: { persona, izquierdo, derecho }
```

### 3.1 - Inserción Recursiva

#### Estrategia:
El ABB mantiene la propiedad: los valores menores van a la izquierda, los mayores a la derecha.

```
Insertar personas con RUTs: 55, 33, 77, 22, 44, 66, 88

        55
       /  \
      33   77
     / \   / \
    22 44 66 88
```

#### Función Recursiva:
```java
private Nodo insertarRec(Nodo nodo, Persona persona) {
    if (nodo == null) {
        return new Nodo(persona);  // Crear nuevo nodo
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
```

#### Explicación:
- **Caso base:** Si el nodo es nulo, creamos uno nuevo con la persona.
- **Caso recursivo:** Comparamos el RUT de la persona actual con el del nuevo nodo:
  - Si es menor, insertamos en el subárbol izquierdo.
  - Si es mayor o igual, insertamos en el subárbol derecho.

#### 📌 Sobre el método `compareTo()`:
El método `compareTo()` es un método de la clase `String` que compara dos cadenas **lexicográficamente** (alfabéticamente):
- Retorna un valor **negativo** si la cadena actual es menor que la cadena comparada
- Retorna **0** si son iguales
- Retorna un valor **positivo** si la cadena actual es mayor que la cadena comparada

```java
"12345678".compareTo("87654321")  // Retorna negativo (12345678 < 87654321)
"87654321".compareTo("12345678")  // Retorna positivo (87654321 > 12345678)
"55555555".compareTo("55555555")  // Retorna 0 (son iguales)
```

**Alternativa - Convertir RUT a entero:**
Si los RUT fuesen numéricos puros y sin caracteres especiales, se podría haber convertido a entero:
```java
int rutInt1 = Integer.parseInt(nodo.persona.rut);
int rutInt2 = Integer.parseInt(persona.rut);

if (rutInt1 > rutInt2) {
    nodo.izquierdo = insertarRec(nodo.izquierdo, persona);
} else {
    nodo.derecho = insertarRec(nodo.derecho, persona);
}
```

Sin embargo, en el contexto real de Chile, los RUT contienen un dígito verificador con un carácter especial (ej: "12345678-9"), por lo que es más práctico tratarlos como strings y usar `compareTo()`.

---

#### Concepto:
Un nodo con un solo hijo es aquel que tiene:
- Solo hijo izquierdo (hijo derecho es nulo), o
- Solo hijo derecho (hijo izquierdo es nulo)

#### Ejemplo:
```
        55 (2 hijos) ← no cuenta
       /  \
      33   77 (1 hijo: derecho) ← SUMA
     / \    \
    22 44   88 (0 hijos) ← no cuenta

Nodos con un solo hijo: 77
Suma de edades: 30 (edad de 77)
```

#### Función Recursiva:
```java
private int sumaEdadesUnSoloHijoRec(Nodo nodo) {
    int suma = 0;
    if (nodo != null) {
        // Recorrer subárbol izquierdo
        suma += sumaEdadesUnSoloHijoRec(nodo.izquierdo);
        
        // Recorrer subárbol derecho
        suma += sumaEdadesUnSoloHijoRec(nodo.derecho);
        
        // Verificar si este nodo tiene un solo hijo
        if ((nodo.izquierdo == null && nodo.derecho != null) || 
            (nodo.izquierdo != null && nodo.derecho == null)) {
            suma += nodo.persona.edad;
        }
    }
    return suma;
}
```

#### Explicación:
- **Recorrido Post-orden:** Visitamos primero los subárboles izquierdo y derecho, luego verificamos el nodo actual.
- **Condición:** Sumamos la edad solo si el nodo tiene exactamente un hijo (XOR lógico entre izquierdo y derecho).

#### 📌 Operadores Lógicos en la Condición XOR:
La condición utiliza operadores lógicos para verificar exactamente un solo hijo:

```java
if ((nodo.izquierdo == null && nodo.derecho != null) || 
    (nodo.izquierdo != null && nodo.derecho == null)) {
    suma += nodo.persona.edad;
}
```

**Operadores utilizados:**
- `&&` (AND lógico): Ambas condiciones deben ser verdaderas
- `||` (OR lógico): Al menos una de las condiciones debe ser verdadera

**Desglose de la condición:**
1. Primera parte: `(nodo.izquierdo == null && nodo.derecho != null)`
   - Significa: hijo izquierdo ES nulo Y hijo derecho NO ES nulo
   - Es decir: Solo tiene hijo derecho

2. Segunda parte: `(nodo.izquierdo != null && nodo.derecho == null)`
   - Significa: hijo izquierdo NO ES nulo Y hijo derecho ES nulo
   - Es decir: Solo tiene hijo izquierdo

3. Ambas partes conectadas con `||`:
   - Se cumple si alguna de las dos condiciones es verdadera
   - Conclusión: El nodo tiene exactamente UN solo hijo

**Ejemplos:**
```java
// Nodo con solo hijo derecho
if ((null == null && derecho != null) ||      // Esta es VERDADERA
    (null != null && null == null)) {          // Esta es FALSA
    // Entra aquí porque al menos una es verdadera (||)
}

// Nodo con dos hijos
if ((izquierdo == null && derecho != null) || // FALSA
    (izquierdo != null && derecho == null)) {  // FALSA
    // NO entra, ambas son falsas
}
```

---

## Ejercicio 4: Recorrido Post-Orden

### Problema
Realizar un **recorrido post-orden** del árbol binario y mostrar los valores.

### Tipos de Recorridos

#### In-orden (IZQ-RAÍZ-DCHO):
Recorre izquierda, luego raíz, luego derecha → **Resultado ordenado en ABB**

#### Pre-orden (RAÍZ-IZQ-DCHO):
Recorre raíz, luego izquierda, luego derecha

#### **Post-orden (IZQ-DCHO-RAÍZ):**
Recorre izquierda, luego derecha, luego raíz → **Útil para eliminar nodos**

### Ejemplo de Post-orden:

**Árbol Binario de Búsqueda resultante:**
```
        8
       / \
      3   10
     / \    \
    1   6   14
       / \   /
      4  7 13
```

**Recorrido Post-orden: 1 - 4 - 7 - 6 - 3 - 13 - 14 - 10 - 8**

**Explicación paso a paso:**
1. Procesar 1 (hoja izquierda de 3)
2. Procesar 4 (hijo izquierdo de 6)
3. Procesar 7 (hijo derecho de 6)
4. Procesar 6 (después de procesar su subárbol)
5. Procesar 3 (después de procesar su subárbol izquierdo)
6. Procesar 13 (hoja izquierda de 14)
7. Procesar 14 (después de procesar su hijo izquierdo)
8. Procesar 10 (después de procesar su subárbol derecho)
9. Procesar 8 (raíz, al final en post-orden)

#### Función Recursiva (Ejemplo):
```java
public void postOrden(Nodo nodo) {
    if (nodo != null) {
        postOrden(nodo.izquierdo);    // Izquierda
        postOrden(nodo.derecho);      // Derecha
        System.out.print(nodo.persona.rut + " "); // Raíz
    }
}
```

---

## Conceptos Clave

### Recursión
- **Caso base:** Condición que detiene la recursión
- **Caso recursivo:** La función se llama a sí misma con un problema más pequeño
- **Ventaja:** Código más simple y elegante para problemas naturalmente recursivos

### Divide y Conquista
1. **Divide:** Partir en subproblemas
2. **Conquista:** Resolver recursivamente
3. **Combina:** Unir soluciones

### Árboles Binarios
- Estructura jerárquica con máximo 2 hijos por nodo
- **ABB:** Mantiene orden (izquierda < raíz < derecha)
- **Recorridos:** Distintas formas de visitar todos los nodos
