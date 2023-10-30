/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * La clase Lista representa una lista enlazada genérica.
 * Permite insertar, eliminar, buscar y obtener elementos de la lista.
 * También proporciona métodos para obtener el tamaño de la lista y verificar si está vacía.
 *
 * @param <T> el tipo de elementos que se almacenarán en la lista
 */
public class Lista<T> {

    private Nodo pFirst;
    private int tamano;

    /**
     * Crea una nueva instancia de la clase Lista.
     * Inicializa el primer nodo y el tamaño de la lista en cero.
     */
    public Lista() {
        this.pFirst = null;
        this.tamano = 0;
    }

    /**
     * Obtiene el primer nodo de la lista.
     *
     * @return el primer nodo de la lista
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * Establece el primer nodo de la lista.
     *
     * @param pFirst el nuevo primer nodo de la lista
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Obtiene el tamaño de la lista.
     *
     * @return el tamaño de la lista
     */
    public int getTamano() {
        return tamano;
    }

    /**
     * Establece el tamaño de la lista.
     *
     * @param tamano el nuevo tamaño de la lista
     */
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    /**
     * Inserta un nodo al inicio de la lista.
     *
     * @param n el nodo a insertar
     */
    public void insertar_inicio(Nodo n) {
        if (pFirst == null) {
            pFirst = n;
        } else {
            n.setpNext(pFirst);
            pFirst = n;
        }
        tamano++;
    }

    /**
     * Inserta un elemento al final de la lista.
     *
     * @param data el elemento a insertar
     */
    public void insertar_final(T data) {
        Nodo n = new Nodo(data);
        if (pFirst == null) {
            pFirst = n;
        } else {
            Nodo aux = pFirst;
            while (aux.getpNext() != null) {
                aux = aux.getpNext();
            }
            aux.setpNext(n);
        }
        tamano++;
    }

    /**
     * Elimina un elemento de la lista.
     *
     * @param dato el elemento a eliminar
     */
    public void eliminar(T dato) {
        Nodo aux = pFirst;
        if (aux.getUser().equals(dato)) {
            pFirst = aux.getpNext();
        } else {
            while (aux.getpNext() != null && !aux.getpNext().getUser().equals(dato)) {
                aux = aux.getpNext();
            }
            if (aux.getpNext() != null) {
                aux.setpNext(aux.getpNext().getpNext());
            }
        }
        tamano--;
    }

    /**
     * Busca un nodo en la lista.
     *
     * @param n el nodo a buscar
     * @return el nodo encontrado, o null si no se encuentra
     */
    public Nodo buscar(Nodo n) {
        Nodo aux = pFirst;
        while (aux.getUser() == n.getUser()) {
            aux = aux.getpNext();
        }
        return aux;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si la lista está vacía, false de lo contrario
     */
    public boolean isEmpty() {
        return pFirst == null;
    }

    /**
     * Obtiene el elemento en la posición especificada de la lista.
     *
     * @param indice la posición del elemento a obtener
     * @return el elemento en la posición especificada, o null si la lista está vacía
     */
    public T get(int indice) {
        if (isEmpty()) {
            return null;
        } else {
            Nodo pointer = pFirst;
            for (int i = 0; i < indice; i++) {
                pointer = pointer.getpNext();
            }
            return (T) pointer.getUser();
        }
    }

    /**
     * Imprime los elementos de la lista en la consola.
     */
    public void imprimir() {
        Nodo aux = pFirst;
        while (aux != null) {
            System.out.println(aux.getUser());
            aux = aux.getpNext();
        }
    }
}

