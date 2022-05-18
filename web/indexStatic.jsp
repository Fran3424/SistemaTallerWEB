<%@page import="CapaLogica.BLClientes"%>
<%@page import="Capa_Entidades.EntidadCliente"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Sistema Taller</title>
    <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
 
    <header>
        
           <%String id = request.getParameter("IdCliente");
                        int codigo = Integer.parseInt(id);
                        EntidadCliente cliente;
                        BLClientes logica = new BLClientes();
                        if(codigo > 0){
                            //cliente exite
                            cliente = logica.ObtenerUnCliente("Id_Cliente="+codigo);                         
                        }else{
                            cliente = new EntidadCliente();
                            
                        } %>
    
        
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
                            <a class="nav-link text-dark" href="Frm_Productos.jsp">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="Frm_Clientes.jsp">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="Frm_Empleados.jsp">Empleados</a>
                        </li>
                         <li class="nav-item">
                             <a class="nav-link text-dark" href="Frm_Automovil.jsp?IdCliente=<%=codigo%>">Automovil</a>
                        </li>
                        <li class="nav-item">
                              <a class="nav-link text-dark" href="Carrito.jsp?IdCliente=<%=codigo%>">Catalogo</a>
                        </li>
                        
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="Frm_Orden_Compra.jsp?IdCliente=<%=codigo%>">OrdenCompra</a>
                        </li>
                        
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <div class="container">
        <p>Ejemplo de sistema de facturación</p>
        <br/>
        <p>Por medio del menú principal tendrá acceso a todas las opciones de la aplicación</p>
        <br/><br/><br/><br/>    
    </div>

    <footer class="border-top">
        <div class="container">
            &copy; Proyecto Web creado en Clase
        </div>
        
 
        
    </footer>
    <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>

</body>
</html>