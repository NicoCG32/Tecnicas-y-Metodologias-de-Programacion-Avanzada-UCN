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

### Opción 1: Importar como Proyecto Existente

1. **Crear una carpeta del proyecto:**
   - Copia toda la carpeta `Solución/` a una ubicación accesible
   - Renómbrala a algo más descriptivo, ej: `Prueba1_TecMetProg`

2. **Abrir Eclipse y crear un nuevo proyecto Java:**
   - `File` → `New` → `Java Project`
   - Nombre del proyecto: `Prueba1_TecMetProg`
   - Sol project contents: `Create from existing source`
   - Browse → Selecciona la carpeta que copiaste
   - Finish

3. **Lo que Eclipse debería detectar:**
   - Una carpeta `src/` con los 6 archivos Java
   - Eclipse automáticamente compilará los archivos

4. **Ejecutar el programa:**
   - Click derecho en `Main.java` en el Project Explorer
   - `Run As` → `Java Application`

### Opción 2: Importar la Carpeta `src/` Directamente

1. **En Eclipse, crear un nuevo Java Project:**
   - `File` → `New` → `Java Project`
   - Nombre: `Prueba1_TecMetProg`
   - Finish

2. **Copiar archivos fuente:**
   - En el Project Explorer, expande el proyecto
   - Click derecho en la carpeta `src/` (dentro del proyecto)
   - `Import` → `File System`
   - Selecciona la carpeta `src/` de esta solución
   - Finish

3. **Ejecutar:**
   - Click derecho en `Main.java`
   - `Run As` → `Java Application`

### Opción 3: Copiar y Pegar Archivos Manualmente

1. **Crear proyecto Java:**
   - `File` → `New` → `Java Project` → Nombre: `Prueba1_TecMetProg` → Finish

2. **Copiar archivos:**
   - Abre el Explorador de archivos
   - Ve a la carpeta `src/` de esta solución
   - Selecciona todos los archivos `.java`
   - Cópialosy pégalos en `Prueba1_TecMetProg/src/` en Eclipse
   - Eclipse te pedirá confirmar → Click "Yes to All"

3. **Ejecutar:**
   - Click derecho en `Main.java`
   - `Run As` → `Java Application`

### Verificar que Todo Funciona

- En la consola de Eclipse deberías ver:
  ```
  ========================================
  Técnicas y Metodologías de Prog. Avanzada
  Prueba 1 - 2025 S1
  ========================================
  
  === EJERCICIO 1: Suma de Dígitos (Recursivo) ===
  Ingrese un número positivo:
  ```

- Ingresa un número (ej: 123) y presiona Enter

### Nota Importante
Este examen fue realizado de forma presencial en papel, por lo que esta es una **solución anterior a la entrega real**. Los archivos de referencia en `referencia/` corresponden a las soluciones parciales escritas en la prueba.

## Estado

- [x] Base de estructura
- [x] Implementación completa