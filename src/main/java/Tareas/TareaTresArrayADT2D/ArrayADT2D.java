package Tareas.TareaTresArrayADT2D;

import java.util.Arrays;

public class ArrayADT2D<T> {
    private int renglones;
    private int columnas;
    private Object[][] datos;

    public ArrayADT2D(int renglones, int columnas) {
        this.renglones = renglones;
        this.columnas = columnas;
        this.datos = new Object[renglones][columnas];
    }

    @Override
    public String toString() {
        return "ArrayADT2D{" +
                "renglones=" + renglones +
                ", columnas=" + columnas +
                ", datos=" + Arrays.deepToString(datos) +
                '}';
    }

    public int obtenerRenglones() {
        return this.renglones;
    }

    public int obtenerColumnas() {
        return this.columnas;
    }

    public void establecerElemento(int ren, int col, T dato) {
        validarTamanio(ren, col);
        datos[ren][col] = dato;
    }

    public void rellenar(T dato) {
        for (int i = 0; i < renglones; i++) {
            for (int j = 0; j < columnas; j++) {
                datos[i][j] = dato;
            }
        }
    }

    public T obtenerElemento(int ren, int col) {
        validarTamanio(ren, col);
        return (T) datos[ren][col];
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
                System.out.println(datos[i][j]);
            }

        }
    }
}

