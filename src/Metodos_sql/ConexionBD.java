/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos_sql;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author jtodd
 */
public class ConexionBD {
    
    public static String url = "jdbc:mysql://localhost/login_bd";
    public static String usuario = "root";
    public static String contraseña = "root";
    public static String clase ="com.mysql.cj.jdbc.Driver";
    
    public static Connection conectar(){
        Connection conexion = null;
        //DriverManager.getConnection(url,usuario,contraseña)
        try {
             Class.forName(clase);
             conexion = DriverManager.getConnection(url,usuario,contraseña);
             System.out.println("conexion establecida");
        }  catch (Exception e) {   
            
            System.out.println(e);
        }
        return conexion; 
    
    }

    public PreparedStatement prepareStatement(String SQL) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
