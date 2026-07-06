package sistema;

import gestion.*;
import modelo.Aula;
import modelo.Curso;
import modelo.Docente;

public class Sistema {
    public static final GestionDocentes gestionDocentes = new GestionDocentes(100);
    public static final GestionCursos gestionCursos = new GestionCursos();
    public static final GestionAulas gestionAulas = new GestionAulas(50);
    public static final GestionHorarios gestionHorarios = new GestionHorarios();
    public static final GestionSolicitudes gestionSolicitudes = new GestionSolicitudes();

    public static void inicializar() {
        // Docentes
        gestionDocentes.registrar(new Docente("D001", "Juan Pérez", "Programación"));
        gestionDocentes.registrar(new Docente("D002", "María Torres", "Base de Datos"));
        gestionDocentes.registrar(new Docente("D003", "Carlos Díaz", "Redes"));

        // Cursos
        gestionCursos.registrar(new Curso("C001", "Programación I", 4));
        gestionCursos.registrar(new Curso("C002", "Base de Datos", 4));
        gestionCursos.registrar(new Curso("C003", "Redes", 3));

        // Aulas
        gestionAulas.registrar(new Aula("A101", 30));
        gestionAulas.registrar(new Aula("A102", 40));
        gestionAulas.registrar(new Aula("LAB01", 25));
    }
}
