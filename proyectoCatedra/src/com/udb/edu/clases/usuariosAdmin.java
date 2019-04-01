/*
Roberto Carlos Ortega Vargas OV161179
Juan Jose Landaverde Martinez LM 160780
Deysi Guadalupe de Paz Sosa DS150922
Ricardo Alberto Gonzalez Diaz GD181909
Wiliam Vladimir Garcia Hernandez GH171489

*/
package com.udb.edu.clases;


public class usuariosAdmin {

    //valores a recibir
private String nombre;
private String contra;
private String cargo;

//constructor de la clase
public usuariosAdmin(String nombre,String contra,String cargo){
this.nombre = nombre;
this.contra = contra;
this.cargo = cargo;

}
//metodos getter and setter
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    @Override
    public String toString(){
        return this.nombre;
    }
    
}
