package modelo;

public class Aula {
    private String numero;
    private int capacidad;

    public Aula(String numero, int capacidad) {
        this.numero = numero;
        this.capacidad = capacidad;
    }

    // Getter and Setter
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return String.format("""
                Aula {
                    numero: %s
                    capacidad: %d
                }""", numero, capacidad);
    }
}
