/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ana
 */
public class Registro extends HttpServlet {

public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ConexionBD conect = new ConexionBD();
        Statement stm = null;
        response.setContentType("text/html;charset=UTF-8");
       
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellido");
        String nombreCompleto = (nombre + " "  + apellidos);
        String correo = request.getParameter("correo");
        String username = request.getParameter("username");
        String contra = request.getParameter("contrasenia");
        
        Connection conexion = conect.getConexion();
        try {
            stm = (Statement) conexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            try{
                stm.executeUpdate("insert into Usuario(Nombre_Usuario, Apellido_Usuario, Correo_Usuario, Username_Usuario, Contrasenia_Usuario)"
                        + "values('" + nombre + "','" + apellidos + "','" + correo + "', '" + username + "','" + contra + "');");
                conexion.close();
                response.sendRedirect("/Venus/Ingresar.html");
            }catch(SQLException error)
            {
                System.out.println(error.toString());
            }
            
        
    }
}
