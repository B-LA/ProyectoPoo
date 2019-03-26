
package com.udb.edu.clases;
import com.udb.edu.conexion.*;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author neon
 */
public class principal {
conexion n = new conexion();
    
 private String nombre;
 private String contra;

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
 
    public boolean validarFrame(String nombre,String contra) throws SQLException{
         this.nombre = nombre;
         this.contra = contra;
       boolean valorN =   n.obtenerUsuario(nombre, contra);
       if(valorN == true){
       return true;
       }else
    return false;
    }
    
}
