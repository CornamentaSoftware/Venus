/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 */
public class ConexionBD {
        
        public Connection getConexion(){
            Connection cn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://localhost/venus", "root", "n0m3l0");
                System.out.print("Conexion Satisfactoria");
            }
            catch (Exception e){
                System.out.print("Error de conexion: "+e);
            }
            return cn;
        }
}
