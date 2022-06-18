package ar.edu.poo2.tpCambioManoCalles.domain;

import ar.edu.poo2.tpCambioManoCalles.exception.InvalidFileException;

import java.io.*;

public class ProcesarCambioManoCalles {
    private Barrio barrio;
    private int nroEsquinas;
    private int origen;
    private int destino;
    private int cantCalles;
    private Calle[] calles;
    private int ind = 0;
    private int distanciaMasCorta;
    private String callesAcambiar;

    public ProcesarCambioManoCalles(String nomArch){
        generarBarrio(nomArch);
        distanciaMasCorta = barrio.obtenerDistanciaCorta();
        callesAcambiar = barrio.obtenerCallesACambiar();
    }

    private void generarBarrio(String nomArch) {
        FileReader fr = null;
        BufferedReader br;

        try {
            fr = new FileReader (nomArch);
            br = new BufferedReader(fr);
            String linea;
            String [] columnas;
            int contLinea = 0;

            linea = br.readLine();

            if (linea == null){
                throw new InvalidFileException("El archivo se encuentra vacio. Por favor, cargue datos.");
            }

            while(linea !=null) {
                columnas = linea.split(" ");

                switch (contLinea) {
                    case 0:
                        try {
                            nroEsquinas = Integer.parseInt(columnas[0]);
                            origen = Integer.parseInt(columnas[1]);
                            destino = Integer.parseInt(columnas[2]);
                            validarNroEsquinas(nroEsquinas);
                        }catch (NumberFormatException e) {
                            throw new InvalidFileException("Se ingreso un dato no numerico. Por favor, corregir los datos de entrada.");
                        }
                        break;
                    case 1:
                        try {
                            cantCalles = Integer.parseInt(columnas[0]);
                            validarCantCalles(cantCalles);
                            calles = new Calle[cantCalles];
                        }catch (NumberFormatException e) {
                            throw new InvalidFileException("Se ingreso un dato no numerico. Por favor, corregir los datos de entrada.");
                        }
                        break;
                    default :
                        try {
                            int esquinaOrigen = Integer.parseInt(columnas[0]);
                            int esquinaDestino = Integer.parseInt(columnas[1]);
                            int distancia = Integer.parseInt(columnas[2]);
                            validarDistancia(distancia);
                            cargarVectorCalles(esquinaOrigen, esquinaDestino, distancia);
                        }catch (NumberFormatException e) {
                            throw new InvalidFileException("Se ingreso un dato no numerico. Por favor, corregir los datos de entrada.");
                        }
                }
                contLinea++;
                linea = br.readLine();
            }
            barrio = new Barrio(nroEsquinas, origen, destino, cantCalles, calles);
        }catch(IOException e2){
            e2.printStackTrace();
        }finally{
            try{
                if( fr != null ){
                    fr.close();
                }
            }catch (Exception e3){
                e3.printStackTrace();
            }
        }
    }

    private void cargarVectorCalles(int esquinaOrigen, int esquinaDestino, int distancia) {
        Calle calle = new Calle(esquinaOrigen, esquinaDestino, distancia);
        if (ind < cantCalles){
            calles[ind] = calle;
            ind ++;
        }
    }

    private void validarNroEsquinas(int nroEsquinas) {
        if ((nroEsquinas < 1) || (nroEsquinas > 80000)){
            throw new InvalidFileException("Se ingreso un numero de esquinas invalido. Por favor corregir.");
        }
    }

    private void validarCantCalles(int cantCalles) {
        if ((cantCalles < 1) || (cantCalles > 250000)){
            throw new InvalidFileException("Se ingreso una cantidad de calles invalido. Por favor corregir.");
        }
    }

    private void validarDistancia(int distancia) {
        if ((distancia < 1) || (distancia > 50)){
            throw new InvalidFileException("Se ingreso una distancia de calle invalido. Por favor corregir.");
        }
    }

    public void generarSalida() throws IOException {
        FileWriter archivo = new FileWriter("C:/Users/pame3/IdeaProjects/TpCambioManoCalles/src/resources/cambio.out");
        PrintWriter cambioOut = new PrintWriter(archivo);

        cambioOut.println(distanciaMasCorta);
        cambioOut.println(callesAcambiar);

        cambioOut.close();
    }
}
