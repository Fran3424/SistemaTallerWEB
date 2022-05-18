/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Entidades;

import java.util.Date;

/**
 *
 * @author Fran
 */
public class EntidadFactura {
    private int id;
    private int id_pago;
    private int id_cliente;
    private String Descripcion;
    private Date Fecha;
    private String Estado;
    private boolean existe=false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public EntidadFactura(int id, int id_pago, int id_cliente, String Descripcion, Date Fecha, String Estado) {
        this.id = id;
        this.id_pago = id_pago;
        this.id_cliente = id_cliente;
        this.Descripcion = Descripcion;
        this.Fecha = Fecha;
        this.Estado = Estado;
    }

    public EntidadFactura() {
        this.id = 0;
        this.id_pago = 0;
        this.id_cliente = 0;
        this.Descripcion = "";
        this.Estado = "";
        
        
        
    }
    
    
    
    
    
    
    
}
