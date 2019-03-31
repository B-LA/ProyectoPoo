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
private boolean existe;

   

public void insertarCodigo(String codigo) throws SQLException{
   this.codigo = codigo;
    System.out.println("Codigo " + codigo);

}
public void definir(boolean valorr){
this.existe = valorr;
    System.out.println("es:"+ this.existe);
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
