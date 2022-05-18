/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import Capa_Acceso_Datos.DAClientes;
import Capa_Acceso_Datos.DAEmpleados;
import Capa_Entidades.EntidadCliente;
import Capa_Entidades.EntidadEmpleado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fran
 */
public class BLEmpleados {
           private String mensaje;
    
    
     public String getMensaje() {
        return mensaje;
    }
     
     
        //Llamar al método modificar de la lógica
    public int Modificar(EntidadEmpleado empleado) throws Exception{
        int resultado = -1;
        DAEmpleados daempleado;
        try {
           daempleado = new DAEmpleados();
           resultado = daempleado.Modificar(empleado);
           mensaje = daempleado.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    //Llamar al método eliminar de la lógica
    public int Eliminar(EntidadEmpleado empleado) throws Exception{
        int resultado = -1;
        DAEmpleados daempleado;
        try {
           daempleado= new DAEmpleados();
           resultado = daempleado.Eliminar(empleado);
           mensaje = daempleado.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    //Llamar al método insertar de la lógica
    public int Insertar(EntidadEmpleado empleado) throws Exception{
        int resultado = -1;
        DAEmpleados daempleados;
        try {
           daempleados = new DAEmpleados();
           resultado = daempleados.Insertar(empleado);
           mensaje = daempleados.getMensaje();
        } catch (Exception ex) {
            throw ex;
        }
        return resultado;
    }
    
    public List<EntidadEmpleado> ListarEmpleados(String condicion) throws Exception{
        List<EntidadEmpleado> empleados = new ArrayList();
        DAEmpleados daempleado;
        try {
            daempleado = new DAEmpleados();
            empleados = daempleado.ListarRegistros(condicion);
        } catch (Exception ex) {
            throw ex;
        }
        return empleados;
    }
    
    public EntidadEmpleado ObtenerUnEmpleado(String condicion) throws Exception{
        EntidadEmpleado resultado;
        DAEmpleados daempleado;
        try {
            daempleado = new DAEmpleados();
            resultado = daempleado.ObtenerUnEmpleado(condicion);
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
