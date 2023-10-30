/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * La clase Nodo representa un nodo en una lista enlazada.
 * Cada nodo contiene un elemento de tipo T y una referencia al siguiente nodo en la lista.
 *
 * @param <T> el tipo de elemento almacenado en el nodo.
 */
public class Nodo<T> {

    private T user;
    private Nodo pNext;

    /**
     * Crea un nuevo nodo con el elemento especificado.
     *
     * @param user el elemento almacenado en el nodo.
     */
    public Nodo(T user) {
        this.user = user;
        this.pNext = null;
    }

    /**
     * Obtiene el elemento almacenado en el nodo.
     *
     * @return el elemento almacenado en el nodo.
     */
    public T getUser() {
        return user;
    }

    /**
     * Establece el elemento almacenado en el nodo.
     *
     * @param user el elemento a almacenar en el nodo.
     */
    public void setUser(T user) {
        this.user = user;
    }

    /**
     * Obtiene la referencia al siguiente nodo en la lista.
     *
     * @return la referencia al siguiente nodo.
     */
    public Nodo getpNext() {
        return pNext;
    }

    /**
     * Establece la referencia al siguiente nodo en la lista.
     *
     * @param pNext la referencia al siguiente nodo.
     */
    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }
}
