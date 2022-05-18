/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Acceso_Datos;

import Capa_Entidades.EntidadCompraProducto;
import Capa_Entidades.EntidadEmpleado;
import Capa_Entidades.EntidadProducto;
import Capa_Entidades.EntidadReparaciones;
import java.awt.Component;
import java.sql.CallableStatement;
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
public class DACompras {
        private Connection _cnn;

    private String mensaje;
    public String getMensaje() {
        return mensaje;
    }

   
    
    
        
       public void Insertar(EntidadCompraProducto compra ,int IdCliente) throws SQLException, Exception {
        int id_orden = -1;
        int resultado=-1;
        Connection _conexion = null;
        try {
            _conexion = ClaseConexion.getConnection();
            CallableStatement cllbst = _conexion.prepareCall("{call SP_INSERTAR_ORDEN_VERIFICACION2(?,?,?,?,?,?)}");
            cllbst.setInt(1, compra.getCantidad());
            cllbst.setInt(2, compra.getId_Producto());
            cllbst.setString(3, compra.getDescripcion());
            cllbst.setInt(4, compra.getMonto());
            cllbst.setInt(5, IdCliente);
            cllbst.setInt(6, resultado);
            cllbst.execute();
            
            
        } catch (Exception ex) {
            throw ex;
        } finally {
            if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
   
    }
        
        
       public List<EntidadCompraProducto> ListarCompras(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadCompraProducto> lista = new ArrayList();
         Connection _conexion = null;
        try {
             _conexion = ClaseConexion.getConnection();
            Statement stm = _conexion.createStatement();
            String sentencia = "Select Id_Compra,OC.Id_Factura,Id_Producto,Monto,OC.Descripcion,Cantidad from Orden_Compras OC inner join  Facturas FA ON FA.Id_Factura=OC.Id_Factura";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadCompraProducto
                                            (rs.getInt("Id_Compra"),
                                             rs.getInt("Id_Producto"),
                                             rs.getInt("Cantidad"),
                                             rs.getString("Descripcion"),
                                             rs.getInt("Monto"),       
                                             rs.getInt("Id_Factura")
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
    

     
         public EntidadCompraProducto ObtenerUnaCompra(String condicion) throws SQLException, Exception{
        ResultSet rs = null;
        EntidadCompraProducto compra = new EntidadCompraProducto();
        Connection _conexion = null;
        try {
             _conexion = ClaseConexion.getConnection();
            Statement stm = _conexion.createStatement();
            String sentencia = "Select Id_Compra,Id_Factura,Id_Producto,Monto,Descripcion,Cantidad from Orden_Compras";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                compra.setId_Compra(rs.getInt(1));
                compra.setId_Factura(rs.getInt(2));
                compra.setId_Producto(rs.getInt(3));
                compra.setMonto(rs.getInt(4));
                compra.setDescripcion(rs.getString(5));
                compra.setCantidad(rs.getInt(6));
                compra.setExiste(true);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return compra;
        
    }
    
        
        public int EliminarCompra(EntidadCompraProducto compra) throws SQLException, Exception {
        int id_orden = -1;
        int resultado=-1;
              Connection _conexion = null;
        try {
                _conexion = ClaseConexion.getConnection();
            CallableStatement cllbst = _conexion.prepareCall("{call  SP_ELIMINAR_ORDEN_VERIFICACION2(?,?)}");
            cllbst.setInt(1, compra.getId_Compra());
            cllbst.setInt(2, resultado);
            cllbst.execute();
 
        
 
            
               
            
        } catch (Exception ex) {
            throw ex;
        } finally {
            if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return id_orden;
    }  
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
        
        
    
    
    
  
    
}
