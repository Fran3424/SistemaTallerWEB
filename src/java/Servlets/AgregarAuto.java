/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import CapaLogica.BLAuto;
import CapaLogica.BLEmpleados;
import Capa_Entidades.EntidadAutomovil;
import Capa_Entidades.EntidadEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fran
 */
public class AgregarAuto extends HttpServlet {

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
            BLAuto logica = new BLAuto();
            EntidadAutomovil auto = new EntidadAutomovil();
            int resultado;
            auto.setId_cliente(Integer.parseInt(request.getParameter("txtIdCliente")));
            auto.setPlaca(Integer.parseInt(request.getParameter("txtPlaca")));
            auto.setTipo_vehiculo(new String(request.getParameter("cmbTipo").getBytes("ISO-8859-1"),"UTF-8"));  
            auto.setMarca(new String(request.getParameter("txtMarca").getBytes("ISO-8859-1"),"UTF-8"));
            auto.setModelo(new String(request.getParameter("txtModelo").getBytes("ISO-8859-1"),"UTF-8"));
            logica.Insertar(auto);
            
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
