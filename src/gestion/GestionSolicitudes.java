package gestion;

import modelo.Solicitud;

public class GestionSolicitudes {
    private NodoSolicitud frente;
    private NodoSolicitud fin;
    private int cantidad;

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(Solicitud solicitud) {
        NodoSolicitud nuevo = new NodoSolicitud(solicitud);

        if (estaVacia()) {
            frente = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;

        cantidad++;
    }

    public Solicitud desencolar() {
        if (estaVacia()) {
            return null;
        }

        Solicitud solicitud = frente.getSolicitud();
        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }

        cantidad--;

        return solicitud;
    }

    public Solicitud frente() {
        if (estaVacia()) {
            return null;
        }

        return frente.getSolicitud();
    }

    public int getCantidad() {
        return cantidad;
    }

    public NodoSolicitud getNodoFrente() {
        return frente;
    }
}
