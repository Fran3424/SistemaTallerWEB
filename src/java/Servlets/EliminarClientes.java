/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlets;
import Capa_Entidades.EntidadCliente;
import CapaLogica.BLClientes;
import java.io.*;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Fran
 */
@WebServlet("/EliminarClientes")
public class EliminarClientes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
       throws ServletException, IOException {
        
        response.setContentType("tezt/html/charset=UTF-8");
        
        PrintWriter out = response.getWriter();

        try {
            BLClientes logica = new BLClientes();
           EntidadCliente cliente = new EntidadCliente();
            String id = request.getParameter("idEliminar");
            int codigo=Integer.parseInt(id);
            cliente.setId(codigo);
            int resultado=logica.Eliminar(cliente);
            String mensaje=logica.getMensaje();
            mensaje=URLEncoder.encode(mensaje,"UTF-8" );
            //redireccionar a la pagina
           response.sendRedirect("Frm_Clientes.jsp?meCli=" + mensaje + "&resultado=" + resultado);
            
        } catch (Exception e) {
            out.print(e.getMessage());
        }
        
        
        
        
        
        
        
        
    }
    
}   
    //Sobreescribir metodo
    