package gestion;

import modelo.Accion;

public class NodoAccion {
    private Accion accion;
    private NodoAccion siguiente;

    public NodoAccion(Accion accion) {
        this.accion = accion;
    }

    public Accion getAccion() {
        return accion;
    }

    public void setAccion(Accion accion) {
        this.accion = accion;
    }

    public NodoAccion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoAccion siguiente) {
        this.siguiente = siguiente;
    }
}
