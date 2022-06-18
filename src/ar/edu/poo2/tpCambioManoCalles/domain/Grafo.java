package ar.edu.poo2.tpCambioManoCalles.domain;

public class Grafo {
    private final int cantVertices;
    private final int grafo[][];
    private Camino[] caminoMasCorto;

    public Camino[] getCaminoMasCorto() {
        return caminoMasCorto;
    }

    public Grafo(int cantVertices) {
        this.cantVertices = cantVertices;
        this.grafo = new int[cantVertices][cantVertices];
    }

    public void agregarCalle(Calle calle) {
        if (existeCalle(calle)){
            System.out.println(" Ya existe una calle entre esas esquinas");
        }else{
            grafo[calle.getEsquinaOrigen()][calle.getEsquinaDestino()] = calle.getDistancia();
        }
    }

    public boolean existeCalle(Calle calle) {
        return grafo[calle.getEsquinaOrigen()][calle.getEsquinaDestino()] != 0;
    }

    public void mostrar(){
        for (int i=0; i<cantVertices; i++){
            for (int j=0; j<cantVertices; j++){
                if (grafo[i][j] != 0)
                    System.out.print(" verticeOrig= " + i + " verticeDest= " + j + " peso= " + grafo[i][j]);
            }
            System.out.println(" ");
        }
    }

    public int dijkstra(int origen, int destino) {
        int[] distanciaMasCorta = new int[cantVertices];
        boolean[] verticeYaProcesado = new boolean[cantVertices];
        caminoMasCorto = new Camino[cantVertices];

        for (int i = 1; i < cantVertices; i++) {
            distanciaMasCorta[i] = Integer.MAX_VALUE;
            verticeYaProcesado[i] = false;
        }

        distanciaMasCorta[origen] = 0;

        for (int count = 1; count < cantVertices-1; count++) {
            int verticeMinimo = minDistance(distanciaMasCorta, verticeYaProcesado);

            verticeYaProcesado[verticeMinimo] = true;

            for (int v = 1; v < cantVertices; v++) {

                if (!verticeYaProcesado[v] && grafo[verticeMinimo][v] > 0 &&
                        distanciaMasCorta[verticeMinimo] != Integer.MAX_VALUE &&
                        distanciaMasCorta[verticeMinimo] + grafo[verticeMinimo][v] < distanciaMasCorta[v]) {
                    distanciaMasCorta[v] = distanciaMasCorta[verticeMinimo] + grafo[verticeMinimo][v];
                    obtenerCaminoCorto(verticeMinimo, v, origen);
                }
            }
        }

        printSolution(distanciaMasCorta, cantVertices);
        int distMasCortaHaciaDestino = obtenerDistanciaMasCorta(distanciaMasCorta, destino);

        return distMasCortaHaciaDestino;
    }

    private void obtenerCaminoCorto(int verticeMinimo, int v, int origen) {
        Camino camino = new Camino();
        camino.agregarCamino(origen);

        if (caminoMasCorto[verticeMinimo] != null){
            camino.setCaminoMasCorto(caminoMasCorto[verticeMinimo].getCamino());
        }

        camino.agregarCamino(v);
        caminoMasCorto[v] = camino;
    }

    private int minDistance(int[] dist, boolean[] verticeYaProcesado) {
        int min = Integer.MAX_VALUE;
        int min_index=0;

        for (int i = 0; i < cantVertices; i++) {
            if (!verticeYaProcesado[i] && dist[i] <= min) {
                min = dist[i];
                min_index = i;
            }
        }

        return min_index;
    }

    private void printSolution(int[] dist, int n) {
        System.out.println("Distancia del vertice desde el origen\n");
        for (int i = 0; i < cantVertices; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    private int obtenerDistanciaMasCorta(int [] dist, int destino){
        System.out.println("Camino mas corto");
        caminoMasCorto[destino].mostrarCamino();
        System.out.println("Distancia: " + dist[destino]);

        return dist[destino];
    }
}
