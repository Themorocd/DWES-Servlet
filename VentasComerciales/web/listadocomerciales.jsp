<%-- 
    Document   : listadocomerciales
    Created on : 3 nov. 2022, 19:08:53
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
            <% ArrayList<comerciales> listaComercial= connection.DB.listadoComercial();
                
                %>
            <h2 style="text-align: center">Listado de Productos</h2>
            
            <table border="0" style="margin-left: 30%;">
            <thead>
                <tr style="background-color: grey">
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Salario</th>
                    <th>Hijos</th>
                </tr>
            </thead>
            <tbody>
                
                <% for (comerciales comercial : listaComercial) {
   
                %>
                <tr>
                    <td><%= comercial.getCodigo()%></td>
                    <td><%= comercial.getNombre()%></td>
                    <td><%= comercial.getSalario()%></td>
                    <td><%= comercial.getHijos() %></td>
                    
                </tr>
                
                <%}%>
                
            </tbody>
             </table>
        </div>
    </body>
</html>
