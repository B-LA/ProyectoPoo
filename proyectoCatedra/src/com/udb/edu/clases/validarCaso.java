package com.udb.edu.clases;

/**
 *
 * @author neon
 */
public class validarCaso {
private String nombre;
private String descripcion;
private String codigo;
private String trabajador;
/*
Roberto Carlos Ortega Vargas OV161179
Juan Jose Landaverde Martinez LM 160780
Deysi Guadalupe de Paz Sosa DS150922
Ricardo Alberto Gonzalez Diaz GD181909
Wiliam Vladimir Garcia Hernandez GH171489

*/
public validarCaso(){

}  

public validarCaso(String nombre,String descripcion){
this.nombre = nombre;
this.descripcion = descripcion;
}

    public validarCaso(String nombre,String descripcion,String codigo,String trabajador){
this.nombre = nombre;
this.descripcion = descripcion;
this.codigo = codigo;
this.trabajador = trabajador;
}

       public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
