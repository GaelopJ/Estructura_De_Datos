package Tareas.TareaTresArrayADT2D.Ajedrez;

import Tareas.TareaTresArrayADT2D.ArrayADT2D;

public class AjustesTablero {
    private ArrayADT2D<Pieza> tablero;

    public void guardarPiezas() {
        tablero = new ArrayADT2D<>(8, 8);
        //peones
        for (int i = 0; i < tablero.obtenerColumnas(); i++) {
            tablero.establecerElemento(1, i, new Peon("Peon", "\u2659", "Blanco"));
        }
        for (int i = 0; i < tablero.obtenerColumnas(); i++) {
            tablero.establecerElemento(6, i, new Peon("Peon", "\u265F", "Negro"));
        }
        //reyes
        tablero.establecerElemento(0, 4, new Rey("Rey", "\u2654", "Blanco"));
        tablero.establecerElemento(7, 4, new Rey("Rey", "\u265A", "Negro"));
        //torres
        tablero.establecerElemento(0, 0, new Torre("Torre", "\u2656", "Blanco"));
        tablero.establecerElemento(0, 7, new Torre("Torre", "\u2656", "Blanco"));
        tablero.establecerElemento(7, 0, new Torre("Torre", "\u265C", "Negro"));
        tablero.establecerElemento(7, 7, new Torre("Torre", "\u265C", "Negro"));
        //caballos
        tablero.establecerElemento(0, 1, new Caballo("Caballo", "\u2658", "Blanco"));
        tablero.establecerElemento(0, 6, new Caballo("Caballo", "\u2658", "Blanco"));
        tablero.establecerElemento(7, 1, new Caballo("Caballo", "\u265E", "Negro"));
        tablero.establecerElemento(7, 6, new Caballo("Caballo", "\u265E", "Negro"));
        //alfiles
        tablero.establecerElemento(0, 2, new Alfil("Alfil", "\u2657", "Blanco"));
        tablero.establecerElemento(0, 5, new Alfil("Alfil", "\u2657", "Blanco"));
        tablero.establecerElemento(7, 2, new Alfil("Alfil", "\u265D", "Negro"));
        tablero.establecerElemento(7, 5, new Alfil("Alfil", "\u265D", "Negro"));
        //reinas
        tablero.establecerElemento(0, 3, new Reina("Reina", "\u2655", "Blanco"));
        tablero.establecerElemento(7, 3, new Reina("Reina", "\u265B", "Negro"));

    }

    public void imprimirTablero() {
        for (int i = 0; i < tablero.obtenerRenglones(); i++) {

            for (int j = 0; j < tablero.obtenerColumnas(); j++) {
                if (tablero.obtenerElemento(i, j) != null) {
                    System.out.print(tablero.obtenerElemento(i, j).getCharUnicode() + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}








