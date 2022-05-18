/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import CapaLogica.BLCompras;
import CapaLogica.BLFactura;
import Capa_Entidades.EntidadCompraProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fran
 */
public class GuardarCarrito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            int resultado=-1;
       int IdCliente =Integer.parseInt(request.getParameter("txtIdCliente"));
       EntidadCompraProducto Compra= new EntidadCompraProducto();
       BLCompras logicaCompra = new BLCompras();
       Compra.setCantidad(Integer.parseInt(request.getParameter("txtcantidad")));
       Compra.setId_Producto(Integer.parseInt(request.getParameter("txtIdProducto")));
       Compra.setMonto(Integer.parseInt(request.getParameter("txtprecio"))*Compra.getCantidad());
       Compra.setDescripcion("Orden de compra");
      logicaCompra.Insertar(Compra,IdCliente);
      String mensaje;
       
       response.sendRedirect("Frm_Orden_Compra.jsp?IdCliente="+IdCliente);
       
        }catch( Exception ex){
       
            
        
        }
       
       
       
    }

 
}
