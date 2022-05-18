/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import Capa_Acceso_Datos.DAClientes;
import Capa_Acceso_Datos.DACompras;
import Capa_Acceso_Datos.DAPagos;
import Capa_Entidades.EntidadCliente;
import Capa_Entidades.EntidadCompraProducto;
import Capa_Entidades.EntidadPagos;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Fran
 */
public class BLPagos {
    
          private String mensaje;
    
    
     public String getMensaje() {
        return mensaje;
    }
     
    
    
       //Llamar al método insertar de la lógica
    public int RealizarPago(EntidadPagos pago) throws Exception{
        int resultado = -1;
        DAPagos daPago;
        try {
           daPago = new DAPagos();
           resultado = daPago.RealizarPago(pago);
           mensaje = daPago.getMensaje();
        } catch (Exception ex) {
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent,ex);
        }
        return resultado;
    }
    
    
     public int AbonarPago(EntidadPagos pago, int montopagado) throws Exception{
        int resultado = -1;
        DAPagos daPago;
        try {
           daPago = new DAPagos();
           resultado = daPago.AbonarPago(pago,montopagado);
           mensaje = daPago.getMensaje();
        } catch (Exception ex) {
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent,ex);
        }
        return resultado;
    }
    
    
    

    
    public EntidadPagos ObtenerUnPago(String condicion) throws Exception{
        EntidadPagos resultado;
        DAPagos daPago;
        try {
            daPago = new DAPagos();
            resultado = daPago.ObtenerUnPago(condicion);
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
     
     
     
    
        public List<EntidadPagos> ListarPagos(String condicion) throws Exception{
        List<EntidadPagos> pagos = new ArrayList();
        DAPagos daPago;
        try {
            daPago = new DAPagos();
            pagos = daPago.ListarPagos(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return pagos;
    }
    
    
    
    
    
    
    
    
}
