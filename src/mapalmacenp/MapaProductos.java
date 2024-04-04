/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapalmacenp;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Antonio Atienza Cano
 */
public class MapaProductos {
    // Se definen los atributos de la clase 
    // int para mapear el codigo del producto
    // objetos tipo producto
    private Map<Integer, Producto> conjunto;

    // Constructor por defecto
    public MapaProductos() {
        conjunto = new HashMap<Integer, Producto>();
    }

    // Constructor de copia
    public MapaProductos(MapaProductos mp) {
        this.conjunto = new HashMap<Integer, Producto>(mp.conjunto);
    }

      // Método para añadir un producto al mapa
    public boolean añadirProducto(int codigo, Producto producto) {
        if (producto != null && !conjunto.containsKey(codigo)) {
            conjunto.put(codigo, producto);
            return true; // Producto añadido exitosamente
        }
        return false; // No se pudo añadir el producto (código duplicado o producto nulo)
    }

    public Map<Integer, Producto> getConjunto() {
        return conjunto;
    }

    public void setConjunto(Map<Integer, Producto> conjunto) {
        this.conjunto.putAll(conjunto); 
    }

    // Método para buscar un producto por su código
    public Producto buscarProducto(int codigo) {
        return conjunto.get(codigo);
    }

 // Método para eliminar un producto por su código
    public boolean eliminarProducto(int codigo) {
        if (conjunto.containsKey(codigo)) {
            conjunto.remove(codigo);
            return true; // Producto eliminado exitosamente
        }
        return false; // No se pudo eliminar el producto (código no encontrado)
    }

    // Método para listar todos los productos en el mapa
    public void listarProductos() {
        for (Map.Entry<Integer, Producto> entry : conjunto.entrySet()) {
            System.out.println("Código: " + entry.getKey());
            entry.getValue().mostrarProducto(); // Llama al método mostrarProducto de Producto
            System.out.println("---------------------------");
        }
    }

    // Método para borrar todos los productos del mapa
    public boolean borrarMapa() {
        if (!conjunto.isEmpty()) {
            conjunto.clear();
            return true; // Mapa borrado exitosamente
        }
        return false; // No se pudo borrar el mapa (mapa ya está vacío)
    }

    // Método para mostrar el tamaño del mapa
    public int tamañoMapa() {
        return conjunto.size();
    }
}
