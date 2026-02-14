package dieta;

import java.io.File;          // Clase para manipular rutas de archivos
import java.io.IOException;   // Excepción para errores de I/O
import java.util.Scanner;    // Clase para leer entrada (archivos o consola)

// Aplicación de Dieta usando Backtracking
// Objetivo: Encontrar una combinación de alimentos que cumpla restricciones de calorías y grupos
public class DietaApp {
    // Constantes: límites máximos
    private static int MAX_GRUPOS = 7;        // 7 grupos alimenticios (normalizado a 0-6)
    private static int MAX_ALIMENTOS = 100;   // Máximo de alimentos a procesar

    // Arreglos estáticos compartidos por todos los métodos
    private static Grupo[] grupos = new Grupo[MAX_GRUPOS];           // Estado de cada grupo
    private static Alimento[] alimentos = new Alimento[MAX_ALIMENTOS]; // Todos los alimentos
    private static Alimento[] solucion = new Alimento[MAX_ALIMENTOS];  // Alimentos seleccionados
    
    // Contadores
    private static int cantAlimentos = 0;         // Cuántos alimentos se cargaron
    private static int cantAlimentosDieta = 0;   // Cuántos alimentos se seleccionaron
    private static int sumaCaloriasActual = 0;   // Sum total de calorías seleccionadas

    // Límites de calorías
    private static int limiteInferior;
    private static int limiteSuperior;

    // Punto de entrada de la aplicación
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        // Lee los límites de calorías de la entrada estándar
        limiteInferior = Integer.parseInt(sc.nextLine());
        limiteSuperior = Integer.parseInt(sc.nextLine());

        inicializarGrupos();  // Crea los 7 grupos con contador en 0
        leerAlimentos();      // Carga alimentos desde archivo

        // Intenta encontrar una solución usando backtracking
        // intenta(0) comienza desde el primer alimento
        boolean ok = intenta(0);
        if (ok) {
            imprimirSolucion();        // Si encontró solución, la muestra
        } else {
            System.out.println("No hay solucion");
        }
    }

    // Inicializa los 7 grupos alimenticios
    public static void inicializarGrupos() {
        for (int i = 0; i < MAX_GRUPOS; i++) {
            grupos[i] = new Grupo("G" + (i + 1));  // Crea G1, G2, ..., G7
        }
    }

    // Lee alimentos desde un archivo de texto
    // Formato del archivo: nombre,calorias,grupo (ej: Pollo,250,2)
    public static void leerAlimentos() throws IOException {
        File file = new File("src/dieta/alimentos.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            // split(",") divide la línea en 3 partes usando la coma como separador
            String[] datos = scan.nextLine().split(",");
            String nombre = datos[0];
            // parseInt convierte texto a número entero
            int calorias = Integer.parseInt(datos[1]);
            // -1 normaliza grupo de 1-7 a índices 0-6
            int grupo = Integer.parseInt(datos[2]) - 1;
            alimentos[cantAlimentos++] = new Alimento(nombre, calorias, grupo);
        }
        scan.close();  // Cierra el archivo
    }

    // BACKTRACKING: intenta encontrar una combinación válida
    // k: índice del alimento desde el cual comenzar a buscar
    // Usa recursión: cada llamada decide si incluir el alimento k o no
    public static boolean intenta(int k) {
        // Caso base: ya pasamos todos los alimentos
        if (k >= cantAlimentos) {
            return false;
        }

        // Itera desde el alimento k hasta el final
        for (int i = k; i < cantAlimentos; i++) {
            if (esAceptable(i)) {                    // ¿Puedo agregar este alimento?
                registrarSeleccion(i);               // Sí, lo agrego
                if (!solucionIncompleta()) {         // ¿La solución es completa?
                    return true;                     // ¡Encontré la solución!
                }
                if (intenta(i + 1)) {                // Recursión: intenta con los siguientes
                    return true;                     // Si recursión encuentra solución, retorna
                }
                cancelarSeleccion();                 // BACKTRACK: deshace la selección
            }
        }
        return false;  // No hay solución desde k
    }

    // Verifica si un alimento puede ser agregado a la solución
    // Condiciones:
    // 1) Calorías totales no excedan el límite superior
    // 2) El grupo tiene menos de 2 alimentos seleccionados
    private static boolean esAceptable(int idx) {
        Alimento a = alimentos[idx];
        int sumaCal = sumaCaloriasActual + a.calorias;  // Suma si agrego este alimento
        int grupo = a.grupo;
        return sumaCal <= limiteSuperior && grupos[grupo].cantAlimGrupo < 2;
    }

    // Registra la selección de un alimento (avanza en backtracking)
    private static void registrarSeleccion(int idx) {
        Alimento a = alimentos[idx];
        solucion[cantAlimentosDieta++] = a;         // Agrega a la solución
        grupos[a.grupo].cantAlimGrupo++;            // Incrementa contador del grupo
        sumaCaloriasActual += a.calorias;           // Suma calorías
    }

    // Cancela la selección (retrocede en backtracking - BACKTRACK)
    // Usa --cantAlimentosDieta para decrementar y acceder al último elemento agregado
    private static void cancelarSeleccion() {
        Alimento a = solucion[--cantAlimentosDieta];  // Obtiene y decrementa
        solucion[cantAlimentosDieta] = null;          // Limpia la posición
        grupos[a.grupo].cantAlimGrupo--;              // Decrementa contador del grupo
        sumaCaloriasActual -= a.calorias;             // Resta calorías
    }

    // Verifica si la solución actual es completa (cumple todas las restricciones)
    // Restricciones:
    // 1) Calorías deben estar en el rango [limiteInferior, limiteSuperior]
    // 2) Cada grupo debe tener al menos 1 alimento
    private static boolean solucionIncompleta() {
        if (sumaCaloriasActual < limiteInferior || sumaCaloriasActual > limiteSuperior) {
            return true;  // Calorías fuera de rango
        }
        for (int g = 0; g < MAX_GRUPOS; g++) {
            if (grupos[g].cantAlimGrupo < 1) {
                return true;  // Grupo sin alimentos
            }
        }
        return false;  // Solución completa
    }

    // Imprime la solución encontrada
    private static void imprimirSolucion() {
        for (int i = 0; i < cantAlimentosDieta; i++) {
            Alimento a = solucion[i];
            // Imprime en formato: nombre,calorias,grupo(normalizado a 1-7)
            System.out.println(a.nombre + "," + a.calorias + "," + (a.grupo + 1));
        }
    }
}
