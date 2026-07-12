# Solución - Prueba 2 - 2024 S2

**Asignatura**: Técnicas y Metodologías de Programación Avanzada

**Período**: 2024 S2

**Tipo**: Prueba 2

**Estado**: Completa

## Descripción

La evaluación integra selección de dieta mediante backtracking, búsqueda recursiva del mayor en un ABB y construcción de matriz con y sin concurrencia.

## Explicación detallada

[EXPLICACIÓN.md](EXPLICACIÓN.md) desarrolla modelamiento, poda, recorridos, sincronización, complejidad y decisiones de implementación.

## Ejercicios

| Ejercicio | Estado | Ubicación |
| --- | --- | --- |
| Dieta con restricciones | Implementado | `src/dieta/`. |
| Mayor de ABB | Implementado | `src/abb/`. |
| Matriz secuencial y concurrente | Implementado | `src/hilos/AppHilos.java`. |

## Estructura de la solución

```text
Solución/
├── README.md
├── EXPLICACIÓN.md
├── referencia/
└── src/
    ├── dieta/
    ├── abb/
    └── hilos/
```

Los archivos `alimentos.txt` y `datos.txt` se encuentran dentro de sus paquetes de ejemplo.

## Cómo cargar en Eclipse

Use `Solución/src/` como carpeta fuente. Ejecute:

```text
dieta.DietaApp
abb.AppABB
hilos.AppHilos
```

La carpeta de trabajo debe permitir las rutas relativas usadas por cada programa.

## Resultado esperado

La dieta muestra una combinación válida dentro del rango ingresado, el ABB imprime su mayor y el programa concurrente presenta matrices equivalentes con tiempos separados.

## Estado

- [x] Tres ejercicios implementados.
- [x] Código Java compilado.
- [x] Archivos de entrada presentes.
- [x] Explicación técnica extensa.
- [x] Material gráfico y referencias disponibles.
