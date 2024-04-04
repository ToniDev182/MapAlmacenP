/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mapalmacenp;

import java.util.Scanner;

/**
 *
 * @author Antonio Atienza Cano
 */
public class MapAlmacenP {

      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MapaProductos mapaProductos = new MapaProductos();

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Añadir producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Listar productos");
            System.out.println("5. Tamaño del mapa");
            System.out.println("6. Borrar mapa");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Añadir producto
                    System.out.println("Introduce el código del producto:");
                    int codigo = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea
                    Producto nuevoProducto = new Producto();
                    nuevoProducto.leerProducto(); // Leer datos del producto
                    mapaProductos.añadirProducto(codigo, nuevoProducto);
                    System.out.println("Producto añadido correctamente.");
                    break;
                case 2:
                    // Buscar producto
                    System.out.println("Introduce el código del producto:");
                    int codigoBuscar = scanner.nextInt();
                    Producto productoEncontrado = mapaProductos.buscarProducto(codigoBuscar);
                    if (productoEncontrado != null) {
                        System.out.println("Producto encontrado:");
                        productoEncontrado.mostrarProducto();
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 3:
                    // Eliminar producto
                    System.out.println("Introduce el código del producto a eliminar:");
                    int codigoEliminar = scanner.nextInt();
                    mapaProductos.eliminarProducto(codigoEliminar);
                    System.out.println("Producto eliminado correctamente.");
                    break;
                case 4:
                    // Listar productos
                    System.out.println("Listado de productos:");
                    mapaProductos.listarProductos();
                    break;
                case 5:
                    // Tamaño del mapa
                    System.out.println("La cantidad de productos es: " + mapaProductos.tamañoMapa());
                    break;
                case 6:
                    // Borrar mapa
                    mapaProductos.borrarMapa();
                    System.out.println("productos borrados correctamente.");
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 0);
        
        scanner.close();
    }
}