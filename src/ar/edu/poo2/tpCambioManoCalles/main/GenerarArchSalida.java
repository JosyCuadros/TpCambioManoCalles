package ar.edu.poo2.tpCambioManoCalles.main;

import ar.edu.poo2.tpCambioManoCalles.domain.ProcesarCambioManoCalles;

import java.io.IOException;

public class GenerarArchSalida {
    public static void main (String [] arg) throws IOException {

        ProcesarCambioManoCalles procesarCambioManoCalle = new ProcesarCambioManoCalles("C:/Users/pame3/IdeaProjects/TpCambioManoCalles/src/resources/cambio.in");
        procesarCambioManoCalle.generarSalida();

    }
}
