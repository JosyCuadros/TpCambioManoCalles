package ar.edu.poo2.tpCambioManoCalles.domain;

public class Calle {
    private int esquinaOrigen;
    private int esquinaDestino;
    private int distancia;

    public Calle(int esquinaOrigen, int esquinaDestino, int distancia) {
        this.esquinaOrigen = esquinaOrigen;
        this.esquinaDestino = esquinaDestino;
        this.distancia = distancia;
    }

    public int getEsquinaOrigen() {
        return esquinaOrigen;
    }

    public int getEsquinaDestino() {
        return esquinaDestino;
    }

    public int getDistancia() {
        return distancia;
    }
}
