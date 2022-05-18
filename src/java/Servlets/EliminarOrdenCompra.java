/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import CapaLogica.BLClientes;
import CapaLogica.BLCompras;
import Capa_Entidades.EntidadCliente;
import Capa_Entidades.EntidadCompraProducto;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fran
 */
public class EliminarOrdenCompra extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         try{
      BLCompras logica = new BLCompras();
           EntidadCompraProducto compra = new EntidadCompraProducto();
            String id = request.getParameter("idEliminar");
            String idc=request.getParameter("IdCliente");
            int idCliente=Integer.parseInt(idc);
            int codigo=Integer.parseInt(id);
            compra.setId_Compra(codigo);
            logica.EliminarCompra(compra);
            //redireccionar a la pagina
        response.sendRedirect("Carrito.jsp?IdCliente="+idCliente);
       } catch (Exception ex){
             try {
                 throw ex;
             } catch (Exception ex1) {
                   out.print(ex1.getMessage());
             }
       }  
       
    }
    
}

