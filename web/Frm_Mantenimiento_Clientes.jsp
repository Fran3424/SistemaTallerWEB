
<%@page import="Capa_Entidades.*"%>
<%@page import="CapaLogica.*"%>
<%@page import="java.util.List" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Clientes</title>
        <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/styles.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-white border-bottom box-shadow mb-3">
                <div class="container">
                    <a class="navbar-brand" href="indexccc.html">Sistema Facturación <i class="fas fa-tasks"></i></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="navbar-collapse collapse d-sm-inline-flex flex-sm-row-reverse">
                        <ul class="navbar-nav flex-grow-1">
                            <li class="nav-item">
                                <a class="nav-link text-dark" href="indexccc.html">Inicio</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark" href="frmProductos.jsp">Productos</a>
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
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <div class="card-header">            
                        <h1>Mantenimiento de Clientes</h1>
                    </div><br>
                     <%
                     
                        String id = request.getParameter("idCrearModificar");
                        int codigo = Integer.parseInt(id);
                        EntidadCliente cliente;
                        BLClientes logica = new BLClientes();
                        if(codigo > 0){
                            //cliente exite
                            cliente = logica.ObtenerUnCliente("ID_CLIENTE="+id);                         
                        }else{
                            cliente = new EntidadCliente();
                            
                        }
                     %> <><!-- al no tener jsp quiere decir que es un servlet -->
                     <form action="CrearModificarCliente" method="post" id="frmAgregarModificar">
                         
                        <div class="form-group">
                            
                            <%if(codigo > 0){%>
                                <label for = "txtCodigo" class="control-lable">Código</label>
                                <input 
                                    type="number" 
                                    id="txtCodigo" 
                                    name="txtCodigo"  
                                    value="<%=cliente.getId()%>"
                                    readonly
                                    class="form-control"/>
                            <%}else{%>
                                <input 
                                    type="hidden" 
                                    id="txtCodigo" 
                                    name="txtCodigo"  
                                    value="-1"
                                    />
                            <%}%>
                        </div>
                        <div> 
                            <label 
                                for = "txtNombre" 
                                class="control-lable">Nombre
                            </label>
                            <input 
                                id="txtNombre" 
                                name="txtNombre"  
                                value="<%=cliente.getNombre()%>"
                                class="form-control"
                            />
                        </div>
                        <div> 
                            <label 
                                for = "txtApellido1" 
                                class="control-lable">Apellido1
                            </label>
                            <input 
                                id="txtApellido1" 
                                name="txtApellido1" 
                                value="<%=cliente.getApellido1()%>"
                                class="form-control"
                            />
                        </div>
                                <div> 
                            <label 
                                for = "txtApellido2" 
                                class="control-lable">Apellido2
                            </label>
                            <input 
                                id="txtApellido2" 
                                name="txtApellido2"  
                                value="<%=cliente.getApellido2()%>"
                                class="form-control"
                            />
                        </div>
                                
                            <div> 
                            <label 
                                for = "txtTelefono" 
                                class="control-lable">Telefono
                            </label>
                            <input 
                                id="txtTelefono" 
                                name="txtTelefono"  
                                value="<%=cliente.getTelefono()%>"
                                class="form-control"
                            />
                        </div>       
                                                     
                                
                                
                        <div class="form-group">
                            <div class="input-group">
                                <input 
                                    type="submit" 
                                    id="btnGuardar" 
                                    value="Guardar"
                                    class="btn btn-primary"&nbsp;&nbsp
                                />
                                <input 
                                    type="button" 
                                    id="btnRegresar" 
                                    value="Regresar"
                                    class="btn btn-secondary"
                                    onclick="location.href='Frm_Clientes.jsp'"
                                />
                            </div> 
                        </div> 
                     </form>
                </div>            
            </div>            
        </div><!-- container -->
        <script src="lib/bootstrap/dist/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="lib/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
        <!-- Creamos la validación -->
        <script>
            //cuando el documento este listo
            $(document).ready(function(){
                
                $("#frmAgregarModificar").validate({
                    
                    rules:{
                        txtNombre:{required:true,maxlength:50},
                        txtTelefono:{required:true,minlength:8,maxlength:11},
                        txtDireccion:{required:true,maxlength:80}
                    },
                    messages:{
                        txtNombre:"El campo 'Nombre' es requerido, máximo 50 carácteres",
                        txtTelefono:"El campo 'Teléfono' es requerido, mínimo 8 carácteres,máximo 11",
                        txtDireccion:"El campo 'Dirección' es requerido, máximo 80 carácteres"
                    },
                    errorElement:'span'
                });
            });
            
        </script>
    </body>
</html>
