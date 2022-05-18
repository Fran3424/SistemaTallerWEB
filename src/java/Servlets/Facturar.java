/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import CapaLogica.BLFactura;
import Capa_Entidades.EntidadCompraProducto;
import Capa_Entidades.EntidadFactura;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fran
 */
public class Facturar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType ("text/html;charset=UTF-8"); 
           PrintWriter out = response.getWriter(); 
           try {
           BLFactura LogicaFactura = new BLFactura(); 
           EntidadFactura Factura = new EntidadFactura();
            EntidadCompraProducto Compra = new EntidadCompraProducto();
            int resultado;
            String mensaje="";
            //crear entidad de factura
            if (request.getParameter ("txtNombreCliente")!=null &&
                !request.getParameter("txtNombreCliente").equals("")){
            Factura.setId_cliente(Integer.parseInt(request.getParameter ("txtIdCliente"))); 
            Factura.setId (Integer.parseInt(request.getParameter ("txtnumFactura")));
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fechaString = request.getParameter("txtFechaFactura");
            Date fecha = formato.parse(fechaString);
            java.sql.Date fechasql = new java.sql.Date(fecha.getTime());
            Factura.setFecha(fechasql); 
            Factura.setId_cliente(Integer.parseInt(request.getParameter("txtIdCliente")));
            Factura.setEstado("Pendiente");
            
        if(! (request.getParameter ("txtdescripcion").equals(""))&&
                !(request.getParameter("txtcantidad").equals(""))&&
                !(request.getParameter("txtprecio").equals(""))){ 
            //crear entidad de detalle
            Compra.setId_Factura(-1);
            Compra.setId_Producto(Integer.parseInt(request.getParameter("txtIdProducto")));
            Compra.setCantidad(Integer.parseInt(request.getParameter("txtcantidad")));
            Compra.setMonto (Integer.parseInt(request.getParameter("txtprecio")));
            resultado = LogicaFactura.InsertarFact(Factura, Compra);
            mensaje = LogicaFactura.getMensaje(); 
        }else{
            resultado = LogicaFactura.ModificarCliente(Factura);
        }
        
       // response.sendRedirect("Frm_Orden_Compra.jsp?msgFac=" + mensaje + "&txtnumFactura=" + resultado);
        response. sendRedirect("Frm_Orden_Compra.jsp");
        }else{ 
                response.sendRedirect("Frm_Orden_Compra.jsp?txtnumFactura="+
                            request.getParameter("txtnumFactura"));
            }
        } catch(Exception e){
            out.print(e.getMessage());
                }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
