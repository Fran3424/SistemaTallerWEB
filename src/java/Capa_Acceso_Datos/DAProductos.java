/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Acceso_Datos;

import static Capa_Acceso_Datos.ClaseConexion.getConnection;
import Capa_Entidades.EntidadProducto;
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
public class DAProductos {
    
         private Connection _cnn;

    private String mensaje;
    public String getMensaje() {
        return mensaje;
    }

      
    
    
    
    
    
    
     public List<EntidadProducto> ListarProductos(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadProducto> lista = new ArrayList();
          Connection _conexion = null;
        try {
               _conexion = getConnection();
            Statement stm = _conexion.createStatement();
            String sentencia = "Select Id_Producto,Cantidad,Nombre,Precio,Descripcion from Productos";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadProducto
                                            (rs.getInt("Id_Producto"),
                                             rs.getInt("Cantidad"),
                                             rs.getString("Nombre"),
                                             rs.getInt("Precio"),
                                             rs.getString("Descripcion")
                ));
            }
        } catch (Exception ex) {
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent,ex);
        } finally {
             if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }     
        return lista;
    }
    

    
      public EntidadProducto ObtenerUnProducto(String condicion) throws SQLException, Exception{
        ResultSet rs = null;
        EntidadProducto producto = new EntidadProducto();
        Connection _conexion = null;
        try {
            _conexion = getConnection();
            Statement stm = _conexion.createStatement();
            String sentencia = "Select Id_Producto,Cantidad,Nombre,Precio,Descripcion from Productos";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                producto.setId(rs.getInt(1));
                producto.setCantidad(rs.getInt(2));
                producto.setNombre(rs.getString(3));
                producto.setPrecio(rs.getInt(4));
                producto.setDescripcion(rs.getString(5));
                producto.setExiste(true);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return producto;
    }
    
    
    
    
       public int Insertar(EntidadProducto producto) throws SQLException, Exception {
        int id_empleado = -1;
        String sentencia = "INSERT INTO Productos(Nombre,Precio,Cantidad,Descripcion) VALUES(?,?,?,?) ";
        Connection _conexion = null;
        try {
            _conexion = getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getPrecio());
            ps.setInt(3, producto.getCantidad());
            ps.setString(4, producto.getDescripcion());
            ps.execute();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return id_empleado;
    }
    
    
    
       public int Modificar(EntidadProducto producto) throws SQLException, Exception {
        int resultado = 0;
        String sentencia = "UPDATE Productos SET Nombre=?,Precio=?,Cantidad=?,Descripcion=? WHERE Id_Producto=?";
        Connection _conexion = null;
        try {
            _conexion = getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getPrecio());
            ps.setInt(3, producto.getCantidad());
            ps.setString(4, producto.getDescripcion());
            ps.setInt(5, producto.getId());
            
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               mensaje = "Producto modificado!"; 
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
    
    
    public int Eliminar(EntidadProducto producto) throws SQLException, Exception {
        int resultado = 0;
        String sentencia = "DELETE FROM Productos WHERE Id_Producto=?";
         Connection _conexion = null;
        try {
            _conexion = getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setInt(1, producto.getId());       
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               mensaje = "Producto eliminado!"; 
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
