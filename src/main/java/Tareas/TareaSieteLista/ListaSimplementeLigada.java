package Tareas.TareaSieteLista;
import Tareas.TareaCincoNodo.Nodo;

public class ListaSimplementeLigada<T> {
    private Nodo<T> head;
    private int tamanio;

    public ListaSimplementeLigada() {
        this.head = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {
        return this.head == null;
    }

    public int getTamanio() {
        return this.tamanio;
    }

    public void agregarAlFinal(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (estaVacia()) {
            this.head = nuevoNodo;
        } else {
            Nodo<T> actual = this.head;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        this.tamanio++;
    }

    public void agregarAlInicio(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor, this.head);
        this.head = nuevoNodo;
        this.tamanio++;
    }

    public void agregarDespuesDe(T referencia, T valor) {
        Nodo<T> actual = this.head;
        while (actual != null && !actual.getDato().equals(referencia)) {
            actual = actual.getSiguiente();
        }
        if (actual != null) {
            Nodo<T> nuevoNodo = new Nodo<>(valor, actual.getSiguiente());
            actual.setSiguiente(nuevoNodo);
            this.tamanio++;
        }
    }

    public void eliminarElPrimero() {
        if (!estaVacia()) {
            this.head = this.head.getSiguiente();
            this.tamanio--;
        }
    }

    public void eliminarElFinal() {
        if (estaVacia()) return;

        if (this.head.getSiguiente() == null) {
            this.head = null;
        } else {
            Nodo<T> actual = this.head;
            while (actual.getSiguiente().getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(null);
        }
        this.tamanio--;
    }

    public int buscar(T valor) {
        Nodo<T> actual = this.head;
        int posicion = 0;
        while (actual != null) {
            if (actual.getDato().equals(valor)) {
                return posicion;
            }
            actual = actual.getSiguiente();
            posicion++;
        }
        return -1;
    }

    public void actualizar(T aBuscar, T valorNuevo) {
        Nodo<T> actual = this.head;
        while (actual != null) {
            if (actual.getDato().equals(aBuscar)) {
                actual.setDato(valorNuevo);
                return;
            }
            actual = actual.getSiguiente();
        }
    }

    public void transversal() {
        Nodo<T> actual = this.head;
        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getSiguiente();
        }
        System.out.println("null");
    }
}