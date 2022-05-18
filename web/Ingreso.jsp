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
        
        <div class="container">
            <div class="row">
                <div class="col-md-4 mx-auto">
                    <div class="card-header">            
                        <h1>Ingreso</h1>
                    </div><br>
                     <form action="Ingresar" method="post" >
                         
                        <div> 
                            <label 
                                for = "txtUsuario" 
                                class="control-lable">Usuario
                            </label>
                            <input 
                                id="txtUsuario" 
                                name="txtUsuario"  
                                value=""
                                class="form-control"
                            />
                        </div>
                        <div> 
                            <label 
                                for = "txtContra" 
                                class="control-lable">Contraseña
                            </label>
                            <input 
                                id="txtContra" 
                                name="txtContra" 
                                value=""
                                class="form-control"
                            />
                        </div>
                         
                              <div class="form-group">
                            <div class="input-group">
                                <a href="Frm_Automovil.jsp?txtIdCliente=1">
                                <input 
                                    type="submit" 
                                    id="btnIngresar" 
                                    value="Ingreso"
                                    class="btn btn-primary"&nbsp;&nbsp
                                    
                                />
                                </a>
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
 
    </body>
</html>
