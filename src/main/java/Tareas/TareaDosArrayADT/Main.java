package Tareas.TareaDosArrayADT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Nomina nominaJunio = new Nomina();
        int seleccion = 0;
        String opciones[] = {"Nomina", "trabajador con mayor antigüedad", "trabajador con menor antigüedad"};

        for (int i = 0; i < opciones.length; i++) {
            System.out.println("[" + (i + 1) + "]" + opciones[i]);
        }
        Scanner scanner = new Scanner(System.in);
        seleccion = scanner.nextInt();

        if (seleccion <= 0 || seleccion > opciones.length) {
            System.out.println("Opción no válida. Intenta de nuevo.\n");
        } else {
            switch (seleccion) {
                case 1:
                    System.out.println("----------NOMINA DE ESTE MES----------");
                    nominaJunio.imprimirNomina();
                    break;
                case 2:
                    System.out.println("----------Trabajadores con mayor antigüedad---------");
                    nominaJunio.mayorAntiguedad();
                    break;
                case 3:
                    System.out.println("----------Trabajadores con menor antigüedad----------");
                    nominaJunio.menorAntiguedad();
                    break;
            }
        }
    }
}
