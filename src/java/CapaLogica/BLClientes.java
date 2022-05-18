/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import Capa_Acceso_Datos.DAClientes;
import Capa_Entidades.EntidadCliente;
import Capa_Entidades.EntidadPersona;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fran
 */
public class BLClientes {
       private String mensaje;
    
    //Se hace un un meotdo para devolver un mensaje que venga desde acceso a datos
     public String getMensaje() {
        return mensaje;
    }
     
  
     //Se llaman a los procedimientos de CRUD desde la logica
     
    public int Modificar(EntidadCliente cliente) throws Exception{
        int resultado = -1;
        DAClientes daCliente;
        try {
           daCliente = new DAClientes();
           resultado = daCliente.Modificar(cliente);
           mensaje = daCliente.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    

    public int Eliminar(EntidadCliente cliente) throws Exception{
        int resultado = -1;
        DAClientes daCliente;
        try {
           daCliente = new DAClientes();
           resultado = daCliente.Eliminar(cliente);
           mensaje = daCliente.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    

    public int Insertar(EntidadCliente cliente) throws Exception{
        int resultado = -1;
        DAClientes daCliente;
        try {
           daCliente = new DAClientes();
           resultado = daCliente.Insertar(cliente);
           mensaje = daCliente.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    public List<EntidadCliente> ListarClientes(String condicion) throws Exception{
        List<EntidadCliente> clientes = new ArrayList();
        DAClientes daCliente;
        try {
            daCliente = new DAClientes();
            clientes = daCliente.ListarClientes(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return clientes;
    }
    
    public EntidadCliente ObtenerUnCliente(String condicion) throws Exception{
        EntidadCliente resultado;
        DAClientes daCliente;
        try {
            daCliente = new DAClientes();
            resultado = daCliente.ObtenerUnCliente(condicion);
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
     
     
     
       public List<EntidadCliente> ListarRegistros(String condicion) throws Exception{
        List<EntidadCliente> resultado=new ArrayList();
        DAClientes adcliente;
        try {
            adcliente=new DAClientes();
            resultado=adcliente.ListarRegistros(condicion);
            
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }
     
       
       
       
      public boolean CuentaExiste(String condicion,String usuario,String contraseña) throws Exception{
        boolean resultado;
        DAClientes daCliente;
        try {
            daCliente = new DAClientes();
            resultado = daCliente.CuentaExiste(condicion,usuario,contraseña);
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
     
    
      
      
      public int ObtenerIdCuenta(String condicion,String usuario,String contraseña) throws Exception{
        int resultado;
        DAClientes daCliente;
        try {
            daCliente = new DAClientes();
            resultado = daCliente.ObtenerIdCuenta(condicion,usuario,contraseña);
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
      
      
       
       
       
     
}
