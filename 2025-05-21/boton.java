import javax.swing.JButton;
import javax.swing.JFrame;

public class boton {
    JFrame f;
    boton(){
        f=new JFrame("mi primer boton");
        JButton b= new JButton("click");
        b.setBounds(100, 100, 100, 100);
        b.addActionListener(e->{
            System.out.println("boton pressionado");
        });
        f.add(b);
        f.setSize(640, 480);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
    public static void main(String args[]){

    new boton();
}
}
