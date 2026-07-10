package vista;

import modelo.Docente;
import sistema.Sistema;

import javax.swing.*;

public class BusquedaFrm {
    private JPanel rootPanel;
    private JButton mostrarButton;
    private JTextArea resultadoTextArea;
    private JTextField codigoTextField;
    private JButton buscarButton;

    public BusquedaFrm() {
        buscarButton.addActionListener(e -> {
            String codigo = codigoTextField.getText().trim();

            Docente docente = Sistema.gestionBusquedaABB.buscar(codigo);

            if (docente == null) {
                resultadoTextArea.setText("Docente no encontrado");
                return;
            }

            resultadoTextArea.setText(
                    "Código: "
                            + docente.getCodigo()
                            + "\nNombre: "
                            + docente.getNombre()
                            + "\nEspecialidad: "
                            + docente.getEspecialidad()
            );
        });

        mostrarButton.addActionListener(e -> {
            resultadoTextArea.setText(
                    Sistema.gestionBusquedaABB.mostrarInOrden()
            );
        });
    }

    public void mostrar() {
        JFrame frame = new JFrame("BusquedaFrm");
        frame.setContentPane(new BusquedaFrm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
