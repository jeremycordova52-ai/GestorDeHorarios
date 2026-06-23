package modelo;

public class SesionClase {
    private Curso curso;
    private Docente docente;
    private Aula aula;
    private String dia;
    private String hora;

    public SesionClase(Curso curso, Docente docente, Aula aula, String dia, String hora) {
        this.curso = curso;
        this.docente = docente;
        this.aula = aula;
        this.dia = dia;
        this.hora = hora;
    }

    // Getter and Setter
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return String.format("""
                SesionClase {
                    curso: %s
                    docente: %s
                    aula: %s
                    dia: %s
                    hora: %s
                }""", curso.getNombre(), docente.getNombre(), aula.getNumero(), dia, hora);
    }
}
