<%@page import="Capa_Entidades.*"%>
<%@page import="CapaLogica.*"%>
<%@page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Empleados</title>
        <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-white border-bottom box-shadow mb-3">
                <div class="container">
                    <a class="navbar-brand" href="index.html">Sistema Facturación <i class="fas fa-tasks"></i></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="navbar-collapse collapse d-sm-inline-flex flex-sm-row-reverse">
                        <ul class="navbar-nav flex-grow-1">
                            <li class="nav-item">
                                <a class="nav-link text-dark" href="index.html">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark" href="#">Productos</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark" href="frmListarClientes.jsp">Clientes</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark" href="FrmListarFacturas.jsp">Facturación</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>

        <div class="container">
            <div class="card-header">
                <h1>Listado de Empleados</h1>
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
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Apellido1</th>
                        <th>Apellido2</th>
                        <th>Telefono</th>
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
                        BLEmpleados logica = new BLEmpleados();
                        List<EntidadEmpleado> datos;
                        datos = logica.ListarEmpleados(condicion);
            
                        //for para llenar la tabla
                        for (EntidadEmpleado registro:datos){
                    %>
                    <tr>
                        <% int codigo=registro.getId();%>
                        <td><%=codigo %></td>
                        <td><%=registro.getNombre()%></td>
                        <td><%=registro.getApellido1()%></td>
                        <td><%=registro.getApellido2()%></td>
                        <td><%=registro.getTelefono()%></td>
                        <!--Columna para los botones -->
                        <td>
                            <!--Botón para modificar -->
                            <a href="Frm_Mantenimiento_Empleado.jsp?idCrearModificar=<%=codigo %>"> <i class="fas fa-user-edit">  
                            <!--Botón para Eliminar -->
                            <a href="EliminarEmpleados?idEliminar=<%=codigo %>"> <i class="fas fa-trash-alt"> 
|
                        </td>
                    </tr>
                    <%}%><!--Para cerrar el for --> 
             </tbody
            </table>
                <br> 
           
                
                
                
                
                
                
             <a href="Frm_Mantenimiento_Empleado.jsp?idCrearModificar=-1"> Agregar un nuevo Cliente </a> 
             <a href="frmListarClientes.jsp"> Actualizar </a> 
             <a href="index.html"> Regresar al Inicio </a> 
         
           
        </div><!--Fin Container --> 
        <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>

    </body>
</html>
