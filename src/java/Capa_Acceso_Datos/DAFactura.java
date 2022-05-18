/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Capa_Acceso_Datos;

import static Capa_Acceso_Datos.ClaseConexion.getConnection;
import Capa_Entidades.EntidadCompraProducto;
import Capa_Entidades.EntidadFactura;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Fran
 */
public class DAFactura {
    
    private Connection _cnn;
        private String mensaje;
    public String getMensaje() {
        return mensaje;
    }
    

       
    
       
       //Se ingresa la factura de manera que dependiendo del pago cambie su estado instanteneamente mediante procedimiento almacenado
    
            public int Insertar(EntidadFactura factura) throws SQLException {
        int id_orden = -1;
        int resultado=-1;
        try {
            CallableStatement cllbst = _cnn.prepareCall("{call SP_INGRESARFACTURA(?,?,?,?,?)}");
            cllbst.setInt(1, factura.getId_pago());
            cllbst.setInt(2, factura.getId_cliente());
            cllbst.setString(3, factura.getDescripcion());
            cllbst.setDate(4,new java.sql.Date( factura.getFecha().getTime()));
            cllbst.setInt(5, resultado);
            cllbst.registerOutParameter(5, java.sql.Types.INTEGER);
            cllbst.execute();
 
            resultado=cllbst.getInt(5);
            
        
            if(resultado==0){
            mensaje="No se pudo hacer la orden de compra debido a que no hay suficiente cantidad del producto";
                 
            }
            else{
            mensaje="Factura registrada correctamente puede visualizar las facturas en el apartado de listar";
           
            
            }
            
            
            
            
        } catch (Exception ex) {
            throw ex;
        } finally {
            _cnn = null;
        }
        return id_orden;
    }
        
    
    
    //Se lista factura con resultset para tener una consulta con datos de manera mas rapida
    
        public ResultSet ListarFacturasMES(String condicion,String orden) throws Exception{
            ResultSet rs= null;
            try{
            Statement stm = _cnn.createStatement();
            String sentencia = "SELECT Id_Cliente,Id_Factura,Id_Pago,Fecha,estado FROM Facturas";
            if(!condicion.equals("")){
                sentencia = String.format("%s where %s",sentencia,condicion);
            
            }
            
            if(!orden.equals("")){
                sentencia = String.format("%s order by %s",sentencia,orden);
            
            }
            
            rs= stm.executeQuery(sentencia);
            
            return rs;
            
            }catch(SQLException ex){
            throw ex;
                    } 
  
         
                
            
            
    }  
    
        
        
        public List<EntidadFactura> ListarFacturas(String condicion) throws SQLException{
        ResultSet rs = null;
        List<EntidadFactura> lista = new ArrayList();
         Connection _conexion = null;
        try {
             _conexion = ClaseConexion.getConnection();
            Statement stm = _conexion.createStatement();
            String sentencia = "Select Id_Factura,Id_Pago,Id_Cliente,Descripcion,Fecha,Estado from Facturas";
            if (!condicion.equals("")) {
                sentencia = String.format("%s WHERE %s", sentencia, condicion);
            }
            rs = stm.executeQuery(sentencia);
            while(rs.next()){
                lista.add(new EntidadFactura
                                            (rs.getInt("Id_Factura"),
                                             rs.getInt("Id_Pago"),
                                             rs.getInt("Id_Cliente"),
                                             rs.getString("Descripcion"),
                                             rs.getDate("Fecha"),       
                                             rs.getString("Estado")
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
        
        
        
        
        
        
        
        
        
        
    
    
       public EntidadFactura ObtenerRegistro(String condicion) throws Exception{
        ResultSet rs = null;
        EntidadFactura factura = new EntidadFactura();
        String sentencia;
        Connection _conexion = null;
        sentencia = "SELECT Id_Factura,F.ID_CLIENTE,FECHA,F.Estado FROM FACTURAS F INNER JOIN CLIENTES ON CLIENTES.ID_CLIENTE=F.ID_CLIENTE";
         if(!condicion.equals("")){
                sentencia = String.format("%s WHERE %s", sentencia,condicion);
            }
        try { 
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();
            rs = st.executeQuery(sentencia);
            if (rs.next()){
                                factura.setId(rs.getInt("Id_Factura"));      
                                factura.setId_cliente(rs.getInt("Id_Cliente"));      
                                factura.setFecha(rs.getDate("Fecha"));      
                                factura.setEstado(rs.getString("Estado"));
                                factura.setExiste(false);
            }else{
                    factura.setExiste(false);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return factura;
    }//Fin listar Clientes
    
    
    
    
    public int InsertarFact(EntidadFactura Factura, EntidadCompraProducto Orden) throws Exception {
CallableStatement CS;
int resultado = 0;
int idFactura = 0;
Connection _Conexion = null;
try {
    _Conexion = ClaseConexion.getConnection();
    // por defecto el objeto Connection trabaja las transacciones con confirmacion automatica 
    // Pero en este ejemplo deseamos realizar varias transacciones y que todas se
    // manejen como si fuera una sola 
    _Conexion.setAutoCommit(false); // en TRUE hace COMMIT cada vez que se ejecute un COMANDO,
    // En FALSE - todas las operaciones de aquí en ademante se manejan como una
    // Para garantizar que se hagan todas las operaciones en UNA SOLA TRANSACCIÓN
    CS = _Conexion.prepareCall("{call Guardar_Factura (?,?,?,?,?)}");
    CS.setInt (1, Factura.getId());
    CS.setInt (2, Factura.getId_cliente());
    CS.setDate (3, (Date) Factura.getFecha()); 
    CS.setString(4, Factura.getEstado()); 
    CS.setString (5, mensaje);
    CS.registerOutParameter (1, Types.INTEGER);//obtiene id de factura
    
    resultado = CS.executeUpdate(); 
    idFactura = CS.getInt(1);    
      
      
    CS = _Conexion.prepareCall ("{call GUARDAR_ORDEN (?,?,?,?,?)}");
    CS.setInt(1, idFactura); // llama a la variable que acabamos de declarar 
    CS.setInt (2, Orden.getId_Producto()); 
    CS.setInt (3, Orden.getCantidad()); 
    CS.setInt(4, Orden.getMonto()); 
    CS.setString (5, mensaje);
    
    //registrar mensaje para salida 
    CS. registerOutParameter(5, Types.VARCHAR);
    resultado = CS.executeUpdate();
    //SE RECIBE DEL SP
    mensaje = CS.getString (5);
    _Conexion.commit();//todo esta bien 
} catch (ClassNotFoundException | SQLException ex) {
_Conexion.rollback(); // Si algo salió mal se DESHACEN todas las transacciones
throw ex; 
} finally {
    if (_Conexion != null) {
        ClaseConexion.close(_Conexion);
    }
}
return idFactura; 
} // fin de insertar
      
    
    
     public int Modificarcliente( EntidadFactura Factura)  throws Exception {
int idfactura = 0;
Connection _Conexion = null; 
try {
_Conexion = ClaseConexion.getConnection(); 
PreparedStatement PS = _Conexion.prepareStatement ("update Facturas set ID_CLIENTE = ? where NUM_FACTURA = ?");

PS.setInt (1, Factura.getId_cliente());
PS.setInt (2, Factura.getId());

PS.executeUpdate(); 
idfactura = Factura.getId(); // este devuelve el ID FACTURA

} catch (Exception ex) {
    throw ex;
} finally {
    if (_Conexion != null) {
        ClaseConexion.close(_Conexion);
    }
}   
return idfactura; 
 } // fin Modificar ID del cliente     
      
     
     
 public int ObtenerUltimaFactura(String condicion) throws Exception{
        ResultSet rs = null;
        int factura = 0;
        String sentencia;
        Connection _conexion = null;
        sentencia = "Select MAX(Id_Factura) from  Facturas ";
         if(!condicion.equals("")){
                sentencia = String.format("%s WHERE %s", sentencia,condicion);
            }
        try { 
            _conexion = ClaseConexion.getConnection();
            Statement st = _conexion.createStatement();
            rs = st.executeQuery(sentencia);
            if (rs.next()){
               factura = rs.getInt("Id_Factura");      
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if(_conexion != null){
                ClaseConexion.close(_conexion);
            }
        }
        return factura;
    }//Fin listar Clientes
    
    
  
       public int Modificar(EntidadFactura Factura) throws SQLException, Exception {
         int resultado = -1;
        Connection _conexion = null;
        try
        {
            _conexion = getConnection();
            PreparedStatement ps = _conexion.prepareStatement("UPDATE Facturas SET Estado='CANCELADA' WHERE ID_FACTURA=?");
            ps.setInt(1, Factura.getId());        
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
    
    
    
    
    
    
    
    
    
    
}
