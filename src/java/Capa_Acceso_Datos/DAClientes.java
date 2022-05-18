/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Acceso_Datos;

import Capa_Entidades.EntidadCliente;
import Capa_Entidades.EntidadPersona;
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
import static Capa_Acceso_Datos.ClaseConexion.getConnection;
import java.sql.CallableStatement;
/**
 *
 * @author Fran
 */
public class DAClientes {
    
   private Connection _cnn;


      private  String mensaje;
    
    //PROPIEDADES
    public String getMensaje(){
        return mensaje;
    }
    //CONSTRUCTORES
    public DAClientes(){
        mensaje="";
    }
    
    
    
    

    public int Insertar(EntidadCliente cliente) throws SQLException {
        int id_cliente = -1;
        String sentencia = "INSERT INTO CLIENTES(Nombre ,Apellido1,Apellido2,Telefono) VALUES(?,?,?,?) ";
        Connection _conexion = null;
        try {
            _conexion = ClaseConexion.getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido1());
            ps.setString(3, cliente.getApellido2());
            ps.setInt(4, cliente.getTelefono());
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
    
    
    
       public int Modificar(EntidadCliente cliente) throws SQLException, Exception {
         int resultado = -1;
        Connection _conexion = null;
        try
        {
            _conexion = getConnection();
            PreparedStatement ps = _conexion.prepareStatement("UPDATE Clientes SET Nombre=?,Apellido1=?,Apellido2=?,Telefono=? WHERE Id_Cliente=?");
            ps.setString(1, cliente.getNombre());        
            ps.setString(2, cliente.getApellido1()); 
            ps.setString(3, cliente.getApellido2());
            ps.setInt(4, cliente.getTelefono());  
            ps.setInt(5, cliente.getId());
                
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
    
    
    public int Eliminar(EntidadCliente cliente) throws SQLException, Exception {
        ResultSet rs = null;
        Connection _conexion = null;
        int resultado = 0;
        try {
            _conexion = ClaseConexion.getConnection();
            String sentencia = "DELETE FROM Clientes WHERE Id_Cliente=?"; 
            PreparedStatement st = _conexion.prepareStatement(sentencia);
            st.setInt(1, cliente.getId()); 
            resultado = st.executeUpdate();
            if (resultado > 0) {
               mensaje = "Cliente eliminado!"; 
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return resultado;

    }
    
    
    

    public List<EntidadCliente> ListarClientes(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadCliente> lista = new ArrayList();
        try {
            Statement stm = _cnn.createStatement();
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
            _cnn = null;
        }     
        return lista;
    }
    
    
    
   
    public EntidadCliente ObtenerUnCliente(String condicion) throws SQLException, Exception{
        ResultSet rs = null;
        EntidadCliente cliente = new EntidadCliente();
        Connection _conexion = null;
        
 
        try {
              _conexion = ClaseConexion.getConnection();
              Statement st = _conexion.createStatement();
            String sentencia = "Select Id_Cliente , Nombre , Apellido1 , Apellido2 , Telefono  from Clientes";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = st.executeQuery(sentencia);
            if (rs.next()) {
                cliente.setId(rs.getInt(1));
                cliente.setNombre(rs.getString(2));
                cliente.setApellido1(rs.getString(3));
                cliente.setApellido2(rs.getString(4));
                cliente.setTelefono(rs.getInt(5));
                cliente.setExiste(true);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
             if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return cliente;
        
    } 
        
     
    
    //Listar registros 
    public List<EntidadCliente> ListarRegistros(String condicion) throws Exception{
        ResultSet rs = null;
        EntidadCliente cliente;
        List<EntidadCliente> lista = new ArrayList<>();
        Connection _conexion = null;
        try {
            //abrir la conexion 
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();
            String sentencia;
            sentencia = " Select Id_Cliente,Nombre,Apellido1,Apellido2,Telefono from Clientes";
            if(!condicion.equals("")){
                sentencia = String.format("%s WHERE %s", sentencia,condicion);
            }
            rs = st.executeQuery(sentencia);
            //recorrer el rs para cargar la lista de clientes
            while (rs.next()){
                cliente = new EntidadCliente(rs.getInt(1),
                                      rs.getString(2),
                                      rs.getString(3),
                                      rs.getString(4),
                                      rs.getInt(5)
                                        );
                lista.add(cliente);
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
        
        
        
        
        public boolean CuentaExiste(String condicion,String usuario,String contrasenia) throws SQLException, Exception{
        ResultSet rs = null;
        String Usuario="";
        String Contraseña="";
        
        Connection _conexion = null;
        boolean CuentaExiste = false;
 
        try {
              _conexion = ClaseConexion.getConnection();
              Statement st = _conexion.createStatement();
            String sentencia = "Select Usuario,Contrasenia From CuentasClientes Where Usuario="+usuario;
            condicion="Contrasenia="+contrasenia;
            if (!condicion.equals("")) {
                sentencia = String.format("%s AND %s", sentencia, condicion);
            }
            rs = st.executeQuery(sentencia);
            if (rs.next()) {
              Usuario= rs.getString(1);
              Contraseña= rs.getString(2);
            }
            
            if(Usuario.equals("")&&Contraseña.equals("")){
            CuentaExiste=false;
            
            
            
            
            }
            
            else{
            CuentaExiste=true;
        
           }
            
            
            
            
            

        } catch (Exception ex) {
            throw ex;
        } finally {
             if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return CuentaExiste;
        
    } 
        
        
        public int ObtenerIdCuenta(String condicion,String usuario,String contrasenia) throws SQLException, Exception{
        ResultSet rs = null;
        int id=0;
        Connection _conexion = null;
        boolean CuentaExiste = false;
 
        try {
              _conexion = ClaseConexion.getConnection();
              Statement st = _conexion.createStatement();
            String sentencia = "Select Id_Cliente From CuentasClientes Where Usuario="+usuario;
            condicion="Contrasenia="+contrasenia;
            if (!condicion.equals("")) {
                sentencia = String.format("%s AND %s", sentencia, condicion);
            }
            rs = st.executeQuery(sentencia);
            if (rs.next()) {
              id=rs.getInt("Id_Cliente");
            }
            
            
            else{
            CuentaExiste=true;
        
           }
            
            
            
            
            

        } catch (Exception ex) {
            throw ex;
        } finally {
             if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return id;
        
    } 
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


