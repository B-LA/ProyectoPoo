package com.udb.edu.clases;
import com.udb.edu.conexion.conexion;
import java.sql.SQLException;
/*
Roberto Carlos Ortega Vargas OV161179
Juan Jose Landaverde Martinez LM 160780
Deysi Guadalupe de Paz Sosa DS150922
Ricardo Alberto Gonzalez Diaz GD181909
Wiliam Vladimir Garcia Hernandez GH171489

*/

/**
 *
 * @author neon
 */
public class principal {
conexion n;
    
 private String nombre;
 private String contra;
private String usuario;
//contructor de la clae
    public principal() {
        this.n = new conexion();
    }

   
 //metodo para validar la existencia de un usuario
 public boolean validarExistenciaUsuario(String nombre,String contra) throws SQLException{
         this.nombre = nombre;
         this.contra = contra;
       boolean valorN =   n.obtenerAdministrador(nombre, contra); //guarda el valor de la consulta hecha en la clase coexion
 if(valorN == true){
 
 return true;
 }else
     return false;
 }
 
 //getter and setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
       public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
}
