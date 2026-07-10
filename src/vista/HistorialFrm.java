package vista;

import sistema.Sistema;

import javax.swing.*;

public class HistorialFrm {
    private JPanel rootPanel;
    private JTextArea historialTextArea;

    public HistorialFrm() {
        cargarHistorial();
    }

    private void cargarHistorial() {
        historialTextArea.setText(Sistema.gestionHistorial.mostrar());
    }

    public void mostrar() {
        JFrame frame = new JFrame("HistorialFrm");
        frame.setContentPane(new HistorialFrm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
