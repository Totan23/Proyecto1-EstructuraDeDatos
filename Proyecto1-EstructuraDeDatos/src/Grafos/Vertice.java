/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

/**
 *
 * @author guzzo
 */
/**
 * La clase Vertice representa un vértice en un grafo.
 */
public class Vertice {
    String nombre;
    int relaciones;

    /**
     * Crea una nueva instancia de la clase Vertice.
     * @param nombre el nombre del vértice.
     */
    public Vertice(String nombre) {
        this.nombre = nombre;
        this.relaciones = 0;
    }

    /**
     * Obtiene el nombre del vértice.
     * @return el nombre del vértice.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del vértice.
     * @param nombre el nombre del vértice.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de relaciones del vértice.
     * @return el número de relaciones del vértice.
     */
    public int getRelaciones() {
        return relaciones;
    }

    /**
     * Establece el número de relaciones del vértice.
     * @param relaciones el número de relaciones del vértice.
     */
    public void setRelaciones(int relaciones) {
        this.relaciones = relaciones;
    }
}
