/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import Capa_Acceso_Datos.DAClientes;
import Capa_Acceso_Datos.DAFactura;
import Capa_Acceso_Datos.DAPagos;
import Capa_Entidades.EntidadCliente;
import Capa_Entidades.EntidadCompraProducto;
import Capa_Entidades.EntidadFactura;
import Capa_Entidades.EntidadPagos;
import java.awt.Component;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Fran
 */
public class BLFactura {
    
              private String mensaje;
    
    
     public String getMensaje() {
        return mensaje;
    }
     
    
    
       //Llamar al método insertar de la lógica
    public int Insertar(EntidadFactura factura) throws Exception{
        int resultado = -1;
        DAFactura daFactura;
        try {
           daFactura = new DAFactura();
           resultado = daFactura.Insertar(factura);
           mensaje = daFactura.getMensaje();
        } catch (Exception ex) {
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent,ex);
        }
        return resultado;
    }
    
    
    public ResultSet listarFacturasMES(String condicion,String orden) throws Exception{
        ResultSet rs;
        DAFactura daFactura;
        try
        {
            daFactura = new DAFactura();
            rs = daFactura.ListarFacturasMES(condicion, orden);
        } catch (Exception ex)
        {
            throw ex;
        }
        return rs;
    }
    
      public EntidadFactura ObtenerRegistro(String condicion) throws Exception{
        EntidadFactura resultado;
        DAFactura DA;
        try {
            DA=new DAFactura();
            resultado=DA.ObtenerRegistro(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    } 
    
    public int InsertarFact (EntidadFactura Factura, EntidadCompraProducto Compra) throws Exception {
    int Resultado = 0;
    try {
    
        DAFactura DA = new DAFactura (); 
        Resultado = DA.InsertarFact (Factura, Compra); 
        mensaje = DA.getMensaje();
    
    } catch (Exception ex) {
            Resultado = -1; 
            throw ex;
    }       
return Resultado;      
   }

    public int ModificarCliente (EntidadFactura Factura) throws Exception {
int idfactura = 0;
try {
    
    DAFactura DA = new DAFactura();
    
    idfactura = DA. Modificarcliente(Factura);
    
} catch (Exception ex) {
    throw ex;
}

    
 return idfactura;     
    
}
 
    
  public int ObtenerUltimaFactura(String condicion) throws Exception{
        int resultado;
        DAFactura DA;
        try {
            DA=new DAFactura();
            resultado=DA.ObtenerUltimaFactura(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }    
    
      public int Modificar(EntidadFactura cliente) throws Exception{
        int resultado = -1;
        DAFactura DA;
        try {
           DA = new DAFactura();
           resultado = DA.Modificar(cliente);
           mensaje = DA.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    

    public List<EntidadFactura> ListarFacturas(String condicion) throws Exception{
        List<EntidadFactura> Facturas = new ArrayList();
        DAFactura daFact;
        try {
            daFact = new DAFactura();
            Facturas = daFact.ListarFacturas(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return Facturas;
    }
    
    
    
    
}