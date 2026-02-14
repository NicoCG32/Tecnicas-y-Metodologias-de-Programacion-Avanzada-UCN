package hilos;

import java.util.Random;  // Clase para generar números aleatorios

// Aplicación que compara rendimiento: sin concurrencia vs. con concurrencia (hilos)
// Crea una matriz 5x5 de dos formas:
// 1) SIN concurrencia: un único hilo (programa principal)
// 2) CON concurrencia: múltiples hilos ejecutando en paralelo
public class AppHilos extends Thread {  // Extiende Thread para poder ejecutar código en paralelo
    private static int[] vectorGenerado = new int[25];  // Vector aleatorio generado
    private static int[][] matrizCC = new int[5][5];   // Matriz compartida entre hilos (CON concurrencia)
    // Object lock es un "cerrojo" para sincronización: evita que 2 hilos accedan simultáneamente
    private static Object lock = new Object();

    private int filaIni;  // Fila inicial que procesa este hilo
    private int filaFin;  // Fila final que procesa este hilo

    // Constructor: cada hilo conoce el rango de filas que debe procesar
    public AppHilos(int filaIni, int filaFin) {
        this.filaIni = filaIni;
        this.filaFin = filaFin;
    }

    // Genera 25 números aleatorios (0-15) en el vector
    // System.nanoTime() proporciona una semilla única (basada en tiempo del sistema en nanosegundos)
    // nextInt(16) genera un número entre 0 y 15
    public static void generarVectorElementos() {
        Random rand = new Random(System.nanoTime());  // Crea generador con semilla basada en tiempo
        for (int i = 0; i < 25; i++) {
            vectorGenerado[i] = rand.nextInt(16);  // Genera número aleatorio 0-15
        }
    }

    // Versión SIN concurrencia: llena la matriz secuencialmente
    // cont incrementa de forma lineal: 0,1,2,...,24 para acceder a todos los elementos
    public static void generarMatrizSC(int[][] matriz) {
        int cont = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = vectorGenerado[cont++];  // cont++ retorna edad valor luego incrementa
            }
        }
    }

    // Punto de entrada de la aplicación
    public static void main(String[] args) throws Exception {
        generarVectorElementos();
        desplegarVectorGenerado();

        // === VERSIÓN SIN CONCURRENCIA ===
        // System.nanoTime() retorna tiempo en nanosegundos desde un punto de referencia arbitrario
        double t1 = System.nanoTime();
        int[][] matrizSC = new int[5][5];
        generarMatrizSC(matrizSC);  // Llena matriz con 1 hilo (el principal)
        // Divide por 1_000_000 para convertir nanosegundos a milisegundos
        System.out.println("\nVersion NO concurrente: " + ((System.nanoTime() - t1) / 1_000_000) + " ms");
        despliegaMatriz("Matriz SIN concurrencia", matrizSC);

        // === VERSIÓN CON CONCURRENCIA ===
        Runtime runtime = Runtime.getRuntime();  // Obtiene info del sistema
        int cantHilos = Math.min(5, runtime.availableProcessors());  // min(5, procesadores disponibles)
        AppHilos[] hilos = new AppHilos[cantHilos];  // Array para almacenar referencias a los hilos

        double t2 = System.nanoTime();
        // Crea hilos para procesar cada fila (o distribuyendo filas entre hilos si hay menos de 5)
        if (cantHilos >= 5) {
            // Si hay al menos 5 procesadores, cada hilo procesa 1 fila
            for (int i = 0; i < 5; i++) {
                hilos[i] = new AppHilos(i, i);  // Hilo i procesa fila i
                hilos[i].start();  // start() lanza el hilo paralelamente (ejecuta run())
            }
        } else {
            // Si hay menos de 5 procesadores, distribuye las filas entre los hilos disponibles
            int fila = 0;
            for (int i = 0; i < cantHilos - 1; i++) {
                hilos[i] = new AppHilos(fila, fila);  // Cada hilo anterior procesa 1 fila
                hilos[i].start();
                fila++;
            }
            // El último hilo procesa las filas restantes
            hilos[cantHilos - 1] = new AppHilos(fila, 4);
            hilos[cantHilos - 1].start();
        }

        // join() espera a que cada hilo termine antes de continuar
        // Sin join(), el programa terminaría antes de que los hilos terminen
        for (AppHilos h : hilos) {
            if (h != null) {
                h.join();  // Bloquea hasta que el hilo h termine su ejecución
            }
        }

        System.out.println("\nVersion CON concurrencia: " + ((System.nanoTime() - t2) / 1_000_000) + " ms");
        despliegaMatriz("Matriz CON concurrencia", matrizCC);
    }

    // run() es el método que ejecuta cada hilo cuando se llama start()
    @Override
    public void run() {
        // synchronized(lock) es un CERROJO: solo un hilo puede entrar a la vez
        // Previene condiciones de carrera cuando acceden a matrizCC simultáneamente
        synchronized (lock) {
            for (int i = filaIni; i <= filaFin; i++) {
                int k = i * 5;  // Índice en el vector (cada fila tiene 5 elementos)
                for (int j = 0; j < 5; j++) {
                    matrizCC[i][j] = vectorGenerado[k++];  // Copia elemento del vector a matriz
                }
            }
        }
    }

    // Muestra el vector aleatorio generado
    private static void desplegarVectorGenerado() {
        System.out.println("\nVector con los 25 datos generados\n");
        for (int i = 0; i < 25; i++) {
            System.out.print(vectorGenerado[i] + " - ");
        }
    }

    // Imprime una matriz con un título
    private static void despliegaMatriz(String titulo, int[][] matriz) {
        System.out.println("\n" + titulo + "\n");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();  // Salto de línea después de cada fila
        }
    }
}
