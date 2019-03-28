
package com.udb.edu.clases;
import com.udb.edu.conexion.*;
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


 public boolean validarExistenciaUsuario(String nombre,String contra) throws SQLException{
         this.nombre = nombre;
         this.contra = contra;
       boolean valorN =   n.obtenerUsuario(nombre, contra);
       if(valorN == true){
       return true;
       }else
    return false;
    }
 
 
    public void validarTipoDeUsuario(String usuario){
    
   if(usuario.equals("super")){
 setUsuario(usuario);   
   }else
setUsuario(usuario);
    }

    public principal() {
        this.n = new conexion();
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
