package dieta;

// Clase Alimento: Representa un alimento con sus propiedades
// Cada alimento tiene un nombre, calorías y grupo alimenticio al que pertenece
public class Alimento {
    public String nombre;      // Nombre del alimento (ej: Pollo, Pan, Leche)
    public int calorias;       // Calorías que contiene el alimento
    public int grupo;          // Grupo alimenticio (0-6, normalizado desde 1-7 del archivo)

    // Constructor: inicializa un alimento con sus atributos
    public Alimento(String nombre, int calorias, int grupo) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.grupo = grupo;
    }
}
