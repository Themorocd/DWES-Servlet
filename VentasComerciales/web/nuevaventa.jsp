<%-- 
    Document   : nuevaventa
    Created on : 2 nov. 2022, 10:55:08
    Author     : Andres
--%>
<%@page import="connection.comerciales"%>
<%@page import="connection.ventas"%>
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
            <a href="listadoventas.jsp"><img src="imagenes/listado-ventas.jpg"  width="150px" height="30px"></a><br>
            <a href="nuevaventa.jsp"><img src="imagenes/nueva-venta.jpg" width="150px" height="30px"></a>
            </div>
            <div style="margin-left: 10%;">
            <a href="productos.jsp"><img src="imagenes/productos.jpg"  width="150px" height="100px"></a>
            </div>
            <div style="margin-left: 10%;">
            <a href="comerciales.jsp"><img src="imagenes/comerciales.jpg"  width="150px" height="100px"></a>
           
            </div>
            </div>
            <h1 style="text-align: center">Añadir una nueva venta</h1>
        
        <div style="margin-left: 38%">
        
        <form action="/VentasComerciales/NuevaVenta" method="post">
            
            <% ArrayList<comerciales> listaComercial= connection.DB.listadoComercial(); %>
            
            <label for="comercial">Comercial</label>
            <select name="comercial">
                <option value="0">Selecciona un comercial</option>
                
                <% for (comerciales comerciales : listaComercial) {  
                %>
                
                
                <option value="<%= comerciales.getCodigo() %>"><%= comerciales.getNombre() %></option>
                
                <%}%>
            </select>
            
            <% ArrayList<Producto> listaProducto= connection.DB.listadoProducto(); %>
            <br>
            <br>
            <label for="producto">Producto</label>
            <select name="producto">
                <option value="0">Selecciona un producto</option>
                
                <% for (Producto producto : listaProducto) {  
                %>
                
                
                <option value="<%= producto.getReferencia() %>"><%= producto.getNombre() %> - <%= producto.getDescripcion() %></option>
                
                <%}%>
            </select>
            <br><br>
            <label for="cantidad">Cantidad:</label>
            <input type="number" minlength="1" maxlength="3" name="cantidad"/>
            <br><br>
            <label for="fecha">Fecha de via:</label>
            <input type="date" name="fecha"   placeholder="yyyy-mm-dd"/>
            <br><br>
            <input type="submit" value="aceptar"/>
            <input type="reset" value="cancelar"/>
        </form>
   
            </div>
        </div>
    </body>
</html>
