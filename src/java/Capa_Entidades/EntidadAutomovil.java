/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Entidades;

/**
 *
 * @author Fran
 */
public class EntidadAutomovil {
    private int id;
    private int id_cliente;
    private String Tipo_vehiculo;
    private String Marca;
    private String Modelo;
    private int Placa;
    private boolean existe=false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTipo_vehiculo() {
        return Tipo_vehiculo;
    }

    public void setTipo_vehiculo(String Tipo_vehiculo) {
        this.Tipo_vehiculo = Tipo_vehiculo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public int getPlaca() {
        return Placa;
    }

    public void setPlaca(int Placa) {
        this.Placa = Placa;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    
    

    public EntidadAutomovil(int id, int id_cliente, String Tipo_vehiculo, String Marca, String Modelo, int Placa) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.Tipo_vehiculo = Tipo_vehiculo;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Placa = Placa;
    }

    public EntidadAutomovil() {
         this.id = 0;
        this.id_cliente = 0;
        this.Tipo_vehiculo = "";
        this.Marca = "";
        this.Modelo = "";
        this.Placa = 0;
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
