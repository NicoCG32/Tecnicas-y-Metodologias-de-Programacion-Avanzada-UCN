# Solución

**Asignatura**: Técnicas y Metodologías de Programación Avanzada  
**Período**: 2024 Semestre 2  
**Tipo**: Prueba 2

**Estado**: ✅ Implementación completa | ✅ Documentación completa

## Descripción

Esta carpeta contiene las soluciones de la Prueba 2: tres ejercicios que evalúan patrones algorítmicos fundamentales. La prueba cubre **Backtracking** (búsqueda con poda), **Árboles Binarios de Búsqueda (ABB)** con operaciones recursivas, y **Concurrencia** con sincronización de hilos.

- **Duración**: 3 horas
- **Tipo de problemas**: Algoritmos y estructuras de datos avanzadas

## Ejercicios y Descripción

### Ejercicio 1: Selección de Dieta (Backtracking)
**Patrón**: Backtracking con poda  
**Objetivo**: Encontrar una combinación de alimentos que cumpla restricciones de calorías y cobertura de grupos alimenticios.

**Restricciones**:
- Calorías entre `limiteInferior` y `limiteSuperior` (kcal)
- Máximo 1 alimento por grupo (7 grupos totales)
- Debe cubrirse al menos 1 alimento de cada grupo

**Archivos de datos**:
- `alimentos.txt` (15 alimentos con nombre, calorías, grupo)

**Clases**:
- `Alimento.java`: Entidad con nombre, calorías, grupo
- `Grupo.java`: Contador de alimentos seleccionados por grupo
- `DietaApp.java`: Algoritmo de backtracking principal

### Ejercicio 2: Búsqueda del Mayor en ABB (Recursión)
**Patrón**: Árbol Binario de Búsqueda (ABB) con recursión  
**Objetivo**: Encontrar el elemento de mayor valor en un ABB manteniendo la propiedad de búsqueda.

**Operaciones**:
- Inserción recursiva manteniendo propiedad ABB (izq < nodo ≤ der)
- Búsqueda del máximo recorriendo hacia la derecha

**Archivos de datos**:
- `datos.txt` (cantidad, seguida de valores a insertar)

**Clases**:
- `NodoABB.java`: Estructura de nodo con getters/setters
- `ABB.java`: Árbol con inserción y búsqueda recursiva
- `AppABB.java`: Carga de datos y rutina principal

### Ejercicio 3: Generación de Matriz con Concurrencia
**Patrón**: Multi-threading con sincronización  
**Objetivo**: Comparar desempeño de llenar una matriz 5×5 de forma secuencial vs concurrente.

**Características**:
- Generación de vector aleatorio (25 elementos, valores 0..15)
- Llenado secuencial: un hilo
- Llenado concurrente: múltiples hilos con synchronization
- Comparación de tiempos en milisegundos

**Clases**:
- `AppHilos.java`: Extiende `Thread`, con métodos generadores y medición de tiempo

## Estructura de la Solución

```
Solución/
├── src/
│   ├── dieta/
│   │   ├── Alimento.java
│   │   ├── Grupo.java
│   │   ├── DietaApp.java
│   │   └── alimentos.txt
│   ├── abb/
│   │   ├── NodoABB.java
│   │   ├── ABB.java
│   │   ├── AppABB.java
│   │   └── datos.txt
│   └── hilos/
│       └── AppHilos.java
├── README.md (este archivo)
├── EXPLICACION.md (documentación detallada)
└── referencia/
    ├── Ej1.md
    ├── Ej2.md
    └── Ej3.md
```

## Cómo Cargar y Ejecutar en Eclipse

### Ubicación en el Repositorio
Este código se encuentra en: `Técnicas y Metodologías de Prog. Avanz/PRUEBA 2/2024 S2/Solución/src/`

### Opción Recomendada: Copiar la Carpeta `src/`

1. **Obtener los archivos fuente:**
   - Descarga o clona el repositorio `Programacion-Avanzada`
   - Navega a `Técnicas y Metodologías de Prog. Avanz/PRUEBA 2/2024 S2/Solución/`
   - Copia SOLO la carpeta `src/` a tu computadora

2. **En Eclipse, crear un nuevo proyecto Java:**
   - `File` → `New` → `Java Project`
   - Nombre: `Prueba2_TecMetProg`
   - Selecciona `Create from existing source`
   - Browse → Apunta a la carpeta `src/` que copiaste
   - Finish

3. **Ejecutar cada ejercicio:**
   - **Ej1 (Dieta)**: Clic derecho en `src/dieta/DietaApp.java` → `Run As` → `Java Application`
     - Ingresa dos números: límite inferior y superior de calorías
   - **Ej2 (ABB)**: Clic derecho en `src/abb/AppABB.java` → `Run As` → `Java Application`
   - **Ej3 (Concurrencia)**: Clic derecho en `src/hilos/AppHilos.java` → `Run As` → `Java Application`

### Importante: Archivos de Texto

Para que el programa pueda leer los archivos de texto (.txt) correctamente:
- Copia los archivos desde sus ubicaciones originales a la raíz de tu proyecto (paralelo a la carpeta `src/`):
  - `alimentos.txt` (actualmente en `src/dieta/alimentos.txt`)
  - `datos.txt` (actualmente en `src/abb/datos.txt`)
- Los archivos requeridos son:
  - `alimentos.txt` (para el ejercicio de Dieta)
  - `datos.txt` (para el ejercicio de ABB)
- El programa los buscará en la raíz del proyecto, no dentro de `src/`

### Opción Alternativa: Copiar Archivos Manualmente

1. **Crear un nuevo proyecto Java en Eclipse:**
   - `File` → `New` → `Java Project` → Nombre: `Prueba2_TecMetProg` → Finish

2. **Copiar los archivos:**
   - **Fase 1**: Copia los directorios `dieta/`, `abb/`, `hilos/` (con todos sus archivos `.java` y `.txt`)
   - Ve a `Técnicas y Metodologías de Prog. Avanz/PRUEBA 2/2024 S2/Solución/src/`
   - Copia las carpetas `dieta/`, `abb/`, `hilos/` y pégalas en la carpeta `src/` de tu proyecto
   - Eclipse reconocerá automáticamente los paquetes

3. **Ejecutar:**
   - **Ej1**: Clic derecho en `dieta/DietaApp.java` → `Run As` → `Java Application`
   - **Ej2**: Clic derecho en `abb/AppABB.java` → `Run As` → `Java Application`
   - **Ej3**: Clic derecho en `hilos/AppHilos.java` → `Run As` → `Java Application`

## Verificar que Todo Funciona Correctamente

### Ejercicio 1 - Dieta (Backtracking)
- **Entrada esperada**:
  ```
  2000
  3000
  ```
  (Límite inferior: 2000 kcal, superior: 3000 kcal)
- **Salida**: Combinación de alimentos que cumpla restricciones o mensaje de no solución

### Ejercicio 2 - ABB Mayor
- **Entrada**: Archivo `datos.txt` debe existir en la raíz del proyecto
- **Salida esperada**:
  ```
  El mayor del ABB es: 14
  ```

### Ejercicio 3 - Concurrencia
- **Entrada**: Generación interna de datos
- **Salida esperada**:
  ```
  Vector con los 25 datos generados
  [listado de números]
  
  Versión NO concurrente: X.XXX ms
  Matriz SIN concurrencia
  [matriz 5x5]
  
  Versión CON concurrencia: X.XXX ms
  Matriz CON concurrencia
  [matriz 5x5]
  ```

## Documentación

Para una explicación completa y detallada sobre el modelado, algoritmos, decisiones de diseño y patrones utilizados, revisa el archivo [EXPLICACION.md](EXPLICACION.md).

### Referencia de Ejercicios

Los enunciados y planteamientos detallados de cada ejercicio se encuentran en la carpeta [referencia/](referencia/):
- [referencia/Ej1.md](referencia/Ej1.md) - Modelamiento del problema de dieta
- [referencia/Ej2.md](referencia/Ej2.md) - Especificación de ABB
- [referencia/Ej3.md](referencia/Ej3.md) - Detalles de concurrencia

## Notas Importantes

- **Archivos de datos**: Los archivos `.txt` (`alimentos.txt` y `datos.txt`) deben estar en la raíz del proyecto (paralelo a `src/`).
- **Backtracking**: El Ejercicio 1 puede tardar dependiendo de los límites de calorías ingresados.
- **Concurrencia**: El Ejercicio 3 mostrará que la versión concurrente es frecuentemente más lenta que la secuencial debido al overhead de sincronización.
- **Entrada estándar**: El Ejercicio 1 requiere ingreso manual de dos valores. Los otros leen archivos automáticamente.

## Estado

- [x] Base de estructura
- [x] Implementación completa
- [x] Documentación Ejercicio 1 (Backtracking)
- [x] Documentación Ejercicio 2 (Árbol Binario de Búsqueda)
- [x] Documentación Ejercicio 3 (Hilos)