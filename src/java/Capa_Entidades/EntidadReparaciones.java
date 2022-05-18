/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Entidades;

import java.util.Date;
import java.time.LocalDateTime;
import java.util.Calendar;

/**
 *
 * @author Fran
 */
public class EntidadReparaciones {
    private int id;
    private int id_servicio;
    private int id_empleado;
    private int id_auto;
    private Date FechaFin;
    private Date FechaInicio;
    private int Monto;
    private boolean existe=false;
    Calendar today = Calendar.getInstance();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_auto() {
        return id_auto;
    }

    public void setId_auto(int id_auto) {
        this.id_auto = id_auto;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Date getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(Date FechaFin) {
        this.FechaFin = FechaFin;
    }

    public int getMonto() {
        return Monto;
    }

    public void setMonto(int Monto) {
        this.Monto = Monto;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

    public EntidadReparaciones(int id, int id_servicio, int id_empleado, int id_auto, Date FechaInicio, Date FechaFin, int Monto) {
        this.id = id;
        this.id_servicio = id_servicio;
        this.id_empleado = id_empleado;
        this.id_auto = id_auto;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.Monto = Monto;
    }

   

    public EntidadReparaciones() {
         this.id = 0;
        this.id_servicio = 0;
        this.id_empleado = 0;
        this.id_auto = 0;
        this.Monto = 0;
        
        
            
        
    }
    
    
    
    
    
    
    
  
    
    
    
    
    
    
    
    
    
}
