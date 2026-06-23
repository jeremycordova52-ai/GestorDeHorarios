package vista;

import javax.swing.*;
import java.awt.*;

public class FrmPrincipal extends JFrame {
    private JButton btnDocentes;
    private JButton btnSalir;

    public FrmPrincipal() {
        setTitle("Sistema de Gestión de Horarios");
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JLabel lblTitulo = new JLabel("SISTEMA DE GESTIÓN DE HORARIOS", SwingConstants.CENTER);

        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));

        btnDocentes = new JButton("Gestión de Docentes");
        btnSalir = new JButton("Salir");

        btnDocentes.addActionListener(e -> {
            FrmDocentes frm = new FrmDocentes();
            frm.setVisible(true);
        });

        btnSalir.addActionListener(e -> {
            System.exit(0);
        });

        JPanel panelBotones = new JPanel(new GridLayout(2,1,10,10));

        panelBotones.add(btnDocentes);
        panelBotones.add(btnSalir);

        setLayout(new BorderLayout());

        add(lblTitulo, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
    }
}
