# Explicación Detallada - Prueba 1 2024 S2

## Objetivo

Documentar el código existente y establecer qué debe incorporarse para resolver cada problema sin presentar la base como una implementación completa.

## Implementación actual

`src/Main.java` contiene solamente `main` y dos impresiones. No recibe datos, no implementa recursión, no crea matrices y no modela el árbol.

Su complejidad es `O(1)` en tiempo y espacio, pero esa observación no tiene valor resolutivo: el programa no satisface ningún ejercicio.

## Algoritmos requeridos

### Ruteo recursivo

Debe trazarse manualmente `proc(25, 1)`, registrando los valores de `m`, `n`, las llamadas pendientes y los retornos. La división entera `m / 10` garantiza progreso hacia `m == 0`.

### Suma de matriz con divide y conquista

Una solución debe definir:

- Caso base para una celda o región mínima.
- División de la matriz en subregiones.
- Suma recursiva de resultados parciales.

Si se divide en cuatro cuadrantes, el tamaño `N = 2^i` permite particiones exactas. Cada elemento debe sumarse una vez, por lo que el trabajo total esperado es `O(N²)`.

### Palíndromo recursivo

El contrato natural compara los caracteres en posiciones izquierda y derecha:

```text
esPalindromo(palabra, izquierda, derecha)
```

El caso base ocurre cuando los índices se cruzan. Si los extremos difieren se retorna falso; si coinciden, ambos índices avanzan hacia el centro.

### Promedio de hojas en ABB

Una hoja cumple:

```text
izquierdo == null y derecho == null
```

Para calcular el promedio se necesitan suma de edades y cantidad de hojas. Puede retornarse un par acumulado o usar dos recorridos. Un recorrido único visita `n` nodos en `O(n)` y utiliza `O(h)` de pila, donde `h` es la altura.

## Correctitud y terminación esperadas

Cada algoritmo recursivo debe reducir una medida:

- Cantidad de dígitos en el ruteo.
- Tamaño de la región de matriz.
- Distancia entre índices del palíndromo.
- Altura restante del árbol.

Sin esa reducción no puede justificarse terminación.

## Estado actual

Ninguno de estos algoritmos está presente en `Main.java`. La documentación define el trabajo pendiente, no una solución.

## Cómo verificar una futura solución

Debe compilarse todo `src/`, ejecutar casos normales y borde, y contrastar:

- Matrices de tamaño 1 y potencias de dos.
- Palabras de longitud par, impar y un carácter.
- Árbol vacío, una hoja y varias hojas.
- Resultado manual del ruteo.
