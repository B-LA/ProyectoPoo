package com.udb.edu.clases;
import com.udb.edu.conexion.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class validarUsuarios {
conexion n =  new conexion();


private String usuario;
private String contra;
private String codigo;

public void  ValidarUsuarios(String usuario,String contra){
this.usuario = usuario;
this.contra = contra;

}
public void insertarCodigo(String codigo) throws SQLException{
   this.codigo = codigo; 
    if(codigo != null){
        System.out.println("Codigo"+ codigo);
        n.validarCaso(codigo);  
    }

}

    public String getCodigo() {
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

    
  
    
}
