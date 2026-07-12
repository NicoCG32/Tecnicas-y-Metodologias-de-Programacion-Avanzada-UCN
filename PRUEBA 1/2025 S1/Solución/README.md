# Solución - Prueba 1 - 2025 S1

**Asignatura**: Técnicas y Metodologías de Programación Avanzada

**Período**: 2025 S1

**Tipo**: Prueba 1

**Estado**: Completa como material de estudio

## Descripción

La solución cubre suma recursiva de dígitos, producto de impares mediante divide y conquista, inserción y suma recursiva en ABB, y ruteo postorden.

Los tres problemas de programación están en `src/`; el ejercicio de ruteo está desarrollado en `referencia/Ej4.md`.

## Explicación detallada

[EXPLICACIÓN.md](EXPLICACIÓN.md) desarrolla casos base, llamadas recursivas, estructura del ABB y recorrido postorden.

## Ejercicios

| Ejercicio | Estado | Ubicación |
| --- | --- | --- |
| Suma de dígitos | Implementado | `src/sumadigitos/Main.java`. |
| Producto de impares | Implementado | `src/multiplicarimpares/Main.java`. |
| ABB de personas | Implementado | `src/arbol/`. |
| Ruteo postorden | Documentado | `referencia/Ej4.md`. |

## Estructura de la solución

```text
Solución/
├── README.md
├── EXPLICACIÓN.md
├── referencia/
└── src/
    ├── sumadigitos/
    ├── multiplicarimpares/
    └── arbol/
```

## Cómo cargar en Eclipse

Use `Solución/src/` como carpeta fuente. Ejecute por separado:

```text
sumadigitos.Main
multiplicarimpares.Main
arbol.Main
```

## Resultado esperado

Cada clase muestra un caso independiente. La suma de dígitos solicita entrada; los otros programas usan datos demostrativos incluidos en código.

## Estado

- [x] Cuatro ejercicios cubiertos.
- [x] Código Java compilado.
- [x] Referencias y diagrama disponibles.
- [x] Explicación técnica disponible.

La clasificación completa se refiere a cobertura académica; los programas no constituyen una suite automatizada de pruebas.
