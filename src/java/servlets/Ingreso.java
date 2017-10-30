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
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ingreso extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String user, contra;
        ConexionBD conect = new ConexionBD();
        Statement stm = null;
        ResultSet result;
        response.setContentType("text/html;charset=UTF-8");
       
        user = request.getParameter("user");
        contra = request.getParameter("contra");
        
        Connection conexion = conect.getConexion();
        try {
            stm = (Statement) conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Ingreso.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            result = stm.executeQuery("Select * from usuario where Nombre_Usuario = '" + user + "' && Contrasenia_Usuario = '" + contra + "';");
            if(result.first()){
                //si coincide usuario y password y además no hay sesión iniciada
                sesion.setAttribute("usuario", user);
//                  redirijo a página con información de login exitoso
                response.sendRedirect("../Venus/Plantillas/Menu.html");
            }
            else{
                //lógica para login inválido
                response.sendRedirect("../Venus/Plantillas/Inicio.html");
            }
        }catch(SQLException error)
        {
            System.out.println(error.toString());
        }
            
        
        
    }

}