package Tareas.TareaCincoNodo;

public class Main {
    public static void main(String[] args) {
        Nodo<String> head = new Nodo<>("Al",new Nodo<>("B",new Nodo<>("C",new Nodo<>("De",new Nodo<>("Mc",new Nodo<>("Zi"))))));
        System.out.println("Imprime el estado inicial completo de la lista");
        System.out.println(head + "\n");
        System.out.println("Imprime únicamente el dato almacenado en el primer nodo de la lista");
        System.out.println(head.getDato()+ "\n");
        System.out.println("Imprime el estado completo del nodo ubicado en la última posición de la lista.");
        Nodo<String> cursor = head;
        while (cursor.getSiguiente() != null){
            cursor = cursor.getSiguiente();
        }
        System.out.println(cursor+ "\n");
        System.out.println("Inserta un nuevo nodo con el valor Fe entre los nodos que contienen De y Mc");
        cursor = head;
        while (cursor != null && !cursor.getDato().equals("De")) {
            cursor = cursor.getSiguiente();
        }
        if (cursor != null) {
            Nodo<String> tmp = new Nodo<>("Fe", cursor.getSiguiente());
            cursor.setSiguiente(tmp);
        }
        System.out.println("Imprime el nuevo estado de la lista");
        System.out.println(head + "\n");
        System.out.println("Inserta un nuevo nodo con el valor Zz al final de la lista");
        while (cursor.getSiguiente() != null){
            cursor = cursor.getSiguiente();
        }
        cursor.setSiguiente(new Nodo<>("Zz"));
        System.out.println("Imprime el nuevo estado de la lista");
        System.out.println(head + "\n");
        System.out.println("Inserta un nuevo nodo con el valor Aa al inicio de la lista, de modo que se convierta en el primer nodo");
        Nodo<String> nuevoUno = new Nodo<>("Aa",head);
        head = nuevoUno;
        System.out.println("Imprime el estado final de la lista");
        System.out.println(head);


    }
}
