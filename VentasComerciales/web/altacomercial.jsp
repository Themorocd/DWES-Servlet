<%-- 
    Document   : altacomercial
    Created on : 3 nov. 2022, 19:16:39
    Author     : Andres
--%>
<%@page import="connection.comerciales"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div align="center">
            <h1>Aplicacion de gestion comercial</h1>
            <br><br><br><br>
             <div style="display: flex">
             <div style="margin-left: 25%; width: 150px;">
            <a href="ventas.jsp"><img src="imagenes/ventas.jpg" width="150px" height="100px"></a><br>
            </div>
            <div style="margin-left: 10%;">
            <a href="productos.jsp"><img src="imagenes/productos.jpg"  width="150px" height="100px"></a>
            </div>
            <div style="margin-left: 10%; width: 150px;">
            <a href="comerciales.jsp"><img src="imagenes/comerciales.jpg"  width="150px" height="100px"></a>
            <a href="listadocomerciales.jsp"><img src="imagenes/listado-comerciales.jpg"  width="150px" height="30px"></a><br>
            <a href="altacomercial.jsp"><img src="imagenes/alta-comerciales.jpg" width="150px" height="30px"></a>
           
            </div>
            </div>
        <% ArrayList<comerciales> listaComercial= connection.DB.listadoComercial();%>
            <h1 style="text-align: center">Añadir nuevo comercial</h1>
        
        <div style="margin-left: 38%">
            <form action="/VentasComerciales/AltaComercial" method="post">
            <br><br>
            <label for="Codigo">Codigo  </label>
            <input type="text" minlength="1" maxlength="6" name="Codigo" required/>
            <br><br>
            <label for="nombre">Nombre</label>
            <input type="text" name="nombre" required/>
            <br><br>
            <label for="Salario">Salario</label>
            <input type="number" name="Salario" required/>
            <br><br>
            <label for="Hijos">Hijos</label>
            <input type="number" name="Hijos" required/>
            <br><br>
            <label for="fecha">Fecha nacimiento</label>
            <input type="date" name="fecha"  required/>
            <br><br>
            <input type="submit" value="aceptar"/>
            <input type="reset" value="cancelar"/>
            </form>
        </div>
    </body>
</html>
