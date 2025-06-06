import javax.swing.JFrame;
import javax.swing.JLabel;

public class holamundo{

    public static void crearventana(){

        JFrame frame = new JFrame("titulo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel label=new JLabel("hola alumnos :)");

        frame.getContentPane().add(label);

        
        frame.pack();
        frame.setVisible(true);
        frame.setSize(200,300);
    }
    public static void main(String args[]){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                crearventana();
            }
        }
        );

    }
}