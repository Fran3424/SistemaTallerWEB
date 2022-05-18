/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import Capa_Acceso_Datos.DAEmpleados;
import Capa_Acceso_Datos.DAProductos;
import Capa_Entidades.EntidadEmpleado;
import Capa_Entidades.EntidadProducto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fran
 */
public class BLProductos {
    
      private String mensaje;
    
    
     public String getMensaje() {
        return mensaje;
    }
     
    
    
        public List<EntidadProducto> ListarProductos(String condicion) throws Exception{
        List<EntidadProducto> empleados = new ArrayList();
        DAProductos daProducto;
        try {
            daProducto = new DAProductos();
            empleados = daProducto.ListarProductos(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return empleados;
    }
    
      public EntidadProducto ObtenerUnProducto(String condicion) throws Exception{
        EntidadProducto resultado;
        DAProductos daProducto;
        try {
            daProducto = new DAProductos();
            resultado = daProducto.ObtenerUnProducto(condicion);
            if (resultado.isExiste()) {
                mensaje = "Cliente encontrado!";
            }
            else{
                mensaje = "Cliente NO encontrado";
            }
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    
    
    
    
     public int Eliminar(EntidadProducto empleado) throws Exception{
        int resultado = -1;
        DAProductos daProducto;
        try {
           daProducto= new DAProductos();
           resultado = daProducto.Eliminar(empleado);
           mensaje = daProducto.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    //Llamar al método insertar de la lógica
    public int Insertar(EntidadProducto empleado) throws Exception{
        int resultado = -1;
        DAProductos daProducto;
        try {
           daProducto = new DAProductos();
           resultado = daProducto.Insertar(empleado);
           mensaje = daProducto.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    
    
    
    
    
        //Llamar al método modificar de la lógica
    public int Modificar(EntidadProducto empleado) throws Exception{
        int resultado = -1;
        DAProductos daProducto;
        try {
           daProducto = new DAProductos();
           resultado = daProducto.Modificar(empleado);
           mensaje = daProducto.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    
    
    
    
    
    
    
    
    
}
