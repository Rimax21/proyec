package cola;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

public class Colas {

    Nodo frente;
    Nodo fin;
    /*Queue representa una cola en Java y define un conjunto 
    de métodos estándar para trabajar con estructuras de datos en forma de cola. 
    Al utilizar LinkedList como implementación de Queue, 
    se obtienen todas las funcionalidades de una cola, como encolar, desencolar, 
    acceder al frente de la cola, entre otros.*/
    public Queue<Nodo> cola = new LinkedList<>(); // Declaración e inicialización de la cola

    public Colas() {
        frente = null;
        fin = null;
    }

    public int encolar(int dato) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.dato = dato;

        if (frente == null) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }

        // Utilizando offer() de una cola
        cola.offer(nuevoNodo);
        //El ofter se hace para agregar un nuevo nodo al final de la lista
        return nuevoNodo.dato;
    }

    public String imprimirCola() {
        int i = 0;
        StringBuilder listaCompleta = new StringBuilder();
        Nodo actual = frente;
        if (actual == null) {
            JOptionPane.showMessageDialog(null, "La cola está vacía"); // Si la cola está vacía, se retorna una cadena vacía
        }
        while (actual != null) {
            listaCompleta.append(actual.dato).append("  ");
            actual = actual.siguiente;
            i++;
        }
        listaCompleta.append(" Longitud : ").append(i);
        return listaCompleta.toString().trim();
    }

    public Nodo buscarNodoCola(int valor) {
        if (cola.isEmpty()) {
            return null; // La cola está vacía, no se puede buscar ningún nodo
        }

        Queue<Nodo> colaAuxiliar = new LinkedList<>(cola);

        while (!colaAuxiliar.isEmpty()) {
            Nodo actual = colaAuxiliar.poll();
            if (actual.dato == valor) {
                return actual; // Se encontró el nodo, se retorna
            }
        }

        return null; // No se encontró el nodo
    }

//public boolean modificarNodoCola(int valorBuscado, int nuevoValor) {
//    Nodo nodoEncontrado = buscarNodoCola(valorBuscado);
//    if (nodoEncontrado != null) {
//        // El nodo se encontró, realiza la modificación
//        nodoEncontrado.dato = nuevoValor;
//        return true; // Modificación exitosa
//    } else {
//        // El nodo no se encontró
//        return false; // Nodo no encontrado
//    }
//}
public boolean modificarNodoCola(int valorBuscado, int nuevoValor) {
    Queue<Nodo> colaAuxiliar = new LinkedList<>(cola);
    Nodo nodoActual = colaAuxiliar.peek();

    // Buscar el nodo a modificar
    while (nodoActual != null && nodoActual.dato != valorBuscado) {
        colaAuxiliar.remove();
        nodoActual = colaAuxiliar.peek();
    }

    if (nodoActual != null) {
        // El nodo fue encontrado, realizar la modificación
        nodoActual.dato = nuevoValor;
        return true; // Modificación exitosa
    } else {
        // El nodo no fue encontrado
        return false; // Nodo no encontrado
    }
}


//    public boolean eliminarNodoCola(int valorBuscado) {
//        Nodo nodoActual = frente;
//        Nodo nodoAnterior = null;
//
//        // Buscar el nodo a eliminar
//        while (nodoActual != null && nodoActual.dato != valorBuscado) {
//            nodoAnterior = nodoActual;
//            nodoActual = nodoActual.siguiente;
//        }
//
//        if (nodoActual != null) {
//            // El nodo fue encontrado, realizar la eliminación
//            if (nodoAnterior != null) {
//                // El nodo a eliminar no es el primer nodo
//                nodoAnterior.siguiente = nodoActual.siguiente;
//            } else {
//                // El nodo a eliminar es el primer nodo
//                frente = nodoActual.siguiente;
//            }
//            JOptionPane.showMessageDialog(null, "Eliminado: " + valorBuscado);
//            return true; // Eliminación exitosa
//        } else {
//            // El nodo no fue encontrado
//            return false; // Nodo no encontrado
//        }
//    }
public boolean eliminarNodoCola() {
    if (frente != null) {
        Nodo nodoEliminado = frente;
        frente = frente.siguiente;
        nodoEliminado.siguiente = null;
        JOptionPane.showMessageDialog(null, "Eliminado: " + nodoEliminado.dato);
        return true; // Eliminación exitosa
    } else {
        // La cola está vacía
        return false; // Cola vacía, no se puede eliminar
    }
}


    public boolean verCola() {
        return frente == null;
    }
}
