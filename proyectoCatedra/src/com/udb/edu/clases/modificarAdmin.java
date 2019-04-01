
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
public class modificarAdmin {
//variables de la clase
private String nombre;
private String contra;
private int id;

//constructor de la clase
public modificarAdmin(String nombre,String contra,int id){

    this.nombre = nombre;
    this.contra = contra;
    this.id = id;

}

//getter and setter
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
