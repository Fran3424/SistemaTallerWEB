/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Acceso_Datos;

import Capa_Entidades.EntidadPagos;
import java.awt.Component;
import java.sql.CallableStatement;
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
public class DAPagos {
    
       private Connection _cnn;
    
    
       private String mensaje;
       
       
    public String getMensaje() {
        return mensaje;
    }
    


    
    
  //Este metodo asigna un pago a las ordenes de compra y reparaciones toma el id de compra o el id reparacion o ambos y genera en la tabla pagos un registro con lo anteriormente dicho
    
          public int RealizarPago(EntidadPagos pago) throws SQLException {
        int id_orden = -1;
        int resultado=-1;
        try {
            CallableStatement cllbst = _cnn.prepareCall("{call SP_Pagar(?,?,?,?)}");
            cllbst.setInt(1, pago.getId_compra());
            cllbst.setInt(2, pago.getId_reparacion());
            cllbst.setInt(3,pago.getMonto());
            cllbst.registerOutParameter(4, java.sql.Types.INTEGER);
            cllbst.setInt(4, resultado);
            cllbst.execute();
            resultado=cllbst.getInt(4);
            
        
            if(resultado==0){
            mensaje="No es posible pagar debido a que el monto no es suficiente para el pago";
                 
            }
            else{
            mensaje="Pago asignado con exito ahora es posible emitir una factura";
           
            
            }
            
            
            
            
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return id_orden;
    }
        
    
     
          
          //Lista los pagos
          
      public List<EntidadPagos> ListarPagos(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadPagos> lista = new ArrayList();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "Select Id_Pago,Id_Compra,Id_Reparacion,Monto,Pagado from Pagos";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadPagos(
                                            rs.getInt("Id_Pago"),
                                            rs.getInt("Id_Compra"),
                                            rs.getInt("Id_Reparacion"),
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
    
    
    //Metodo para abonar a los pagos pendientes registrados 
      //Se trae un monto ingresado por el usuario y con procedimiento almacenado lo resta del monto del pago pendiente hasta que quede en cero 
      //Si ya existe una factura emitida con este pago pendiente y se paga la factura cambia de estado pendiente a cancelado
         public int AbonarPago(EntidadPagos pago, int montopagado) throws SQLException {
        int id_orden = -1;
        int resultado=-1;
        try {
            CallableStatement cllbst = _cnn.prepareCall("{call SP_ABONAR2(?,?,?)}");
            cllbst.setInt(1, pago.getId());
            cllbst.setInt(2, montopagado);
            cllbst.registerOutParameter(3, java.sql.Types.INTEGER);
            cllbst.setInt(3, resultado);
            cllbst.execute();
            resultado=cllbst.getInt(3);
            
        
            if(resultado==0){
            mensaje="Aunque queda monto pendiente pero puede seguir abonando para cancelar el monto completo";
                 
            }
            else{
            mensaje="Pago pendiente realizado el estado fue cambiado a pagado";
           
            
            }
            
              
            
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return id_orden;
    }
    
    
    
    
    //Metodo para obtener todos los datos de la tabla pagos en el id seleccionado en la tabla que se visualiza en el formulario
      public EntidadPagos ObtenerUnPago(String condicion) throws SQLException{
        ResultSet rs = null;
        EntidadPagos producto = new EntidadPagos();
        try {
            Statement stm = _cnn.createStatement();
            String sentencia = "Select Id_Pago,Id_Compra,Id_Reparacion,Monto from Pagos";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            if (rs.next()) {
                producto.setId(rs.getInt(1));
                producto.setId_compra(rs.getInt(2));
                producto.setId_reparacion(rs.getInt(3));
                producto.setMonto(rs.getInt(4));
                producto.setExiste(true);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return producto;
    }
    
    
    
    
    
    
    
}
