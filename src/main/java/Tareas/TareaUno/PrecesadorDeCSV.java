package Tareas.TareaUno;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PrecesadorDeCSV {

    private String archivoRuta = "/home/zorkhat/Downloads/datos_redes_sociales (1).csv";
    private String lineaALeer;
    private ArrayList<ArrayList<String>> tablaDeContenido = new ArrayList<>();
    private int seleccion = -1;

    public void leerContendidoCSV(){
        try (BufferedReader br = new BufferedReader(new FileReader(archivoRuta))){

            while ((lineaALeer = br.readLine()) != null){

                String[] palabra = lineaALeer.split(",");
                ArrayList<String> fila = new ArrayList<>();

                for (int i =0; i< palabra.length;i++){
                    fila.add(palabra[i]);
                }
                tablaDeContenido.add(fila);
            }

            for (int i = 0; i < tablaDeContenido.size(); i++) {
                for (int j = 0; j < tablaDeContenido.get(i).size(); j++) {
                    System.out.printf("%-27s",tablaDeContenido.get(i).get(j) + " ");
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("No se encontro el archivo");
        }
    }

    public void accionesEnTabla(){
        this.leerContendidoCSV();
        String[] opciones = {"Sacar Promedio", "Diferencia entre Meses", "Promedio total de ME GUSTA "};

        Scanner scanner = new Scanner(System.in);

        while (seleccion < 1 || seleccion > opciones.length){
            System.out.println("----- SELECCIONA UNA OPCIÓN -----");

            for (int i = 0; i < opciones.length;i++){
                System.out.println("[" + (i+1) + "]" + opciones[i]);
            }
            System.out.println();
            System.out.println("Introduce tu opción:  ");

            if (scanner.hasNextInt()){
                seleccion = scanner.nextInt();
                if (seleccion <= 0 || seleccion > opciones.length){
                    System.out.println("Opción no válida. Intenta de nuevo.\n");
                }
                switch (seleccion){
                    case 1:
                        System.out.println("----- PROMEDIO -----");
                        System.out.println("En que campo quieres sacar promedio?");
                        for (int i = 1; i < tablaDeContenido.size(); i++) {
                            System.out.println("[" + (i) + "]" + "↓");
                            for (int j = 0; j < 2; j++) {
                                System.out.printf("%-10s", tablaDeContenido.get(i).get(j) + " ");
                            }
                            System.out.println();
                        }
                        int filaElegida = scanner.nextInt();

                        double suma = 0.0;
                        int mesesConDatos = 0;

                        for (int col = 3; col <= 8; col++) {
                            if (col < tablaDeContenido.get(filaElegida).size()) {
                                String celda = tablaDeContenido.get(filaElegida).get(col).replace("%", "").trim();
                                if (!celda.isEmpty() && !celda.equals("-")) {
                                    try {
                                        suma += Double.parseDouble(celda);
                                        mesesConDatos++;
                                    } catch (NumberFormatException e) {
                                    }
                                }
                            }
                        }

                        if (mesesConDatos > 0) {
                            double promedioFinal = suma / mesesConDatos;
                            String redSocial = tablaDeContenido.get(filaElegida).get(0);
                            String campo = tablaDeContenido.get(filaElegida).get(1);

                            System.out.println("\nEl promedio de " + redSocial + " (" + campo + ") es: " + promedioFinal + " (basado en " + mesesConDatos + " meses)\n");
                        } else {
                            System.out.println("\nNo se encontraron datos numéricos válidos en esa fila para sacar un promedio.\n");
                        }
                        break;

                    case 2:
                        System.out.println("----- DIFERENCIA ENTRE MESES -----");
                        System.out.println("¿De qué campo quieres calcular la diferencia?");

                        for (int i = 1; i < tablaDeContenido.size(); i++) {
                            System.out.print("[" + i + "] ");
                            for (int j = 0; j < 2; j++) {
                                System.out.printf("%-10s", tablaDeContenido.get(i).get(j) + " ");
                            }
                            System.out.println();
                        }

                        int filaDif = scanner.nextInt();

                        System.out.println("\nMeses disponibles:");
                        String[] nombresMeses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

                        for (int i = 0; i < nombresMeses.length; i++) {
                            System.out.println("[" + (i+1) + "] " + nombresMeses[i]);
                        }

                        System.out.print("\nSelecciona el número del PRIMER mes: ");
                        int mes1 = scanner.nextInt();
                        System.out.print("Selecciona el número del SEGUNDO mes: ");
                        int mes2 = scanner.nextInt();

                        int indiceMes1 = mes1 + 2;
                        int indiceMes2 = mes2 + 2;

                        String celda1 = tablaDeContenido.get(filaDif).get(indiceMes1).replace("%", "").trim();
                        String celda2 = tablaDeContenido.get(filaDif).get(indiceMes2).replace("%", "").trim();

                        double valorMes1 = Double.parseDouble(celda1);
                        double valorMes2 = Double.parseDouble(celda2);

                        double diferencia = (valorMes1 - valorMes2);

                        String redSeleccionada = tablaDeContenido.get(filaDif).get(0);
                        String campoSeleccionado = tablaDeContenido.get(filaDif).get(1);

                        System.out.println("\n--- RESULTADO DE LA DIFERENCIA ---");
                        System.out.println("Red Social: " + redSeleccionada + "  Campo: " + campoSeleccionado);
                        System.out.println(nombresMeses[mes1 - 1] + ": " + valorMes1);
                        System.out.println(nombresMeses[mes2 - 1] + ": " + valorMes2);
                        System.out.println("La diferencia exacta es: " + diferencia + "\n");
                        break;

                    case 3:
                        System.out.println("----- PROMEDIO ME GUSTA (POR SEPARADO) -----");
                        int[] filasDeMeGusta = {5, 13, 18};

                        System.out.println("\n--- RESULTADOS INDIVIDUALES ---");

                        for (int filaIndex : filasDeMeGusta) {
                            if (filaIndex < tablaDeContenido.size()) {

                                double sumaRed = 0.0;
                                int mesesValidosRed = 0;

                                String socialRed = tablaDeContenido.get(filaIndex).get(0);
                                String concepto = tablaDeContenido.get(filaIndex).get(1);

                                for (int col = 3; col <= 8; col++) {
                                    if (col < tablaDeContenido.get(filaIndex).size()) {
                                        String celda = tablaDeContenido.get(filaIndex).get(col).replace("%", "").trim();

                                        if (!celda.isEmpty() && !celda.equals("-")) {
                                            try {
                                                sumaRed += Double.parseDouble(celda);
                                                mesesValidosRed++;
                                            } catch (NumberFormatException e) {
                                            }
                                        }
                                    }
                                }

                                if (mesesValidosRed > 0) {
                                    double promedioIndividual = sumaRed / mesesValidosRed;
                                    System.out.println(socialRed + " (" + concepto + "):");
                                    System.out.println("   Suma total: " + sumaRed);
                                    System.out.println("   Promedio  : " + promedioIndividual + " (calculado sobre " + mesesValidosRed + " meses)\n");
                                } else {
                                    System.out.println(socialRed + " no tiene datos numéricos válidos.\n");
                                }
                            }
                        }
                        break;
                }
            } else {
                System.out.println("Introduce un NÚMERO válido.\n");
                scanner.next();
            }
        }
    }
}