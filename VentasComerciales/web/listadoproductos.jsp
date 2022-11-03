<%-- 
    Document   : listadoproductos
    Created on : 3 nov. 2022, 8:46:52
    Author     : Andres
--%>
<%@page import="connection.Producto"%>
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
            <div style="margin-left: 10%; width: 150px;">
            <a href="productos.jsp"><img src="imagenes/productos.jpg"  width="150px" height="100px"></a>
            <a href="listadoproductos.jsp"><img src="imagenes/listado-productos.jpg"  width="150px" height="30px"></a><br>
            <a href="nuevoproducto.jsp"><img src="imagenes/nuevo-producto.jpg" width="150px" height="30px"></a>
            <a href="modificarproducto.jsp"><img src="imagenes/modificar-producto.jpg" width="150px" height="30px"></a>
            
            </div>
            <div style="margin-left: 10%;">
            <a href="comerciales.jsp"><img src="imagenes/comerciales.jpg"  width="150px" height="100px"></a>
           
            </div>
            </div>
            <% ArrayList<Producto> lista= connection.DB.consultaProducto();
                
                %>
            <h2 style="text-align: center">Listado de Productos</h2>
            
            <table border="0" style="margin-left: 30%;">
            <thead>
                <tr style="background-color: grey">
                    <th>Referencia</th>
                    <th>Nombre</th>
                    <th>Descripcion</th>
                    <th>Precio</th>
                    <th>Descuento</th>
                </tr>
            </thead>
            <tbody>
                
                <% for (Producto producto : lista) {
   
                %>
                <tr>
                    <td><%= producto.getReferencia()%></td>
                    <td><%= producto.getNombre()%></td>
                    <td><%= producto.getDescripcion()%></td>
                    <td><%= producto.getPrecio() %></td>
                    <td><%= producto.getDescuento() %></td>
                </tr>
                
                <%}%>
                
            </tbody>
             </table>
        
        </div>
    </body>
</html>
