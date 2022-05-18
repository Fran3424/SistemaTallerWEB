/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import Capa_Acceso_Datos.DAClientes;
import Capa_Acceso_Datos.DACompras;
import Capa_Acceso_Datos.DAReparaciones;
import Capa_Entidades.EntidadCliente;
import Capa_Entidades.EntidadCompraProducto;
import Capa_Entidades.EntidadReparaciones;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Fran
 */
public class BLCompras {
              private String mensaje;
              
                  
     public String getMensaje() {
        return mensaje;
    }
     
       //Llamar al método insertar de la lógica
    public void Insertar(EntidadCompraProducto orden,int idCliente) throws Exception{
        int resultado = -1;
        DACompras daCompra;
        try {
           daCompra = new DACompras();
            daCompra.Insertar(orden,idCliente);
           mensaje = daCompra.getMensaje();
        } catch (Exception ex) {
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent,ex);
        }
     
    }
    
    
    
     public int EliminarCompra(EntidadCompraProducto orden) throws Exception{
        int resultado = -1;
        DACompras daCompra;
        try {
           daCompra = new DACompras();
           resultado = daCompra.EliminarCompra(orden);
           mensaje = daCompra.getMensaje();
        } catch (Exception ex) {
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent,ex);
        }
        return resultado;
    }
    
    
    
    
    
    
    
    
    
      public List<EntidadCompraProducto> ListarCompras(String condicion) throws Exception{
        List<EntidadCompraProducto> clientes = new ArrayList();
        DACompras daCompra;
        try {
            daCompra = new DACompras();
            clientes = daCompra.ListarCompras(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return clientes;
    }
    /*
    public EntidadCompraProducto ObtenerUnaCompra(String condicion) throws Exception{
        EntidadCompraProducto resultado;
        DACompras daCompra;
        try {
            daCompra = new DACompras();
            resultado = daCompra.ObtenerUnaCompra(condicion);
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
     
     */
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
