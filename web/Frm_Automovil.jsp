<%@page import="Capa_Entidades.EntidadCliente"%>
<%@page import="CapaLogica.BLClientes"%>
<%@page import="java.util.*"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
    <head>
        <meta charset="utf-8" /> 
        <link href="lib/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/> 
        <link href="lib/bootstrap-datepicker/css/bootstrap-datepicker3.standalone.min.css" rel="stylesheet" type="text/css"/> 
        <link href="lib/fontawesome-free-5.14.0-web/css/all.min.css" rel="stylesheet" type="text/css"/> 
        <link href="lib/DataTables/datatables.min.css" rel="stylesheet" type="text/css"/>
        <link href="lib/css/Style.css" rel="stylesheet" type="text/css"/>
        <title> Agregar un automovil </title> 
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
                    </ul>
                </div>
            </div>
        </nav>
    </header>

        
<div class="container"> 
    <div class="row">
        <div class="col-10"><hl></h1></div>
</div>
    
  
<br/>





<!-- Formulario para los datos de la factura --> 
<form action="AgregarAuto" method="post">
    <div class="form-group float-center" >
        

    <br/> 
    <div class="form-group"> 
                                <label 
                                for = "txtNombreCliente" 
                                class="control-lable">Nombre
                            </label>
        <div class="input-group">
            <input  id="txtIdCliente" name="txtIdCliente" value="<%=codigo%>"
                    class="form-control" type="hidden" /> 
            <input type="text" id="txtNombreCliente" name="txtNombreCliente"
                   value="<%=cliente.getNombre()%>" readonly="" class="form-control"
                   placeholder="Seleccione un cliente"/>&nbsp;&nbsp;
        </div> 
    </div>

               


 
<div class="float-right">
    
</div> 
        <div> 
                            <label 
                                for = "cmbTipo" 
                                class="control-lable">Tipo de vehiculo
                            </label>
            <select id="cmbTipo" name="cmbTipo">
                                         <option value="MOTOCICLETA">MOTOCICLETA</option>
                                         <option value="CAMION">CAMION</option>
                                         <option value="AUTOMOVIL">AUTOMOVIL</option>
                                         <option value="CAMIONETA">CAMIONETA</option>
                                     </select>
                        </div>

                   
                     <div> 
                            <label 
                                for = "txtPlaca" 
                                class="control-lable">Placa
                            </label>
                            <input 
                                id="txtPlaca" 
                                name="txtPlaca" 
                                value=""
                                class="form-control"
                            />
                        </div>
                   
                       <div> 
                            <label 
                                for = "txtMarca" 
                                class="control-lable">Marca
                            </label>
                            <input 
                                id="txtMarca" 
                                name="txtMarca" 
                                value=""
                                class="form-control"
                            />
                        </div>

                   
                   
                       <div> 
                            <label 
                                for = "txtModelo" 
                                class="control-lable">Modelo
                            </label>
                            <input 
                                id="txtModelo" 
                                name="txtModelo" 
                                value=""
                                class="form-control"
                            />
                        </div>

    <div class="form-group">
        <input type="submit" name="Guardar" id="BtnGuardar" value="Agregar y Guardar" class="btn btn-primary"/>
        <a href="indexStatic.jsp?IdCliente=<%=id%>" class="btn btn-secondary">Regresar</a>
    </div>  

<br><br>
<%
//mensaje generado en en servlets facturas
if (request.getParameter("msgFac") != null) {
    out.print("<p class='text-danger'>" + new String(request.getParameter("msgFac").getBytes("ISO-8859-1"), "UTF-8") + "</p>");
    }
%>    

<!-- Modal de clientes --> 
<div class="modal" id="buscarCliente" tabindex="1" role="dialog" aria-labelledby="tituloVentana">
    <div class="modal-dialog" role="document"> 
        <div class="modal-content">
            <div class="modal-header">
                <h5 id="tituloVentaja">Buscar cliente</h5>
                <button class="close" data-dismiss="modal" aria-label="Cerrar" aria-hidden="true"
                    onclick="Limpiar()"> 
                  <span aria-hidden="true">&times;</span>
                </button> 
            </div> 
            <div class="modal-body">
            <!-- tabla de clientes --> 
            <table id="tablaClientes">
                <thead> 
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Seleccionar</th> 
                    </tr> 
                </thead>

                
 
<tbody>
<%
    BLClientes logicaClientes = new BLClientes();
    List<EntidadCliente> datosClientes;
    datosClientes = logicaClientes. ListarRegistros ("");
    for (EntidadCliente registroC : datosClientes) {
%>
<tr> 
    <%int codigoCliente = registroC.getId();
        String nombreCliente = registroC.getNombre();%>
        <td><%= codigoCliente%></td>
        <td><%= nombreCliente%></td> 
        <td>
            <a href="#" data-dismiss="modal"
                onclick="SeleccionarCliente('<%=codigoCliente%>', '<%= nombreCliente%>');">Seleccionar</a> 
        </td> 
</tr>
<%} %>
</tbody> 
</table> 
</div> <!-- modal body --> 
<div class="modal-footer"> 
<button class="btn btn-warning" type="button" data-dismiss="modal" onclick="Limpiar()">
    Cancelar 
</button> 
</div> 
</div> <!-- modal content -->
</div> <!-- modal dialog -->
</div> <!-- modal --> 


<!-- Modal de PRODUCTO -->

            <!-- tabla de clientes -->

       
            </div> 
        </div> <!-- modal content --> 
    </div> <!-- mnodal dialog --> 
</div> <!-- modal -->
  


<!-- Scripts requeridos --> 
<script src="lib/jquery/dist/jquery.min.js" type="text/javascript"></script>
<script src="lib/bootstrap/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
<script src="lib/bootstrap-datepicker/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
<script src="lib/bootstrap-datepicker/locales/bootstrap-datepicker.es.min.js" type="text/javascript"></script>
<script src="lib/DataTables/datatables.min.js" type="text/javascript"></script>
<script src="lib/DataTables/DataTables-1.10.21/js/dataTables.bootstrap4.min.js" type="text/javascript"></script>

<script>
//cuando el documento este listo 
//Cargue las siguientes funciones
$(document).ready(function () {
    //mostrar calendario 
    $('.datepicker').datepicker({
    format: 'yyyy-mm-dd',
    autoclose: true,
    language: 'es' 
}); 
//hacer que la lista de clientes se comporte como un datatable 
// Configurar la tabla clientes del modal 
$('#tablaClientes').dataTable({
   "lengthMenu": [[5, 15, 15, -1], [5, 10, 15, "All"]],
   "language": {
   "info": "Página_PAGE_de_PAGES_ ",
   "infoEmpty": "No existen Registros disponibles",
   "zeroRecords": "No se encuentran registros",
   "search": "Buscar",
   "infoFiltered": "",
   "lengthMenu": "Mostrar_MENU_ Registros",
   "paginate": {
        "first": "Primero",
        "last": "Último",
        "next": "Siguiente",
        "previous": "Anterior"
        }
   }
});


//Configura la tabla productos del modal
$('#tablaProductos').dataTable({
"lengthMenu": [[5, 15, 15, -1], [5, 10, 15, "All"]],
"language": {
    "info": "Página _PAGE_ de _PAGES_",
    "infoEmpty": "No existen Registros disponibles",
    "zeroRecords": "No se encuentran registros",
    "search": "Buscar",
    "infoFiltered": "",
    "lengthMenu": "",
    "paginate": {
        "first": "Primero",
        "last": "Último",
        "next": "Siguiente", 
        "previous": "Anterior"
        }
    }
});
});


//seleccionar cliente 
// estas funciones se llaman con un evento desde un modal 
function SeleccionarCliente(idCliente, nombreCliente) {
    $("#txtIdCliente").val(idCliente);
    $("#txtNombreCliente").val(nombreCliente);
}

//seleccionar producto 
function SeleccionarProducto(idProducto, Descripcion, Precio, Existencia) {
$("#txtIdProducto").val(idProducto);
$("#txtdescripcion").val(Descripcion);
$("#txtprecio").val(Precio);
$("#txtexistencia").val(Existencia);
$("#txtcantidad").focus();
}

// seleccionar cliente 
function Limpiar() {
$("#txtIdCliente").val("");
$("#txtNombreCliente").val("");
}
//seleccionar producto 
function LimpiarProducto() {
$("#txtIdProducto").val("");
$("#txtdescripcion").val("");
$("#txtprecio").val("");
$("#txtexistencia").val("");
}
        </script> 
    </body> 
</html>