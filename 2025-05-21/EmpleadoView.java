import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmpleadoView extends JFrame {
  private JTable table;
  private DefaultTableModel tableModel;
  private JButton loadbutton;
  private JButton addButton;
  private JButton editButton;
  private JButton deleteButton;
  private JButton saveButton;

  public EmpleadoView(){
    setTitle("Empleados Compañia ABC");  // Ver como solucionar el tema de caracteres especiales
    setSize(640,480);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLocationRelativeTo(null);
    
    tableModel = new DefaultTableModel(new Object[] {"DNI","Nombres","Sueldo"},0);

    table = new JTable(tableModel);

    JScrollPane scrollPane = new JScrollPane(table);

    loadbutton = new JButton("Leer Archivo");
    addButton = new JButton("Agregar");
    editButton = new JButton("Editar");
    deleteButton = new JButton("Eliminar");
    saveButton = new JButton("Guardar Archivo");

    JPanel conjuntoDeBotones = new JPanel();
    conjuntoDeBotones.add(loadbutton);
    conjuntoDeBotones.add(addButton);
    conjuntoDeBotones.add(editButton);
    conjuntoDeBotones.add(deleteButton);
    conjuntoDeBotones.add(saveButton);

    add(scrollPane,BorderLayout.CENTER);
    add(conjuntoDeBotones,BorderLayout.SOUTH); // Aca Estuvo el Lio
  }

  // listeners son los que escuchan los clicks y se los pasan al controlador
  public void addLoadButtonListener(ActionListener listener){
    loadbutton.addActionListener(listener);
  }

  public void addAddButtonListener(ActionListener listener){
    addButton.addActionListener(listener);
  }

  public void addEditButtonListener(ActionListener listener){
    editButton.addActionListener(listener);
  }

  public void addDeleteButtonListener(ActionListener listener){
    deleteButton.addActionListener(listener);
  }

  public void addSaveButtonListener(ActionListener listener){
    saveButton.addActionListener(listener);
  }

  // para manejar los datos de la tabla 
  public void setTableData(Object[][] data) {
    tableModel.setRowCount(0);
    for (Object[] row : data) {
       tableModel.addRow(row);
    }
  }

  // me devuelve una celda seleccionada
  public int getSelectRow() {
    return table.getSelectedRow();
  }

  // me devuelve una fila seleccionada
  public Object[] getRowData(int row){
    int NroColumnas = tableModel.getColumnCount();
    Object[] rowdata = new Object[NroColumnas];
    for (int i=0; i<NroColumnas; i++){
      rowdata[i] = tableModel.getValueAt(row,i);
    }
    return rowdata;
  }

  // saca un mensaje a pantalla pidiendo datos
  public String getInput(String Mensaje){
    return JOptionPane.showInputDialog(this, Mensaje);
  }

  public String getInput(String Mensaje, String ValorDefecto){
    return JOptionPane.showInputDialog(this, Mensaje, ValorDefecto);
  }
  
  public void showMessage(String Mensaje) {
    JOptionPane.showMessageDialog(this, Mensaje);
  }

}