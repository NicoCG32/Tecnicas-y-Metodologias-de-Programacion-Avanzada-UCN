package arbol;

public class Persona {
    public String rut;
    public String nombre;
    public int edad;
    
    public Persona(String rut, String nombre, int edad) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
    }
    
    @Override
    public String toString() {
        return "Persona[" + "rut='" + rut + ", nombre='" + nombre + ", edad=" + edad + "]";
    }
}
