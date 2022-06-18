package ar.edu.poo2.tpCambioManoCalles.tests;
import ar.edu.poo2.tpCambioManoCalles.domain.Barrio;
import ar.edu.poo2.tpCambioManoCalles.domain.Calle;
import ar.edu.poo2.tpCambioManoCalles.domain.Camino;
import ar.edu.poo2.tpCambioManoCalles.domain.Grafo;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcesarCambioManoCallesTest {
    // Barrio
    @Test
    public void obtenerDistanciaCortaTest(){
        Calle calle1 = new Calle( 2,4 ,4);
        Calle calle2 = new Calle(2, 1 ,5);
        Calle calle3 = new Calle(2, 3 ,2);
        Calle calle4 = new Calle(3, 1 ,3);
        Calle calle5 = new Calle(4, 1 ,4);
        Calle calle6 = new Calle(7, 5 ,3);
        Calle calle7 = new Calle(1, 5 ,3);
        Calle calle8 = new Calle(1, 6 ,7);
        Calle calle9 = new Calle(8, 4 ,2);
        Calle calle10 = new Calle(6, 8 ,1);
        Calle calle11 = new Calle(8, 7 ,6);
        Calle calle12= new Calle(6, 7 ,8);
        Calle calle13 = new Calle(5, 3 ,2);
        Calle[] calles = {calle1, calle2, calle3, calle4, calle5, calle6, calle7, calle8,
                          calle9, calle10, calle11, calle12, calle13};

        Barrio barrio = new Barrio(8, 2, 7,13, calles);

        assertEquals(7, barrio.obtenerDistanciaCorta());
    }

    @Test
    public void obtenerCallesACambiarTest(){
        Calle calle1 = new Calle( 2,4 ,4);
        Calle calle2 = new Calle(2, 1 ,5);
        Calle calle3 = new Calle(2, 3 ,2);
        Calle calle4 = new Calle(3, 1 ,3);
        Calle calle5 = new Calle(4, 1 ,4);
        Calle calle6 = new Calle(7, 5 ,3);
        Calle calle7 = new Calle(1, 5 ,3);
        Calle calle8 = new Calle(1, 6 ,7);
        Calle calle9 = new Calle(8, 4 ,2);
        Calle calle10 = new Calle(6, 8 ,1);
        Calle calle11 = new Calle(8, 7 ,6);
        Calle calle12= new Calle(6, 7 ,8);
        Calle calle13 = new Calle(5, 3 ,2);
        Calle[] calles = {calle1, calle2, calle3, calle4, calle5, calle6, calle7, calle8,
                calle9, calle10, calle11, calle12, calle13};

        Barrio barrio = new Barrio(8, 2, 7,13, calles);
        barrio.obtenerDistanciaCorta();
        assertEquals("13 6 ", barrio.obtenerCallesACambiar());
    }
}
