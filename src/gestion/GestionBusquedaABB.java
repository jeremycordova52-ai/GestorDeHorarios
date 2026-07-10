package gestion;

import modelo.Docente;

public class GestionBusquedaABB {
    private NodoDocenteABB raiz;

    public boolean estaVacio() {
        return raiz == null;
    }

    public boolean insertar(Docente docente) {
        if (raiz == null) {
            raiz = new NodoDocenteABB(docente);
            return true;
        }

        return insertar(raiz, docente);
    }

    private boolean insertar(NodoDocenteABB actual, Docente docente) {
        int comparacion = docente.getCodigo().compareToIgnoreCase(
                actual.getDocente().getCodigo()
        );

        if (comparacion == 0) {
            return false;
        }

        if (comparacion < 0) {
            if (actual.getIzquierdo() == null) {
                actual.setIzquierdo(
                        new NodoDocenteABB(docente)
                );

                return true;
            }

            return insertar(
                    actual.getIzquierdo(),
                    docente
            );
        }

        if (actual.getDerecho() == null) {
            actual.setDerecho(
                    new NodoDocenteABB(docente)
            );

            return true;
        }

        return insertar(
                actual.getDerecho(),
                docente
        );
    }

    public Docente buscar(String codigo) {
        return buscar(raiz, codigo);
    }

    private Docente buscar(
            NodoDocenteABB actual,
            String codigo
    ) {
        if (actual == null) {
            return null;
        }

        int comparacion = codigo.compareToIgnoreCase(
                actual.getDocente().getCodigo()
        );

        if (comparacion == 0) {
            return actual.getDocente();
        }

        if (comparacion < 0) {
            return buscar(
                    actual.getIzquierdo(),
                    codigo
            );
        }

        return buscar(
                actual.getDerecho(),
                codigo
        );
    }

    public String mostrarInOrden() {
        if (estaVacio()) {
            return "El árbol está vacío";
        }

        return mostrarInOrden(raiz);
    }

    private String mostrarInOrden(
            NodoDocenteABB actual
    ) {
        if (actual == null) {
            return "";
        }

        return mostrarInOrden(actual.getIzquierdo())
                + actual.getDocente()
                + "\n"
                + mostrarInOrden(actual.getDerecho());
    }

    public NodoDocenteABB getRaiz() {
        return raiz;
    }
}
