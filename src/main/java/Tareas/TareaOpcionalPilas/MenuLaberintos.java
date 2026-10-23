package Tareas.TareaOpcionalPilas;

import java.util.Scanner;

public class MenuLaberintos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OpcionesArchLab solver = new OpcionesArchLab();
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- RESOLVEDOR DE LABERINTOS ---");
            System.out.println("1. Resolver entrada.lab");
            System.out.println("2. Resolver entrada2.lab");
            System.out.println("3. Resolver entrada3.lab");
            System.out.println("4. Resolver entrada4.lab");
            System.out.println("5. Resolver entrada5.lab");
            System.out.println("6. Resolver entrada7.lab");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");

            String opcion = scanner.nextLine();
            String rutaBase = "src/Recursos/entrada";
            String extension = ".lab";
            String rutaFinal = "";

            switch (opcion) {
                case "1":
                    rutaFinal = rutaBase + extension;
                    break;
                case "2":
                case "3":
                case "4":
                case "5":
                    rutaFinal = rutaBase + opcion + extension;
                    break;
                case "6":
                    rutaFinal = rutaBase + "7" + extension;
                    break;
                case "7":
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    continue;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
                    continue;
            }

            System.out.println("\nEjecutando laberinto: " + rutaFinal);
            solver.resolverLaberinto(rutaFinal);
        }

        scanner.close();
    }
}