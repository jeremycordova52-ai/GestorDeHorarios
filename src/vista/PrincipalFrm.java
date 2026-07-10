package vista;

import javax.swing.*;

public class PrincipalFrm {
    private JPanel rootPanel;
    private JButton horarioButton;
    private JButton cursosButton;
    private JButton docentesButton;
    private JButton solicitudesButton;
    private JButton historialButton;
    private JButton busquedaButton;

    public PrincipalFrm() {
        docentesButton.addActionListener(e -> {
            new DocentesFrm().mostrar();
        });
        cursosButton.addActionListener(e -> {
            new CursosFrm().mostrar();
        });
        horarioButton.addActionListener(e -> {
            new HorariosFrm().mostrar();
        });
        solicitudesButton.addActionListener(e -> {
            new SolicitudesFrm().mostrar();
        });
        historialButton.addActionListener(e -> {
            new HistorialFrm().mostrar();
        });
        busquedaButton.addActionListener(e -> {
            new BusquedaFrm().mostrar();
        });
    }

    public void mostrar() {
        JFrame frame = new JFrame("PrincipalFrm");
        frame.setContentPane(new PrincipalFrm().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
