/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Acceso_Datos;

import static Capa_Acceso_Datos.ClaseConexion.getConnection;
import Capa_Entidades.EntidadCliente;
import Capa_Entidades.EntidadEmpleado;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Fran
 */
public class DAEmpleados {
        private  String mensaje;
    
    //PROPIEDADES
    public String getMensaje(){
        return mensaje;
    }
    //CONSTRUCTORES
    public DAEmpleados(){
        mensaje="";
    }
    
    
    
    

    public int Insertar(EntidadEmpleado empleado) throws SQLException {
        int id_cliente = -1;
        String sentencia = "INSERT INTO EMPLEADOS(Nombre ,Apellido1,Apellido2,Telefono) VALUES(?,?,?,?) ";
        Connection _conexion = null;
        try {
            _conexion = ClaseConexion.getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido1());
            ps.setString(3, empleado.getApellido2());
            ps.setInt(4, empleado.getTelefono());
            ps.execute();
        } catch (Exception ex) {
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent,ex);
        } finally {
            if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return id_cliente;
    }
    
    
    
       public int Modificar(EntidadEmpleado empleado) throws SQLException, Exception {
         int resultado = -1;
        Connection _conexion = null;
        try
        {
            _conexion = getConnection();
            PreparedStatement ps = _conexion.prepareStatement("UPDATE Empleados SET Nombre=?,Apellido1=?,Apellido2=?,Telefono=? WHERE Id_Empleado=?");
            ps.setString(1, empleado.getNombre());        
            ps.setString(2, empleado.getApellido1()); 
            ps.setString(3, empleado.getApellido2());
            ps.setInt(4, empleado.getTelefono());  
            ps.setInt(5, empleado.getId());
                
            resultado = ps.executeUpdate();           


        } catch (Exception ex)
        {
            throw ex;
        }finally{
            if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
    
    
    
    return resultado;

    }
    
    
    public int Eliminar(EntidadEmpleado empleado) throws SQLException, Exception {
        ResultSet rs = null;
        Connection _conexion = null;
        int resultado = 0;
        try {
            _conexion = ClaseConexion.getConnection();
            String sentencia = "DELETE FROM EMPLEADOS WHERE Id_Empleado=?"; 
            PreparedStatement st = _conexion.prepareStatement(sentencia);
            st.setInt(1, empleado.getId()); 
            resultado = st.executeUpdate();
            if (resultado > 0) {
               mensaje = "Cliente eliminado!"; 
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
             if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return resultado;

    }
    
    
    

    public List<EntidadCliente> ListarClientes(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadCliente> lista = new ArrayList();
        Connection _conexion = null;
        try {
            Statement stm = _conexion.createStatement();
            String sentencia = "SELECT Id_Cliente,Nombre,Apellido1,Apellido2,Telefono  FROM Clientes";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadCliente(rs.getInt("Id_Cliente"),
                                             rs.getString("Nombre"),
                                             rs.getString("Apellido1"),
                                             rs.getString("Apellido2"),
                                             rs.getInt("Telefono")
                                            
                ));
            }
        } catch (Exception ex) {
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent,"Shir");
        } finally {
            if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }     
        return lista;
    }
    
    
    
   
    public EntidadEmpleado ObtenerUnEmpleado(String condicion) throws SQLException, Exception{
        ResultSet rs = null;
        EntidadEmpleado empleado = new EntidadEmpleado();
        Connection _conexion = null;
        
 
        try {
              _conexion = ClaseConexion.getConnection();
              Statement st = _conexion.createStatement();
            String sentencia = "Select Id_Empleado , Nombre , Apellido1 , Apellido2 , Telefono  from Empleados";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = st.executeQuery(sentencia);
            if (rs.next()) {
                empleado.setId(rs.getInt(1));
                empleado.setNombre(rs.getString(2));
                empleado.setApellido1(rs.getString(3));
                empleado.setApellido2(rs.getString(4));
                empleado.setTelefono(rs.getInt(5));
                empleado.setExiste(true);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
             if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return empleado;
        
    } 
        
     
    
    //Listar registros 
    public List<EntidadEmpleado> ListarRegistros(String condicion) throws Exception{
        ResultSet rs = null;
        EntidadEmpleado empleado;
        List<EntidadEmpleado> lista = new ArrayList<>();
        Connection _conexion = null;
        try {
            //abrir la conexion 
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();
            String sentencia;
            sentencia = " Select Id_Empleado,Nombre,Apellido1,Apellido2,Telefono from Empleados";
            if(!condicion.equals("")){
                sentencia = String.format("%s WHERE %s", sentencia,condicion);
            }
            rs = st.executeQuery(sentencia);
            //recorrer el rs para cargar la lista de clientes
            while (rs.next()){
                empleado = new EntidadEmpleado(rs.getInt(1),
                                      rs.getString(2),
                                      rs.getString(3),
                                      rs.getString(4),
                                      rs.getInt(5)
                                        );
                lista.add(empleado);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return lista;
        
    
    }//Fin listar Clientes
}
