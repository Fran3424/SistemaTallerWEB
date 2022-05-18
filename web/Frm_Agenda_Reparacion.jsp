<%-- 
    Document   : Frm_Agenda_Reparacion
    Created on : 11 may. 2022, 07:34:37
    Author     : Fran
--%>

<%@page import="CapaLogica.BLReparaciones"%>
<%@page import="Capa_Entidades.*"%>
<%@page import="Capa_Entidades.EntidadAutomovil"%>
<%@page import="CapaLogica.*"%>
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
    <header>
 </header> 
    <div class="container"> 
        <div class-"row">
            <div class="col-10"><h1>Agenda una Reparacion</h1></div>
    </div>
        
   
        
<div class="container"> 
    <div class="row">
        <div class="col-10"><hl></h1></div>
</div>
    
<%
int numFactura = -1;
double total = 0;
EntidadAutomovil Auto = new EntidadAutomovil();

BLAuto logicaAuto = new BLAuto();

EntidadEmpleado empleado = new EntidadEmpleado();

Entidad_Servicio servicio= new Entidad_Servicio();

BLEmpleados logicaEmpleado = new BLEmpleados();




%>    
<br/>

<!-- Formulario para los datos de la factura --> 
<form action="AgendarReparacion" method="post">
    <div class="form-group float-center" >
        

    <br/> 
    <div class="form-group"> 
        <div class="input-group">
            <input type="hidden" id="txtIdAuto" name="txtIdAuto" value="<%=Auto.getId()%>"
                   readonly="" class="form-control"/> 
            <input type="text" id="txtModelo" name="txtModelo"
                   value="<%=Auto.getModelo()%>" readonly="" class="form-control"
                   placeholder="Seleccione un Auto"/>&nbsp;&nbsp;
            <a id="btnbuscar" class="btn btn-success" data-toggle="modal"
                data-target="#buscarAuto"><i class="fas fa-search"></i></a> 
        </div> 
    </div>

               
       <div class="form-group"> 
        <div class="input-group">
            <input type="hidden" id="txtIdEmpleado" name="txtIdEmpleado" value="<%=empleado.getId()%>"
                   readonly="" class="form-control"/> 
            <input type="text" id="txtNombreEmpleado" name="txtNombreEmpleado"
                   value="<%=empleado.getNombre()%>" readonly="" class="form-control"
                   placeholder="Seleccione un Empleado"/>&nbsp;&nbsp;
            <a id="btnbuscar2" class="btn btn-success" data-toggle="modal"
                data-target="#buscarEmpleado"><i class="fas fa-search"></i></a> 
        </div> 
    </div>               

                   
        <div class="form-group"> 
        <div class="input-group">
            <input type="hidden" id="txtIdServicio" name="txtIdServicio" value="<%=servicio.getId()%>"
                   readonly="" class="form-control"/> 
            <input type="text" id="txtNombreServicio" name="txtNombreServicio"
                   value="<%=servicio.getNombre()%>" readonly="" class="form-control"
                   placeholder="Seleccione un Servicio"/>&nbsp;&nbsp;
              
            <a id="btnbuscar2" class="btn btn-success" data-toggle="modal"
                data-target="#buscarServicio"><i class="fas fa-search"></i></a> 
        </div> 
    </div>                  
                   
                   
                   
                   
                   
                   
 
<div class="float-right">
    
</div> 
        <div> 
             <input type="text" id="txtMonto" name="txtMonto"
                   value="<%=servicio.getPrecio()%>" readonly="" class="form-control"
                   placeholder="Esperando Monto"/>&nbsp;&nbsp;
                   
                     <div> 
                            <label 
                                for = "txtFechaInicio" 
                                class="control-lable">Fecha Inicio
                            </label>
                            <input 
                                id="txtFechaInicio" 
                                name="txtFechaInicio" 
                                value=""
                                class="datepicker form-control"
                            />
                        </div>
                   
                         <div> 
                            <label 
                                for = "txtFechaFin" 
                                class="control-lable">Fecha Fin
                            </label>
                            <input 
                                id="txtFechaFin" 
                                name="txtFechaFin" 
                                value=""
                                class="datepicker form-control"
                            />
                        </div>
                   
    <div class="form-group">
        <input type="submit" name="Guardar" id="BtnGuardar" value="Agregar y Guardar" class="btn btn-primary"/>
    </div>  

<br><br>
<%
//mensaje generado en en servlets facturas
if (request.getParameter("msgFac") != null) {
    out.print("<p class='text-danger'>" + new String(request.getParameter("msgFac").getBytes("ISO-8859-1"), "UTF-8") + "</p>");
    }
%>    

<!-- Modal de clientes --> 
<div class="modal" id="buscarEmpleado" tabindex="1" role="dialog" aria-labelledby="tituloVentana1">
    <div class="modal-dialog" role="document"> 
        <div class="modal-content">
            <div class="modal-header">
                <h5 id="tituloVentana1">Buscar Auto</h5>
                <button class="close" data-dismiss="modal" aria-label="Cerrar" aria-hidden="true"
                    onclick="Limpiar()"> 
                  <span aria-hidden="true">&times;</span>
                </button> 
            </div> 
            <div class="modal-body">
            <!-- tabla de clientes --> 
            <table id="tablaEmpleados">
                <thead> 
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Seleccionar</th> 
                    </tr> 
                </thead>

                
 
<tbody>


<%
    BLEmpleados logicaEmpleados = new BLEmpleados();
    List<EntidadEmpleado> datosEmpleado;
    datosEmpleado = logicaEmpleados.ListarEmpleados("");
    for (EntidadEmpleado registroE : datosEmpleado) {
%>
<tr> 
    <%int codigoEmpleado = registroE.getId();
        String nombreEmpleado = registroE.getNombre();%>
        <td><%= codigoEmpleado%></td>
        <td><%= nombreEmpleado%></td> 
        <td>
            <a href="#" data-dismiss="modal"
                onclick="SeleccionarEmpleado('<%=codigoEmpleado%>', '<%= nombreEmpleado%>');">Seleccionar</a> 
        </td> 
</tr>
<%} %>
</tbody>
</table>
</div>
<div class="modal-footer"> 
<button class="btn btn-warning" type="button" data-dismiss="modal" onclick="Limpiar()">
    Cancelar 
</button> 
</div> 
</div>
</div>   
</div>   





<div class="modal" id="buscarAuto" tabindex="1" role="dialog" aria-labelledby="tituloVentana2">
    <div class="modal-dialog" role="document"> 
        <div class="modal-content">
            <div class="modal-header">
                <h5 id="tituloVentana2">Buscar Auto</h5>
                <button class="close" data-dismiss="modal" aria-label="Cerrar" aria-hidden="true"
                    onclick="Limpiar()"> 
                  <span aria-hidden="true">&times;</span>
                </button> 
            </div> 
            <div class="modal-body">
            <!-- tabla de clientes --> 
            <table id="tablaAutos">
                <thead> 
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Seleccionar</th> 
                    </tr> 
                </thead>

                
 
<tbody>
<%
    BLAuto logicaAutos = new BLAuto();
    List<EntidadAutomovil> datosClientes;
    datosClientes = logicaAutos.ListarAutos("");
    for (EntidadAutomovil registroA : datosClientes) {
%>
<tr> 
    <%int codigoCliente = registroA.getId();
        String nombreCliente = registroA.getModelo();%>
        <td><%= codigoCliente%></td>
        <td><%= nombreCliente%></td> 
        <td>
            <a href="#" data-dismiss="modal"
                onclick="SeleccionarAuto('<%=codigoCliente%>', '<%= nombreCliente%>');">Seleccionar</a> 
        </td> 
</tr>
<%} %>
</tbody>
</table>
</div>
<div class="modal-footer"> 
<button class="btn btn-warning" type="button" data-dismiss="modal" onclick="Limpiar()">
    Cancelar 
</button> 
</div> 
</div>   
</div>   
</div>   

<!-- Modal de clientes --> 
<div class="modal" id="buscarServicio" tabindex="1" role="dialog" aria-labelledby="tituloVentana3">
    <div class="modal-dialog" role="document"> 
        <div class="modal-content">
            <div class="modal-header">
                <h5 id="tituloVentana3">Buscar Servicio</h5>
                <button class="close" data-dismiss="modal" aria-label="Cerrar" aria-hidden="true"
                    onclick="Limpiar()"> 
                  <span aria-hidden="true">&times;</span>
                </button> 
            </div> 
            <div class="modal-body">
            <!-- tabla de clientes --> 
            <table id="tablaServicios">
                <thead> 
                    <tr>
                        <th>Código</th>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Seleccionar</th> 
                    </tr> 
                </thead>

                
 
<tbody>
<%
    BLServicios logicaServicio = new BLServicios();
    List<Entidad_Servicio> datosServicios;
    datosServicios = logicaServicio.ListarServicios("");
    for (Entidad_Servicio registroA : datosServicios) {
%>
<tr> 
    <%int codigoCliente = registroA.getId();
        String nombreCliente = registroA.getNombre();
        int precioServicio = registroA.getPrecio();
    
    %>
        <td><%= codigoCliente%></td>
        <td><%= nombreCliente%></td>
        <td><%= precioServicio %></td> 
        <td>
            <a href="#" data-dismiss="modal"
                onclick="SeleccionarServicio('<%=codigoCliente%>', '<%= nombreCliente%>','<%= precioServicio%>');">Seleccionar</a> 
        </td> 
</tr>
<%} %>
</tbody>
</table>
</div>
<div class="modal-footer"> 
<button class="btn btn-warning" type="button" data-dismiss="modal" onclick="Limpiar()">
    Cancelar 
</button> 
</div> 
</div>   
</div>   
</div>   






























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
$('#tablaAutos').dataTable({
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
$('#tablaEmpleados').dataTable({
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





$('#tablaServicios').dataTable({
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
function SeleccionarEmpleado(idCliente, nombreCliente) {
    $("#txtIdEmpleado").val(idCliente);
    $("#txtNombreEmpleado").val(nombreCliente);
}

//seleccionar producto 
function SeleccionarAuto(idCliente, nombreCliente) {
$("#txtIdAuto").val(idCliente);
$("#txtModelo").val(nombreCliente);
}

function SeleccionarServicio(idCliente, nombreCliente,precioServicio) {
$("#txtIdServicio").val(idCliente);
$("#txtNombreServicio").val(nombreCliente);
$("#txtMonto").val(precioServicio);
}


// seleccionar cliente 
function Limpiar() {
$("#txtIdAuto").val("");
$("#txtModelo").val("");
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