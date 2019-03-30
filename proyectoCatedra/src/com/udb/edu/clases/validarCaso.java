package com.udb.edu.clases;

/**
 *
 * @author neon
 */
public class validarCaso {
private String nombre;
private String descripcion;

public validarCaso(String nombre,String descripcion){
this.nombre = nombre;
this.descripcion = descripcion;

}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
