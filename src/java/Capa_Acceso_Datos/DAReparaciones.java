/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Acceso_Datos;


import static Capa_Acceso_Datos.ClaseConexion.getConnection;
import Capa_Entidades.EntidadReparaciones;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Fran
 */
public class DAReparaciones {
    
        private Connection _cnn;

    private String mensaje;
    public String getMensaje() {
        return mensaje;
    }


    
    
      
    public int Insertar(EntidadReparaciones reparacion) throws SQLException {
        int id_empleado = -1;
        String sentencia = "Insert into Reparaciones(Id_Servicio,Id_Empleado,Id_Automovil,FechaInicio,FechaFin,Monto) VALUES(?,?,?,?,?,?) ";
        Connection _conexion = null;
        try {
              _conexion = getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia);
            ps.setInt(1, reparacion.getId_servicio());
            ps.setInt(2, reparacion.getId_empleado());
            ps.setInt(3, reparacion.getId_auto());
            ps.setDate(4,new java.sql.Date( reparacion.getFechaInicio().getTime()) );
            ps.setDate(5,new java.sql.Date( reparacion.getFechaFin().getTime()) );
            ps.setInt(6,reparacion.getMonto());
            ps.execute();
        } catch (Exception ex) {
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent,ex);
        } finally {
             if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return id_empleado;
    }
    
    
      public List<EntidadReparaciones> ListarReparaciones(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadReparaciones> lista = new ArrayList();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "Select Id_Reparacion,Id_Automovil,Id_Empleado,Id_Servicio,Monto,FechaInicio,FechaFin from Reparaciones";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadReparaciones(
                                             rs.getInt("Id_Reparacion"),
                                             rs.getInt("Id_Automovil"),
                                             rs.getInt("Id_Empleado"),
                                              rs.getInt("Id_Servicio"),
                                             rs.getDate("FechaInicio"),
                                              rs.getDate("FechaFin"),
                                              rs.getInt("Monto")
                                            
                                            
                ));
            }
        } catch (Exception ex) {
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent,ex);
        } finally {
            _cnn = null;
        }     
        return lista;
    }
    
        public EntidadReparaciones ObtenerUnaReparacion(String condicion) throws SQLException{
        ResultSet rs = null;
        EntidadReparaciones cliente = new EntidadReparaciones();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "Select Id_Reparacion,Id_Automovil,Id_Empleado,Id_Servicio,Monto,FechaInicio,FechaFin from Reparaciones";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                cliente.setId(rs.getInt(1));
                cliente.setId_auto(rs.getInt(2));
                cliente.setId_empleado(rs.getInt(3));
                cliente.setId_servicio(rs.getInt(4));
                cliente.setMonto(rs.getInt(5));
                cliente.setFechaInicio(rs.getDate(6));
                 cliente.setFechaFin(rs.getDate(7));
                cliente.setExiste(true);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return cliente;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
