# Explicación Detallada - RECA 2024 S2

## Objetivo

Describir el estado real de la base y establecer un diseño académico para concurrencia, divide y conquista y backtracking.

## Implementación actual

`src/Main.java` no implementa estructuras, algoritmos ni lectura de datos. Su única función es informar que la solución está pendiente.

## Algoritmos requeridos

### Suma de diagonales con concurrencia

Para cada índice `i` se comparan:

```text
principal   = matriz[i][i]
secundaria  = matriz[i][N - 1 - i]
```

Se suma el mayor. La versión concurrente debe repartir índices entre hilos, almacenar sumas parciales y combinarlas después de `join()`.

Compartir un acumulador sin sincronización genera una condición de carrera. Es preferible que cada hilo escriba en una posición exclusiva y que el hilo principal reduzca los parciales.

El trabajo total sigue siendo `O(N)` para las diagonales. Con `N = 9`, el costo de crear hilos probablemente supera cualquier beneficio; esa observación debe aparecer en la comparación de tiempos.

### Binario a decimal con divide y conquista

Cada dígito aporta:

```text
dígito * 2^posición
```

Puede dividirse el intervalo de dígitos en dos mitades y sumar resultados. El caso base procesa un dígito. La validación debe rechazar símbolos distintos de `0` y `1`.

El tiempo es `O(d)` para `d` dígitos y la pila balanceada usa `O(log d)`.

### Vuelto con backtracking

El estado debe incluir:

- Índice de denominación.
- Monto restante.
- Cantidad disponible por moneda.
- Selección parcial.

Una decisión es aceptable cuando no excede disponibilidad ni monto. Se registra disminuyendo monto y existencias; se cancela restaurándolos. La búsqueda termina al llegar a monto cero.

El peor caso es combinatorio. Las podas más directas son detener montos negativos y descartar ramas cuya disponibilidad restante no puede cubrir el monto.

## Correctitud y terminación esperadas

Los índices concurrentes deben cubrir cada posición una sola vez. La conversión reduce el intervalo. El backtracking avanza de denominación o reduce monto, y restaura el estado al retroceder.

## Estado actual

No hay código que materialice estos diseños. La documentación no cambia el estado “no implementada”.

## Cómo verificar una futura solución

Compare versión secuencial y concurrente sobre la misma matriz, valide conversiones binarias conocidas y pruebe vuelto posible, imposible, cero y limitado por existencias.
