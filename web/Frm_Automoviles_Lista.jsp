<%@page import="Capa_Entidades.*"%>
<%@page import="CapaLogica.*"%>
<%@page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Autos</title>
        <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/css/Style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
                 <%String id = request.getParameter("IdCliente");
                        int codigo1 = Integer.parseInt(id);
                        EntidadCliente cliente;
                        BLClientes logicaC = new BLClientes();
                        if(codigo1 > 0){
                            //cliente exite
                            cliente = logicaC.ObtenerUnCliente("Id_Cliente="+codigo1);                         
                        }else{
                            cliente = new EntidadCliente();
                            
                        } %>
    
       
    <header>
               
        <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-white border-bottom box-shadow mb-3">
            <div class="container">
                <a class="navbar-brand" href="index.html">Taller WEB </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="navbar-collapse collapse d-sm-inline-flex flex-sm-row-reverse">
                    <ul class="navbar-nav flex-grow-1">
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="index.jsp?IdCliente=<%=codigo1%>">Inicio</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link text-dark" href="Frm_Automovil.jsp?IdCliente=<%=codigo1%>"> Agregar Vehiculo</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="Carrito.jsp?IdCliente=<%=codigo1%>">Carrito</a>
                        </li>
                        
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="Frm_Orden_Compra.jsp?IdCliente=<%=codigo1%>">OrdenCompra</a>
                        </li>
                        
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="FrmAutomoviles_Lista.jsp?IdCliente=<%=codigo1%>">Mis vehiculos</a>
                        </li> 
                    </ul>
                </div>
            </div>
        </nav>
    </header>



        <div class="container">
            <div class="card-header">
                <h1>Listado de vehiculos</h1>
            </div>                      
            <br>

            <!-- El formulario se va a cargar a si mismo -->    
            <form action="Frm_Clientes.jsp" method="post">
                <div class="form-group">
                    <div class="input-group">
                        <input type="text" id="txtnombre" name="txtnombre" value="" 
                               placeholder="Buscar por Nombre" class="form-control"/>
                        &nbsp;&nbsp;
                        <input type="submit" id="btnbuscar" name="btnbuscar" value="Buscar" 
                               class="btn btn-primary"/><br><br>
                    </div> 
                </div> 
            </form>
            <hr>
            <table class="table">
                <thead>
                    <tr id="titulos">
                        <th>ID</th>
                        <th>ID CLIENTE</th>
                        <th>TIPO VEHICULO</th>
                        <th>MARCA</th>
                        <th>MODELO</th>
                        <th>PLACA</th>
                        <th>Opciones</th>
                    </tr>
                </thead>
                <tbody>

                    <!--Hacer una consulta a la bd para obtener la lista de clientes
                        mediante código JAVA--> 
                    <% 
                        String nombre = "";
                        String condicion = "";
                        //si el txtnombre no está vacio
                        if(request.getParameter("txtnombre")!=null){
                            nombre = request.getParameter("txtnombre");
                            condicion = "NOMBRE LIKE '%" + nombre + "%'";
                        }
                        condicion="Id_Cliente="+codigo1;
                        BLAuto logica = new BLAuto();
                        List<EntidadAutomovil> datos;
                        datos = logica.ListarAutos(condicion);
            
                        //for para llenar la tabla
                        for (EntidadAutomovil registro:datos){
                    %>
                    <tr>
                        <% int codigo=registro.getId();%>
                        <td><%=codigo %></td>
                        <td><%=registro.getId_cliente()%></td>
                        <td><%=registro.getTipo_vehiculo()%></td>
                        <td><%=registro.getMarca()%></td>
                        <td><%=registro.getModelo()%></td>
                        <td><%=registro.getPlaca()%></td>
                        <!--Columna para los botones -->
                        <td>
                              <a href="Frm_Clientes.jsp?idCrearModificar=<%=codigo%>"><i class="fas fa-user-edit"></i></a> |
                            <a href="EliminarCliente?idEliminar=<%=codigo%>"><i class="fas fa-trash-alt"></i></a>
                        </td>
                    </tr>
                    <%}%><!--Para cerrar el for --> 
           
            </table>
                <br> 
           
                
                
                
                
                
                
             <a href="Frm_Automovil.jsp?idCrearModificar=-1"> Agregar un nuevo vehiculo </a> 
             <a href="frmListarClientes.jsp"> Actualizar </a> 
             <a href="index.html"> Regresar al Inicio </a> 
           </tbody
           
        </div><!--Fin Container --> 
        <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>

    </body>
</html>
