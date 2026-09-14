package Tareas.TareaCuatroConjuntoADT;

public class Main {

    public static void main(String[] args) {
        ConjuntoADT biomasTotales = new ConjuntoADT<>();
        ConjuntoADT biomasVisitados = new ConjuntoADT<>();

        biomasTotales.agregarElemento("Llanuras");
        biomasTotales.agregarElemento("Bosque");
        biomasTotales.agregarElemento("Desierto");
        biomasTotales.agregarElemento("Selva");
        biomasTotales.agregarElemento("Pantano");
        biomasTotales.agregarElemento("Taiga");
        biomasTotales.agregarElemento("Sabana");
        biomasTotales.agregarElemento("Llanuras nevadas");
        biomasTotales.agregarElemento("Tierras baldías");
        biomasTotales.agregarElemento("Campos de champiñones");
        biomasTotales.agregarElemento("Playa");
        biomasTotales.agregarElemento("Océano profundo");


        if (biomasTotales.longitud() == biomasVisitados.longitud()){
            System.out.println("=======================================");
            System.out.println(" Logro completado:  HORA DE AVENTURAS  ");
            System.out.println("=======================================");
        }else {
            System.out.println("Logro en proceso...");
        }

        biomasVisitados.agregarElemento("Llanuras");
        biomasVisitados.agregarElemento("Bosque");
        biomasVisitados.agregarElemento("Desierto");
        biomasVisitados.agregarElemento("Selva");
        biomasVisitados.agregarElemento("Pantano");
        biomasVisitados.agregarElemento("Taiga");
        biomasVisitados.agregarElemento("Sabana");
        biomasVisitados.agregarElemento("Llanuras nevadas");
        biomasVisitados.agregarElemento("Tierras baldías");
        biomasVisitados.agregarElemento("Campos de champiñones");
        biomasVisitados.agregarElemento("Playa");
        biomasVisitados.agregarElemento("Océano profundo");

        if (biomasTotales.longitud() == biomasVisitados.longitud()){
            System.out.println("=======================================");
            System.out.println(" Logro completado:  HORA DE AVENTURAS  ");
            System.out.println("=======================================");
        }else {
            System.out.println("Logro en proceso...");
        }

    }
}
