package com.udb.edu.clases;

/**
 *
 * @author neon
 */
public class obtenerCaso {

private String nombre;
private String apellido;
private String descripcion;
private String estadoCaso;


public obtenerCaso(String nombre,String apellido,String Descripcion,String estado){
this.nombre = nombre;
this.apellido = apellido;
this.descripcion = Descripcion;
this.estadoCaso = estado;
}

public  obtenerCaso(String estado){
this.estadoCaso = estado;
}

    public String getEstadoCaso() {
        return estadoCaso;
    }

    public void setEstadoCaso(String estadoCaso) {
        this.estadoCaso = estadoCaso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
