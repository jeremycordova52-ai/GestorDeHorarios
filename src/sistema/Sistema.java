package sistema;

import gestion.*;
import modelo.Aula;
import modelo.Curso;
import modelo.Docente;

import javax.print.Doc;

public class Sistema {
    public static final GestionDocentes gestionDocentes = new GestionDocentes(100);
    public static final GestionCursos gestionCursos = new GestionCursos();
    public static final GestionAulas gestionAulas = new GestionAulas(50);
    public static final GestionHorarios gestionHorarios = new GestionHorarios();
    public static final GestionSolicitudes gestionSolicitudes = new GestionSolicitudes();
    public static final GestionHistorial gestionHistorial = new GestionHistorial();
    public static final GestionBusquedaABB gestionBusquedaABB = new GestionBusquedaABB();

    public static void inicializar() {
        // Docentes
        Docente docente1 = new Docente("D001", "Juan Pérez", "Programación");
        Docente docente2 = new Docente("D002", "María Torres", "Base de Datos");
        Docente docente3 = new Docente("D003", "Carlos Díaz", "Redes");

        gestionDocentes.registrar(docente1);
        gestionDocentes.registrar(docente2);
        gestionDocentes.registrar(docente3);

        Sistema.gestionBusquedaABB.insertar(docente1);
        Sistema.gestionBusquedaABB.insertar(docente2);
        Sistema.gestionBusquedaABB.insertar(docente3);

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
