import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class listener {
    public static void main(String args[]){
        JFrame f = new JFrame("button example");
        final JTextField tf = new JTextField();
        tf.setBounds(50, 50, 150, 20);
        JButton b = new JButton("click here");
        b.setBounds(50, 100, 95, 30);

        JLabel etiqueta = new JLabel(".....");
        etiqueta.setBounds(50, 150, 100, 50);

        b.addActionListener(e-> {
                etiqueta.setText(tf.getText());
            }
            
        );
        f.add(etiqueta);
        f.add(b);
        f.add(tf);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
