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
    <link href="lib/css/Style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
 
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
                            <a class="nav-link text-dark" href="index.jsp?IdCliente=<%=codigo%>">Inicio</a>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link text-dark" href="Frm_Automovil.jsp?IdCliente=<%=codigo%>"> Agregar Vehiculo</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="Carrito.jsp?IdCliente=<%=codigo%>">Carrito</a>
                        </li>
                        
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="Frm_Orden_Compra.jsp?IdCliente=<%=codigo%>">OrdenCompra</a>
                        </li>
                        
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="FrmAutomoviles_Lista.jsp?IdCliente=<%=codigo%>">Mis vehiculos</a>
                        </li> 
                        
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="ListarFacturas.jsp?IdCliente=<%=codigo%>">Facturas</a>
                        </li> 
                    </ul>
                </div>
            </div>
        </nav>
    </header>

                        
                        
    <footer class="border-top">
        <div class="container">
            &copy; Proyecto Web 2022
        </div> 
    </footer>
    <script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
    <script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>

</body>
</html>