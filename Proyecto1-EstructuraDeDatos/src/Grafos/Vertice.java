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
public class Vertice {
    String nombre;
    int relaciones;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.relaciones = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRelaciones() {
        return relaciones;
    }

    public void setRelaciones(int relaciones) {
        this.relaciones = relaciones;
    }
    
}
