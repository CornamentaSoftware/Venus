/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
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
public class servletSession extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String usu, pass;
        usu = request.getParameter("user");
        pass = request.getParameter("contra");
        if (usu.equals("admin") && pass.equals("admin") && sesion.getAttribute("usuario") == null) {
            //si coincide usuario y password y además no hay sesión iniciada
            sesion.setAttribute("usuario", usu);
            //redirijo a página con información de login exitoso
            response.sendRedirect("Perfil.html");
//            response.setContentType("text/html");
//            //Mostramos los  valores en el cliente
//            PrintWriter out = response.getWriter();
//
//            out.println("<a href=\"/EjemploSession/catalogo.jsp\"> Link al catalogo del carrito  </a>");
//            out.println("<br>");
//            out.println("ID de la sesi&oacute;n: " + sesion.getId());
//
//            out.println("<br>Hora actual ");
//            out.println("<br>Creación:  ");
//            out.println("<br>Última vez accesada:  ");
        } else {
            //lógica para login inválido
        }
    }

}
