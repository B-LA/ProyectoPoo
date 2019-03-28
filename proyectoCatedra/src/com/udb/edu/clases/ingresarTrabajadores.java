/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.edu.clases;

public class ingresarTrabajadores {

    private int index;
    private String nombre;
    private String apellido;
    private String departamento;
    
    public ingresarTrabajadores(int index,String nombre, String apellido,String departamento){
    this.index = index;
    this.nombre = nombre;
    this.apellido = apellido;
    this.departamento = departamento;
    }

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
