package dieta;

// Clase Grupo: Representa un grupo alimenticio con su contador de alimentos
// Se usa para llevar el control de cuántos alimentos del mismo grupo se seleccionan
public class Grupo {
    public String nombre;           // Nombre del grupo (ej: G1, G2, etc)
    public int cantAlimGrupo;       // Contador de alimentos seleccionados de este grupo

    // Constructor: crea un grupo con nombre y contador en 0
    public Grupo(String nombre) {
        this.nombre = nombre;
        this.cantAlimGrupo = 0;     // Inicialmente sin alimentos seleccionados
    }
}
