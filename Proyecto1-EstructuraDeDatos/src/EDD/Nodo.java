/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 * Clase que corresponde a los nodos
 * @author jonathanpizzurro
 */
public class Nodo {
    
   public String user;
   public Nodo pNext;

    /**
     *
     * @param user
     */
    public Nodo(String user) {
        this.user = user;
        this.pNext = null;
    }

    /**
     *
     * @return
     */
    public String getUser() {
        return user;
        
    }

    /**
     *
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public Nodo getpNext() {
        return pNext;
    }

    /**
     *
     * @param pNext
     */
    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }

    
}
