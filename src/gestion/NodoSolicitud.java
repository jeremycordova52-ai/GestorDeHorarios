package gestion;

import modelo.Solicitud;

public class NodoSolicitud {
    private Solicitud solicitud;
    private NodoSolicitud siguiente;

    public NodoSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public NodoSolicitud getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSolicitud siguiente) {
        this.siguiente = siguiente;
    }
}
