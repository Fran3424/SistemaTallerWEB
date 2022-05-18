/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Entidades;

/**
 *
 * @author Fran
 */
public class EntidadPagos {
    private int id;
    private int id_compra;
    private int id_reparacion;
    private int monto;
    private boolean existe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_reparacion() {
        return id_reparacion;
    }

    public void setId_reparacion(int id_reparacion) {
        this.id_reparacion = id_reparacion;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    
    
    
    
    
    
    
    
    public EntidadPagos() {
        this.id = 0;
        this.id_compra = 0;
        this.id_reparacion = 0;
        this.monto = 0;
        
        
    }

    public EntidadPagos(int id, int id_compra, int id_reparacion, int monto) {
        this.id = id;
        this.id_compra = id_compra;
        this.id_reparacion = id_reparacion;
        this.monto = monto;
    }
    
    
    
    
    
    
    
    
    
    
    
}
