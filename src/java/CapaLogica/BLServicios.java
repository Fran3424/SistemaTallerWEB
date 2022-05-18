/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import Capa_Acceso_Datos.DAClientes;
import Capa_Acceso_Datos.DAServicios;
import Capa_Entidades.EntidadCliente;
import Capa_Entidades.Entidad_Servicio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fran
 */
public class BLServicios {
    
     private String mensaje;
    
    
     public String getMensaje() {
        return mensaje;
    }
     
    
    
      public List<Entidad_Servicio> ListarServicios(String condicion) throws Exception{
        List<Entidad_Servicio> servicios = new ArrayList();
        DAServicios daServicio;
        try {
            daServicio = new DAServicios();
            servicios = daServicio.ListarServicios(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return servicios;
    }
    
      
      
      
      
      public Entidad_Servicio ObtenerUnServicio(String condicion) throws Exception{
        Entidad_Servicio servicio;
        DAServicios daServicios;
        try {
            daServicios = new DAServicios();
            servicio = daServicios.ObtenerUnServicio(condicion);
            if (servicio.isExiste()) {
                mensaje = "Cliente encontrado!";
            }
            else{
                mensaje = "Cliente NO encontrado";
            }
        } catch (Exception ex) {
            throw ex;
        }
        return servicio;
    }
     
     
    
    
    
    
    
    
    
    
    
    
}
