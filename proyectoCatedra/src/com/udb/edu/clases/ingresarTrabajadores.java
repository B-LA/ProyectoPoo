/*
Roberto Carlos Ortega Vargas OV161179
Juan Jose Landaverde Martinez LM 160780
Deysi Guadalupe de Paz Sosa DS150922
Ricardo Alberto Gonzalez Diaz GD181909
Wiliam Vladimir Garcia Hernandez GH171489

*/
package com.udb.edu.clases;

public class ingresarTrabajadores {
//variables de la clase
    private int index;
    private String nombre;
    private String apellido;
    private String departamento;
    
    //constructor sobrecargado para definir a cada variable un valor que no  sea el de defecto
    public ingresarTrabajadores(int index,String nombre, String apellido,String departamento){
    this.index = index;
    this.nombre = nombre;
    this.apellido = apellido;
    this.departamento = departamento;
    }

    //getter and setter
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    
    
    
}
