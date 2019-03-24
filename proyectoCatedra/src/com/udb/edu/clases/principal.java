
package com.udb.edu.clases;
import com.udb.edu.gui.*;
/**
 *
 * @author neon
 */
public class principal {
    
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
 
    public String validarFrame(String nombre,String contra){
         this.nombre = nombre;
         this.contra = contra;
           if("root".equals(nombre) && "root".equals(contra)){
           return "admin";
           }else
               if("ricardo".equals(nombre) && "alberto".equals(contra)){
         return "usuario";
           }else{
                   return "";
               }
    }
    
}
