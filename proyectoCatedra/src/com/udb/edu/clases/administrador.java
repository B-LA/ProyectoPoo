/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.edu.clases;

/**
 *
 * @author neon
 */
public class administrador {
    
    private String nombre;
    private String apellido;
    private String telefono;
    private String departamento;

    public administrador(String nombre,String apellido,String telefono,String departamento){
    this.nombre = nombre;
    this.apellido = apellido;
    this.telefono = telefono;
    this.departamento = departamento;
    
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
