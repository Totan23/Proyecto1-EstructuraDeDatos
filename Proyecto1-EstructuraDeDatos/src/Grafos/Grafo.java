/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;
import EDD.Lista;
import EDD.Nodo;
/**
 *
 * @author nicolepinto
 */
public class Grafo {
        Lista [] users;
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
    
    public Grafo(int max){
        users = new Lista[max];
        max_users = max;  
    }
    
    public void insertar_users(Nodo m){       //Insertamos el nodo al grafo con una lista 
        
            boolean encontrar = false;        //Luego buscamos un espacio que este vacio
  
            for (int i = 0; i < max_users; i++) {
                if(users[i] == null){
                    users[i] = new Lista();
                    users[i].pFirst = m;
                    encontrar = true;
                    break;
                }
            }
            if (!encontrar){                  //Si no encontramos una posicion vacia (el grafo esta lleno), por eso llamamos a una funcion que va a crear otro grafo con un espacio mas, que en este caso seria (grafo_mayor(Nodo m))
                this.grafo_mayor(m);
        }
    }
    
    public void grafo_mayor(Nodo m){
        
        Lista[] nuevo = new Lista[max_users+1];                  //creamos una nueva lista con el maximo de usuarios de la pasada y el +1 es para agregarle un nuevo espacio a la lista
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
    
    public void eliminar_users(String dato){                   //Se le pasa un string porque quieres eliminar el nombre del usuario no del Nodo
        for (int i = 0; i < max_users; i++) {                   // Recorremos la lista
            if(this.users[i].pFirst != null && this.users[i].pFirst.getUser() == dato) {    //1ero verificamos que no sean nulo, sino es nulo entonces comparamos los datos (preguntar mejor esto)
            this.users[i].pFirst = null;                                                    // Volver a preguntarle todo sobre este codigo eliminar
        }else{
                Nodo aux = new Nodo(dato);
                this.users[i].eliminar(aux);        
            }
    }
}
    
    public void insertar_relacion(String dato, String seguidor){
        
        for (int i = 0; i < max_users; i++) {
            if(this.users[i].pFirst.getUser()== dato){          //Volver a preguntarle a Andres
                
                Nodo aux = new Nodo (seguidor);            //Como la funcion pide un Nodo, lo creas
                this.users[i].insertar_final(aux);           //
                 
                break;                                         //Como solo hay un usuario con ese nombre cuando lo elimine como es el unico que no hay, no hace fakta seguir recorriendo
            } 
        }     
    }
    
    public void imprimir(){
        
        for (int i = 0; i < max_users; i++) {
            if(this.users[i].getpFirst()!= null){
            Nodo aux = this.users[i].getpFirst();
            if(aux.getpNext()== null){System.out.println("El usuario " + aux.getUser() + " no sigue a nadie.");}else{
            String val = "El usuario "+aux.getUser() + " sigue a ";
            aux = aux.getpNext();
                System.out.println(i);
            
            while(aux!=null){
                val += aux.getUser()+" ";
                aux = aux.getpNext();
            }
            System.out.println(val);
            }
        }}
        
    }
}
