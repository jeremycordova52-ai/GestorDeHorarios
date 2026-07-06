package gestion;

import modelo.Curso;

public class GestionCursos {
    private NodoCurso primero;
    private int cantidad;

    public boolean registrar(Curso curso) {
        if (buscarPorCodigo(curso.getCodigo()) != null) {
            return false;
        }

        NodoCurso nuevo = new NodoCurso(curso);

        if (primero == null) {
            primero = nuevo;
        } else {
            NodoCurso aux = primero;

            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }

            aux.setSiguiente(nuevo);
        }

        cantidad++;
        return true;
    }

    public Curso buscarPorCodigo(String codigo) {
        NodoCurso aux = primero;

        while (aux != null) {

            if (aux.getCurso().getCodigo().equalsIgnoreCase(codigo)) {
                return aux.getCurso();
            }

            aux = aux.getSiguiente();

        }

        return null;
    }

    public boolean eliminar(String codigo) {
        if (primero == null) {
            return false;
        }

        if (primero.getCurso().getCodigo().equalsIgnoreCase(codigo)) {
            primero = primero.getSiguiente();
            cantidad--;

            return true;
        }

        NodoCurso anterior = primero;
        NodoCurso actual = primero.getSiguiente();

        while (actual != null) {
            if (actual.getCurso().getCodigo().equalsIgnoreCase(codigo)) {
                anterior.setSiguiente(actual.getSiguiente());
                cantidad--;

                return true;
            }

            anterior = actual;
            actual = actual.getSiguiente();
        }

        return false;
    }

    public NodoCurso getPrimero() {
        return primero;
    }

    public int getCantidad() {
        return cantidad;
    }
}
