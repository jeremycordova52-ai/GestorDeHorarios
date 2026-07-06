package gestion;

import modelo.SesionClase;

public class GestionHorarios {
    private SesionClase[][] horario;

    public GestionHorarios() {
        horario = new SesionClase[7][5];
    }

    public SesionClase[][] getHorario() {
        return horario;
    }

    public void setHorario(SesionClase[][] horario) {
        this.horario = horario;
    }

    public boolean asignarSesion(int hora, int dia, SesionClase sesion) {
        if (horario[hora][dia] != null) {
            return false;
        }

        horario[hora][dia] = sesion;
        return true;
    }

    public boolean eliminarSesion(int hora, int dia) {
        if (horario[hora][dia] == null) {
            return false;
        }

        horario[hora][dia] = null;
        return true;
    }

    public SesionClase obtenerSesion(int hora, int dia) {
        return horario[hora][dia];
    }

    public void mostrar() {
        String[] dias = {
                "Lunes",
                "Martes",
                "Miércoles",
                "Jueves",
                "Viernes"
        };

        for (int i = 0; i < horario.length; i++) {
            System.out.println("Hora " + (i + 1));
            for (int j = 0; j < horario[i].length; j++) {
                System.out.print(dias[j] + ": ");

                if (horario[i][j] == null) {
                    System.out.println("Libre");
                } else {
                    System.out.println(horario[i][j]);
                }
            }
            System.out.println();
        }
    }
}
