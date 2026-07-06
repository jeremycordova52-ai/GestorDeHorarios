package vista;

import modelo.Curso;
import modelo.Docente;
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

            Sistema.gestionCursos.registrar(new Curso(codigo, nombre, ciclo));
        });
        eliminarButton.addActionListener(e -> {
            String codigo = codigoTextField.getText().trim();
            Sistema.gestionCursos.eliminar(codigo);
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
