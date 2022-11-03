<%-- 
    Document   : listadoventas
    Created on : 2 nov. 2022, 10:18:27
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
            
                 <h2 style="text-align: center">Listado de ventas</h2>
        
        <div style="margin-left: 40%">
 
            
            <form action="/VentasComerciales/listadoventas2.jsp">
                
                <% ArrayList<Producto> lista= connection.DB.consultaProducto();
                
                %>
                
                <select name="sel">
                    <option value="0">Seleccione un producto</option>
                    <% for (Producto producto : lista) {
                        
                    %>
                    
                    <option value="<%= producto.getReferencia() %>"><%= producto.getNombre()%> - <%= producto.getDescripcion()%></option>
                    <%}%>
                </select><br><br>
                
                <div style="margin-left: 80px">
                <input type="submit" value="Aceptar">
                <input type="reset" value="Cancelar">
                </div>
                
            </form>
            
        </div>
    </body>
</html>
