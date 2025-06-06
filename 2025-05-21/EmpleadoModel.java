import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoModel {
    private List<Empleado> empleados;  // como si fuese un vector en c++
    
    public EmpleadoModel(){
       empleados = new ArrayList<>();  // en el constructor inicio con un vector vacio
    }                                  // este tipo de arreglos puede recibir cualquier elemento
                                       // siempre y cuando sean del mismo tipo 

    public void addEmpleado(Empleado empleado){
       empleados.add(empleado); 
    }

    public void updateEmpleado(int index, Empleado empleado){
      empleados.set(index, empleado);
    }

    public void deleteEmpleado(int index){
      empleados.remove(index);
    }

    public List<Empleado> getEmpleado() {
      return empleados; 
    }

    public void loadFromCSV(String NombreArchivo) {
        empleados.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(NombreArchivo) ) ) {
          String Linea;
          while ( (Linea = br.readLine()) != null )  {
             String[] datos = Linea.split(";");  // split separa una cadena en base a un separador
             int _DNI = Integer.parseInt(datos[0]);
             String _nombre = datos[1];
             double _sueldo = Double.parseDouble(datos[2]);
             empleados.add( new Empleado(_DNI, _nombre, _sueldo) );
          }
        } catch (IOException e) {
            //podria sacarse el mensaje de error en forma grafica
            e.printStackTrace();
        }
    }

    // este metodo fue generado por AI desde el metodo loadFromCSV
    public void saveToCSV(String nombreArchivo) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
        for (Empleado emp : empleados) {
            String linea = emp.getDNI() + ";" + emp.getNombre() + ";" + emp.getSueldo();
            bw.write(linea);
            bw.newLine(); // Salto de línea
        }
        // quisiera sacar este en modo grafico
        System.out.println("Datos guardados exitosamente en " + nombreArchivo);
    } catch (IOException e) {
        // tambien si hubo mensaje de error quisiera verlo graficamente
        e.printStackTrace();
    }
    }
}