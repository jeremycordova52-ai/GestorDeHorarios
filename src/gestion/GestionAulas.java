package gestion;

import modelo.Aula;
import java.util.Arrays;

public class GestionAulas {
    private Aula[] aulas;
    private int cantidad;

    public Aula[] getAulas() {
        return aulas;
    }

    public void setAulas(Aula[] aulas) {
        this.aulas = aulas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public GestionAulas(int capacidad) {
        aulas = new Aula[capacidad];
    }

    public Aula buscarPorCodigo(String codigo) {
        for (int i = 0; i < cantidad; i++) {
            if (aulas[i].getCodigo().equalsIgnoreCase(codigo)) {
                return aulas[i];
            }
        }

        return null;
    }

    public boolean registrar(Aula aula) {
        if (cantidad >= aulas.length) {
            return false;
        }

        if (buscarPorCodigo(aula.getCodigo()) != null) {
            return false;
        }

        aulas[cantidad++] = aula;
        return true;
    }

    public boolean eliminar(String codigo) {
        for (int i = 0; i < cantidad; i++) {
            if (aulas[i].getCodigo().equalsIgnoreCase(codigo)) {
                for (int j = i; j < cantidad - 1; j++) {
                    aulas[j] = aulas[j + 1];
                }
                aulas[--cantidad] = null;
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(aulas);
    }
}
