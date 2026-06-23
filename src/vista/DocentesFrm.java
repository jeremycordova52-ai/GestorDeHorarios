package vista;

import modelo.Docente;
import gestion.GestionDocentes;

import javax.swing.*;

public class DocentesFrm {
    private JTextField codigoTextField;
    private JTextField nombreTextField;
    private JTextField especialidadTextField;
    private JButton resgistrarButton;
    private JButton mostrarButton;
    private JButton eliminarButton;
    private JPanel rootPanel;

    public DocentesFrm() {
        GestionDocentes gestionDocentes = new GestionDocentes(5);

        resgistrarButton.addActionListener(e -> {
            String codigo = codigoTextField.getText().trim();
            String nombre = nombreTextField.getText().trim();
            String especialidad = especialidadTextField.getText().trim();
            Docente docente = new Docente(codigo, nombre, especialidad);
            gestionDocentes.registrar(docente);
        });
        eliminarButton.addActionListener(e -> {
            String codigo = codigoTextField.getText().trim();
            gestionDocentes.eliminar(codigo);
        });
        mostrarButton.addActionListener(e -> {
            System.out.println(gestionDocentes);
        });
    }

    public void mostrar() {
        JFrame frame = new JFrame("DocentesFrm");
        frame.setContentPane(new DocentesFrm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
