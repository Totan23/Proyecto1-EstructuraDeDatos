/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EDD;

/**
 *
 * @author jonathanpizzurro
 */
public class Lista {
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
    
    public void insertar_inicio(Nodo n){
        
        if (pFirst == null){
        pFirst = n;
        
                tamano ++;
        
    }else{
       n.setpNext(pFirst);
       pFirst = n;
       
                tamano ++;
    }
    }
       
    public void insertar_final(Nodo n){
        
        if (pFirst == null){
        pFirst = n ;
        
                tamano ++;   
    }else{
        Nodo aux = pFirst;
        while (aux.getpNext()!= null){
            aux = aux.getpNext();
        }
        aux.setpNext(n);
        
                tamano ++;
        
        }
    
}
    public void eliminar(Nodo n){
        
        
        Nodo aux = pFirst;
        if(aux.getUser().equals(n.getUser())){
            pFirst = aux.getpNext();
            
        }
        else{
        while (aux.getpNext() != null && !aux.getpNext().getUser().equals(n.getUser())){
            aux = aux.getpNext();
        }
       
        if (aux.getpNext()!= null){
           
            aux.setpNext(aux.getpNext().getpNext());   //Por lo menos si quieres eliminar de 1234 el 3. con esto que hicimos se lo va a saltar
        }
                    tamano --;
    }}

    public Nodo buscar(Nodo n){         //Para retornar quitamos el Void y ponemos lo que es, en este caso buscar es el Nodo
        
        Nodo aux = pFirst;
        
        while (aux.getUser()== n.getUser()){
            aux = aux.getpNext();
        }
        
        return aux;
    }
    
    
    public void imprimir(){
        
        Nodo aux = pFirst;
        
        while (aux != null){
            System.out.println(aux.getUser());
            aux = aux.getpNext();
                    }
    } 
}
