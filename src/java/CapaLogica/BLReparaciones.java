/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import Capa_Acceso_Datos.DAClientes;
import Capa_Acceso_Datos.DAReparaciones;
import Capa_Entidades.EntidadCliente;
import Capa_Entidades.EntidadReparaciones;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Fran
 */
public class BLReparaciones {
    
         private String mensaje;
    
    
     public String getMensaje() {
        return mensaje;
    }
     
   
       //Llamar al método insertar de la lógica
    public int Insertar(EntidadReparaciones reparacion) throws Exception{
        int resultado = -1;
        DAReparaciones dareparacion;
        try {
           dareparacion = new DAReparaciones();
           resultado = dareparacion.Insertar(reparacion);
           mensaje = dareparacion.getMensaje();
        } catch (Exception ex) {
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent,ex);
        }
        return resultado;
    }
    
    
    
        public List<EntidadReparaciones> ListarReparaciones(String condicion) throws Exception{
        List<EntidadReparaciones> clientes = new ArrayList();
        DAReparaciones daReparacion;
        try {
            daReparacion = new DAReparaciones();
            clientes = daReparacion.ListarReparaciones(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return clientes;
    }
    
    
        
       public EntidadReparaciones ObtenerUnaReparacion(String condicion) throws Exception{
        EntidadReparaciones resultado;
        DAReparaciones daReparacion;
        try {
            daReparacion = new DAReparaciones();
            resultado = daReparacion.ObtenerUnaReparacion(condicion);
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
     
    
    
    
}
