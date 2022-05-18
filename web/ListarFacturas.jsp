<%-- 
    Document   : ListarFacturas
    Created on : 17 may. 2022, 23:10:25
    Author     : Fran
--%>

<%@page import="Capa_Entidades.*"%>
<%@page import="CapaLogica.*"%>
<%@page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito</title>
        <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/css/Style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <%
             String id = request.getParameter("IdCliente");
             int codigo2 = Integer.parseInt(id);
            
            
            %>
                     
            <nav class="navbar navbar-expand-sm navbar-toggleable-sm" style="background-color:#cc0000">
            <div class="container">
                <a class="navbar-brand" href="index.jsp?IdCliente=<%=codigo2%>">Taller WEB <i class="fas fa-car"></i></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="navbar-collapse collapse d-sm-inline-flex flex-sm-row-reverse">
                    <ul class="navbar-nav flex-grow-1">
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="index.jsp?IdCliente=<%=codigo2%>">Inicio</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link text-dark" href="Frm_Automovil.jsp?IdCliente=<%=codigo2%>"> Agregar Vehiculo</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="Carrito.jsp?IdCliente=<%=codigo2%>">Carrito</a>
                        </li>
                        
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="Frm_Orden_Compra.jsp?IdCliente=<%=codigo2%>">OrdenCompra</a>
                        </li>
                        
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="FrmAutomoviles_Lista.jsp?IdCliente=<%=codigo2%>">Mis vehiculos</a>
                        </li> 
                        
                         <li class="nav-item">
                            <a class="nav-link text-dark" href="ListarFacturas.jspIdCliente=<%=codigo2%>">Facturas</a>
                        </li> 
                        
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="Frm_Clientes.jsp?IdCliente=<%=codigo2%>">Clientes</a>
                        </li> 
                        
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="Frm_Productos.jsp?IdCliente=<%=codigo2%>">Productos</a>
                        </li> 
                    </ul>
                </div>
            </div>
        </nav>
        </header>

        <div class="container">
            <div class="card-header">
                <h1>Listado de Facturas</h1>
            </div>                      
            <br>

            <!-- El formulario se va a cargar a si mismo -->    
            <form action="" method="post">
                <div class="form-group">
                  
                </div> 
            </form>
            <hr>
            <table class="table" style="background-color: grey">
                <thead>
                    <tr id="titulos">
                        <th>ID FACTURA</th>
                        <th>ID CLIENTE</th>
                        <th>DESCRIPCION</th>
                        <th>Estado</th>
                        <th>FECHA</th>
                    </tr>
                </thead>
                <tbody style="background-color: #a8c8d8">
                    
                    

                    <!--Hacer una consulta a la bd para obtener la lista de clientes
                        mediante código JAVA--> 
                    <% 
                        String nombre = "";
                        String condicion = "";
                        BLFactura logica = new BLFactura();
                        List<EntidadFactura> datos;
                        datos = logica.ListarFacturas("");
                        EntidadCompraProducto compra = new EntidadCompraProducto();
                        int total=0;
                        //for para llenar la tabla
                        for (EntidadFactura registro:datos){
                    %>
                    <tr>
                        <% int codigo=registro.getId();%>
                        <td><%=codigo %></td>
                        <td> <%=registro.getId_cliente()%> </td>
                        <td><%=registro.getDescripcion()%></td>
                        <td><%=registro.getEstado()%></td>
                         <td><%=registro.getFecha()%></td>
                        <!--Columna para los botones -->
                    </tr>
                    <%}%><!--Para cerrar el for --> 
                     
                  
            </table>
                <br> 
           
                
                
                
               
           </tbody
           
        </div><!--Fin Container --> 
   
        <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>

    </body>
</html>
