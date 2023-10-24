/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;

import EDD.Lista;
import EDD.Nodo;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author nicolepinto
 */
public class Grafo {

    Lista[] users;
    int max_users;

    public Lista[] getUsers() {
        return users;
    }

    public void setUsers(Lista[] users) {
        this.users = users;
    }

    public int getMax_users() {
        return max_users;
    }

    public void setMax_users(int max_users) {
        this.max_users = max_users;
    }

    public Grafo(Lista[] users, int max_users) {
        this.users = users;
        this.max_users = max_users;
    }

    public Grafo(int max) {
        users = new Lista[max];
        max_users = max;
    }

    public void insertar_users(Nodo m) {       //Insertamos el nodo al grafo con una lista 

        boolean encontrar = false;        //Luego buscamos un espacio que este vacio

        for (int i = 0; i < max_users; i++) {
            if (users[i] == null) {
                users[i] = new Lista();
                users[i].pFirst = m;
                encontrar = true;
                break;
            }
        }
        if (!encontrar) {                  //Si no encontramos una posicion vacia (el grafo esta lleno), por eso llamamos a una funcion que va a crear otro grafo con un espacio mas, que en este caso seria (grafo_mayor(Nodo m))
            this.grafo_mayor(m);
        }
    }

    public void grafo_mayor(Nodo m) {

        Lista[] nuevo = new Lista[max_users + 1];                  //creamos una nueva lista con el maximo de usuarios de la pasada y el +1 es para agregarle un nuevo espacio a la lista
        for (int i = 0; i < max_users; i++) {
            nuevo[i] = new Lista();
            //esta copiando los nodos de la otra funcion y los 
            nuevo[i].insertar_inicio(this.users[i].pFirst);  //esta insertando en la nueva lista
        }
        nuevo[max_users] = new Lista();
        nuevo[max_users].insertar_inicio(m);                  //como [i] llega a la posicion antes del nuevo nodo, entonces aca lo que hacemose es insertar el nuevo nodo
        this.users = nuevo;                                //Aca la lista del grafo ahora va a ser la nueva que hicimos
        this.max_users++;                                  // Sumamos porque se le esta agregando un espacio mas a la lista
    }

    public void eliminar_users(String dato) {                   //Se le pasa un string porque quieres eliminar el nombre del usuario no del Nodo
        for (int i = 0; i < max_users; i++) {                   // Recorremos la lista
            if (this.users[i].pFirst != null && this.users[i].pFirst.getUser().equals(dato)) {
                this.users[i].pFirst = null;
            } else {
                Nodo aux = new Nodo(dato);
                this.users[i].eliminar(aux);
            }
        }
    }

    public void insertar_relacion(String user, String seguidor) {

        for (int i = 0; i < max_users; i++) {
            if (this.users[i].pFirst.getUser().equals(user)) {
                Nodo aux = new Nodo(seguidor);            //Como la funcion pide un Nodo, lo creas
                this.users[i].insertar_final(aux);
                break;                                         //Como solo hay un usuario con ese nombre cuando lo elimine como es el unico que no hay, no hace fakta seguir recorriendo
            }
        }
    }

    public void imprimir() {

        for (int i = 0; i < max_users; i++) {
            if (this.users[i].getpFirst() != null) {
                Nodo aux = this.users[i].getpFirst();
                if (aux.getpNext() == null) {
                    System.out.println("El usuario " + aux.getUser() + " no sigue a nadie.");
                } else {
                    String val = "El usuario " + aux.getUser() + " sigue a ";
                    aux = aux.getpNext();

                    while (aux != null) {
                        val += aux.getUser() + " ";
                        aux = aux.getpNext();
                    }
                    System.out.println(val);
                }
            }
        }

    }

    public void dfs(int index, boolean[] visited, int[] order, int[] indexOrder) {

        visited[index] = true;
        Nodo node = users[index].getpFirst().getpNext(); // Obtiene el primer nodo de la lista de adyacencia
        while (node != null) {
            int idx = getUserIndex(node.getUser()); // Función adicional para obtener el índice del usuario/nodo
            if (idx != -1 && !visited[idx]) {
                dfs(idx, visited, order, indexOrder);
            }
            node = node.getpNext();
        }

        order[indexOrder[0]] = index;
        indexOrder[0] += 1; // incrementa el contador
    }

    public int getUserIndex(String user) {  // Función adicional para obtener el índice de un usuario en el grafo
        for (int i = 0; i < max_users; i++) {
            if (users[i].getpFirst().getUser().equals(user)) {
                return i;
            }
        }
        return -1;
    }

    public void encontrarSCCs() {
        int[] order = new int[max_users];
        int[] indexOrder = {0}; // Se usa un array para modificar el valor dentro del método dfs
        boolean[] visited = new boolean[max_users];
        // Paso 1: Realizar DFS y almacenar los nodos en el arreglo 'order'
        for (int i = 0; i < max_users; i++) {
            if (users[i] != null && !visited[i]) {
                dfs(i, visited, order, indexOrder);
            }
        }

    }

    public void graficar_grafo() {                         //Copiar nuestro grafo y convertirlo en el grafo de la libreria
        Graph grafo = new SingleGraph("mi grafo");     //Creas el grafo de la libreria
        grafo.setAttribute("ui.stylesheet","node {shape:circle; fill-color:#ADD8E6; text-color: #000000; size: 30px;} edge{size: 2px; shape: line; fill-color: #D3D3D3;}");
        for (int i = 0; i < max_users; i++) {                 //Recorremos los usuarios del grafo y los agregamos al nuevo grafo(el de la libreria)
            String user = this.users[i].pFirst.getUser();    //Por cada usuario agarramos su nombre y creamos un nodo
            Node usuario = grafo.addNode(user);
            usuario.setAttribute("ui.label", user); //Le inserta el nombre del usuario al nodo
        }
        for (int i = 0; i < max_users; i++) {                 //Recorre las relaciones
            String user = this.users[i].pFirst.getUser();   //
            Nodo aux = this.users[i].pFirst.getpNext();
            while (aux != null) {
                grafo.addEdge(user + "-" + aux.getUser(), this.users[i].pFirst.getUser(), aux.getUser());
                aux = aux.getpNext();
            }
        }
        System.setProperty("org.graphstream.ui", "org.graphstream.ui.swing");
        Viewer viewer = grafo.display();         //Llamamos a la funcion display, crea la ventana y lo grafica
    }
    
}
