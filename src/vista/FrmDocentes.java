package vista;

import gestion.GestionDocentes;
import modelo.Docente;

import javax.swing.*;
import java.awt.*;

public class FrmDocentes extends JFrame {
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtEspecialidad;

    private JButton btnRegistrar;
    private JButton btnEliminar;
    private JButton btnMostrar;

    private JTextArea txtArea;

    private GestionDocentes gestion;

    public FrmDocentes() {
        gestion = new GestionDocentes(100);

        setTitle("Gestión de Docentes");
        setSize(700,500);
        setLocationRelativeTo(null);

        inicializarComponentes();
        eventos();
    }

    private void inicializarComponentes() {
        JLabel lblCodigo = new JLabel("Código:");
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblEspecialidad = new JLabel("Especialidad:");

        txtCodigo = new JTextField(15);
        txtNombre = new JTextField(15);
        txtEspecialidad = new JTextField(15);

        btnRegistrar = new JButton("Registrar");
        btnEliminar = new JButton("Eliminar");
        btnMostrar = new JButton("Mostrar");

        txtArea = new JTextArea();
        txtArea.setEditable(false);

        JPanel panelDatos = new JPanel(new GridLayout(3,2,5,5));

        panelDatos.add(lblCodigo);
        panelDatos.add(txtCodigo);

        panelDatos.add(lblNombre);
        panelDatos.add(txtNombre);

        panelDatos.add(lblEspecialidad);
        panelDatos.add(txtEspecialidad);

        JPanel panelBotones = new JPanel();

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnMostrar);

        JScrollPane scroll = new JScrollPane(txtArea);

        setLayout(new BorderLayout());

        add(panelDatos, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);
    }

    private void eventos() {
        btnRegistrar.addActionListener(e -> {
            registrarDocente();
        });

        btnEliminar.addActionListener(e -> {
            eliminarDocente();
        });

        btnMostrar.addActionListener(e -> {
            mostrarDocentes();
        });
    }

    private void registrarDocente() {
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        String especialidad = txtEspecialidad.getText();

        if(codigo.isEmpty() || nombre.isEmpty() || especialidad.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos");
            return;
        }

        Docente docente = new Docente(codigo, nombre, especialidad);

        if(gestion.registrar(docente)) {
            JOptionPane.showMessageDialog(this, "Docente registrado");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo registrar");
        }
    }

    private void eliminarDocente() {
        String codigo = txtCodigo.getText();

        if(codigo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el código");
            return;
        }

        if(gestion.eliminar(codigo)) {
            JOptionPane.showMessageDialog(this, "Docente eliminado");
            limpiar();
        } else {
            JOptionPane.showMessageDialog(this, "Código no encontrado");
        }
    }

    private void mostrarDocentes() {
        txtArea.setText(gestion.toString());
    }

    private void limpiar() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtEspecialidad.setText("");
        txtCodigo.requestFocus();
    }
}
