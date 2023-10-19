/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author jonathanpizzurro
 * @param <t>
 */
public class Nodo <t> {
    
    private Nodo pNext;
    private Nodo pPrev;
    private t dato;

    public Nodo(Nodo pNext, Nodo pPrev, t dato) {
        this.pNext = pNext;
        this.pPrev = pPrev;
        this.dato = dato;
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }

    public Nodo getpPrev() {
        return pPrev;
    }

    public void setpPrev(Nodo pPrev) {
        this.pPrev = pPrev;
    }

    public t getDato() {
        return dato;
    }

    public void setDato(t dato) {
        this.dato = dato;
    }
    
    
    
}
