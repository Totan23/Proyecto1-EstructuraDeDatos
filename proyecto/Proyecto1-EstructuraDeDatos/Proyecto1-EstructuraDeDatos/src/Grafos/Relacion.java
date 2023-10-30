/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;


/**
 * La clase Relacion representa una relación entre dos vértices.
 */
public class Relacion {
    String verticeA;
    String verticeB;

    /**
     * Crea una nueva instancia de la clase Relacion.
     * @param verticeA el primer vértice de la relación.
     * @param verticeB el segundo vértice de la relación.
     */
    public Relacion(String verticeA, String verticeB) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
    }

    /**
     * Obtiene el primer vértice de la relación.
     * @return el primer vértice.
     */
    public String getVerticeA() {
        return verticeA;
    }

    /**
     * Establece el primer vértice de la relación.
     * @param verticeA el primer vértice.
     */
    public void setVerticeA(String verticeA) {
        this.verticeA = verticeA;
    }

    /**
     * Obtiene el segundo vértice de la relación.
     * @return el segundo vértice.
     */
    public String getVerticeB() {
        return verticeB;
    }

    /**
     * Establece el segundo vértice de la relación.
     * @param verticeB el segundo vértice.
     */
    public void setVerticeB(String verticeB) {
        this.verticeB = verticeB;
    }
}

