import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ejemplo extends JFrame{
    public ejemplo(){
        JButton btnboton = new JButton("boton");
        JButton btnMostrar = new JButton("mostrar");
        JButton btnOcultar = new JButton("ocultar");
        JPanel pnlIzquierda = new JPanel();
        JPanel pnlDerecha = new JPanel();

        btnMostrar.setBounds(40, 340, 100, 24);
        btnOcultar.setBounds(40, 370,100, 24);
        btnboton.setBounds(100, 50, 100, 24);
        pnlIzquierda.setBounds(50, 20, 200, 200);
        pnlDerecha.setBounds(300, 20, 200, 200);
        pnlIzquierda.setBackground(Color.red);
        pnlDerecha.setBackground(Color.green);
        pnlDerecha.setLayout(null);
        pnlDerecha.add(btnboton);

        btnMostrar.addActionListener(e->pnlDerecha.setVisible(true));
        btnOcultar.addActionListener(e->pnlDerecha.setVisible(false));

        add(btnMostrar);
        add(btnOcultar);
        add(pnlIzquierda);
        add(pnlDerecha);


        setTitle("VENTANA FIIS");
        setSize(640, 480);

        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    };
    public static void main(String args[]){
        new ejemplo();
    }
    
}