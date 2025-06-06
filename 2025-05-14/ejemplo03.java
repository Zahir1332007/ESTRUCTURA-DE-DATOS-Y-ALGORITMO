import java.util.Calendar;
public class ejemplo03 {
    public static void main(String[] args){
        System.out.println("ANTES DE LOS FOR");

        Etiqueta:
        for(int i=1; i<=3; i++){
            System.out.println("bucle i");
            for(int j=1; j<=4; j++){
                System.out.println("bucle j");
                for(int k=1; k<=5; k++){
                    System.out.println("bucle k");
                }
                break Etiqueta;
            }
        }
    }
}
/*hace algun tieempo hubo etiquetas  */
