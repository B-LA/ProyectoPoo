package com.udb.edu.clases;
import com.udb.edu.conexion.conexion;
import java.sql.SQLException;

public class validarUsuarios {
conexion n =  new conexion();


private String usuario;
private String contra;
private String codigo;
private boolean existe;
private String departamento;


public void insertarCodigo(String codigo) throws SQLException{
   this.codigo = codigo;
}
public void definir(boolean valorr) throws SQLException{
this.existe = valorr;


}

public boolean falsoOverdadero(){
return this.existe;
}

public String usuario(String usuario){
    this.usuario = usuario;
 return usuario;   
}



public void  ValidarUsuarios(String usuario,String contra) throws SQLException{
this.usuario = usuario;
this.contra = contra;
System.out.println("Get usuario" + getUsuario());

}



     public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
 
   

    public  String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

     public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }

  
}
