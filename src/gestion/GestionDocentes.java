package gestion;

import modelo.Docente;

import java.util.Arrays;

public class GestionDocentes {
    private Docente[] docentes;
    private int cantidad;

    public GestionDocentes(int capacidad) {
        docentes = new Docente[capacidad];
        cantidad = 0;
    }

    // Getter and Setter
    public Docente[] getDocentes() {
        return docentes;
    }

    public void setDocentes(Docente[] docentes) {
        this.docentes = docentes;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Docente buscarPorCodigo(String codigo) {
        for (int i = 0; i < cantidad; i++) {
            if (docentes[i].getCodigo().equalsIgnoreCase(codigo)) {
                return docentes[i];
            }
        }

        return null;
    }

    public boolean registrar(Docente docente) {
        // Que el arreglo tenga espacio
        if (cantidad >= docentes.length) {
            return false;
        }

        // Que no exista otro docente con el mismo código
        if (buscarPorCodigo(docente.getCodigo()) != null) {
            return false;
        }

        docentes[cantidad++] = docente;
        return true;
    }

    public boolean eliminar(String codigo) {
        for (int i = 0; i < cantidad; i++) {
            if (docentes[i].getCodigo().equalsIgnoreCase(codigo)) {
                for (int j = i; j < cantidad - 1; j++) {
                    docentes[j] = docentes[j + 1];
                }

                docentes[cantidad - 1] = null;
                cantidad--;

                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (cantidad == 0) {
            return "No hay docentes registrados";
        }

        return String.format("""
                GestionDocentes {
                    docentes: %s,
                    cantidad: %d
                }""", Arrays.toString(docentes), cantidad);
    }
}
