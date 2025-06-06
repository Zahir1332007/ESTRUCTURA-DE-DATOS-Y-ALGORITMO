import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class CheckedExample {
    public static void main(String[] args){
        int a=0;
        int b=0;
        int c;
        try{
            c=a/b;

            File file=new File("archivo.txt");
            FileReader filerader=new FileReader(file);
        }catch(Exception e){
            System.out.println("mensaje: "+ e.getMessage());

        }

    }   
}
