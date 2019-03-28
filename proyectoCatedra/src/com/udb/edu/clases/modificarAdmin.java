
package com.udb.edu.clases;

/**
 *
 * @author neon
 */
public class modificarAdmin {

private String nombre;
private String contra;
private int id;

public modificarAdmin(String nombre,String contra,int id){

    this.nombre = nombre;
    this.contra = contra;
    this.id = id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
