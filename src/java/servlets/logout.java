/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Usuario
 */
public class logout extends HttpServlet {

//////  //método encargado de la gestión del método GET
//////    protected void processRequestGET(HttpServletRequest request, HttpServletResponse response)
//////            throws ServletException, IOException {
//////
//////        //me llega la url "proyecto/login/out"
//////        String action = (request.getPathInfo() != null ? request.getPathInfo() : "");
//////        HttpSession sesion = request.getSession();
//////        if (action.equals("/out")) {
//////            sesion.invalidate();
//////            response.sendRedirect("Plantillas/Inicio.html");
//////        } else {
////////....
//////        }
//////    }
    //Ya sea que el método sea por GET o POST, cerraremos la sesion.
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession sesion = request.getSession(true);

        //Cerrar sesion
        sesion.invalidate();

        //Redirecciono a index.jsp
        response.sendRedirect("Plantillas/Inicio.html");

    }

}
