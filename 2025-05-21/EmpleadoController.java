import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmpleadoController {
    private EmpleadoModel model;
    private EmpleadoView view;

    public EmpleadoController(EmpleadoModel _model, EmpleadoView _view) {
        this.model = _model;
        this.view = _view;

        // falta conectar los listernes de los botones
        this.view.addLoadButtonListener(new LoadButtonListener());
        this.view.addAddButtonListener(new AddButtonListener());
        this.view.addEditButtonListener(new EditButtonListener());
        this.view.addDeleteButtonListener(new DeleteButtonListener());
        this.view.addSaveButtonListener(new SaveButtonListener());
    }

    class LoadButtonListener implements ActionListener {
        @Override // se llama sobre escritura, Actionlistener ya existe, pero quiero modificar su
                  // comportamiento
        public void actionPerformed(ActionEvent e) {
            model.loadFromCSV("Empleados.csv");
            updateView();
        }
    }

    class AddButtonListener implements ActionListener {
        @Override // se llama sobre escritura, Actionlistener ya existe, pero quiero modificar su
                  // comportamiento
        public void actionPerformed(ActionEvent e) {
            // debo de tener un empleado y agregar sus datos
            String DNIStr = view.getInput("Ingrese su DNI");
            String nombreStr = view.getInput("Ingrese su Nombre");
            String sueldoStr = view.getInput("Ingrese su Sueldo");

            // aca podrian introducir procesos de validacion
            int _DNI = Integer.parseInt(DNIStr);
            String _nombre = nombreStr;
            double _sueldo = Double.parseDouble(sueldoStr);

            model.addEmpleado(new Empleado(_DNI, _nombre, _sueldo));
            updateView();
        }
    }

    class EditButtonListener implements ActionListener {
        @Override // se llama sobre escritura, Actionlistener ya existe, pero quiero modificar su
                  // comportamiento
        public void actionPerformed(ActionEvent e) {
            int indice = view.getSelectRow();
            if (indice != -1) { // procede porque he escogio algo
                Object[] rowData = view.getRowData(indice);

                String DNIStr = view.getInput("Modifique su DNI", rowData[0].toString());
                String nombreStr = view.getInput("Modifique su Nombre", rowData[1].toString());
                String sueldoStr = view.getInput("Modifique su Sueldo", rowData[2].toString());

                // aca podrian introducir procesos de validacion
                int _DNI = Integer.parseInt(DNIStr);
                String _nombre = nombreStr;
                double _sueldo = Double.parseDouble(sueldoStr);

                model.updateEmpleado(indice, new Empleado(_DNI, _nombre, _sueldo));
                updateView();
            }
        }
    }

    class DeleteButtonListener implements ActionListener {
        @Override // se llama sobre escritura, Actionlistener ya existe, pero quiero modificar su
                  // comportamiento
        public void actionPerformed(ActionEvent e) {
            int indice = view.getSelectRow();
            if (indice != -1) { // procede porque he escogio algo

                model.deleteEmpleado(indice);
                updateView();
                view.showMessage("Se ha borrado un registro");
            }
        }
    }

    class SaveButtonListener implements ActionListener {
        @Override // se llama sobre escritura, Actionlistener ya existe, pero quiero modificar su
                  // comportamiento
        public void actionPerformed(ActionEvent e) {
            model.saveToCSV("Empleados.csv");
            updateView();
            view.showMessage("Se ha guardado el archivo");
        }
    }

    private void updateView() {
        List<Empleado> empleados = model.getEmpleado();
        Object[][] data = new Object[empleados.size()][3]; // para el examen puede variar
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            // empiezo a rellenar la rejilla de datos
            data[i][0] = empleado.getDNI();
            data[i][1] = empleado.getNombre();
            data[i][2] = empleado.getSueldo();
        }
        view.setTableData(data);
    }

}
