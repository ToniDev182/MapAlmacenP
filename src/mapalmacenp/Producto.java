/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapalmacenp;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Antonio Atienza Cano
 */
public class Producto implements Comparable<Producto>{
    private String marca, modelo, tipo, codigo;
    int precio; 
    
    // constructor por defecto
    public Producto (){
        
    }
    
    // constructor de copia
     
   public Producto (Producto p ){
       this.marca = p.marca;
       this.modelo = p.modelo;
       this.tipo = p.tipo;
       this.precio = p.precio;
       this.codigo = p.codigo;
   }
   
   // constructor parametrizado
   
   public Producto (String marca, String modelo, String tipo, String codigo){
       this.marca = marca;
       this.modelo = modelo;
       this.tipo = tipo;
       if(validarPrecio(precio))
           this.precio=precio;
       else
           this.precio= 0;
       if(validarCodigo(codigo))
           this.codigo=codigo;
           else
           
           this.codigo="";
   }
    // metodos getter y setters con sus comprovaciones
   
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        if(validarCodigo(codigo))
            this.codigo = codigo;
        else 
            this.codigo="";
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecio() {
        return precio;
    }

     public void setPrecio(int precio) {
       if(validarPrecio(precio))
           this.precio = precio;
       else
           this.precio = 0; 
   }
     public static boolean validarCodigo(String codigo) {
        String patronCodigo = "\\d{4}[a-zA-Z]";
        return Pattern.matches(patronCodigo, codigo);
    }
     
   // Método para validar el precio
   private boolean validarPrecio(int precio) {
       return precio > 0;
   }
   
   // metodo para leer producto 
  
   public void leerProducto() {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Introduce la marca del producto:");
       this.marca = scanner.nextLine();
       System.out.println("Introduce el modelo del producto:");
       this.modelo = scanner.nextLine();
       System.out.println("Introduce el tipo del producto:");
       this.tipo = scanner.nextLine();
       System.out.println("Introduce el precio del producto:");
       int precio = scanner.nextInt();
       setPrecio(precio); // Validar y asignar el precio usando el método setPrecio
       System.out.println("Introduce el codigo del producto");
       String codigo = scanner.nextLine();
       setCodigo(codigo); // validar y asignar el codigo usando el metodo setCodigo 
   }

    @Override
    public String toString() {
        return "Producto{" + "marca=" + marca + ", modelo=" + modelo + ", tipo=" + tipo + ", codigo=" + codigo + ", precio=" + precio + '}';
    }
   
   // metodo para mostrar el precio
     public void mostrarProducto() {
       System.out.println("Marca: " + marca);
       System.out.println("Modelo: " + modelo);
       System.out.println("Tipo: " + tipo);
       System.out.println("Precio: " + precio);
   }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        return Objects.equals(this.codigo, other.codigo);
    }
    
       // Método compareTo para comparar productos por código
    public int compareTo(Producto otroProducto) {
        return this.codigo.compareTo(otroProducto.codigo);
    }
     
    
   
}

