package Tareas.TareaTresArrayADT2D;

import java.util.ArrayList;

public class ArrayADT2D<T> {
    private int renglones;
    private int columnas;
    private ArrayList<ArrayList<T>> datos;

    public ArrayADT2D() {
        this.renglones = 0;
        this.columnas = 0;
        this.datos = new ArrayList<>();
    }

    public ArrayADT2D(int renglones, int columnas) {
        this.renglones = renglones;
        this.columnas = columnas;
        this.datos = new ArrayList<>(renglones);

        for (int i = 0; i < renglones; i++) {
            ArrayList<T> fila = new ArrayList<>(columnas);
            for (int j = 0; j < columnas; j++) {
                fila.add(null);
            }
            this.datos.add(fila);
        }
    }

    @Override
    public String toString() {
        return "ArrayADT2D{" +
                "renglones=" + renglones +
                ", columnas=" + columnas +
                ", datos=" + datos +
                '}';
    }


    public int obtenerRenglones() {
        return this.renglones;
    }

    public int obtenerColumnas() {
        return this.columnas;
    }

    public void establecerElemento(int ren, int col, T dato) {
        asegurarCapacidad(ren, col);
        datos.get(ren).set(col, dato);
    }

    private void asegurarCapacidad(int ren, int col) {
        while (ren >= renglones) {
            datos.add(new ArrayList<>());
            renglones++;
        }

        if (col >= columnas) {
            columnas = col + 1;
        }

        for (int i = 0; i < renglones; i++) {
            ArrayList<T> fila = datos.get(i);
            while (fila.size() < columnas) {
                fila.add(null);
            }
        }
    }

    public void rellenar(T dato) {
        for (int i = 0; i < renglones; i++) {
            for (int j = 0; j < columnas; j++) {
                datos.get(i).set(j, dato);
            }
        }
    }

    public T obtenerElemento(int ren, int col) {
        validarTamanio(ren, col);
        return datos.get(ren).get(col);
    }

    public int[] obtenerCoordenadas(T dato) {
        for (int i = 0; i < renglones; i++) {
            for (int j = 0; j < columnas; j++) {
                if (dato.equals(datos.get(i).get(j))) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private void validarTamanio(int ren, int col) {
        if (ren < 0 || ren >= renglones) {
            throw new IndexOutOfBoundsException("Renglón fuera de rango: " + ren);
        }
        if (col < 0 || col >= columnas) {
            throw new IndexOutOfBoundsException("Columna fuera de rango: " + col);
        }
    }

    public void imprimir() {
        for (int i = 0; i < renglones; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(datos.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }
}