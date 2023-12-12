
package listaenlazada;
import javax.swing.JOptionPane;

public class Listas {
    Nodo inicio = null;
    Nodo ultimo = null;

    public Listas() {
        inicio = null;
        ultimo = null;
    }


    //Metodo para insertar nodo ordenandolo
    public void insertarNodoOrdenado(int valor) {
        Nodo nuevo = new Nodo();
        nuevo.dato = valor;

        // Caso 1: Inserción al inicio de la lista
        if (inicio == null || valor < inicio.dato) {
            nuevo.siguiente = inicio;
            inicio = nuevo;
            if (ultimo == null) {
                ultimo = nuevo;
            }
            return;
        }

        // Caso 2: Inserción al final de la lista
        if (valor > ultimo.dato) {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
            return;
        }

        // Caso 3: Inserción en cualquier otra posición de la lista
        Nodo actual = inicio;
        while (actual.siguiente != null && valor > actual.siguiente.dato) {
            actual = actual.siguiente;
        }
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
    }



    // imprimir la lista enlazada
    public String imprimirLista() {
        int i=0;
        StringBuilder listaCompleta = new StringBuilder();
        Nodo actual = inicio;
        if (actual == null) {
        JOptionPane.showMessageDialog(null, "La lista esta vacia"); // Si la lista está vacía, se retorna una cadena vacía
        }
        while (actual != null) {
            listaCompleta.append(actual.dato).append("  ");
            actual = actual.siguiente;
            i++;
        }
        listaCompleta.append(" Longuitud : ").append(i);
        return listaCompleta.toString().trim();
    }
    
    
//Este metodo midifica al mnodo ingresado despues de buscarlo
public Nodo buscarNodo(int valor) {
    Nodo nodoActual = inicio;
    while (nodoActual != null) {
        if (nodoActual.dato == valor) {
            return nodoActual; // Se encontró el nodo, se retorna
        }
        nodoActual = nodoActual.siguiente;
    }
    return null; // No se encontró el nodo
}
    
//Modifica al nodo igualmente despues de buscarlo y si lo encuenta lo modifica
public boolean modificarNodo(int valorBuscado, int nuevoValor) {
    Nodo nodoEncontrado = buscarNodo(valorBuscado);
    if (nodoEncontrado != null) {
        // El nodo se encontró, realiza la modificación
        nodoEncontrado.dato = nuevoValor;
        return true; // Modificación exitosa
    } else {
        // El nodo no se encontró
        return false; // Nodo no encontrado
    }
}

    //Metodo para eliminar Nodo
    public boolean eliminarNodo(int valorBuscado) {
        Nodo nodoActual = inicio;
        Nodo nodoAnterior = null;

        // Buscar el nodo a eliminar
        while (nodoActual != null && nodoActual.dato != valorBuscado) {
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.siguiente;
        }

        if (nodoActual != null) {
            // El nodo fue encontrado, realizar la eliminación
            if (nodoAnterior != null) {
                // El nodo a eliminar no es el primer nodo
                nodoAnterior.siguiente = nodoActual.siguiente;
            } else {
                // El nodo a eliminar es el primer nodo
                inicio = nodoActual.siguiente;
            }
            JOptionPane.showMessageDialog(null, "Eliminado: " + valorBuscado);
            return true; // Eliminación exitosa
        } else {
            // El nodo no fue encontrado
            return false; // Nodo no encontrado
        }
    }

    
    public boolean verLista() {
        return inicio == null;
    }

}
