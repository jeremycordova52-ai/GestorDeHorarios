package vista;

import modelo.Accion;
import modelo.Docente;
import sistema.Sistema;

import javax.swing.*;

public class DocentesFrm {
    private JTextField codigoTextField;
    private JTextField nombreTextField;
    private JTextField especialidadTextField;
    private JButton resgistrarButton;
    private JButton mostrarButton;
    private JButton eliminarButton;
    private JPanel rootPanel;
    private JTextArea mensajeTextArea;

    public DocentesFrm() {
        mensajeTextArea.setEditable(false);

        resgistrarButton.addActionListener(e -> {
            String codigo = codigoTextField.getText().trim();
            String nombre = nombreTextField.getText().trim();
            String especialidad = especialidadTextField.getText().trim();

            Docente docente = new Docente(codigo, nombre, especialidad);

            if (Sistema.gestionDocentes.registrar(docente)) {
                Sistema.gestionHistorial.apilar(new Accion(
                        "Se registró el docente "
                                + docente.getCodigo()
                                + " - "
                                + docente.getNombre()
                ));

                Sistema.gestionBusquedaABB.insertar(docente);
            }
        });
        eliminarButton.addActionListener(e -> {
            String codigo = codigoTextField.getText().trim();

            if (Sistema.gestionDocentes.eliminar(codigo)) {
                Sistema.gestionHistorial.apilar(
                        new Accion("Se eliminó el docente " + codigo)
                );
            }
        });
        mostrarButton.addActionListener(e -> {
            System.out.println(Sistema.gestionDocentes);
        });
    }

    public void mostrar() {
        JFrame frame = new JFrame("Gestión de Docentes");
        frame.setContentPane(rootPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
