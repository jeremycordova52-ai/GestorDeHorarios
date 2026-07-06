package vista;

import gestion.NodoCurso;
import modelo.Curso;
import modelo.Solicitud;
import sistema.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SolicitudesFrm {
    private JTextField codigoTextField;
    private JTextField motivoTextField;
    private JButton registrarButton;
    private JButton atenderButton;
    private JComboBox cursoComboBox;
    private JPanel rootPanel;

    public SolicitudesFrm() {
        registrarButton.addActionListener(e -> {
            String codigo = codigoTextField.getText();
            String motivo = motivoTextField.getText();
            Curso curso = (Curso) cursoComboBox.getSelectedItem();

            Sistema.gestionSolicitudes.encolar(new Solicitud(codigo, curso, motivo));
        });

        atenderButton.addActionListener(e -> {
            Sistema.gestionSolicitudes.desencolar();
        });

        // CURSO COMBOBOX
        NodoCurso aux = Sistema.gestionCursos.getPrimero();

        while (aux != null) {
            cursoComboBox.addItem(aux.getCurso());
            aux = aux.getSiguiente();
        }
    }

    public void mostrar() {
        JFrame frame = new JFrame("SolicitudesFrm");
        frame.setContentPane(new SolicitudesFrm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
