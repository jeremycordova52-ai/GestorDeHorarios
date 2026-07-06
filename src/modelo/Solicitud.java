package modelo;

public class Solicitud {
    private String codigo;
    private Curso curso;
    private String motivo;

    public Solicitud(String codigo, Curso curso, String motivo) {
        this.codigo = codigo;
        this.curso = curso;
        this.motivo = motivo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return codigo + " - " + curso.getNombre();
    }
}
