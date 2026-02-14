# Ejercicio 3 - Matriz con y sin concurrencia

```java
public class AppHilos extends Thread {
    private static int[] vectorGenerado = new int[25];
    private static int[][] matrizCC = new int[5][5];
    private static Object lock = new Object();

    private int filaIni;
    private int filaFin;

    public AppHilos(int filaIni, int filaFin) {
        this.filaIni = filaIni;
        this.filaFin = filaFin;
    }

    public static void generarVectorElementos() {
        Random rand = new Random(System.nanoTime());
        for (int i = 0; i < 25; i++) {
            vectorGenerado[i] = rand.nextInt(16);
        }
    }

    public static void generarMatrizSC(int[][] matriz) {
        int cont = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = vectorGenerado[cont++];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        generarVectorElementos();
        desplegarVectorGenerado();

        double t1 = System.nanoTime();
        int[][] matrizSC = new int[5][5];
        generarMatrizSC(matrizSC);
        System.out.println("\nVersion NO concurrente: " + ((System.nanoTime() - t1) / 1_000_000) + " ms");
        despliegaMatriz("Matriz SIN concurrencia", matrizSC);

        Runtime runtime = Runtime.getRuntime();
        int cantHilos = Math.min(5, runtime.availableProcessors());
        AppHilos[] hilos = new AppHilos[cantHilos];

        double t2 = System.nanoTime();
        if (cantHilos >= 5) {
            for (int i = 0; i < 5; i++) {
                hilos[i] = new AppHilos(i, i);
                hilos[i].start();
            }
        } else {
            int fila = 0;
            for (int i = 0; i < cantHilos - 1; i++) {
                hilos[i] = new AppHilos(fila, fila);
                hilos[i].start();
                fila++;
            }
            hilos[cantHilos - 1] = new AppHilos(fila, 4);
            hilos[cantHilos - 1].start();
        }

        for (AppHilos h : hilos) {
            if (h != null) {
                h.join();
            }
        }

        System.out.println("\nVersion CON concurrencia: " + ((System.nanoTime() - t2) / 1_000_000) + " ms");
        despliegaMatriz("Matriz CON concurrencia", matrizCC);
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = filaIni; i <= filaFin; i++) {
                int k = i * 5;
                for (int j = 0; j < 5; j++) {
                    matrizCC[i][j] = vectorGenerado[k++];
                }
            }
        }
    }

    private static void desplegarVectorGenerado() {
        System.out.println("\nVector con los 25 datos generados\n");
        for (int i = 0; i < 25; i++) {
            System.out.print(vectorGenerado[i] + " - ");
        }
    }

    private static void despliegaMatriz(String titulo, int[][] matriz) {
        System.out.println("\n" + titulo + "\n");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```