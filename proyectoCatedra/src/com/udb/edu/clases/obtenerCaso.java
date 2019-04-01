package com.udb.edu.clases;
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
public class obtenerCaso {

private String nombre;
private String apellido;
private String descripcion;
private String estadoCaso;

//constructor de la clase
public obtenerCaso(String nombre,String apellido,String Descripcion,String estado){
this.nombre = nombre;
this.apellido = apellido;
this.descripcion = Descripcion;
this.estadoCaso = estado;
}
//constructor sobrecargado
public  obtenerCaso(String estado){
this.estadoCaso = estado;
}

//getter and setter
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
