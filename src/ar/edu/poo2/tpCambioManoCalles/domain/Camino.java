package ar.edu.poo2.tpCambioManoCalles.domain;

import java.util.ArrayList;

public class Camino {
    private ArrayList<Integer> caminos;

    public Camino() {
        this.caminos = new ArrayList<>();
    }

    public void agregarCamino(int nodo){
        caminos.add(nodo);
    }

    public void setCaminoMasCorto(ArrayList<Integer> caminoMasCorto) {
        caminos = caminoMasCorto;
    }

    public ArrayList<Integer> getCamino() {
        return caminos;
    }

    public void mostrarCamino(){
        for (Integer nodo: caminos){
            System.out.println("nodo: " + nodo);
        }
    }

}
