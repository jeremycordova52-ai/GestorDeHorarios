package vista;

import gestion.NodoCurso;
import modelo.Accion;
import modelo.Curso;
import modelo.Solicitud;
import sistema.Sistema;

import javax.swing.*;

public class SolicitudesFrm {
    private JTextField codigoTextField;
    private JTextField motivoTextField;
    private JButton registrarButton;
    private JButton atenderButton;
    private JComboBox cursoComboBox;
    private JPanel rootPanel;
    private JTextArea solicitudTextArea;

    public SolicitudesFrm() {
        registrarButton.addActionListener(e -> {
            String codigo = codigoTextField.getText();
            String motivo = motivoTextField.getText();
            Curso curso = (Curso) cursoComboBox.getSelectedItem();

            Solicitud solicitud = new Solicitud(codigo, curso, motivo);

            Sistema.gestionSolicitudes.encolar(solicitud);

            Sistema.gestionHistorial.apilar(new Accion(
                    "Se registró la solicitud "
                            + solicitud.getCodigo()
                            + " para el curso "
                            + solicitud.getCurso().getNombre()
            ));

            actualizarSolicitudTextArea();
        });

        atenderButton.addActionListener(e -> {
            Solicitud solicitud = Sistema.gestionSolicitudes.desencolar();

            if (solicitud != null) {
                Sistema.gestionHistorial.apilar(
                        new Accion(
                                "Se atendió la solicitud "
                                        + solicitud.getCodigo()
                                        + " del curso "
                                        + solicitud.getCurso().getNombre()
                        )
                );
            }

            actualizarSolicitudTextArea();
        });

        actualizarSolicitudTextArea();

        // CURSO COMBOBOX
        NodoCurso aux = Sistema.gestionCursos.getPrimero();

        while (aux != null) {
            cursoComboBox.addItem(aux.getCurso());
            aux = aux.getSiguiente();
        }
    }

    public void actualizarSolicitudTextArea() {
        Solicitud solicitud = Sistema.gestionSolicitudes.frente();

        if (solicitud == null) {
            solicitudTextArea.setText("");
            return;
        }

        solicitudTextArea.setText(solicitud.toString());
    }

    public void mostrar() {
        JFrame frame = new JFrame("SolicitudesFrm");
        frame.setContentPane(new SolicitudesFrm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
