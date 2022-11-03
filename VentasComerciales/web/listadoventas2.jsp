<%-- 
    Document   : listadoventas2
    Created on : 2 nov. 2022, 10:20:17
    Author     : Andres
--%>
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
                 <% 
            
            String referencia= request.getParameter("sel");
            
            
            ArrayList<ventas> listaventa= connection.DB.consultaVentas(referencia); %>
            
            <h1 style="text-align: center">LISTADO DE VENTAS</h1>
        
            <table border="0" style="margin-left: 30%;">
            <thead>
                <tr style="background-color: grey">
                    <th>Fecha</th>
                    <th>Comercial</th>
                    <th>Cantidad</th>
                    <th>Precio</th>
                    <th>Total</th>
                    <th>Descuento</th>
                    <th>Total Descuento</th>
                </tr>
            </thead>
            <tbody>
                
                <% for (ventas venta : listaventa) {
   
                %>
                <tr>
                    <td><%= venta.getFecha()%></td>
                    <td><%= venta.getComercial()%></td>
                    <td><%= venta.getCantidad()%></td>
                    <td><%= venta.getPrecio() %></td>
                    <td><%= Math.round(venta.getTotal()*100.0)/100.0%></td>
                    <td><%= venta.getDescuento() %></td>
                    <td><%= Math.round(venta.getTotalDescuento()*100.0)/100.0 %></td>
                </tr>
                
                <%}%>
                
            </tbody>
             </table>
                
          
    </body>
</html>
