package com.udb.edu.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import com.udb.edu.clases.administrador;
import com.udb.edu.clases.modificarAdmin;
import com.udb.edu.clases.obtenerCaso;
import com.udb.edu.clases.principal;
import com.udb.edu.clases.usuariosAdmin;
import com.udb.edu.clases.validarCaso;
import com.udb.edu.clases.validarSuperUsuario;
import com.udb.edu.clases.validarUsuarios;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/*
Roberto Carlos Ortega Vargas OV161179
Juan Jose Landaverde Martinez LM 160780
Deysi Guadalupe de Paz Sosa DS150922
Ricardo Alberto Gonzalez Diaz GD181909
Wiliam Vladimir Garcia Hernandez GH171489

*/
public class conexion {


 String based = "Proyecto_Catedra2019"; //nombre de la base de datos
 String url = "jdbc:mysql://localhost:3306/Proyecto_Catedra"; //la URl donde esta ubicada la base de datos
 String user = "root"; //usuario
 String pass = ""; //password
 Connection conn = null; //Definimos un objeto connection en null
 PreparedStatement prepSt = null; //Definimos un  prepareStatement
 ResultSet rs = null; //Definimos un result set
 String valorU ;  //valores globales para variables
 String valorD;//valores globales para variables
 String valorT;//valores globales para variables
 
    public conexion(){ //constructor de la clase
        try { 
            Class.forName("com.mysql.jdbc.Driver"); //se instancia el driver
        } catch (ClassNotFoundException ex) { //aqui esta la exepcion
            ex.printStackTrace(); //nuestra la exepcion
        }
    }//fin constructor
    
    public void agregarCaso(validarCaso v){//metodo paara agregar casos
    //nombreProyecto,datosProyecto,departamento,getTrabajador()
     try {
         
         conn = DriverManager.getConnection(this.url, this.user, this.pass); //se instancia la conexion
         String sql = "Insert into solicitud_casos values(?,?,?,?,?,?,?,?,?)"; //se crea la sentencia sql
         prepSt = conn.prepareStatement(sql);
         prepSt.setString(1,v.getCodigo());

        prepSt.setString(2,v.getCodigo());

        prepSt.setString(3,v.getCodigo());

        prepSt.setString(4,v.getTrabajador());
        prepSt.setString(5,v.getNombre());

        prepSt.setString(6,v.getNombre());
        prepSt.setString(7,v.getDescripcion());

        prepSt.setString(8,"Sin revisar");

        prepSt.executeUpdate();
         
         
         
         
     } catch (SQLException ex) { //esta linea se ejecuta solo si  hay alguna exepcion
         Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
     }
    
    }// fin del metodo agregar caso
  
    
    
  public boolean validarCaso(String codigo) throws SQLException{ //metodo par validar si existee un caso asociado a un codigo de trabajador
      
  conn = DriverManager.getConnection(this.url, this.user, this.pass); //se instancia la conexion
      String slq  = "select * from solicitud_casos where cod_solicitud=?"; //se crea la sentecnia sql
      prepSt = conn.prepareStatement(slq); //se prepara la sentencia sql
      prepSt.setString(1,codigo); //se agrega el valor referenciado en su posicion uno
      
      rs = prepSt.executeQuery(); // se ejecuta la consulta
     
      while(rs.next()){ //se recorre los valores devueltos
      String valor = rs.getString("cod_solicitud"); //se obtiene un codigo de la sentencia 
          if(valor !=null){ //se valida que el codigo obtenido no es nulo osea bacio
          return true; //se retorna verdadero si asi es si no
    }
      }
     return false; //se retorna falso si no existe ninguno
      }
     
  public String obtenerDepartamento(String usuario,String contra) throws SQLException{ //metodo para obtener el codigo de departamento
   validarUsuarios v = new validarUsuarios(); //se onstancia un objeto de la clase validar usuarios
      conn = DriverManager.getConnection(this.url, this.user, this.pass); //se instancia la conexion
  String sql = "select * from usuarios_testers where nombre_usuario = ?  and apellido_usuario  = ?"; //se define la consulta sql
   prepSt = conn.prepareStatement(sql); //se ejecuta la consulta sql
            prepSt.setString(1,usuario); //se ingresa el valor usuario en la posicion uno 
            prepSt.setString(2, contra); //se ingresa el valor contra en la posicion dos
 rs = prepSt.executeQuery(); //se ejecuta la sconsulta
 while(rs.next()){
          valorU = rs.getString("cod_usuario"); //se obtiene el codigo de usuario
          
    
   if(valorU != null){ //se valida si el valor existe si exite osea no es nulo se envia
        v.insertarCodigo(valorU); //se pasa por referencia el valor obtenido a la clase validar Usuario
        return valorU;
   
   }
 }
 return "";
  }
 
  public String obtenerCodGfe(String usuario,String contra) throws SQLException{ //metodo para obtener el codigo de soicitud de caos
   validarUsuarios v = new validarUsuarios(); //se instancia un objeto del tipo validar usuario
      conn = DriverManager.getConnection(this.url, this.user, this.pass); //se instancia la conexion
  String sql = "select * from usuarios_testers where nombre_usuario = ?  and apellido_usuario  = ?"; //se define la consulta sql
   prepSt = conn.prepareStatement(sql); //se ejecuta la consulta sql
            prepSt.setString(1,usuario); //se ingresa el valor usuario en la posicion uno 
            prepSt.setString(2, contra); //se ingresa el valor contra en la posicion dos
 rs = prepSt.executeQuery(); //se ejecuta la consulta
 while(rs.next()){
          valorU = rs.getString("cod_solicitud"); //se obtiene el valor de la tabla pero en la posicion que es ingresado
         
    
   if(valorU != null){ //se valida si el valor obtenido no es nulo
        v.insertarCodigo(valorU); //se pasa por referencia el codigo obtenido
        return valorU; //se retorna el codigo
   
   }
 }
 return ""; //si no se retorna vacio
  }//fin del metodo
  
  
  public String obtenerCodigoCaso(String usuario,String contra) throws SQLException{ //se crea un metodo para obtener el codigo del caso
   validarUsuarios v = new validarUsuarios(); //se instancia un objeto de la clase validar usuario
      conn = DriverManager.getConnection(this.url, this.user, this.pass); //se instancia la conexion
  String sql = "select * from usuarios_testers where nombre_usuario = ?  and apellido_usuario  = ?"; //se define la consulta sql
   prepSt = conn.prepareStatement(sql); //se ejecuta la consulta sql
            prepSt.setString(1,usuario); //se ingresa el valor usuario en la posicion uno 
            prepSt.setString(2, contra); //se ingresa el valor contra en la posicion dos
 rs = prepSt.executeQuery(); //se ejecuta la consulta
 while(rs.next()){
          valorU = rs.getString("cod_solicitud"); //se obtiene el valor de la tabla pero en la posicion que es ingresado
          System.out.println("Codigo"+valorU); //esta linea solo es para mostrar el codigo obtenido
          
   if(valorU != null){
        v.insertarCodigo(valorU); //se manda por referencia el codigo obtenido
       boolean valor = validarCaso(valorU); //se manda el codigo al metodo validarCaso para saber si existe un caso con este codigo de trabajadpr
       System.out.println("valor caso"+valor); //esta linea solo es para mostrar el valor obtenido
       v.definir(valor); //se manda a la clase validar USuario
        v.ValidarUsuarios(usuario, contra); // se mandan denuevo los valores para que no se pierdan
        return valorU; //se retorna el codigo
   
   }
 }

   return "";//se retorna vacio si no se encontro codigo
  }//fin del metodo
  
  
    public ArrayList<obtenerCaso> insertarCaso(String codigo) throws SQLException{ //se crea un metodo del tipo lista para obtener los casos actuales
    
  
        ArrayList<obtenerCaso> listaUsuarios = new ArrayList<obtenerCaso>(); //se instancia el array  vacio
       
            
            conn = DriverManager.getConnection(this.url, this.user, this.pass);  //se instancia la conexion
            
            String sql = "SELECT * FROM solicitud_casos where cod_solicitud = ?"; //se define la consulta sql
            
            prepSt = conn.prepareStatement(sql); //se  prepara  la consulta pre definida
            prepSt.setString(1,codigo);
            rs = prepSt.executeQuery();  //se ejecuta la consulta
            
            while(rs.next()){ //se recorren los valores obtenidos de la consulta
             
                String estado = rs.getString("estado_caso"); //se obtiene el nombre de la base de datos
              
                
                obtenerCaso ad = new obtenerCaso(estado); //se instancia la clase administrador y se le envian los parametros respectivos
                listaUsuarios.add(ad);//se agregan a el array
            }
    return listaUsuarios; //se retorna la lista
    }
    
  
  
public boolean obtenerAdministrador(String usuario,String contra) throws SQLException {// se define el metodo de para obtener los usuarios

    principal p = new principal();  //se instancia un objeto de la clase principal
    validarUsuarios v = new validarUsuarios();
         conn = DriverManager.getConnection(this.url, this.user, this.pass); //se instancia la conexion
           String sql = "select * from agregar_usuarios where nombre_usuario = ?  and contrasena_usuario  = ?"; //se define la consulta sql
          prepSt = conn.prepareStatement(sql); //se ejecuta la consulta sql
            prepSt.setString(1,usuario); //se ingresa el valor usuario en la posicion uno 
            prepSt.setString(2, contra); //se ingresa el valor contra en la posicion dos
          rs = prepSt.executeQuery(); //se ejecuta la consulta sql
             while(rs.next()){ //se recorre los valores del  result set
          valorU = rs.getString("nombre_usuario"); //se obtiene el valor de la tabla pero en la posicion que es ingresado
         valorD = rs.getString("contrasena_usuario"); //se obtiene el valor de la tabla en la posicion ingresada 
         if(valorU.equals(usuario) && valorD.equals(contra)){ //evalua si los valores debueltos son iguales a los ingresado
           
         return true; //retorna verdadero si existe
         }
             }
     return false;    //retorna  falso si el usuario no existe
} // fin metodo usuario

public boolean validarTester(String usuario,String contra) throws SQLException{

   validarUsuarios v = new validarUsuarios();
    conn = DriverManager.getConnection(this.url, this.user, this.pass); //se instancia la conexion
      String sql = "select * from usuarios_testers  where nombre_usuario = ?  and apellido_usuario  = ?"; //se define la consulta sql
    prepSt = conn.prepareStatement(sql);
    prepSt = conn.prepareStatement(sql); //se ejecuta la consulta sql
            prepSt.setString(1,usuario); //se ingresa el valor usuario en la posicion uno 
            prepSt.setString(2, contra); //se ingresa el valor contra en la posicion dos
          rs = prepSt.executeQuery(); //se ejecuta la consulta sql
             while(rs.next()){ //se recorre los valores del  result set
          valorU = rs.getString("nombre_usuario"); //se obtiene el valor de la tabla pero en la posicion que es ingresado
         valorD = rs.getString("apellido_usuario"); //se obtiene el valor de la tabla en la posicion ingresada 
         if(valorU.equals(usuario) && valorD.equals(contra)){ //evalua si los valores debueltos son iguales a los ingresado
          
             
         }
         return true; //retorna verdadero si existe
         }

     return false;    //retorna  falso si el usuario no existe
   
}

public boolean validarSuperUsuario(String usuario,String contra) throws SQLException{

   validarSuperUsuario su = new validarSuperUsuario();
    conn = DriverManager.getConnection(this.url, this.user, this.pass); //se instancia la conexion
    String sql = "select * from super_usuario where nombre_susuario = ?  and contrasena  = ?"; //se define la consulta sql
   
    prepSt = conn.prepareStatement(sql); //se prepara la consulta sql
            prepSt.setString(1,usuario); //se ingresa el valor usuario en la posicion uno 
            prepSt.setString(2, contra); //se ingresa el valor contra en la posicion dos
          rs = prepSt.executeQuery(); //se ejecuta la consulta sql
             while(rs.next()){ //se recorre los valores del  result set
          valorU = rs.getString("nombre_susuario"); //se obtiene el valor de la tabla pero en la posicion que es ingresado
         valorD = rs.getString("contrasena"); //se obtiene el valor de la tabla en la posicion ingresada 
         if(valorU.equals(usuario) && valorD.equals(contra)){ //evalua si los valores debueltos son iguales a los ingresado
         return true; //retorna verdadero si existe
         }
             }
     return false;    //retorna  falso si el usuario no existe
   
}


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
            
            prepSt = conn.prepareStatement(sql); //se prepara la consulta
            
            rs = prepSt.executeQuery(); //se ejecuta la consulta
            
            while(rs.next()){ //se recorren los valores obtenidos de la consulta
             
                String nombre = rs.getString("nombre_usuario");
               String contra = rs.getString("contrasena_usuario");
               String cargo = rs.getString("cod_jefatura");
               
                usuariosAdmin uA = new usuariosAdmin(nombre,contra,cargo); //se mandan los valores a su respectiva clase para que los guarde
                listaAdministradores.add(uA); //se agregan todos los valores obtenidos a la lista vacia
            }
            
        } catch (SQLException ex) { //se atrapa cualquier error de sintaxis o de la base
            ex.printStackTrace(); //muestra el error en consola
        }
        finally{ //esto es cuando ya se a ejecutado satisfactoriamente todo lo anterior
            try { 
                prepSt.close();//cierra las consultas
                conn.close(); //finaliza la conexion
            } catch (SQLException ex) { //se atrapa cualquier error 
                ex.printStackTrace(); //se muestra en consola el error
            }
        }
       return listaAdministradores; //se retorna la lista
    } //fin de este metodo
    

public void borrarUsuario(String usuario){//metodo para eliminar un usuarior
        try {
            
              conn = DriverManager.getConnection(this.url, this.user, this.pass); //se instancia la conexion
            
            String sql = "DELETE FROM empleados WHERE nombre=?"; //se crea la consulta sql
            
            prepSt = conn.prepareStatement(sql); //se prepara la consulta
            
            prepSt.setString(1, usuario); // se insertan los valores en su respectiva posicion 
  
            prepSt.executeUpdate(); //se ejecuta la consulta en este caso la eliminacion
            
        } catch (SQLException ex) { //se obtiene cualquier error en ejecucion
            ex.printStackTrace(); //se muestra en consola
        }
        finally{ //metodo final para cerrar la conexion
            try {
                prepSt.close(); //se cierra la conexion
                conn.close(); //se sierra la conexion
            } catch (SQLException ex) { //se obtiene cualquier error que pase al momento de cerrarse la conexion
                ex.printStackTrace(); //se muestra el error en consola
            }
        }
    }//fin de este metodo

public void borrarAdministrador(String usuario){ //se crea el metodo borrar administrador
        try {
            
              conn = DriverManager.getConnection(this.url, this.user, this.pass); //se instancia un objeto de la calse conexion
            
            String sql = "DELETE FROM agregar_usuarios WHERE nombre_usuario=?"; //se crea la consulta sql
            
            prepSt = conn.prepareStatement(sql); //se prepara la consulta
            
            prepSt.setString(1, usuario); //se insertan los valores en su respectiva posicion
 
            prepSt.executeUpdate(); //se ejecuta la  consulta
            
        } catch (SQLException ex) { //valida si hay algun error en ejecucion
            ex.printStackTrace(); //muestra el erro en consola
        }
        finally{//metodo final para cerrar la conexion
            try {
                prepSt.close();//se cierra la conexion
                conn.close(); //se sierra la conexion
            } catch (SQLException ex) {//se obtiene cualquier error que pase al momento de cerrarse la conexion
                ex.printStackTrace();//se muestra el error en consola
            }
        }
    }//fin de este metodo

public void insertarTrabajadores(int index,int indexD,String nombre, String apellido,double telefono,String departamento){ //metodo para insertar un nuevo trabajador a la base de datos

     try {
         System.out.println("el valor index es :" + index); //muestra el valor passado por parametros no tiene significado real en la ejecucion
         conn = DriverManager.getConnection(this.url, this.user, this.pass); //se instancia un objeto de la calse conexion
         String sql = "INSERT INTO empleados (cod_emp,cod_cargo,cod_depar,nombre,apellidos,telefono,departamento) VALUES (?,?,?,?,?,?,?)";//se crea la consulta sql
         prepSt = conn.prepareStatement(sql);//se prepara la consulta
         prepSt.setInt(1,index);//se insertan los valores en su respectiva posicion 1
         prepSt.setInt(2,index);//se insertan los valores en su respectia posicion 2
         prepSt.setInt(3,indexD);//se insertan los valores en su respectiva posicion 3 estos tres valores se repiten por que en la tabla son iguales el codigo empleado el codigo de cargo y el codigo de departamento
         prepSt.setString(4,nombre); //se inserta el nombre en su posicion de la tabla
         prepSt.setString(5,apellido);  //se inserta el apellido en su posicion de la tabla
         prepSt.setDouble(6,telefono); //se inserta el telefono en su posicion de la tabla
         prepSt.setString(7,departamento); //se inserta el departamento en su posicion de la tabla
         
         prepSt.executeUpdate(); //se ejecuta la consulta
         
     } catch (SQLException ex) { //valida que no halla ningun error en la ejecucion
         Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex); //muestra la exepcion en consola
     }
            
     
}

public void insertarAdministradores(String nomUs,String contra , int cargo,int cargoB){ //metodo para agregar un adminnistrador a la tabla

     try {
         
         conn = DriverManager.getConnection(this.url, this.user, this.pass); //se instancia un objeto de la clase conexion
         String sql = "INSERT INTO agregar_usuarios (nombre_usuario,contrasena_usuario,cod_jefatura,cod_jefedesa) VALUES (?,?,?,?)"; //se crea la consulta sql
         prepSt = conn.prepareStatement(sql); //se prepara la consulta
         prepSt.setString(1,nomUs); //se inserta el valor en su respeciva posicion
         prepSt.setString(2,contra); //se inserta el valor en su respeciva posicion
         prepSt.setInt(3,cargo);//se inserta el valor en su respeciva posicion
         prepSt.setInt(4,cargoB);//se inserta el valor en su respeciva posicion
         
         prepSt.executeUpdate();// se ejecuta la consulta
         
     } catch (SQLException ex) { //valida que no halla ningun error en la ejecucion
         Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex); //muestra el error en la consulta
         JOptionPane.showMessageDialog(null,"Administrador no ingresado por que ya existe uno con ese cargo"); //muestra este mensaaje debido a que en la tabla no puede aber mas de un administrador asignado a departamento
     }
            
     
}//finaliza el metodo


  public void modificarUsuario(modificarAdmin ad){ //metodo para modificar el usuario
   
      try {
         
         conn = DriverManager.getConnection(this.url, this.user, this.pass);//se instancia un metodo de la clase conexion
         String sql = "UPDATE agregar_usuarios SET nombre_usuario=?, contrasena_usuario=? WHERE cod_registro=?"; //se crea la consulta sql
         prepSt = conn.prepareStatement(sql); //se prepara la consutla
         prepSt.setString(1,ad.getNombre()); //se inserta el valor en su respectiva posicion
         prepSt.setString(2,ad.getContra());//se inserta el valor en su respectiva posicion
         prepSt.setInt(3, ad.getId());//se inserta el valor en su respectiva posicion
         
         prepSt.executeUpdate();//se ejecuta la consulta
         
     } catch (SQLException ex) {//valida que no halla ningun error en la ejecucion
         Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);//muestra el error en la consulta
     }
      
   }   //end del metodo
  
  
    public void modificarTrabajador(administrador ad,int index){ //se crea un metodo para modificar el trabajador
   
      try {
         
         conn = DriverManager.getConnection(this.url, this.user, this.pass); //se instancia un metodo de la clase conexion
         String sql = "UPDATE empleados SET nombre=?, apellidos=? , telefono=? WHERE cod_jefatura=?"; //se crea la consulta sql
         prepSt = conn.prepareStatement(sql); //se prepara la consulta
         prepSt.setString(1,ad.getNombre()); //se inserta el valor en su respectiva posicion
         prepSt.setString(2,ad.getApellido());//se inserta el valor en su respectiva posicion
         prepSt.setString(3,ad.getTelefono());//se inserta el valor en su respectiva posicion
         prepSt.setInt(4,index);//se inserta el valor en su respectiva posicion
         
         prepSt.executeUpdate();//se ejecuta la consulta
         
     } catch (SQLException ex) {//valida que no halla ningun error en la ejecucion
         Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex); //muestra ell error en consola
     }
      
   }
    
    public void modificarEstado(String estado,String nombre){ //metodo para modificar el estado de un proyecto
  
  
  try{
         
         conn = DriverManager.getConnection(this.url, this.user, this.pass); //se instancia un metodo de la clase conexion
         String sql = "UPDATE solicitud_casos SET estado_caso = ? where nombre = ?"; //se crea la consulta sql
         prepSt = conn.prepareStatement(sql); //se prepara la consulta
         prepSt.setString(1,estado); //se inserta el valor en su respectiva posicion
         prepSt.setString(2,nombre);//se inserta el valor en su respectiva posicion
         prepSt.executeUpdate(); // se ejecuta la consulta
  
  } catch (SQLException ex) { //valida que no halla ningun error en la ejecucion
         Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);//muestra el error en consola
     }
    }
  
  
  public ArrayList<obtenerCaso> obtenerCasos(){ //se define el metodo obtener usuarios como una lista
        
        ArrayList<obtenerCaso> listaAdministradores = new ArrayList<obtenerCaso>(); //se instancia la lista del tipo objeto obtener caso como vacio
       try {
            
            conn = DriverManager.getConnection(this.url, this.user, this.pass); //se instancia la conexion
            
            String sql = "SELECT * FROM solicitud_casos order by nombre"; //se define la consulta sql
            
            prepSt = conn.prepareStatement(sql); //se ejecuta la consulta
            
            rs = prepSt.executeQuery(); //se ejecuta la consulta
            
            while(rs.next()){ //se recorren los valores obtenidos de la consulta
             
                String nombre = rs.getString("nombre"); //se guardan los valores en una variable
               String apellido = rs.getString("apellidos");//se guardan los valores en una variable
               String Descripcion = rs.getString("descripcion");//se guardan los valores en una variable
               String  estado  = rs.getString("estado_caso");//se guardan los valores en una variable
               
                obtenerCaso uA = new obtenerCaso(nombre,apellido,Descripcion,estado); //se instancia un objeto del tipo obtener caso para que guarde todos los datos en su clase
                listaAdministradores.add(uA); //se agregan los valores obtenidos a la lista
            }
            
        } catch (SQLException ex) {//valida que no halla ningun error en la ejecucion
            ex.printStackTrace(); //muestra el error en consola
        }
        finally{ //bloque final solo se ejecuta si no existe ningun error en ejecucion
            try {
                prepSt.close(); //se cierra el prepare statemen
                conn.close(); //se cierra la conexion
            } catch (SQLException ex) {//valida que no halla ningun error en la ejecucion del cierre de conexion
                ex.printStackTrace(); //muestra el error en consola
            }
        }
       return listaAdministradores; //se retorna los valores de la lista
    } //fin de este metodo
    
  

  

}// fin clase principal
