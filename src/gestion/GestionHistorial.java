package gestion;

import modelo.Accion;

public class GestionHistorial {
    private NodoAccion cima;
    private int cantidad;

    public boolean estaVacia() {
        return cima == null;
    }

    public void apilar(Accion accion) {
        NodoAccion nuevo = new NodoAccion(accion);

        nuevo.setSiguiente(cima);
        cima = nuevo;

        cantidad++;
    }

    public Accion desapilar() {
        if (estaVacia()) {
            return null;
        }

        Accion accion = cima.getAccion();

        cima = cima.getSiguiente();
        cantidad--;

        return accion;
    }

    public Accion cima() {
        if (estaVacia()) {
            return null;
        }

        return cima.getAccion();
    }

    public int getCantidad() {
        return cantidad;
    }

    public NodoAccion getNodoCima() {
        return cima;
    }

    public String mostrar() {
        if (estaVacia()) {
            return "No hay acciones registradas";
        }

        String resultado = "";
        NodoAccion aux = cima;

        while (aux != null) {
            resultado += aux.getAccion() + "\n";
            aux = aux.getSiguiente();
        }

        return resultado;
    }
}
