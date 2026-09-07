package Tareas.TareaTresArrayADT2D.GameOfLife;

import Tareas.TareaTresArrayADT2D.ArrayADT2D;

import java.io.BufferedReader;
import java.io.FileReader;

public class ArchivoJuegoDeLaVida {
    private String rutaArchivo = "/home/zorkhat/Poblacion_GameOfLife.CSV";
    private String lineaALeer;
    private ArrayADT2D<Integer> tablero;
    private static final int CELULA_VIVA = 1;
    private static final int CELULA_MUERTA = 0;


    public void leerContenidoCSV(){
        tablero =  new ArrayADT2D<>(10,10);
        int renglonActual =0;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))){

            while ((lineaALeer = br.readLine()) != null){

                String[] renglonCelulas = lineaALeer.split(",");

                for (int i = 0; i < renglonCelulas.length; i++){
                        tablero.establecerElemento(renglonActual,i,Integer.parseInt(renglonCelulas[i].trim()));
                }
                renglonActual++;
            }

        } catch (Exception e) {
            System.out.println("No se encontró el archivo o hubo un error: " + e.getMessage());
        }
    }

    public void imprimir(){
        for (int i = 0; i < tablero.obtenerRenglones(); i++) {
            for (int j = 0; j < tablero.obtenerColumnas(); j++) {
                if (tablero.obtenerElemento(i, j) != null && tablero.obtenerElemento(i, j) == 1 ) {
                   // System.out.print(tablero.obtenerElemento(i, j) + "  ");   <--- para que se vean los 1
                    System.out.print(" █ ");

                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }

    public int reglasDelJuego(int ren, int col) {
        int contadorvecinosVIVOS = 0;
        int maxRenglones = tablero.obtenerRenglones();
        int maxColumnas = tablero.obtenerColumnas();


            if (ren - 1 >= 0 && col - 1 >= 0 && tablero.obtenerElemento(ren - 1, col - 1) == 1) {
                contadorvecinosVIVOS++;
            }
            if (ren - 1 >= 0 && tablero.obtenerElemento(ren - 1, col) == 1) {
                contadorvecinosVIVOS++;
            }
            if (ren - 1 >= 0 && col + 1 < maxColumnas && tablero.obtenerElemento(ren - 1, col + 1) == 1) {
                contadorvecinosVIVOS++;
            }
            if (col - 1 >= 0 && tablero.obtenerElemento(ren, col - 1) == 1) {
                contadorvecinosVIVOS++;
            }
            if (col + 1 < maxColumnas && tablero.obtenerElemento(ren, col + 1) == 1) {
                contadorvecinosVIVOS++;
            }
            if (ren +1 < maxRenglones && col -1 >=0 && tablero.obtenerElemento(ren + 1, col - 1) == 1) {
                contadorvecinosVIVOS++;
            }
            if (ren +1 < maxRenglones && tablero.obtenerElemento(ren + 1, col) == 1) {
                contadorvecinosVIVOS++;
            }
            if (ren +1 < maxRenglones && col + 1 < maxColumnas && tablero.obtenerElemento(ren + 1, col + 1) == 1) {
                contadorvecinosVIVOS++;
            }

        if (tablero.obtenerElemento(ren, col) == CELULA_VIVA) {

            if (contadorvecinosVIVOS == 2 || contadorvecinosVIVOS == 3) {
                return CELULA_VIVA;
            } else {
                return CELULA_MUERTA;
            }
        }else if (contadorvecinosVIVOS == 3){
            return CELULA_VIVA;
        }
        return CELULA_MUERTA;

    }

    public void cambioDeGeneracion(){
        ArrayADT2D<Integer> tableroNuevo = new ArrayADT2D<>(tablero.obtenerRenglones(), tablero.obtenerColumnas());
        for (int i = 0; i < tablero.obtenerRenglones(); i++) {
            for (int j = 0; j < tablero.obtenerColumnas(); j++) {
                    int estadoSiguente = reglasDelJuego(i,j);
                    tableroNuevo.establecerElemento(i,j,estadoSiguente);
            }

        }
        tablero = tableroNuevo;
        imprimir();
    }


}
