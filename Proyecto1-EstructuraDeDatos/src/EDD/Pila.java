/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author jonathanpizzurro
 */
public class Pila<T> {

    private Nodo top;
    private Nodo buttom;
    private int size;

    public Pila(Nodo top, Nodo buttom, int size) {
        this.top = top;
        this.buttom = buttom;
        this.size = size;
    }

    public Nodo getTop() {
        return top;
    }

    public void setTop(Nodo top) {
        this.top = top;
    }

    public Nodo getButtom() {
        return buttom;
    }

    public void setButtom(Nodo buttom) {
        this.buttom = buttom;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return top == null;
    }

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
