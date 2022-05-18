/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Entidades;

/**
 *
 * @author Fran
 */
public class EntidadProducto extends Articulos_Servicios {

     private int cantidad;
     private String descripcion;

    
    
    
    public EntidadProducto(int id,int cantidad, String nombre, int precio,String descripcion) {
        super(id, nombre, precio);
        this.cantidad = cantidad;
        this.descripcion=descripcion;
        
    }

    public EntidadProducto() {
        super(0, "", 0);
        this.cantidad=0;
    }

    
     
    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
   
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
    
    
    
}

