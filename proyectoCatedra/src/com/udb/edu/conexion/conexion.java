package com.udb.edu.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.udb.edu.clases.administrador;
import com.udb.edu.clases.usuariosAdmin;

public class conexion {


    
 String based = "Proyecto_Catedra2019";
 String url = "jdbc:mysql://localhost:3306/Proyecto_Catedra2019";
 String user = "root";
 String pass = "";
 Connection conn = null;
 PreparedStatement prepSt = null;
 Statement st = null;
 ResultSet rs = null;
      String valorU ;
     String valorD;
 
    public conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//fin constructor
    
    
public boolean obtenerUsuario(String usuario,String contra) throws SQLException {

   
         conn = DriverManager.getConnection(this.url, this.user, this.pass);
           String sql = "select * from agregar_usuarios where nombre_usuario = ?  and contrasena_usuario = ?";
          prepSt = conn.prepareStatement(sql);
            
            prepSt.setString(1,usuario);
            prepSt.setString(2, contra);
          rs = prepSt.executeQuery();
             while(rs.next()){
          valorU = rs.getString(2);
         valorD = rs.getString(3);
         if(valorU.equals(usuario) && valorD.equals(contra)){
         return true;
         }
          }
     
     return false;   
} // fin metodo usuario

public ArrayList<administrador> obtenerUsuarios(){
        
        ArrayList<administrador> listaUsuarios = new ArrayList<administrador>();
       try {
            
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            
            String sql = "SELECT * FROM empleados order by nombre";
            
            prepSt = conn.prepareStatement(sql);
            
            rs = prepSt.executeQuery();
            
            while(rs.next()){
             
                String nombre = rs.getString("nombre");
               String apellido = rs.getString("apellidos");
               String telefono = rs.getString("telefono");
               String departamento = rs.getString("departamento");
                
                administrador ad = new administrador(nombre,apellido,telefono,departamento);
                listaUsuarios.add(ad);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepSt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
       return listaUsuarios;
    }
    
    public ArrayList<usuariosAdmin> obtenerAdministradores(){
        
        ArrayList<usuariosAdmin> listaAdministradores = new ArrayList<usuariosAdmin>();
       try {
            
            conn = DriverManager.getConnection(this.url, this.user, this.pass);
            
            String sql = "SELECT * FROM agregar_usuarios order by nombre_usuario";
            
            prepSt = conn.prepareStatement(sql);
            
            rs = prepSt.executeQuery();
            
            while(rs.next()){
             
                String nombre = rs.getString("nombre_usuario");
               String contra = rs.getString("contrasena_usuario");
               String cargo = rs.getString("cod_jefatura");
               
                usuariosAdmin uA = new usuariosAdmin(nombre,contra,cargo);
                listaAdministradores.add(uA);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepSt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
       return listaAdministradores;
    }
    
public void borrarAdministrador(usuariosAdmin usuario){
        try {
            
              conn = DriverManager.getConnection(this.url, this.user, this.pass);
            
            String sql = "DELETE FROM agregar_usuarios WHERE nombre_usuario=?";
            
            prepSt = conn.prepareStatement(sql);
            
            prepSt.setString(1, usuario.getNombre());
 
            prepSt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepSt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

public void borrarUsuario(administrador usuario){
        try {
            
              conn = DriverManager.getConnection(this.url, this.user, this.pass);
            
            String sql = "DELETE FROM agregar_usuarios WHERE nombre_usuario=?";
            
            prepSt = conn.prepareStatement(sql);
            
            prepSt.setString(1, usuario.getNombre());
 
            prepSt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally{
            try {
                prepSt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}// fin clase principal
