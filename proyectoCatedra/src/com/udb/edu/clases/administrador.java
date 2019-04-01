/*
Roberto Carlos Ortega Vargas OV161179
Juan Jose Landaverde Martinez LM 160780
Deysi Guadalupe de Paz Sosa DS150922
Ricardo Alberto Gonzalez Diaz GD181909
Wiliam Vladimir Garcia Hernandez GH171489

*/
package com.udb.edu.clases;

/**
 *
 * @author neon
 */
public class administrador {
    //variables de la clase
    private String nombre;
    private String apellido;
    private String telefono;
    private String departamento;

    //constructor de la clase para definir un valor que no sea el por defecto  a cada variable global
    public administrador(String nombre,String apellido,String telefono,String departamento){
    this.nombre = nombre;
    this.apellido = apellido;
    this.telefono = telefono;
    this.departamento = departamento;
    
    }
    //getter and setter
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
}
