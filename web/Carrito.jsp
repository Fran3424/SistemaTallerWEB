<%-- 
    Document   : Carrito
    Created on : 15 may. 2022, 12:53:47
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
                    </ul>
                </div>
            </div>
        </nav>
        </header>

        <div class="container">
            <div class="card-header">
                <h1>Listado de Productos Ordenados</h1>
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
                        <th>ID</th>
                        <th>ID Factura</th>
                        <th>ID PRODUCTO</th>
                        <th>MONTO</th>
                        <th>DESCRIPCION</th>
                        <th>Cantidad</th>
                        <th>Opciones</th>
                    </tr>
                </thead>
                <tbody style="background-color: #a8c8d8">
                    
                    

                    <!--Hacer una consulta a la bd para obtener la lista de clientes
                        mediante código JAVA--> 
                    <% 
                        String nombre = "";
                        String condicion = "";
                        BLCompras logica = new BLCompras();
                        List<EntidadCompraProducto> datos;
                        datos = logica.ListarCompras("");
                        EntidadCompraProducto compra = new EntidadCompraProducto();
                        int total=0;
                        //for para llenar la tabla
                        for (EntidadCompraProducto registro:datos){
                    %>
                    <tr>
                        <% int codigo=registro.getId_Compra();%>
                       <% int codigoFactura=registro.getId_Factura();%>
                        <td><%=codigo %></td>
                        <td><%=registro.getId_Factura()%></td>
                         <td><%=registro.getId_Producto()%></td>
                        <td><%=registro.getMonto()%></td>
                        <td><%=registro.getDescripcion()%></td>
                          <td><%=registro.getCantidad()%></td>
                      <%  total=total+registro.getMonto();%>
                        <!--Columna para los botones -->
                        <td>
                    <a href="EliminarOrdenCompra?idEliminar=<%=codigo%>&IdCliente=<%=codigo2%>"> <i class="fas fa-trash">  
                      </td>   
                            
                    </tr>
                    <%}%><!--Para cerrar el for --> 
                     
                  
             <input type="submit" id="btnFinalizarCompra" name="btnFinalizarCompra" value="Finalizar compra" 
                               class="btn btn-primary"/><br><br>
            </table>
                <br> 
           
                
                
                
                
             <a href="Carrito.jsp"> Actualizar </a> 
             <a href="index.html"> Regresar al Inicio </a> 
           </tbody
           
        </div><!--Fin Container --> 
               <p class="text-danger h5" >Subtotal = <%= total%> </p>
                   <p class="text-danger h5" > Impuesto = ( 0.13) </p>
                   <p class="text-danger h5" > Preciototal = <%=(total*0.13)+total%> </p>
                   
        <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>

    </body>
</html>
