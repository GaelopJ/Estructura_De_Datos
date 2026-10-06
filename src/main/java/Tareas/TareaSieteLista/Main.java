package Tareas.TareaSieteLista;

public class Main {
    public static void main(String[] args) {
        ListaSimplementeLigada<PolloAsado> listaPollos = new ListaSimplementeLigada<>();

        System.out.println("--- ¿La lista está vacía al inicio? ---");
        System.out.println("Respuesta: " + listaPollos.estaVacia());

        PolloAsado p1 = new PolloAsado("Sinaloa", 120.50);
        PolloAsado p2 = new PolloAsado("Ranchero", 150.00);
        PolloAsado p3 = new PolloAsado("Crujiente", 135.00);
        PolloAsado p4 = new PolloAsado("Adobado", 145.00);

        System.out.println("\n--- Agregando elementos ---");
        listaPollos.agregarAlInicio(p1); // Prueba: agregar al inicio
        listaPollos.agregarAlFinal(p2);  // Prueba: agregar al final
        listaPollos.agregarAlFinal(p3);  // Prueba: agregar al final
        listaPollos.transversal();       // Prueba: recorrido transversal

        // 2. PROBANDO estaVacia() CON ELEMENTOS
        System.out.println("\n--- ¿La lista está vacía ahora? ---");
        System.out.println("Respuesta: " + listaPollos.estaVacia());

        System.out.println("\n--- Tamaño de la lista ---");
        System.out.println("Total: " + listaPollos.getTamanio()); // Prueba: obtener tamaño

        System.out.println("\n--- Agregando después de un elemento ---");
        listaPollos.agregarDespuesDe(p2, p4); // Prueba: agregar después de
        listaPollos.transversal();

        System.out.println("\n--- Buscando un elemento ---");
        int posicion = listaPollos.buscar(p3); // Prueba: buscar
        System.out.println("El pollo Crujiente está en el índice: " + posicion);

        System.out.println("\n--- Actualizando un elemento ---");
        PolloAsado pNuevo = new PolloAsado("BBQ", 160.00);
        listaPollos.actualizar(p1, pNuevo); // Prueba: actualizar
        listaPollos.transversal();

        System.out.println("\n--- Eliminando elementos ---");
        listaPollos.eliminarElPrimero(); // Prueba: eliminar el primero
        listaPollos.eliminarElFinal();   // Prueba: eliminar el final
        listaPollos.transversal();

        System.out.println("Tamaño final: " + listaPollos.getTamanio());
    }
}
