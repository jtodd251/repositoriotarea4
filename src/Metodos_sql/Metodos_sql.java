/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos_sql;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author jtodd
 */
public class Metodos_sql {
    
    public static ConexionBD conexion = new ConexionBD();
    
    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static ResultSet res;
    public static String sql;
    public static int resultado_numero = 0;
    
    public int Eliminar(int idusuario ){
        
        int resultado = 0;
        Connection conexion= null;
        
        String sentencia_eliminar = ("DELETE FROM usuario WHERE idusuario=?");
        
        try { 
            conexion =  ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_eliminar);
            sentencia_preparada.setInt(1, idusuario);

            
            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
            
            conexion.close();
        
        } catch (Exception e){
            
            System.out.println(e);
        
        }
        
        return resultado;
    
    }
    
    public int Actualizar(String nombre, String apellidos, String telefono, String correo, String contraseña,String usuario, int idusuario){
        
        int resultado = 0;
        Connection conexion= null;
        
        String sentencia_guardar = ("UPDATE usuario SET nombre=?,apellidos=?,telefono=?,contraseña=?,correo=?,usuario=? WHERE idusuario=?");
        
        try { 
            conexion =  ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setInt(7, idusuario);
            sentencia_preparada.setString(1, nombre);
            sentencia_preparada.setString(2, apellidos);
            sentencia_preparada.setString(3, telefono);
            sentencia_preparada.setString(4, contraseña);
            sentencia_preparada.setString(5, correo);
            sentencia_preparada.setString(6, usuario);
            if(nombre.equals("")){
                    JOptionPane.showMessageDialog(null, "Falta el nommbre");
                    }
            else if(apellidos.equals("")){
                JOptionPane.showMessageDialog(null, "Falta el apellido");
            }
            else if(telefono.equals("")){
                JOptionPane.showMessageDialog(null, "Falta el telefono");
            }
            else if(contraseña.equals("")){
                JOptionPane.showMessageDialog(null, "Falta la contraseña");
            }
            else if(correo.equals("")){
                JOptionPane.showMessageDialog(null, "Falta la correo");
            }
            else if(usuario.equals("")){
                JOptionPane.showMessageDialog(null, "Falta el usuario");
            }
            
            else{
            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
            
            conexion.close();
            }
        
        } catch (Exception e){
            
            System.out.println(e);
        
        }
        
        return resultado;
    
    }
   
    
    public int guardar(String nombre, String apellidos, String telefono, String correo, String contraseña,String usuario,String ccontraseña ){
        
        int resultado = 0;
        Connection conexion= null;
        
        String sentencia_guardar = ("INSERT INTO usuario(nombre,apellidos,telefono,contraseña,correo,usuario) VALUES (?,?,?,?,?,?)");
        
        try { 
            conexion =  ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, nombre);
            sentencia_preparada.setString(2, apellidos);
            sentencia_preparada.setString(3, telefono);
            sentencia_preparada.setString(4, contraseña);
            sentencia_preparada.setString(5, correo);
            sentencia_preparada.setString(6, usuario);
            
            if(nombre.equals("")){
                    JOptionPane.showMessageDialog(null, "Falta el nommbre");
                    }
            else if(apellidos.equals("")){
                JOptionPane.showMessageDialog(null, "Falta el apellido");
            }
            else if(telefono.equals("")){
                JOptionPane.showMessageDialog(null, "Falta el telefono");
            }
            else if(contraseña.equals("")){
                JOptionPane.showMessageDialog(null, "Falta la contraseña");
            }
            else if(correo.equals("")){
                JOptionPane.showMessageDialog(null, "Falta la correo");
            }
            else if(usuario.equals("")){
                JOptionPane.showMessageDialog(null, "Falta el usuario");
            }
            else if(ccontraseña != contraseña){
                JOptionPane.showMessageDialog(null, "La confirmacion de la contraseña no coincide");
            }
            else{
            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();
            
            conexion.close();
            if(resultado>0){
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente.");
                
            }
            }
        
        } catch (Exception e){
            
            System.out.println(e);
        
        }
        
        return resultado;
    
    }
public static String buscarNombre (String usuario){
    
    String busqueda_nombre = null;
    Connection conexion = null;
    try {
        conexion = ConexionBD.conectar();
        String sentencia_buscar = ("SELECT nombre,apellidos FROM usuario WHERE usuario= '"+ usuario + "'");
        sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
        resultado = sentencia_preparada.executeQuery();
        if(resultado.next()){
            String nombre = resultado.getString("nombre");
            String apellidos = resultado.getString("apellidos");
            busqueda_nombre = (nombre+" "+apellidos);
        
        }
        
        conexion.close();
    } catch (Exception e){
        
        System.out.println(e);
        
        
    }
    
    return busqueda_nombre;


}

public static String buscarUsuarioRegistrado(String usuario,String contraseña){
    String busqueda_usuario = null;
    Connection conexion = null;
    
    try {
        conexion = ConexionBD.conectar();
        String sentencia_buscar_usuario = ("SELECT nombre,usuario,contraseña FROM usuario WHERE usuario = '"+usuario+"'"+" && contraseña = '"+contraseña+"'");
        sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
        resultado = sentencia_preparada.executeQuery();
        
        if(resultado.next()){
            busqueda_usuario = "usuario encontrado";
        
        } else {
            busqueda_usuario = "usuario no encontrado";
        
        }
        
        conexion.close();
        
    
    
    
    }catch (Exception e){
        System.out.println(e);
    
    }
    
    return busqueda_usuario;

}


    
    
    

}


    