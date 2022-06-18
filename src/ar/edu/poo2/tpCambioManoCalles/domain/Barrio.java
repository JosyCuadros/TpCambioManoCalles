package ar.edu.poo2.tpCambioManoCalles.domain;

import java.util.ArrayList;

public class Barrio {
    private int nroEsquinas;
    private int origen;
    private int destino;
    private int cantCalles;
    private Calle[] calles;
    private Grafo grafo;

    public Barrio(int nroEsquinas, int origen, int destino, int cantCalles, Calle[] calles) {
        this.nroEsquinas = nroEsquinas;
        this.origen = origen;
        this.destino = destino;
        this.cantCalles = cantCalles;
        this.calles = calles;
    }

    public int obtenerDistanciaCorta() {
        Calle[] callesInvertidas = invertirCalles();
        grafo =  new Grafo(nroEsquinas +1);

        agregarCalles(calles);
        agregarCalles(callesInvertidas);

        int distanciaMasCorta = grafo.dijkstra(origen, destino);

        return distanciaMasCorta;
    }

    private void agregarCalles(Calle[] callesAgregar) {
        for (int i=0; i < cantCalles; i++){
            grafo.agregarCalle(callesAgregar[i]);
        }
    }

    private Calle[] invertirCalles() {
        Calle[] callesInvertidas = new Calle[cantCalles];

        for (int i=0; i < cantCalles; i++){
            Calle calleInvertida = new Calle(calles[i].getEsquinaDestino(),
                                             calles[i].getEsquinaOrigen(), calles[i].getDistancia());
            callesInvertidas[i] = calleInvertida;
        }
        return callesInvertidas;
    }

    public String obtenerCallesACambiar() {
        Camino[] caminoMasCorto;
        caminoMasCorto = grafo.getCaminoMasCorto();
        String calleCambiar = "";

        ArrayList<Integer> camino = caminoMasCorto[destino].getCamino();

        for(int j = 0; j < camino.size()-1; j++) {
            if(!respetaSentidoCalle(j, camino)) {
                calleCambiar = calleCambiar + obtenerCalle(j, camino) + " ";
            }
        }

        System.out.println("Calles a cambiar: " + calleCambiar);
        return calleCambiar;
    }

    private String obtenerCalle(int j, ArrayList<Integer>  camino) {
        int i = 0;
        int posfinal = 0;
        String calleCambia = "";

        while (i < cantCalles){
            if (i < cantCalles) {
                if (calles[i].getEsquinaDestino() == camino.get(j) &&
                        calles[i].getEsquinaOrigen() == camino.get(j + 1)) {
                    posfinal = i +1;
                    calleCambia = Integer.toString(posfinal);
                }
            }
            i++;
        }
        return calleCambia;
    }

    private boolean respetaSentidoCalle(int j, ArrayList<Integer>  camino) {
        boolean encontreCalle = false;
        int i = 0;

        while ((!encontreCalle) && (i < cantCalles)){

            if (i < cantCalles) {
                if (calles[i].getEsquinaOrigen() == camino.get(j) &&
                        calles[i].getEsquinaDestino() == camino.get(j + 1)) {
                    encontreCalle = true;
                }
            }

            i++;
        }

        return encontreCalle;
    }
}

