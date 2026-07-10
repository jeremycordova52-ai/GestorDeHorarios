package gestion;

import modelo.Docente;

public class NodoDocenteABB {
    private Docente docente;
    private NodoDocenteABB izquierdo;
    private NodoDocenteABB derecho;

    public NodoDocenteABB(Docente docente) {
        this.docente = docente;
        izquierdo = null;
        derecho = null;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public NodoDocenteABB getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoDocenteABB izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoDocenteABB getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoDocenteABB derecho) {
        this.derecho = derecho;
    }
}
