/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author jonathanpizzurro
 */
public class Lista<T> {

    public Nodo pFirst;
    int tamano;

    public Nodo getpFirst() {
        return pFirst;
    }

    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public Lista() {
        this.pFirst = null;
        this.tamano = 0;
    }

    public void insertar_inicio(Nodo n) {

        if (pFirst == null) {
            pFirst = n;

            tamano++;

        } else {
            n.setpNext(pFirst);
            pFirst = n;

            tamano++;
        }
    }

    public void insertar_final(T data) {
        Nodo n = new Nodo(data);
        if (pFirst == null) {
            pFirst = n;

            tamano++;
        } else {
            Nodo aux = pFirst;
            while (aux.getpNext() != null) {
                aux = aux.getpNext();
            }
            aux.setpNext(n);

            tamano++;

        }

    }

    public void eliminar(T dato) {

        Nodo aux = pFirst;
        if (aux.getUser().equals(dato)) {
            pFirst = aux.getpNext();

        } else {
            while (aux.getpNext() != null && !aux.getpNext().getUser().equals(dato)) {
                aux = aux.getpNext();
            }

            if (aux.getpNext() != null) {

                aux.setpNext(aux.getpNext().getpNext());   //Por lo menos si quieres eliminar de 1234 el 3. con esto que hicimos se lo va a saltar
            }
            tamano--;
        }
    }

    public Nodo buscar(Nodo n) {         //Para retornar quitamos el Void y ponemos lo que es, en este caso buscar es el Nodo

        Nodo aux = pFirst;

        while (aux.getUser() == n.getUser()) {
            aux = aux.getpNext();
        }

        return aux;
    }

    public boolean isEmpty() {
        return pFirst == null;

    }

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

    public void imprimir() {

        Nodo aux = pFirst;

        while (aux != null) {
            System.out.println(aux.getUser());
            aux = aux.getpNext();
        }
    }
    
    
}
