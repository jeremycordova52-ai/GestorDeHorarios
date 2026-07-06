package vista;
import gestion.GestionHorarios;
import gestion.NodoCurso;
import modelo.Aula;
import modelo.Curso;
import modelo.Docente;
import modelo.SesionClase;
import sistema.Sistema;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class HorariosFrm {
    private JPanel rootPanel;
    private JComboBox cursoComboBox;
    private JComboBox docenteComboBox;
    private JComboBox aulaComboBox;
    private JButton asignarButton;
    private JButton eliminarButton;
    private JTable horarioTable;

    public HorariosFrm() {
        // TABLA DE HORARIOS
        String[] columnas = {"Hora", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};

        Object[][] datos = {
                {"08:00 - 09:00","","","","",""},
                {"09:00 - 10:00","","","","",""},
                {"10:00 - 11:00","","","","",""},
                {"11:00 - 12:00","","","","",""},
                {"13:00 - 14:00","","","","",""},
                {"14:00 - 15:00","","","","",""},
                {"15:00 - 16:00","","","","",""},
        };

        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        horarioTable.setModel(modelo);
        cargarHorario();

        asignarButton.addActionListener(e -> {
            int fila = horarioTable.getSelectedRow();
            int columna = horarioTable.getSelectedColumn();

            if (fila == -1 || columna <= 0) {
                return;
            }

            Curso curso = (Curso) cursoComboBox.getSelectedItem();
            Docente docente = (Docente) docenteComboBox.getSelectedItem();
            Aula aula = (Aula) aulaComboBox.getSelectedItem();

            if (curso == null || docente == null || aula == null) {
                return;
            }

            String dia = horarioTable.getColumnName(columna);
            String hora = horarioTable.getValueAt(fila, 0).toString();

            SesionClase sesion = new SesionClase(curso, docente, aula, dia, hora);

            if (Sistema.gestionHorarios.asignarSesion(fila, columna - 1, sesion)) {
                horarioTable.setValueAt(curso.getNombre(), fila, columna);
            }
        });

        eliminarButton.addActionListener(e -> {
            int fila = horarioTable.getSelectedRow();
            int columna = horarioTable.getSelectedColumn();

            if (fila == -1 || columna <= 0) {
                return;
            }

            if (Sistema.gestionHorarios.eliminarSesion(fila, columna - 1)) {
                horarioTable.setValueAt("", fila, columna);
            }
        });

        // DOCENTES COMBOBOX
        for (Docente docente : Sistema.gestionDocentes.getDocentes()) {
            if (docente != null) {
                docenteComboBox.addItem(docente);
            }
        }

        // AULAS COMBOBOX
        for (int i = 0; i < Sistema.gestionAulas.getCantidad(); i++) {
            Aula aula = Sistema.gestionAulas.getAulas()[i];

            if (aula != null) {
                aulaComboBox.addItem(aula);
            }
        }

        // CURSO COMBOBOX
        NodoCurso aux = Sistema.gestionCursos.getPrimero();

        while (aux != null) {
            cursoComboBox.addItem(aux.getCurso());
            aux = aux.getSiguiente();
        }
    }

    private void cargarHorario() {
        SesionClase[][] horario = Sistema.gestionHorarios.getHorario();

        for (int fila = 0; fila < horario.length; fila++) {
            for (int columna = 0; columna < horario[fila].length; columna++) {
                SesionClase sesion = horario[fila][columna];

                if (sesion != null) {
                    horarioTable.setValueAt(
                            sesion.getCurso().getNombre(),
                            fila,
                            columna + 1
                    );
                } else {
                    horarioTable.setValueAt("", fila, columna + 1
                    );
                }
            }
        }
    }

    public void mostrar() {
        JFrame frame = new JFrame("Gestión de Horarios");
        frame.setContentPane(rootPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
