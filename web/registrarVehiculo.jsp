<%-- 
    Document   : registrarVehiculo
    Created on : 24/05/2021, 08:08:07 AM
    Author     : JUAN DAVID PACHON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Vehiculo</title>
    </head>
    <body>
    <center>
        <h1>Registrar Vehiculo</h1>
        <form method="post" action="Vehiculo">
            <table>
                <tr>
                    <th>
                        PLACA <br>
                        <input type="text" name="textPlaca"> <br>
                        DATOS <br>
                        <input type="text" name="textDatos"><br> 
                        CATEGORIA <br>
                        <input type="text" name="textCategoria"> <br>   
                        MODELO <br>
                        <input type="text" name="textModelo"> <br>   
                        MARCA <br>
                        <input type="text" name="textMarca"> <br>  
                        ESTADO <br>
                        <input type="text" name="textEstado"> <br>  
                        PRECIO <br>
                        <input type="text" name="textPrecio"> <br>   
                    </th>
                </tr>
            </table>
            <button>Registrar</button>
            <input type="hidden" value="1" name="opcion">
        </form>
        <div>
            <% if (request.getAttribute("mensajeError")!= null) {%>
            <div style="color: red;">${mensajeError} </div>
            <%}else{%>
            <div style="color: blue;">${mensajeExito}</div>
         <% }%>
        </div>
    </center>
    </body>
</html>
