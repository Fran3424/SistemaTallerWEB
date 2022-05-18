/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import CapaLogica.BLAuto;
import CapaLogica.BLReparaciones;
import Capa_Entidades.EntidadAutomovil;
import Capa_Entidades.EntidadReparaciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fran
 */
public class AgendarReparacion extends HttpServlet {

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
          response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            BLReparaciones logica = new BLReparaciones();
            EntidadReparaciones reparacion = new EntidadReparaciones();
            int resultado;
            reparacion.setId_auto(Integer.parseInt(request.getParameter("txtIdAuto")));
            reparacion.setId_empleado(Integer.parseInt(request.getParameter("txtIdEmpleado")));
             reparacion.setId_servicio(Integer.parseInt(request.getParameter("txtIdServicio")));
            String fecha1 = new String(request.getParameter("txtFechaInicio").getBytes("ISO-8859-1"),"UTF-8");
            java.util.Date dt= new SimpleDateFormat("yyyy-MM-dd").parse(fecha1);
            java.sql.Date fechaInicio = new java.sql.Date(dt.getTime());
            reparacion.setFechaInicio(fechaInicio);
               String fecha2 = new String(request.getParameter("txtFechaFin").getBytes("ISO-8859-1"),"UTF-8");
            java.util.Date dt2= new SimpleDateFormat("yyyy-MM-dd").parse(fecha2);
            java.sql.Date fechaFin = new java.sql.Date(dt2.getTime());
             reparacion.setMonto(Integer.parseInt(request.getParameter("txtMonto")));
            reparacion.setFechaFin(fechaFin);
            logica.Insertar(reparacion);
            response.sendRedirect("Frm_Automoviles_Lista.jsp");
        } catch (Exception ex)
        {
            //throw ex;
            
            out.print(ex.getMessage());
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
