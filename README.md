# Técnicas y Metodologías de Programación Avanzada - UCN

![Java](https://img.shields.io/badge/Java-orientado%20a%20POO-ED8B00?logo=openjdk&logoColor=white)
![Eclipse](https://img.shields.io/badge/IDE-Eclipse%20opcional-2C2255?logo=eclipseide&logoColor=white)
![Pseudocódigo](https://img.shields.io/badge/Modalidad-Pseudoc%C3%B3digo%20%7C%20Java-6A5ACD)
![Nivel](https://img.shields.io/badge/Nivel-1%20T%C3%A9cnicas%20algor%C3%ADtmicas-blue)

Repositorio de enunciados, archivos de entrada, soluciones y documentación de apoyo para el curso **Técnicas y Metodologías de Programación Avanzada** de la Universidad Católica del Norte.

Este repositorio fue separado desde el repositorio monolítico original para reunir en una unidad autónoma los ejercicios de recursión, divide y conquista, árboles, backtracking y concurrencia en Java.

## Entorno del curso

Este curso es más variable en su modalidad. Puede trabajarse en **Eclipse con Java**, especialmente cuando se implementan soluciones completas, pero también puede evaluarse o ejercitarse **a papel con pseudocódigo**.

En la práctica se orienta a Java porque suele cursarse en paralelo con Programación Orientada a Objetos. Por eso muchos ejercicios usan clases, métodos, árboles y estructuras compatibles con la forma de pensar que se está desarrollando en POO, aunque el foco principal aquí está en la técnica algorítmica.

## Estructura

```text
Tecnicas-y-Metodologias-de-Programacion-Avanzada-UCN/
├── PRUEBA 1/
├── PRUEBA 2/
└── RECA/
```

Cada evaluación puede contener:

- `PRUEBA.pdf` o `Prueba.pdf`: enunciado de la evaluación.
- Archivos `.txt`: datos de entrada usados por la solución.
- `Solución/`: implementación Java y documentación local.
- `Solución/src/`: código fuente.
- `Solución/README.md`: ficha breve con estado, tipo de ejercicios y referencia a la explicación.
- `Solución/referencia/`: material auxiliar o desarrollo de ejercicios, cuando existe.
- `Solución/EXPLICACION.md` o `EXPLICACIÓN.MD`: explicación técnica detallada, cuando existe.

## Soluciones implementadas

### Completas

| Evaluación | Ejercicios disponibles | Conceptos principales |
| --- | --- | --- |
| [Prueba 1 - 2025 S1](PRUEBA%201/2025%20S1/Solución/) | Suma de dígitos, multiplicación de impares, ABB y recorrido postorden. | Recursión, divide y conquista, árbol binario de búsqueda y recorridos. |
| [Prueba 2 - 2024 S2](PRUEBA%202/2024%20S2/Solución/) | Selección de dieta, búsqueda en ABB y matriz concurrente. | Backtracking, poda, ABB, hilos, sincronización y comparación secuencial/concurrente. |

### Parciales

No hay soluciones parciales registradas en este repositorio. Las demás evaluaciones conservan enunciado, estructura base y documentación mínima para implementación futura.

## Evaluaciones

### Prueba 1

| Periodo | Estado | Contenido principal |
| --- | --- | --- |
| [2025 S1](PRUEBA%201/2025%20S1/) | Completa | Recursión, divide y conquista, árbol binario de búsqueda y recorrido postorden. |
| [2025 S1 RESILIENCIA](PRUEBA%201/2025%20S1%20RESILIENCIA/) | Base por implementar | Enunciado, referencia y estructura de solución. |
| [2024 S2](PRUEBA%201/2024%20S2/) | Base por implementar | Enunciado y estructura de solución. |

### Prueba 2

| Periodo | Estado | Contenido principal |
| --- | --- | --- |
| [2024 S2](PRUEBA%202/2024%20S2/) | Completa | Backtracking para selección de dieta, ABB, y concurrencia con sincronización. |

### RECA

| Periodo | Estado | Contenido principal |
| --- | --- | --- |
| [2024 S2](RECA/2024%20S2/) | Base por implementar | Enunciado y estructura de solución. |

## Cómo estudiar este repositorio

1. Lee el enunciado y separa claramente entrada, proceso y salida.
2. Identifica la técnica algorítmica principal antes de revisar el código.
3. Revisa el `README.md` dentro de `Solución/`.
4. Ejecuta cada programa desde `src/`.
5. Usa `EXPLICACION.md` y `referencia/` para contrastar la implementación con el razonamiento esperado.

En este curso la prioridad no es solo producir una salida correcta; también importa justificar por qué la técnica elegida resuelve el problema y cuál es su costo.

## Cómo ejecutar las soluciones

Las instrucciones de uso son comunes para todas las evaluaciones y se concentran aquí para evitar repetición en cada carpeta.

### En Eclipse

1. Crea un proyecto Java nuevo.
2. Copia el contenido de la carpeta `Solución/src/` de la evaluación que quieres revisar dentro del `src/` del proyecto.
3. Copia en la raíz del proyecto los archivos `.txt` que estén junto al enunciado, si la solución los utiliza.
4. Ejecuta la clase que contiene `public static void main(String[] args)`.

### Desde terminal

1. Entra a la carpeta `Solución/src/` de la evaluación.
2. Compila los archivos Java con `javac`.
3. Ejecuta la clase principal con `java`.
4. Si el programa lee archivos `.txt`, ejecútalo desde una ubicación donde esas rutas sean válidas o copia los `.txt` al directorio esperado por el código.

## Temario del curso

| Unidad | Contenidos |
| --- | --- |
| 1. Fundamentos de análisis algorítmico | Correctitud, terminación, casos borde, complejidad temporal, complejidad espacial y notación asintótica. |
| 2. Recursión | Caso base, caso recursivo, progreso, pila de llamadas, recursión directa e indirecta, trazado de ejecución. |
| 3. Divide y conquista | División del problema, resolución recursiva, combinación de resultados, recurrencias y análisis de eficiencia. |
| 4. Fuerza bruta | Exploración exhaustiva, generación de combinaciones, validación de candidatos y costo computacional. |
| 5. Backtracking | Construcción incremental de soluciones, poda de ramas inválidas, retroceso y problemas con restricciones. |
| 6. Árboles | Conceptos de raíz, nodo, hoja, altura, profundidad, recorridos DFS/BFS y representación recursiva. |
| 7. Árbol binario de búsqueda | Inserción, búsqueda, recorrido ordenado, cálculo de máximos/mínimos y efecto del balance en el rendimiento. |
| 8. Concurrencia en Java | `Thread`, `Runnable`, `start`, `run`, `join`, ciclo de vida de hilos y coordinación básica. |
| 9. Sincronización | Estado compartido, condiciones de carrera, secciones críticas, `synchronized`, locks y seguridad de hilos. |
| 10. Paralelismo y desempeño | Diferencia entre concurrencia y paralelismo, medición de tiempos, comparación secuencial/concurrente y límites prácticos. |

## Temas de estudio

### Recursión

La recursión consiste en resolver un problema haciendo que una función se invoque a sí misma sobre una versión más pequeña del mismo problema.

Todo algoritmo recursivo correcto necesita:

- **Caso base**: condición que detiene la recursión.
- **Caso recursivo**: llamada que reduce el tamaño o complejidad del problema.
- **Progreso**: garantía de que eventualmente se alcanzará el caso base.

Ejemplos típicos del curso:

- Suma de dígitos.
- Factorial.
- Fibonacci.
- Búsqueda binaria recursiva.
- Recorridos de árboles.

Una recursión mal diseñada suele fallar por no reducir el problema, por omitir el caso base o por acumular demasiadas llamadas en la pila.

### Divide y conquista

Divide y conquista resuelve un problema mediante tres etapas:

1. **Dividir** el problema en subproblemas más pequeños.
2. **Resolver** cada subproblema, usualmente de forma recursiva.
3. **Combinar** las soluciones parciales.

La técnica es adecuada cuando los subproblemas tienen una estructura similar al problema original. Ejemplos clásicos son mergesort, quicksort y búsquedas de máximos o mínimos por partición.

Su análisis normalmente se expresa mediante recurrencias y complejidad asintótica. En muchos casos eficientes aparece una complejidad del orden `O(n log n)`, aunque esto depende de cómo se divide y combina el trabajo.

### Árboles y ABB

Un árbol es una estructura jerárquica formada por nodos y aristas. Sus conceptos centrales son:

- **Raíz**: nodo inicial del árbol.
- **Padre e hijo**: relación jerárquica entre nodos.
- **Hoja**: nodo sin hijos.
- **Altura**: longitud máxima desde un nodo hasta una hoja.
- **Profundidad**: distancia desde la raíz hasta un nodo.

Un **árbol binario** permite como máximo dos hijos por nodo. Un **árbol binario de búsqueda (ABB)** agrega una restricción de orden: los valores menores se ubican a la izquierda y los mayores a la derecha.

Los recorridos más comunes son:

- **Preorden**: nodo, izquierdo, derecho.
- **Inorden**: izquierdo, nodo, derecho.
- **Postorden**: izquierdo, derecho, nodo.
- **Por niveles**: recorrido BFS.

En un ABB balanceado, búsqueda e inserción tienden a `O(log n)`. En un árbol degenerado, esas operaciones pueden caer a `O(n)`.

### Backtracking

Backtracking explora un espacio de soluciones tomando decisiones parciales y retrocediendo cuando una rama no puede conducir a una solución válida.

Su estructura conceptual es:

1. Elegir una alternativa.
2. Verificar si la decisión parcial sigue siendo válida.
3. Continuar recursivamente.
4. Retroceder si la alternativa falla.

Es útil en problemas de combinaciones, restricciones y búsqueda exhaustiva controlada. En el repositorio aparece aplicado a selección de dieta, donde se prueban combinaciones que deben cumplir restricciones.

El backtracking no elimina por sí mismo la naturaleza exponencial de muchos problemas, pero evita explorar ramas que ya se sabe que no pueden producir una solución aceptable.

### Concurrencia y paralelismo

La concurrencia permite estructurar un programa con múltiples tareas que progresan de manera solapada. El paralelismo implica ejecución simultánea real, normalmente usando más de un núcleo de procesamiento.

En Java se trabaja principalmente con:

- `Thread`: clase que representa un hilo.
- `Runnable`: interfaz preferida para definir la tarea ejecutable.
- `start()`: inicia un hilo nuevo.
- `run()`: contiene el código que ejecutará el hilo.
- `join()`: espera a que un hilo termine.
- `sleep(...)`: pausa temporalmente la ejecución.

Cuando varios hilos acceden a datos compartidos, aparecen riesgos como condiciones de carrera, resultados no deterministas y deadlocks. Para controlarlos se usan mecanismos como:

- `synchronized`.
- Locks explícitos.
- Variables `volatile` cuando corresponde.
- Estructuras de datos seguras para concurrencia.

La sincronización debe ser suficiente para proteger el estado compartido, pero no excesiva al punto de bloquear innecesariamente el programa.

## Criterios de análisis

Al estudiar o implementar una solución en este curso, conviene justificar:

- Correctitud: por qué el algoritmo resuelve el problema.
- Terminación: por qué no queda en ciclos o recursiones infinitas.
- Complejidad temporal: cuánto crece el tiempo de ejecución.
- Complejidad espacial: cuánta memoria adicional requiere.
- Robustez: cómo se comporta ante entradas inválidas o casos borde.

## Nota sobre niveles de abstracción

Técnicas y Metodologías de Programación Avanzada se ubica en el **nivel 1** de abstracción, junto con Programación Orientada a Objetos, pero con un énfasis distinto. Mientras POO enseña a modelar dominios mediante clases, objetos y relaciones, este curso refuerza la capacidad de reconocer técnicas de resolución y estructuras de razonamiento algorítmico.

En Programación se trabaja principalmente con una lógica lineal:

```text
input -> proceso 1 -> proceso 2 -> proceso 3 -> output
```

En este curso ya no basta con encadenar instrucciones. Hay que identificar si el problema se resuelve mejor con recursión, divide y conquista, fuerza bruta, backtracking, árboles o concurrencia. Eso obliga a pensar en **formas de resolver**, no solo en líneas de código.

También aparece una primera idea de componente. Cuando se trabaja con árboles, recorridos, contenedores o separación `App -> Sistema -> SistemaImpl`, el programa deja de ser una función aislada y empieza a organizarse como colaboración entre partes. Todavía no se estudia arquitectura avanzada, pero sí se prepara el terreno para Estructura de Datos y Patrones de Software.

| Nivel | Curso o enfoque | Forma principal de pensar |
| --- | --- | --- |
| 0 | [Programación](https://github.com/NicoCG32/Programacion-UCN) | Líneas de código, instrucciones, pasos directos y algoritmos básicos. |
| 1 | [Programación Orientada a Objetos](https://github.com/NicoCG32/Programacion-Orientada-a-Objetos-UCN) y [Técnicas y Metodologías](https://github.com/NicoCG32/Tecnicas-y-Metodologias-de-Programacion-Avanzada-UCN) | Dominio, clases, objetos, relaciones, técnicas de resolución y componentes básicos. |
| 2 | [Estructura de Datos](https://github.com/NicoCG32/Estructura-de-Datos-UCN) | Contenedores, organización de datos, invariantes y algoritmos sobre estructuras. |
| 3 | [Patrones de Software y Programación](https://github.com/NicoCG32/Patrones-de-Software-y-Programacion-UCN) | Componentes, composición de clases, dependencias y arquitectura de software. |

La idea central es que una técnica no se memoriza como plantilla. Se comprende como una forma de mirar el problema: qué se divide, qué se repite, qué se poda, qué estado se comparte y qué costo tiene cada decisión.
