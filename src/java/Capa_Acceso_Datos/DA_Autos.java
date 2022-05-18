/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Acceso_Datos;

import Capa_Entidades.EntidadAutomovil;
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
public class DA_Autos {
     private Connection _cnn;

    private String mensaje;
    public String getMensaje() {
        return mensaje;
    }


    
       public int Insertar(EntidadAutomovil Auto) throws SQLException {
        int id_Auto = -1;
        String sentencia = "INSERT INTO Automoviles(Id_Cliente ,Tipo_Vehiculo,Placa,Marca,Modelo) VALUES(?,?,?,?,?) ";
        Connection _conexion = null;
        try {
               _conexion = ClaseConexion.getConnection();
            PreparedStatement ps = _conexion.prepareStatement(sentencia, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, Auto.getId_cliente());
            ps.setString(2, Auto.getTipo_vehiculo());
            ps.setInt(3, Auto.getPlaca());
            ps.setString(4, Auto.getMarca());
            ps.setString(5, Auto.getModelo());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id_Auto = rs.getInt(1);
                mensaje = "Auto ingresado satisfactoriamente";
            }
        } catch (Exception ex) {
            Component parentComponent = null;
            JOptionPane.showMessageDialog(parentComponent,ex);;
        } finally {
               if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return id_Auto;
    }
    
    
       public List<EntidadAutomovil> ListarAutos(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadAutomovil> lista = new ArrayList();
          Connection _conexion = null;
        try {
             _conexion = ClaseConexion.getConnection();
            Statement stm = _conexion.createStatement();
            String sentencia = "Select Id_Automovil,Id_Cliente,Tipo_Vehiculo,Marca,Modelo,Placa from Automoviles";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadAutomovil(
                                             rs.getInt("Id_Automovil"),
                                             rs.getInt("Id_Cliente"),
                                             rs.getString("Tipo_Vehiculo"),
                                             rs.getString("Marca"),
                                             rs.getString("Modelo"),
                                             rs.getInt("Placa")
                                            
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
    
        public int Modificar(EntidadAutomovil auto) throws SQLException {
        int resultado = 0;
        String sentencia = "UPDATE Automoviles SET Tipo_Vehiculo=?,Placa=?,Marca=?,Modelo=? WHERE Id_Automovil=?";
        try {
            PreparedStatement ps = _cnn.prepareStatement(sentencia);
            ps.setString(1, auto.getTipo_vehiculo());
            ps.setInt(2, auto.getPlaca());
            ps.setString(3, auto.getMarca());
            ps.setString(4, auto.getModelo());
            ps.setInt(5, auto.getId());
            
            resultado = ps.executeUpdate();
            if (resultado > 0) {
               mensaje = "Cliente modificado!"; 
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return resultado;

    }
     
        
        
        public EntidadAutomovil ObtenerUnAuto(String condicion) throws SQLException{
        ResultSet rs = null;
        EntidadAutomovil auto = new EntidadAutomovil();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "Select Id_Automovil ,Id_cliente , Tipo_Vehiculo , Placa , Marca , MOdelo  from Automoviles";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                auto.setId(rs.getInt(1));
                auto.setId_cliente(rs.getInt(2));
                auto.setTipo_vehiculo(rs.getString(3));
                auto.setPlaca(rs.getInt(4));
                auto.setMarca(rs.getString(5));
                auto.setModelo(rs.getString(6));
                auto.setExiste(true);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return auto;
    }
        
       
        
        
        
        
        
        
        
    
        
        
        
    
    
    
}
