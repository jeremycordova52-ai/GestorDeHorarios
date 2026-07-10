package vista;

import modelo.Accion;
import modelo.Curso;
import sistema.Sistema;

import javax.swing.*;

public class CursosFrm {
    private JPanel rootPanel;
    private JTextField codigoTextField;
    private JTextField nombreTextField;
    private JTextField cicloTextField;
    private JButton registrarButton;
    private JButton eliminarButton;
    private JButton mostrarButton;
    private JTextArea mensajeTextArea;

    public CursosFrm() {
        mensajeTextArea.setEditable(false);

        registrarButton.addActionListener(e -> {
            String codigo = codigoTextField.getText().trim();
            String nombre = nombreTextField.getText().trim();
            int ciclo = Integer.parseInt(cicloTextField.getText());

            Curso curso = new Curso(codigo, nombre, ciclo);

            if (Sistema.gestionCursos.registrar(curso)) {
                Sistema.gestionHistorial.apilar(new Accion(
                        "Se registró el curso "
                                + curso.getCodigo()
                                + " - "
                                + curso.getNombre()
                ));
            }
        });
        eliminarButton.addActionListener(e -> {
            String codigo = codigoTextField.getText().trim();

            if (Sistema.gestionCursos.eliminar(codigo)) {
                Sistema.gestionHistorial.apilar(
                        new Accion("Se eliminó el curso " + codigo)
                );
            }
        });
        mostrarButton.addActionListener(e -> {
            System.out.println(Sistema.gestionCursos);
        });
    }

    public void mostrar() {
        JFrame frame = new JFrame("Gestión de Cursos");
        frame.setContentPane(rootPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
