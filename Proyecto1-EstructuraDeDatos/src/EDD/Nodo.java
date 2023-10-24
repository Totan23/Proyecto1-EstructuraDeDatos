/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * Clase que corresponde a los nodos
 * @author jonathanpizzurro
 */
public class Nodo<T>{
    
   private T user;
   private Nodo pNext;

    /**
     *
     * @param user
     */
    public Nodo(T user) {
        this.user = user;
        this.pNext = null;
    }

    public T getUser() {
        return user;
    }

    public void setUser(T user) {
        this.user = user;
    }

    public Nodo getpNext() {
        return pNext;
    }

    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }

    /**
     *
     * @return
     */
    
}
