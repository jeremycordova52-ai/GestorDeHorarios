package modelo;

public class Curso {
    private String codigo;
    private String nombre;
    private int ciclo;

    public Curso(String codigo, String nombre, int ciclo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ciclo = ciclo;
    }

    // Getter and Setter
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %d", codigo, nombre, ciclo);
    }
}
