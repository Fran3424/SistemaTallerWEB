/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import Capa_Acceso_Datos.DAClientes;
import Capa_Acceso_Datos.DA_Autos;
import Capa_Entidades.EntidadAutomovil;
import Capa_Entidades.EntidadCliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fran
 */
public class BLAuto {
    
       private String mensaje;
    
    
     public String getMensaje() {
        return mensaje;
    }
     
    
    
    
       public int Insertar(EntidadAutomovil auto) throws Exception{
        int resultado = -1;
        DA_Autos daAuto;
        try {
           daAuto = new DA_Autos();
           resultado = daAuto.Insertar(auto);
           mensaje = daAuto.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
        public List<EntidadAutomovil> ListarAutos(String condicion) throws Exception{
        List<EntidadAutomovil> auto = new ArrayList();
        DA_Autos daAuto;
        try {
            daAuto= new DA_Autos();
            auto = daAuto.ListarAutos(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return auto;
    }
    
    
    
    
        public int Modificar(EntidadAutomovil auto) throws Exception{
        int resultado = -1;
        DA_Autos daAuto;
        try {
           daAuto = new DA_Autos();
           resultado = daAuto.Modificar(auto);
           mensaje = daAuto.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    
    
   public EntidadAutomovil ObtenerUnAuto(String condicion) throws Exception{
        EntidadAutomovil resultado;
        DA_Autos daAuto;
        try {
            daAuto = new DA_Autos();
            resultado = daAuto.ObtenerUnAuto(condicion);
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
