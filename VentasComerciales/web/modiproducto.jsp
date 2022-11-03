<%-- 
    Document   : modiproducto
    Created on : 3 nov. 2022, 10:08:23
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
            <h2 style="text-align: center">Modificar un Producto</h2>
        
        <div style="margin-left: 40%">
               <% 
            
            String referencia= request.getParameter("sel");
            
            
            ArrayList<Producto> listaProducto= connection.DB.listadoProducto();
            %>
             <div style="margin-left: 38%">
            <form action="/VentasComerciales/ModificoProducto" method="post">
            <br><br>
            <label for="referencia">Referencia</label>
            <input type="text" minlength="6" maxlength="6" name="referencia"/>
            <br><br>
            <label for="nombre">Nombre</label>
            <input type="text" name="nombre"/>
            <br><br>
            <label for="descripcion">Descripcion</label>
            <input type="text" name="descripcion"/>
            <br><br>
            <label for="precio">Precio</label>
            <input type="text" name="precio"/>
            <br><br>
            <label for="descuento">Descuento</label>
            <input type="text" name="descuento"/>
            <br><br>
            <input type="submit" value="aceptar"/>
            <input type="reset" value="cancelar"/>
            </form>
        </div
        </div>
    </body>
</html>
