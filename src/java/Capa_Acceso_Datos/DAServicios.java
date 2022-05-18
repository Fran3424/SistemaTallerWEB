/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Acceso_Datos;

import static Capa_Acceso_Datos.ClaseConexion.getConnection;
import Capa_Entidades.Entidad_Servicio;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class DAServicios {
    
    
      private Connection _cnn;


    private String mensaje;
    public String getMensaje() {
        return mensaje;
    }
    


    
   
  
    public List<Entidad_Servicio> ListarServicios(String condicion) throws SQLException{
        ResultSet rs = null;
        List<Entidad_Servicio> lista = new ArrayList();
        Connection _conexion = null;
        try {
              _conexion = getConnection();
            Statement stm = _conexion.createStatement();
            String sentencia = "Select Id_Servicio,Tipo_Vehiculo,Nombre,Precio from Servicios";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new Entidad_Servicio
                                            (rs.getString("Tipo_Vehiculo"),
                                             rs.getInt("Id_Servicio"),
                                             rs.getString("Nombre"),
                                             rs.getInt("Precio")
                                            
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
    

    
      public Entidad_Servicio ObtenerUnServicio(String condicion) throws SQLException{
        ResultSet rs = null;
        Entidad_Servicio servicio = new Entidad_Servicio();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "Select Id_Servicio,Tipo_Vehiculo,Nombre,Precio from Servicios";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                servicio.setId(rs.getInt(1));
                servicio.setTipo_Vehiculo(rs.getString(2));
                servicio.setNombre(rs.getString(3));
                servicio.setPrecio(rs.getInt(4));
                servicio.setExiste(true);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return servicio;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
