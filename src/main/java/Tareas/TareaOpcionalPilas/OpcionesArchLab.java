package Tareas.TareaOpcionalPilas;

import Tareas.TareaTresArrayADT2D.ArrayADT2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class OpcionesArchLab {
    private String lineaALeer;
    private ArrayADT2D<Integer> tablero;

    private static final int ENTRADA = 2;
    private static final int SALIDA = 3;
    private static final int RENGLON = 0;
    private static final int COLUMNA = 1;
    private static final int REVISADA = 9;

    String ROJO = "\u001B[31m";
    String AZUL = "\u001B[34m";
    String VERDE = "\u001B[32m";
    String RESET = "\u001B[0m";

    public void leerContenidoLab(String rutaArchivo) {
        tablero = new ArrayADT2D<>();
        int renglonActual = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            br.readLine();
            br.readLine();

            while ((lineaALeer = br.readLine()) != null) {
                String[] renglonCasilla = lineaALeer.split(",");
                for (int i = 0; i < renglonCasilla.length; i++) {
                    String valor = renglonCasilla[i].trim();
                    int numeroAGuardar;

                    if (valor.equals("E")) {
                        numeroAGuardar = ENTRADA;
                    } else if (valor.equals("S")) {
                        numeroAGuardar = SALIDA;
                    } else {
                        numeroAGuardar = Integer.parseInt(valor);
                    }
                    tablero.establecerElemento(renglonActual, i, numeroAGuardar);
                }
                renglonActual++;
            }
        } catch (Exception e) {
            System.out.println("Error al cargar el laberinto: " + e.getMessage());
        }
    }

    public void imprimir() {
        for (int i = 0; i < tablero.obtenerRenglones(); i++) {
            for (int j = 0; j < tablero.obtenerColumnas(); j++) {
                Integer elemento = tablero.obtenerElemento(i, j);
                if (elemento != null) {
                    if (elemento == 1) {
                        System.out.print(" █ ");
                    } else if (elemento == 0) {
                        System.out.print(" □ ");
                    } else if (elemento == ENTRADA) {
                        System.out.print(VERDE + " █ " + RESET);
                    } else if (elemento == SALIDA) {
                        System.out.print(AZUL + " █ " + RESET);
                    } else if (elemento == REVISADA) {
                        System.out.print(ROJO + " █ " + RESET);
                    } else {
                        System.out.print(" " + elemento + " ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void resolverLaberinto(String rutaArchivo) {
        this.leerContenidoLab(rutaArchivo);
        this.imprimir();

        Deque<int[]> pilaLaberinto = new ArrayDeque<>();
        int[] inicio = tablero.obtenerCoordenadas(ENTRADA);

        if (inicio == null) {
            System.out.println("No hay entrada.");
            return;
        }

        pilaLaberinto.push(inicio);

        while (!pilaLaberinto.isEmpty()) {
            int[] actual = pilaLaberinto.pop();
            int renActual = actual[RENGLON];
            int colActual = actual[COLUMNA];

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (tablero.obtenerElemento(renActual, colActual) != ENTRADA) {
                tablero.establecerElemento(renActual, colActual, REVISADA);
            }

            this.imprimir();

            // --- VERIFICAR IZQUIERDA ---
            if (colActual - 1 >= 0) {
                int valorIzquierda = tablero.obtenerElemento(renActual, colActual - 1);
                if (valorIzquierda == SALIDA) {
                    System.out.println("Salida encontrada!!!\n");
                    this.imprimir();
                    return;
                }
                if (valorIzquierda == 0) {
                    pilaLaberinto.push(new int[]{renActual, colActual - 1});
                }
            }

            // --- VERIFICAR Arriba ---
            if (renActual - 1  >= 0) {
                int valorArriba = tablero.obtenerElemento(renActual - 1, colActual);
                if (valorArriba == SALIDA) {
                    System.out.println("Salida encontrada!!!\n");
                    this.imprimir();
                    return;
                }
                if (valorArriba == 0) {
                    pilaLaberinto.push(new int[]{renActual - 1, colActual});
                }
            }

            // --- VERIFICAR derecha ---
            if (colActual + 1 <  tablero.obtenerColumnas()) {
                int valorDerecha =  tablero.obtenerElemento(renActual , colActual + 1);
                if (valorDerecha == SALIDA) {
                    System.out.println("Salida encontrada!!!\n");
                    this.imprimir();
                    return;
                }
                if (valorDerecha == 0) {
                    pilaLaberinto.push(new int[]{renActual , colActual + 1});
                }
            }

            // --- Verificar abajo -----
            if (renActual + 1  < tablero.obtenerRenglones()) {
                int valorAbajo = tablero.obtenerElemento(renActual + 1, colActual);
                if (valorAbajo == SALIDA) {
                    System.out.println("Salida encontrada!!!\n");
                    this.imprimir();
                    return;
                }
                if (valorAbajo == 0) {
                    pilaLaberinto.push(new int[]{renActual + 1, colActual});
                }
            }
        }
        System.out.println("No hay solución, el laberinto no tiene salida.");
    }
}