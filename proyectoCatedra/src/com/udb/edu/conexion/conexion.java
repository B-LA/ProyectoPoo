package com.udb.edu.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import com.udb.edu.clases.administrador;
import com.udb.edu.clases.modificarAdmin;
import com.udb.edu.clases.principal;
import com.udb.edu.clases.usuariosAdmin;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class conexion {


 String based = "Proyecto_Catedra2019"; //nombre de la base de datos
 String url = "jdbc:mysql://localhost:3306/Proyecto_Catedra2019"; //la URl donde esta ubicada la base de datos
 String user = "root"; //usuario
 String pass = ""; //password
 Connection conn = null; //Definimos un objeto connection en null
 PreparedStatement prepSt = null; //Definimos un  prepareStatement
 ResultSet rs = null; //Definimos un result set
 String valorU ; 
 String valorD;
 
    public conexion(){ //constructor de la clase
        try { 
            Class.forName("com.mysql.jdbc.Driver"); //se instancia el driver
        } catch (ClassNotFoundException ex) { //aqui esta la exepcion
            ex.printStackTrace(); //nuestra la exepcion
        }
    }//fin constructor
    
    
public boolean obtenerUsuario(String usuario,String contra) throws SQLException {// se define el metodo de para obtener los usuarios

    principal p = new principal();  //se instancia un objeto de la clase principal
         conn = DriverManager.getConnection(this.url, this.user, this.pass); //se instancia la conexion
           String sql = "select * from agregar_usuarios where nombre_usuario = ?  and contrasena_usuario  = ?"; //se define la consulta sql
          prepSt = conn.prepareStatement(sql); //se ejecuta la consulta sql
            
            prepSt.setString(1,usuario); //se ingresa el valor usuario en la posicion uno 
            prepSt.setString(2, contra); //se ingresa el valor contra en la posicion dos
          rs = prepSt.executeQuery(); //se ejecuta la consulta sql
             while(rs.next()){ //se recorre los valores del  result set
          valorU = rs.getString(2); //se obtiene el valor de la tabla pero en la posicion que es ingresado
         valorD = rs.getString(3); //se obtiene el valor de la tabla en la posicion ingresada 
         if(valorU.equals(usuario) && valorD.equals(contra)){ //evalua si los valores debueltos son iguales a los ingresados
          if(valorU.equals("super") && valorD.equals("super") ){ //evalua nuevamente pero estaves para saber si el usuario ingresado es el super usuario
         p.validarTipoDeUsuario("super"); //se accede al metodo validar tipo de usuario y se le envia el parametro
         }else{ //solo si el usario es diferente a; super usuario
          
          p.validarTipoDeUsuario(usuario);//se accede al metodo validar tipo de usuario y se le envia el parametro
          }
         return true; //retorna verdadero si existe
         }
         
          }
     return false;    //retorna  falso si el usuario no existe
} // fin metodo usuario




public ArrayList<administrador> obtenerUsuarios(){ //se define el metodo obtener usuarios pero como Lista
        
        ArrayList<administrador> listaUsuarios = new ArrayList<administrador>(); //se instancia el array  vacio
       try {
            
            conn = DriverManager.getConnection(this.url, this.user, this.pass);  //se instancia la conexion
            
            String sql = "SELECT * FROM empleados order by nombre"; //se define la consulta sql
            
            prepSt = conn.prepareStatement(sql); //se  prepara  la consulta pre definida
            
            rs = prepSt.executeQuery();  //se ejecuta la consulta
            
            while(rs.next()){ //se recorren los valores obtenidos de la consulta
             
                String nombre = rs.getString("nombre"); //se obtiene el nombre de la base de datos
               String apellido = rs.getString("apellidos"); //se obtiene el apellido  
               String telefono = rs.getString("telefono");// se obtiene el telefono
               String departamento = rs.getString("departamento"); //se obtiene el departamento
                
                administrador ad = new administrador(nombre,apellido,telefono,departamento); //se instancia la clase administrador y se le envian los parametros respectivos
                listaUsuarios.add(ad);//se agregan a el array
            }
            
        } catch (SQLException ex) { //se muestra la exepciom
            ex.printStackTrace();
        }
        finally{ //este es para cerrar la conexion
            try {
                prepSt.close(); //se sierra el prepare statement
                conn.close(); //se cierra la conexion a la base de datos
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
       return listaUsuarios;
    }
    
    public ArrayList<usuariosAdmin> obtenerAdministradores(){ //se define el metodo obtener usuarios como una lista
        
        ArrayList<usuariosAdmin> listaAdministradores = new ArrayList<usuariosAdmin>(); //se instancia la lista del tipo objeto usuariosAdmin como vacio
       try {
            
            conn = DriverManager.getConnection(this.url, this.user, this.pass); //se instancia la conexion
            
            String sql = "SELECT * FROM agregar_usuarios order by nombre_usuario"; //se define la consulta sql
            
            prepSt = conn.prepareStatement(sql); //se ejecuta la consulta
            
            rs = prepSt.executeQuery(); //se ejecuta la consulta
            
            while(rs.next()){ //se recorren los valores obtenidos de la consulta
             
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
    } //fin de este metodo
    

public void borrarUsuario(String usuario){
        try {
            
              conn = DriverManager.getConnection(this.url, this.user, this.pass);
            
            String sql = "DELETE FROM empleado WHERE nombre=?";
            
            prepSt = conn.prepareStatement(sql);
            
            prepSt.setString(1, usuario);
 
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
    }//fin de este metodo

public void borrarAdministrador(String usuario){
        try {
            
              conn = DriverManager.getConnection(this.url, this.user, this.pass);
            
            String sql = "DELETE FROM agregar_usuarios WHERE nombre_usuario=?";
            
            prepSt = conn.prepareStatement(sql);
            
            prepSt.setString(1, usuario);
 
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
    }//fin de este metodo

public void insertarTrabajadores(int index,int indexD,String nombre, String apellido,double telefono,String departamento){

     try {
         System.out.println("el valor index es :" + index);
         conn = DriverManager.getConnection(this.url, this.user, this.pass);
         String sql = "INSERT INTO empleados (cod_emp,cod_cargo,cod_depar,nombre,apellidos,telefono,departamento) VALUES (?,?,?,?,?,?,?)";
         prepSt = conn.prepareStatement(sql);
         prepSt.setInt(1,index);
         prepSt.setInt(2,index);
         prepSt.setInt(3,indexD);
         prepSt.setString(4,nombre);
         prepSt.setString(5,apellido);
         prepSt.setDouble(6,telefono);
         prepSt.setString(7,departamento);
         
         prepSt.executeUpdate();
         
     } catch (SQLException ex) {
         Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
     }
            
     
}

public void insertarAdministradores(String nomUs,String contra , int cargo,int cargoB){

     try {
         
         conn = DriverManager.getConnection(this.url, this.user, this.pass);
         String sql = "INSERT INTO agregar_usuarios (nombre_usuario,contrasena_usuario,cod_jefatura,cod_jefedesa) VALUES (?,?,?,?)";
         prepSt = conn.prepareStatement(sql);
         prepSt.setString(1,nomUs);
         prepSt.setString(2,contra);
         prepSt.setInt(3,cargo);
         prepSt.setInt(4,cargoB);
         
         prepSt.executeUpdate();
         
     } catch (SQLException ex) {
         Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
         JOptionPane.showMessageDialog(null,"Administrador no ingresado por que ya existe uno con ese cargo");
     }
            
     
}


  public void modificarUsuario(modificarAdmin ad){
   
      try {
         
         conn = DriverManager.getConnection(this.url, this.user, this.pass);
         String sql = "UPDATE agregar_usuarios SET nombre_usuario=?, contrasena_usuario=? WHERE cod_registro=?";
         prepSt = conn.prepareStatement(sql);
         prepSt.setString(1,ad.getNombre());
         prepSt.setString(2,ad.getContra());
         prepSt.setInt(3, ad.getId());
         
         prepSt.executeUpdate();
         
     } catch (SQLException ex) {
         Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
     }
      
   }    

}// fin clase principal
