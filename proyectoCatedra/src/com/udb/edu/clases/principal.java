package com.udb.edu.clases;
import com.udb.edu.conexion.conexion;
import java.sql.SQLException;


/**
 *
 * @author neon
 */
public class principal {
conexion n;
    
 private String nombre;
 private String contra;
private String usuario;

    public principal() {
        this.n = new conexion();
    }

   
 
 public boolean validarExistenciaUsuario(String nombre,String contra) throws SQLException{
         this.nombre = nombre;
         this.contra = contra;
       boolean valorN =   n.obtenerAdministrador(nombre, contra);
 if(valorN == true){
 
 return true;
 }else
     return false;
 }
 
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
