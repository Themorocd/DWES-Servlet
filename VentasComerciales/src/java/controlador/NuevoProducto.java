/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import connection.Producto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Andres
 */
public class NuevoProducto extends HttpServlet {

    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ServletContext contex= getServletContext();
        RequestDispatcher rd;
        
        String referencia=request.getParameter("referencia");
        String nombre=request.getParameter("nombre");
        String descripcion=request.getParameter("descripcion");
        double precio= Integer.parseInt(request.getParameter("precio"));
        int descuento=Integer.parseInt(request.getParameter("descuento"));
       
        
        Producto producto= new Producto(referencia, nombre, descripcion, precio, descuento);
        connection.DB.insertarProducto(producto);
        contex.setAttribute("producto", producto);
        rd=request.getRequestDispatcher("nuevoproducto.jsp");
        rd.forward(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
