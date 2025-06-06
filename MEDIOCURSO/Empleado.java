
public class Empleado {
    private int DNI;
    private String nombre;
    private String appaterno;
    private String apmaterno;
    private double sueldo;
    private String Area;
    // Constructor con parámetros
    public Empleado(int DNI,String Appaterno,String Apmaterno, String nombre,double sueldo, String Area) {
        this.DNI = DNI;
        this.appaterno=Appaterno;
        this.apmaterno = Apmaterno;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.Area = Area;
    }

    // Getter y Setter para DNI
    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }
        public String getappaterno(){
        return appaterno;
    }
    public void setappaterno(String Appaterno){
        this.appaterno= Appaterno;
    }
        public String getapmaterno(){
        return apmaterno;
    }
    public void setapmaterno(String Apmaterno){
        this.apmaterno = Apmaterno;
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
    public String getArea(){
    return Area;
    }

    public void setArea(String Area){
        this.Area = Area;
    }
}

