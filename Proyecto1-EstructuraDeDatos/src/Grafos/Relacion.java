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
public class Relacion {
    String verticeA;
    String verticeB;

    public Relacion(String verticeA, String verticeB) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
    }

    public String getVerticeA() {
        return verticeA;
    }

    public void setVerticeA(String verticeA) {
        this.verticeA = verticeA;
    }

    public String getVerticeB() {
        return verticeB;
    }

    public void setVerticeB(String verticeB) {
        this.verticeB = verticeB;
    }
    
}
