/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Entidades;

/**
 *
 * @author Fran
 */
public class Entidad_Servicio extends Articulos_Servicios {
    
    private String Tipo_Vehiculo;

    public String getTipo_Vehiculo() {
        return Tipo_Vehiculo;
    }

    public void setTipo_Vehiculo(String Tipo_Vehiculo) {
        this.Tipo_Vehiculo = Tipo_Vehiculo;
    }

    public Entidad_Servicio(String Tipo_Vehiculo, int id, String nombre, int precio) {
        super(id, nombre, precio);
        this.Tipo_Vehiculo = Tipo_Vehiculo;
    }

    public Entidad_Servicio() {
        super(0, "", 0);
        this.Tipo_Vehiculo = "";
    }


    
      
    
    
    
    
}
