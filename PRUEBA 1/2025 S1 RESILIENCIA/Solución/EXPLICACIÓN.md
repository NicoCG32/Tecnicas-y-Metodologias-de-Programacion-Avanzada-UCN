# Explicación Detallada - Prueba 1 2025 S1 Resiliencia

## Objetivo

Explicar la base existente y precisar los diseños recursivos necesarios para completar la evaluación.

## Implementación actual

`src/Main.java` no contiene los métodos solicitados. Solo imprime un saludo y el estado “en proceso”.

`referencia/Ej1.md` propone comparar el primer y último dígito sin convertir el entero a texto. Esa referencia debe corregirse antes de trasladarla: declara nuevamente `valor` dentro del `while`, lo que no compila por duplicación de variable local.

## Algoritmos requeridos

### Número capicúa

La estrategia obtiene:

- Primer dígito mediante una potencia de diez.
- Último dígito mediante módulo 10.
- Parte central eliminando ambos extremos.

El caso base es un número de un dígito. Si los extremos difieren, el resultado es falso. La cantidad de dígitos disminuye en dos por llamada.

### Diagonal secundaria

En una matriz `N x N`, la celda de diagonal secundaria en fila `i` es:

```text
matriz[i][N - 1 - i]
```

Divide y conquista puede separar el intervalo de filas. El caso base examina una fila y retorna el elemento si es divisible por 3, o `1`, elemento neutro del producto.

### Ancestro común en ABB

Para IDs ordenados:

- Si ambos son menores, continuar a la izquierda.
- Si ambos son mayores, continuar a la derecha.
- Si se separan, el nodo actual es el ancestro común más cercano.

Luego un segundo recorrido suma el rendimiento de todo el subárbol. En un árbol de altura `h` y subárbol de `k` nodos, el costo es `O(h + k)`.

### Ruteo

`metodo(m, n)` reduce `m` en una unidad hasta `m <= 0`. El ruteo debe registrar multiplicaciones pendientes durante el descenso y resolverlas al retornar.

## Correctitud y casos borde

Una solución completa debe considerar:

- Ceros internos en un capicúa.
- Matriz de tamaño uno.
- Ausencia de elementos divisibles por 3.
- IDs inexistentes o repetidos.
- Árbol vacío.

El enunciado puede asumir entradas válidas, pero esos supuestos deben declararse.

## Estado actual

No existe implementación Java evaluable. La referencia del primer ejercicio es material de estudio y no cambia el estado general.

## Cómo verificar una futura solución

Compile desde `Solución/src/` y agregue casos con resultados calculados manualmente. La matriz debe retornar `1` cuando ningún candidato cumple la divisibilidad.
