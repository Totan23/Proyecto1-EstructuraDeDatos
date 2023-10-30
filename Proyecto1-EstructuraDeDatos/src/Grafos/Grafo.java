/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;

import EDD.Lista;
import EDD.Nodo;
import EDD.Pila;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.layout.springbox.implementations.SpringBox;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author nicolepinto
 */
public class Grafo {

    Lista ListaDeAdyacencia;
    Lista ListaDeVertices;
    Lista ListaDeRelaciones;

    public Grafo() {
        this.ListaDeAdyacencia = new Lista();
        this.ListaDeVertices = new Lista();
        this.ListaDeRelaciones = new Lista();
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

    public Lista getListaDeRelaciones() {
        return ListaDeRelaciones;
    }

    public void setListaDeRelaciones(Lista ListaDeRelaciones) {
        this.ListaDeRelaciones = ListaDeRelaciones;
    }

    public boolean isEmpty() {
        return ListaDeVertices.getTamano() == 0;
    }

    public boolean isVertex(String nombre) {
        if (isEmpty()) {
            return false;
        } else {
            for (int indice = 0; indice < ListaDeVertices.getTamano(); indice++) {
                Vertice vertex = (Vertice) ListaDeVertices.get(indice);
                if (vertex.getNombre().equals(nombre)) {
                    return true;
                }

            }
            return false;

        }
    }

    public void agregarVertice(String nombre) {
        if (!isVertex(nombre)) {
            Vertice Vertex = new Vertice(nombre);
            ListaDeVertices.insertar_final(Vertex);
        } else {
            System.out.println("error");
        }
    }

    public void eliminarRelacion(String verticeA, String verticeB) {
        if (ListaDeRelaciones.isEmpty()) {
            System.out.println("No hay relaciones para eliminar.");
            return;
        }

        for (int indice = 0; indice < ListaDeRelaciones.getTamano(); indice++) {
            Relacion rel = (Relacion) ListaDeRelaciones.get(indice);
            if ((rel.getVerticeA().equals(verticeA) && rel.getVerticeB().equals(verticeB))
                    || (rel.getVerticeA().equals(verticeB) && rel.getVerticeB().equals(verticeA))) {
                ListaDeRelaciones.eliminar(rel);
                ListaDeVertices.eliminar(rel);
                System.out.println("Relación eliminada entre " + verticeA + " y " + verticeB);
                return;
            }
        }

        System.out.println("No se encontró la relación entre " + verticeA + " y " + verticeB);
    }

    public void eliminarVertice(String nombre) {
        if (isEmpty()) {
            System.out.println("El grafo está vacío. No hay vértices que eliminar.");
        } else if (isVertex(nombre)) {
            for (int indice = 0; indice < ListaDeVertices.getTamano(); indice++) {
                Vertice vertex = (Vertice) ListaDeVertices.get(indice);
                if (vertex.getNombre().equals(nombre)) {
                    ListaDeVertices.eliminar(ListaDeVertices.get(indice));
                    System.out.println("Vértice " + nombre + " eliminado.");
                    return;
                }
            }
        } else {
            System.out.println("El vértice " + nombre + " no existe en el grafo.");
        }
    }

    public void agregaRelacion(String Vertice1, String Vertice2) {
        // Si el grafo no tiene vértices.
        if (isEmpty()) {
            System.out.println("Grafo vacio");
            return;
        } // Si alguno de los vértices no existe.
        else if (!isVertex(Vertice1) || !isVertex(Vertice2)) {
            System.out.println("Uno o ambos vértices no existen");
            return;
        } // Si ya existe la relación.
        else if (isEdge(Vertice1, Vertice2)) {
            System.out.println("Relacion ya existente");
            return;
        }

        // Si todo está en orden, agrega la relación.
        Relacion edge = new Relacion(Vertice1, Vertice2);
        ListaDeAdyacencia.insertar_final(edge);
        ListaDeVertices.insertar_final(edge);
//        System.out.println("Relacion agregada de manera correcta");
    }

    public boolean isEdge(String Vertice1, String Vertice2) {
        if (isEmpty()) {
            System.out.println("Grafo vacio");
            return false;
        } else {
            if (isVertex(Vertice1) && isVertex(Vertice2)) {
                for (int i = 0; i < ListaDeAdyacencia.getTamano(); i++) {
                    Relacion edge = (Relacion) ListaDeAdyacencia.get(i);
                    if (edge.getVerticeA().equals(Vertice1) && edge.getVerticeB().equals(Vertice2)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public String imprimir() {
        String cadena = "";
        if (isEmpty()) {
            System.out.println("El grafo está vacío.");
        } else {

            cadena += "usuarios\n";

            for (int i = 0; i < ListaDeVertices.getTamano(); i++) {
                Vertice vertex = (Vertice) ListaDeVertices.get(i);
                cadena += vertex.getNombre() + "\n";
            }
            for (int i = 0; i < ListaDeVertices.getTamano(); i++) {
                Vertice vertex = (Vertice) ListaDeVertices.get(i);

                boolean hasEdges = false;
                cadena += "relaciones\n";
                for (int j = 0; j < ListaDeAdyacencia.getTamano(); j++) {
                    Relacion edge = (Relacion) ListaDeAdyacencia.get(j);
                    if (edge.getVerticeA().equals(vertex.getNombre())) {
                        cadena += vertex.getNombre() + ", " + edge.getVerticeB() + "\n";
                        hasEdges = true;
                    }
                }
            }
        }
        return cadena;
    }

    public void graficar(Grafo grafo) {
        System.setProperty("org.graphstream.ui", "org.graphstream.ui.swing.util.Display");

        Graph g = new MultiGraph("grafo");         // Crear un nuevo grafo

        // Estilo CSS para mejorar como se ven los nodos y su legibilidad
        String stylesheet
                = "node {"
                + "   fill-color: #4AEFF5;"
                + "   size: 50px, 50px;"
                + "   text-color: #222;"
                + "   text-size: 20;"
                + "   stroke-mode: plain;"
                + "   stroke-color: black;"
                + "   stroke-width: 2px;"
                + "}"
                + "node.marked {"
                + "   fill-color: red;"
                + "}"
                + "edge {"
                + "   fill-color: black;"
                + "   size: 4px;"
                + "   arrow-size: 15px, 10px;" // Esta línea define el tamaño de las flechas
                + "}";

        g.setAttribute("ui.stylesheet", stylesheet);

        // Recorrer los nodos y agregarlos al grafo
        for (int n = 0; n < grafo.ListaDeVertices.getTamano(); n++) {
            Vertice vertice = (Vertice) grafo.ListaDeVertices.get(n);
            Node node = g.addNode(vertice.getNombre());
            node.setAttribute("ui.label", vertice.getNombre());
        }

        // Recorrer las relaciones y agregar las aristas
        for (int n = 0; n < grafo.ListaDeAdyacencia.getTamano(); n++) {
            Relacion relacion = (Relacion) grafo.ListaDeAdyacencia.get(n);
            String verticeA = relacion.getVerticeA();
            String verticeB = relacion.getVerticeB();

            if (g.getNode(verticeA) != null && g.getNode(verticeB) != null) {
                g.addEdge(verticeA + "-" + verticeB, verticeA, verticeB, true);

            }
        }
        SpringBox layout = new SpringBox();
        layout.setForce(1);  // Cambia esto para ajustar la "fuerza" entre nodos
        layout.setQuality(0.9);  // Ajusta para cambiar la calidad del layout
        layout.setStabilizationLimit(0.9);  // Cambia para ajustar el límite de estabilización

        layout.compute();

        Viewer viewer = g.display(); // Mostrar el grafo 

    }

    private Lista<Vertice> DFS(Vertice v, Lista<Vertice> visitados) {
        visitados.insertar_final(v);
        for (int i = 0; i < ListaDeAdyacencia.getTamano(); i++) {
            Relacion edge = (Relacion) ListaDeAdyacencia.get(i);
            if (edge.getVerticeA().equals(v.getNombre())) {
                Vertice adjVertex = (Vertice) buscarVertice(edge.getVerticeB());
                if (!contieneVertice(visitados, adjVertex)) {
                    DFS(adjVertex, visitados);
                }
            }
        }
        return visitados;
    }

    // Método que verifica si una lista de vértices contiene un vértice específico
    private boolean contieneVertice(Lista<Vertice> lista, Vertice v) {
        for (int i = 0; i < lista.getTamano(); i++) {
            if (lista.get(i).equals(v)) {
                return true;
            }
        }
        return false;
    }

    // Método que busca y devuelve un vértice por nombre
    private Vertice buscarVertice(String nombre) {
        for (int i = 0; i < ListaDeVertices.getTamano(); i++) {
            Vertice v = (Vertice) ListaDeVertices.get(i);
            if (v.getNombre().equals(nombre)) {
                return v;
            }
        }
        return null;
    }

    // Método para invertir el grafo
    private Grafo getGrafoInvertido() {
        Grafo gInv = new Grafo();
        for (int i = 0; i < ListaDeVertices.getTamano(); i++) {
            gInv.agregarVertice(((Vertice) ListaDeVertices.get(i)).getNombre());
        }
        for (int i = 0; i < ListaDeAdyacencia.getTamano(); i++) {
            Relacion edge = (Relacion) ListaDeAdyacencia.get(i);
            gInv.agregaRelacion(edge.getVerticeB(), edge.getVerticeA());
        }
        return gInv;
    }

    // Función principal que encuentra componentes fuertemente conectados usando el algoritmo de Kosaraju
    public void componentesFuertementeConectados() {
        Pila<Vertice> stack = new Pila<>(null, null, 0);
        Lista<Vertice> visitados = new Lista<>();

        // Primera fase: DFS en el grafo original
        for (int i = 0; i < ListaDeVertices.getTamano(); i++) {
            Vertice v = (Vertice) ListaDeVertices.get(i);
            if (!contieneVertice(visitados, v)) {
                DFS(v, visitados);
                stack.push(v);
            }
        }

        Grafo grafoInvertido = getGrafoInvertido();
        visitados = new Lista<>();

        // Segunda fase: DFS en el grafo invertido
        while (stack.getSize() > 0) {
            Vertice v = stack.pop();
            if (v != null && !contieneVertice(visitados, v)) {
                System.out.println("Componente fuertemente conectado:");
                Lista<Vertice> component = grafoInvertido.DFS(v, new Lista<>());

                for (int i = 0; i < component.getTamano(); i++) {
                    Vertice vertex = component.get(i);
                    System.out.print(vertex.getNombre() + " ");
                }

                System.out.println("\n");
            }
        }
    }
}
