/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * La clase Pila representa una estructura de datos tipo pila.
 * Una pila es una colección de elementos donde el último elemento en entrar es el primero en salir (LIFO).
 *
 * @param <T> el tipo de elemento almacenado en la pila.
 */
public class Pila<T> {

    private Nodo top;
    private Nodo buttom;
    private int size;

    /**
     * Crea una nueva pila con el nodo superior, el nodo inferior y el tamaño especificados.
     *
     * @param top    el nodo superior de la pila.
     * @param buttom el nodo inferior de la pila.
     * @param size   el tamaño actual de la pila.
     */
    public Pila(Nodo top, Nodo buttom, int size) {
        this.top = top;
        this.buttom = buttom;
        this.size = size;
    }

    /**
     * Obtiene el nodo superior de la pila.
     *
     * @return el nodo superior de la pila.
     */
    public Nodo getTop() {
        return top;
    }

    /**
     * Establece el nodo superior de la pila.
     *
     * @param top el nodo superior de la pila.
     */
    public void setTop(Nodo top) {
        this.top = top;
    }

    /**
     * Obtiene el nodo inferior de la pila.
     *
     * @return el nodo inferior de la pila.
     */
    public Nodo getButtom() {
        return buttom;
    }

    /**
     * Establece el nodo inferior de la pila.
     *
     * @param buttom el nodo inferior de la pila.
     */
    public void setButtom(Nodo buttom) {
        this.buttom = buttom;
    }

    /**
     * Obtiene el tamaño actual de la pila.
     *
     * @return el tamaño actual de la pila.
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño actual de la pila.
     *
     * @param size el tamaño actual de la pila.
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila está vacía, false de lo contrario.
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Agrega un elemento a la parte superior de la pila.
     *
     * @param dato el elemento a agregar.
     */
    public void push(T dato) {
        Nodo newNode = new Nodo(dato);
        if (isEmpty()) {
            top = newNode;
            buttom = newNode;
        } else {
            newNode.setpNext(top);
            top = newNode;
        }
        size++;
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     *
     * @return el elemento eliminado de la parte superior de la pila.
     */
    public T pop() {
        if (isEmpty()) {
            System.out.println("Error: pila vacia");
            return null;
        }

        T dato = (T) top.getUser();
        top = top.getpNext();

        if (top == null) {
            buttom = null;
        }
        size--;
        return dato;
    }
}
