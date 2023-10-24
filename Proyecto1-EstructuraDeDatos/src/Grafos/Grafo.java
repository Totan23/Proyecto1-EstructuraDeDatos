/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;

import EDD.Lista;


/**
 *
 * @author nicolepinto
 */
public class Grafo {

    Lista ListaDeAdyacencia;
    Lista ListaDeVertices;

    public Grafo() {
        this.ListaDeAdyacencia = new Lista();
        this.ListaDeVertices = new Lista();
    }

    public Lista getListaDeAdyacencia() {
        return ListaDeAdyacencia;
    }

    public void setListaDeAdyacencia(Lista ListaDeAdyacencia) {
        this.ListaDeAdyacencia = ListaDeAdyacencia;
    }

    public Lista getListaDeVertices() {
        return ListaDeVertices;
    }

    public void setListaDeVertices(Lista ListaDeVertices) {
        this.ListaDeVertices = ListaDeVertices;
    }
    
    public boolean isEmpty(){
        if(ListaDeVertices.getTamano() == 0){
            return false;
        }
        else return true;
    
    }
    
    public boolean isVertex(String nombre){
        if (isEmpty()){
            return false;
        }
        else {
            for (int indice = 0; indice < ListaDeVertices.getTamano(); indice++) {
                Vertice vertex = (Vertice) ListaDeVertices.get(indice);
                if(vertex.getNombre().equals(nombre)){
                    return true;
                }
              
            
            }
            return false;
            
        }
    }
    
    
    
    public void agregarVertice(String nombre){
        Vertice Vertex = new Vertice(nombre);
        if (isVertex(nombre)){
            System.out.println("error");
            
                  
                  
        }
        else{
            ListaDeVertices.insertar_final(Vertex);
            System.out.println("Vertice Agregado");
            
        }
           
    }
    
    
}
    

