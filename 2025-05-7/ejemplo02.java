import java.io.BufferedWriter;
import java.io.FileWriter;
public class ejemplo02 {
    public static void main(String[] args){
        try{
        BufferedWriter miarchivo= new BufferedWriter(new FileWriter("archivo.txt"));
        miarchivo.write("primera fila");
        miarchivo.write("segunda fila");
        miarchivo.write("tercera fila");
        miarchivo.close();
        System.out.println("mi archivo se genero con exito ");

        }catch(Exception e){
            System.out.println("mi archivo se genero su exito");

        }
    }
    
}
