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
            int _DNI = 0;
boolean dniValido = false;
String DNIStr;

do {
    DNIStr = view.getInput("Ingrese su DNI (8 dígitos numéricos)");
    if (DNIStr == null || DNIStr.length() != 8) {
        view.showMessage("El DNI debe tener exactamente 8 dígitos.");
        continue;
    }
    try {
        _DNI = Integer.parseInt(DNIStr);
    } catch (NumberFormatException ex) {
        view.showMessage("El DNI debe ser un número válido.");
        continue;
    }
    // Validar si el DNI ya existe
    boolean dniRepetido = false;
    for (Empleado emp : model.getEmpleado()) {
        if (emp.getDNI() == _DNI) {
            dniRepetido = true;
            break;
        }
    }
    if (dniRepetido) {
        view.showMessage("Este DNI ya está registrado, ingrese otro.");
        continue;
    }
    dniValido = true;
} while (!dniValido);
String paternoStr = view.getInput("Ingrese su apellido paterno");
        if (paternoStr != null) paternoStr = paternoStr.trim().toUpperCase();

        String maternoStr = view.getInput("Ingrese su apellido materno");
        if (maternoStr != null) maternoStr = maternoStr.trim().toUpperCase();

        String nombreStr = view.getInput("Ingrese su Nombre");
        if (nombreStr != null) nombreStr = nombreStr.trim().toUpperCase();

            String areaStr;
String[] areasValidas = {"CONTABILIDAD", "ADMINISTRACION", "LOGISTICA", "PATRIMONIO", "ALMACEN"};
boolean areaValida = false;

do {
    areaStr = view.getInput("Ingrese su área de trabajo (CONTABILIDAD, ADMINISTRACION, LOGISTICA, PATRIMONIO, ALMACEN)");
    if (areaStr == null) { // si el usuario cancela o cierra el diálogo
        view.showMessage("Debe ingresar un área válida.");
        continue; // volver a preguntar
    }
    areaStr = areaStr.trim().toUpperCase();
    for (String area : areasValidas) {
        if (area.equals(areaStr)) {
            areaValida = true;
            break;
        }
    }
    if (!areaValida) {
        view.showMessage("Error: El área debe ser una de estas: CONTABILIDAD, ADMINISTRACION, LOGISTICA, PATRIMONIO, ALMACEN");
    }
} while (!areaValida);
double _sueldo = 0;
boolean sueldoValido = false;

do {
    String sueldoStrTemp = view.getInput("Ingrese su Sueldo");
    if (sueldoStrTemp == null) {
        view.showMessage("Debe ingresar un sueldo válido.");
        continue;
    }
    try {
        _sueldo = Double.parseDouble(sueldoStrTemp);
    } catch (NumberFormatException ex) {
        view.showMessage("Error: Debe ingresar un número válido para el sueldo.");
        continue;
    }

    switch (areaStr) {
        case "CONTABILIDAD":
            if (_sueldo >= 1000 && _sueldo <= 1500) sueldoValido = true;
            else view.showMessage("Sueldo para CONTABILIDAD debe estar entre 1000 y 1500.");
            break;
        case "ADMINISTRACION":
            if (_sueldo >= 1400 && _sueldo <= 1800) sueldoValido = true;
            else view.showMessage("Sueldo para ADMINISTRACION debe estar entre 1400 y 1800.");
            break;
        case "LOGISTICA":
            if (_sueldo >= 800 && _sueldo <= 1000) sueldoValido = true;
            else view.showMessage("Sueldo para LOGISTICA debe estar entre 800 y 1000.");
            break;
        case "PATRIMONIO":
            if (_sueldo >= 900 && _sueldo <= 1100) sueldoValido = true;
            else view.showMessage("Sueldo para PATRIMONIO debe estar entre 900 y 1100.");
            break;
        case "ALMACEN":
            if (_sueldo >= 600 && _sueldo <= 900) sueldoValido = true;
            else view.showMessage("Sueldo para ALMACEN debe estar entre 600 y 900.");
            break;
        default:
            view.showMessage("Área desconocida para validar sueldo.");
            break;
    }
} while (!sueldoValido);


String Area = areaStr;


            // aca podrian introducir procesos de validacion
            String paterno = paternoStr;
            String materno = maternoStr;
            String _nombre = nombreStr;


            model.addEmpleado(new Empleado(_DNI,paterno,materno, _nombre, _sueldo,Area));
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

                int _DNI = 0;
boolean dniValido = false;
String DNIStr;

do {
    DNIStr = view.getInput("Modifique su DNI", rowData[0].toString());
    if (DNIStr == null || DNIStr.length() != 8) {
        view.showMessage("El DNI debe tener exactamente 8 dígitos.");
        continue;
    }
    try {
        _DNI = Integer.parseInt(DNIStr);
    } catch (NumberFormatException ex) {
        view.showMessage("El DNI debe ser un número válido.");
        continue;
    }
    // Validar si el DNI ya existe en otro empleado (ignorando el actual)
    boolean dniRepetido = false;
    List<Empleado> empleados = model.getEmpleado();
    for (int i = 0; i < empleados.size(); i++) {
        if (i != indice) {
            Empleado emp = empleados.get(i);
            if (emp.getDNI() == _DNI) {
                dniRepetido = true;
                break;
            }
        }
    }
    if (dniRepetido) {
        view.showMessage("Este DNI ya está registrado en otro empleado. Ingrese otro.");
        continue;
    }
    dniValido = true;
} while (!dniValido);

                String paternoStr = view.getInput("modifique su apellido paterno", rowData[1].toString());
                String maternoStr = view.getInput("modifique su apellido materno", rowData[2].toString());
                String nombreStr = view.getInput("Modifique su Nombre", rowData[3].toString());
                String sueldoStr = view.getInput("Modifique su Sueldo", rowData[4].toString());
                String areaStr = view.getInput("modifique su aréa de trabajo(CONTABILIDAD, ADMINISTRACION,LOGISTICA,PATRIMONIO,ALMACEN)", rowData[5].toString());
    String[] areasValidas = {"CONTABILIDAD", "ADMINISTRACION", "LOGISTICA", "PATRIMONIO", "ALMACEN"};
   boolean areaValida = false;

    do {
     areaStr = view.getInput("Modifique su área de trabajo (CONTABILIDAD, ADMINISTRACION, LOGISTICA, PATRIMONIO, ALMACEN)", rowData[5].toString());
     if (areaStr == null) {
        view.showMessage("Debe ingresar un área válida.");
        continue;
    }
    areaStr = areaStr.trim().toUpperCase();
    for (String area : areasValidas) {
        if (area.equals(areaStr)) {
            areaValida = true;
            break;
        }
    }
    if (!areaValida) {
        view.showMessage("Error: El área debe ser una de estas: CONTABILIDAD, ADMINISTRACION, LOGISTICA, PATRIMONIO, ALMACEN");
    }
} while (!areaValida);
                
                // aca podrian introducir procesos de validacion
                
                String paterno = paternoStr;
                String materno = maternoStr;
                String _nombre = nombreStr;
                double _sueldo = Double.parseDouble(sueldoStr);
                String Area = areaStr.toUpperCase();

                model.updateEmpleado(indice, new Empleado(_DNI,paterno,materno, _nombre, _sueldo,Area));
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
        Object[][] data = new Object[empleados.size()][6]; // para el examen puede variar
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empleado = empleados.get(i);
            // empiezo a rellenar la rejilla de datos
            data[i][0] = empleado.getDNI();
            data[i][1]=empleado.getappaterno();
            data[i][2]=empleado.getapmaterno();
            data[i][3] = empleado.getNombre();
            data[i][4]=empleado.getSueldo();
            data[i][5] = empleado.getArea();
        }
        view.setTableData(data);
    }

}

