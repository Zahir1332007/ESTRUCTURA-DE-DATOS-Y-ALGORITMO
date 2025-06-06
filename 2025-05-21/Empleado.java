public class Empleado {
    private int DNI;
    private String nombre;
    private double sueldo;
    // Constructor con parámetros
    public Empleado(int DNI, String nombre, double sueldo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    // Getter y Setter para DNI
    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    // Getter y Setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para sueldo
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}







