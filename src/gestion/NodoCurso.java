package gestion;

import modelo.Curso;

public class NodoCurso {
    private Curso curso;
    private NodoCurso siguiente;

    public NodoCurso(Curso curso) {
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public NodoCurso getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCurso siguiente) {
        this.siguiente = siguiente;
    }
}
