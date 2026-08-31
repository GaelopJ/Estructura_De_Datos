package Tareas.TareaDosArrayADT;

import java.io.BufferedReader;
import java.io.FileReader;

public class Nomina {
    private ArrayADT<Empleado> datos;
    private String rutaArchivo = "/home/zorkhat/Downloads/junio.dat";
    private String lineaALeer;


    public void leerArchivo() {
        datos = new ArrayADT<>(15);

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            int indice = 1;
            br.readLine();
            while ((lineaALeer = br.readLine()) != null) {

                String[] datosDeEmpleado = lineaALeer.split(",");

                if (datosDeEmpleado.length >= 7) {

                    int numEmpleado = Integer.parseInt(datosDeEmpleado[0].trim());
                    String nombres = datosDeEmpleado[1].trim();
                    String apePaterno = datosDeEmpleado[2].trim();
                    String apeMaterno = datosDeEmpleado[3].trim();
                    int hrsExtra = Integer.parseInt(datosDeEmpleado[4].trim());
                    int sueldoBase = Integer.parseInt(datosDeEmpleado[5].trim());
                    int anioIngreso = Integer.parseInt(datosDeEmpleado[6].trim());

                    Empleado empleado = new Empleado(numEmpleado, nombres, apePaterno, apeMaterno, hrsExtra, sueldoBase, anioIngreso);
                    datos.insertarElemento(indice, empleado);

                    indice++;
                }

            }
        } catch (Exception e) {
            System.out.println("el error fue: " + e.getMessage());
        }
    }

    public void menorAntiguedad() {
        leerArchivo();
        for (int i = 1; i < datos.longitud(); i++) {
            for (int j = 1; j < datos.longitud() - i; j++) {
                Empleado empleadoIzq = datos.obtenerElemento(j);
                Empleado empleadoDer = datos.obtenerElemento(j + 1);
                if (empleadoIzq.getAnioIngreso() < empleadoDer.getAnioIngreso()) {

                    Empleado temporal = empleadoIzq;
                    datos.insertarElemento(j, empleadoDer);
                    datos.insertarElemento(j + 1, temporal);
                }
            }
        }
        datos.imprimir();
    }

    public void mayorAntiguedad() {
        leerArchivo();
        for (int i = 1; i < datos.longitud(); i++) {
            for (int j = 1; j < datos.longitud() - i; j++) {
                Empleado empleadoIzq = datos.obtenerElemento(j);
                Empleado empleadoDer = datos.obtenerElemento(j + 1);
                if (empleadoIzq.getAnioIngreso() > empleadoDer.getAnioIngreso()) {

                    Empleado temporal = empleadoIzq;
                    datos.insertarElemento(j, empleadoDer);
                    datos.insertarElemento(j + 1, temporal);
                }
            }
        }
        datos.imprimir();
    }

    public void imprimirNomina() {
        leerArchivo();
        for (int i = 1; i < datos.longitud(); i++) {
            System.out.print(datos.obtenerElemento(i).toString() + "   -->  " + "Sueldo a pagar este mes:  " + datos.obtenerElemento(i).calcularSueldo() + "\n");

        }
    }
}

