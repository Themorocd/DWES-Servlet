/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import connection.comerciales;
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
public class AltaComercial extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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
        
        String Codigo=request.getParameter("Codigo");
        String nombre=request.getParameter("nombre");
        double Salario= Integer.parseInt(request.getParameter("Salario"));
        int Hijos=Integer.parseInt(request.getParameter("Hijos"));
        String fecha=request.getParameter("fecha");
        
        comerciales comercial= new comerciales(Codigo, nombre, Salario, Hijos, fecha);
        connection.DB.altaComercial(comercial);
        contex.setAttribute("comercial", comercial);
        rd=request.getRequestDispatcher("altacomercial.jsp");
        rd.forward(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
