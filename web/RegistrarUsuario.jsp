<%-- 
    Document   : RegistrarUsuario
    Created on : 10/05/2021, 09:02:25 AM
    Author     : JUAN DAVID PACHON
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registrar Usuario</h1>
        <form method="post" action ="Usuario">
              <table>
                  <tr>
                    Usuario:<br>
                    <input type="text" name="textUsuario"><br>
                     Contraseña:<br>
                    <input type=password" name="textClave"><br>
                  </tr>
            </table><br>
            <button>Registrarse</button>
            <input type ="hidden"value="1" name =" opcion">
            </table>
        </form>     
        <div>
            <% if (request.getAttribute("mensajeError")!=null){%>
            <div style="color: red;">
                ${mensajeError}
                 
            </div>
            <%} else {%>
            <div style="color: blue">
                ${mensajeExito}
            </div>
                <% }%>
            
        </div>
    </body>
</html>
