# Solución

**Asignatura**: Técnicas y Metodologías de Programación Avanzada  
**Período**: 2025 Semestre 1  
**Tipo**: Prueba 1

**Estado**: ✅ Implementación Completa

## Descripción

Solución para Prueba 1 de Técnicas y Metodologías de Programación Avanzada.
- **Profesor**: Sebastián Arce
- **Fecha**: 30-04-2025
- **Duración**: 1.5 horas
- **Puntaje total**: 55 puntos (33 para aprobatoria)

## Explicación Detallada

Para una explicación completa y detallada sobre cómo funcionan los algoritmos recursivos, divide y conquista, y la estructura de árboles binarios, consulta el archivo [EXPLICACION.md](EXPLICACION.md).

## Ejercicios

### Ejercicio 1: Suma de Dígitos (15 puntos)
**Problema:** Haz un programa en Java que lea un número entero positivo por pantalla y, usando recursión, calcule la suma de sus dígitos.

**Ejemplos:**
- 123 → 1 + 2 + 3 = 6
- 502 → 5 + 0 + 2 = 7
- 9 → 9

**Restricciones:**
- No puede transformar el valor entero a otro tipo de variable
- Implementar main() y sumaDigitos()

### Ejercicio 2: Multiplicar Impares (15 puntos - Divide y Conquista)
**Problema:** Utilizando dividir para conquistar, se pide multiplicar todos los números impares de una lista.

**Consideraciones:**
- Si no hay números impares en la lista, debe imprimir 1 como resultado
- Implementar multiplicarImpares()
- Usar enfoque recursivo

### Ejercicio 3: Árbol Binario de Búsqueda (15 puntos)
**Problema:** Organización de datos de personas en un árbol binario de búsqueda, ordenado por RUT. Cada nodo contiene una persona con RUT, nombre y edad.

**Se solicita:**
- **3.1:** Inserte recursivamente los valores en el árbol (insertarRec(): Nodo)
- **3.2:** Imprima la suma total de las edades de las personas que tienen exactamente un solo hijo (sumaEdadesUnSoloHijoRec(): int)

### Ejercicio 4: Recorrido Post-Orden (10 puntos)
**Problema:** Realizar un recorrido post-orden del árbol binario y mostrar el resultado.

**Resultado esperado:**
Post-orden: 1 - 4 - 7 - 6 - 3 - 13 - 14 - 10 - 8

## Estructura de la Solución

```
Solución/
├── src/
│   ├── Main.java                (Clase principal - ejecuta todos los ejercicios)
│   ├── SumaDigitos.java         (Ejercicio 1 - Recursión)
│   ├── MultiplicarImpares.java  (Ejercicio 2 - Divide y Conquista)
│   ├── Persona.java             (Clase auxiliar - Ejercicio 3)
│   ├── Nodo.java                (Clase auxiliar - Ejercicio 3)
│   └── ArbolPersonas.java       (Ejercicio 3 - Árbol Binario de Búsqueda)
├── referencia/
│   ├── Ej1.txt                  (Solución de referencia - Suma de Dígitos)
│   ├── Ej2.txt                  (Solución de referencia - Multiplicar Impares)
│   ├── Ej3.txt                  (Solución de referencia - Árbol ABB)
│   └── Ej4.txt                  (Solución de referencia - Recorrido Post-orden)
└── README.md                    (Este archivo)
```

## Cómo Cargar y Ejecutar en Eclipse

### Ubicación en el Repositorio
Este código se encuentra en: `Técnicas y Metodologías de Prog. Avanz/PRUEBA 1/2025 S1/Solución/src/`

### Opción Recomendada: Copiar la Carpeta `src/`

1. **Obtener los archivos fuente:**
	- Descarga o clona el repositorio `Programacion-Avanzada`
	- Navega a `Técnicas y Metodologías de Prog. Avanz/PRUEBA 1/2025 S1/Solución/`
	- Copia SOLO la carpeta `src/` a tu computadora

2. **En Eclipse, crear un nuevo proyecto Java:**
	- `File` → `New` → `Java Project`
	- Nombre: `Prueba1_TecMetProg`
	- Selecciona `Create from existing source`
	- Browse → Apunta a la carpeta `src/` que copiaste
	- Finish

3. **Ejecutar el programa:**
	- Clic derecho en `Main.java`
	- `Run As` → `Java Application`
	- Deberías ver el menú de opciones en la consola

### Opción Alternativa: Copiar Archivos Manualmente

1. **Crear un nuevo proyecto Java en Eclipse:**
	- `File` → `New` → `Java Project` → Nombre: `Prueba1_TecMetProg` → Finish

2. **Copiar los archivos `.java`:**
	- Abre el Explorador de archivos
	- Ve a `Técnicas y Metodologías de Prog. Avanz/PRUEBA 1/2025 S1/Solución/src/`
	- Selecciona todos los archivos `.java`
	- Cópialos y pégalos en la carpeta `src/` de tu proyecto en Eclipse
	- Eclipse pedirá confirmación → Clic "Yes to All"

3. **Ejecutar:**
	- Clic derecho en `Main.java`
	- `Run As` → `Java Application`

### Notas Importantes
Este examen fue realizado de forma presencial en papel, por lo que esta es una **solución anterior a la entrega real**. Los archivos de referencia en `referencia/` corresponden a las soluciones parciales escritas en la prueba.

## Estado

- [x] Base de estructura
- [x] Implementación completa