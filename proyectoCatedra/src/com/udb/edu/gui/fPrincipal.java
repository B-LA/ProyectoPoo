/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.edu.gui;

import com.udb.edu.clases.obtenerCaso;
import com.udb.edu.clases.validarCaso;
import com.udb.edu.clases.validarUsuarios;

import com.udb.edu.conexion.conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
public class fPrincipal extends javax.swing.JFrame {
  
conexion conn = new conexion(); //se instancia un metodo  de la clase conexion
DefaultTableModel modeloCasos = new DefaultTableModel(); //se crea un modelo para la tabla casos

    /**
     * Creates new form fPrincipal
     * @param usuario
     * @throws java.sql.SQLException
     */
String departamento; //valor global 
private String trabajador; //valor global
validarUsuarios v = new validarUsuarios(); //se intancia un objeto de la clase validar usuarios
    public fPrincipal(String usuario,String cod_gfe,String departamento) throws SQLException { //constructor principal
        initComponents();  //esto lo crea netbeans
        esconder(usuario); //metodo creado por mi
      insertarCasosTabla(); //inicializa el metodo para que el modelo caso este visto
      obtenerUsuario(departamento); //este es un geter para la variable global departamento
      this.trabajador = cod_gfe; //se define el valor c_gfe para el trabajador
    }
    
        private void obtenerUsuario(String departamento){ //metodo setter para la variable global departamento
        this.departamento = departamento; //se define el valor obtenido 
        }
        
        private String obtenerDepartamento(){ //metodo getter para la variable global departamento
        return this.departamento; //retorna el valor de la variable global
        }
          public String getTrabajador() {  //metodo getter para la variable global trabajador
        return trabajador;
    }

    public void setTrabajador(String trabajador) {//metodo setter para la variable global trabajador
        this.trabajador = trabajador;
    }
        
        
        
        private void insertarCasosTabla(){ //metodo mencionado anteriormente este inserta las columnas y las filas a la tabla casos para su visualizacion
        modeloCasos.addColumn("Nombre"); //se define la columna y su nombre
        modeloCasos.addColumn("Apellido");//se define la columna y su nombre
        modeloCasos.addColumn("Descripcion");//se define la columna y su nombre
        modeloCasos.addColumn("Estado");//se define la columna y su nombre
        
         ArrayList<obtenerCaso> deleT =  conn.obtenerCasos(); //se crea un objeto de la clase lista que tengra como contenido le metodo obtener casos de la clase conexion
        int numeroCasos = deleT.size(); //se cuenta cantidad de valores en la lista
        modeloCasos.setNumRows(numeroCasos); // se defice el numero de celdas dependiendo del anterior conteo
    
        for(int i = 0;i<numeroCasos;i++){ // un simple for para iterar los casos
        obtenerCaso ad = deleT.get(i); //se crea un objeto de la clase obtener caso cuyo valor sera el index 
        String nombre = ad.getNombre(); //de la clase se obtiene el nombre (un valor de la clase)
        String apellido = ad.getApellido();//de la clase se obtiene el apellido (un valor de la clase)
        String descipcion = ad.getDescripcion();//de la clase se obtiene el descripcion (un valor de la clase)
        String estado = ad.getEstadoCaso();//de la clase se obtiene el estado del caso (un valor de la clase)
   
        modeloCasos.setValueAt(nombre, i,0);//se inserta el valor en la posicion uno de la columna 
        modeloCasos.setValueAt(apellido, i,1);//se inserta el valor en la posicion dos de la columna 
        modeloCasos.setValueAt(descipcion, i,2);//se inserta el valor en la posicion tres de la columna ingresa
        modeloCasos.setValueAt(estado,i,3);//se inserta el valor en la posicion catro de la columna 
 
        
        }
        }
        
       private void esconder(String codigo) throws SQLException{ //metodo para esconder pestanias del jtabbed panee
           
       
              boolean tieneAvC =  conn.validarCaso(codigo); //valida si tiene avierto un caso AvC
              System.out.println("Valor"+tieneAvC); //solo muesta el valor no tiene valor real en la ejecucion del proyecto
              if(codigo == "admon"){ //valida si el valor ingresado es de un administrador por consiguiente elimina las pestanias donde se muestra agregar un caso
              this.tbnT.remove(1);
              this.tbnT.remove(0);
              }else
              if(tieneAvC){//si tiene un caso asociado a el  
               
                   mostrarEstado(codigo); //metodo creado mas adelante esta la explicaion del mismo
                 
                  this.tbnT.remove(2);
                  this.tbnT.remove(0);
                 
              }
             

          if(tieneAvC == false){ //si no tiene caso asignado elimina siempre la pestania de administrador y desabilita la pestania de mostrar estado
              this.tbnT.remove(2);
                this.tbnT.setEnabledAt(this.tbnT.getTabCount() - 1, false); 
            }else{
                
            }
       
       }
    

        private void mostrarEstado(String codigo) throws SQLException{  //este metodo solo se ejecutara mientras el usuario tenga un caso asignado
            ArrayList<obtenerCaso> deleT =  conn.insertarCaso(codigo);
            obtenerCaso ob = deleT.get(0);
            String Estado = ob.getEstadoCaso();
            //"Incompleto", "Completo", "Aceptado", "Rechasado" 
            if(Estado.equals("Incompleto")){
            this.progresB.setValue(25);
            this.progresB.setString(Estado);
            }else
                if(Estado.equals("Completo")){
                this.progresB.setValue(75);
                this.progresB.setString(Estado);
                }else
                    if(Estado.equals("Aceptado")){
                    this.progresB.setValue(100);
                    this.progresB.setString(Estado);
                    }else
                        if(Estado.equals("Rechasado")){
                        this.lblR.setText(Estado);
                        this.progresB.setValue(0);
                        }
            this.lblEst.setText(Estado);
        }
        
        
        
   
   /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbnT = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txU = new javax.swing.JTextField();
        btnTLT = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDtos = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        btnCrrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        progresB = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblR = new javax.swing.JLabel();
        lblEst = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCasos = new javax.swing.JTable();
        btnRev = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txUActionPerformed(evt);
            }
        });

        btnTLT.setText("Submit");
        btnTLT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTLTActionPerformed(evt);
            }
        });

        jLabel4.setText("Apertura de un caso");

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        txtDtos.setColumns(20);
        txtDtos.setRows(5);
        jScrollPane1.setViewportView(txtDtos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txU, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTLT)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(463, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txU, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTLT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        tbnT.addTab("Casos", jPanel1);

        btnCrrar.setText("Cerrar");
        btnCrrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario su proyecto esta en  proceso de revicion");

        jLabel2.setText("Avance");

        jLabel3.setText("Estado");

        jLabel5.setText("Observaciones");

        lblR.setText("OB");

        lblEst.setText("EST");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(898, Short.MAX_VALUE)
                .addComponent(btnCrrar)
                .addGap(25, 25, 25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(progresB, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(263, 263, 263)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblEst)
                                .addGap(272, 272, 272)
                                .addComponent(lblR)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblR)
                    .addComponent(lblEst))
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(progresB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(btnCrrar)
                .addGap(24, 24, 24))
        );

        tbnT.addTab("Estado", jPanel2);

        tbCasos.setModel(modeloCasos);
        jScrollPane2.setViewportView(tbCasos);

        btnRev.setText("Revisar");
        btnRev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRev)
                .addContainerGap(339, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btnRev)))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        tbnT.addTab("Mod", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbnT)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbnT)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrrarActionPerformed
        this.dispose();
        new login().setVisible(true);
    }//GEN-LAST:event_btnCrrarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
        new login().setVisible(true);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnTLTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTLTActionPerformed
        String nombreProyecto = this.txU.getText();
        String datosProyecto = this.txtDtos.getText();
        JOptionPane.showMessageDialog(null,"Caso abierto satisfactoriamente")   ;
        
        this.tbnT.setSelectedIndex(1);
        this.tbnT.remove(0);
       String departamento = obtenerDepartamento();
        
        validarCaso caso = new validarCaso(nombreProyecto,datosProyecto,departamento,getTrabajador()); 
        conn.agregarCaso(caso);
    }//GEN-LAST:event_btnTLTActionPerformed

    private void btnRevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRevActionPerformed
       int index = this.tbCasos.getSelectedRow();

        if(index == -1){

            JOptionPane.showMessageDialog(null, "No hay datos para modificar.\n"
                + "Por favor, seleccione un registro de la tabla.", "Error en la operación",
                JOptionPane.ERROR_MESSAGE);

        }else{

            new fModificarEstado(index).setVisible(true);

        }
        
        
    }//GEN-LAST:event_btnRevActionPerformed

    private void txUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txUActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new fPrincipal("","","").setVisible(true);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(fPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCrrar;
    private javax.swing.JButton btnRev;
    private javax.swing.JButton btnTLT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEst;
    private javax.swing.JLabel lblR;
    private javax.swing.JProgressBar progresB;
    private javax.swing.JTable tbCasos;
    private javax.swing.JTabbedPane tbnT;
    private javax.swing.JTextField txU;
    private javax.swing.JTextArea txtDtos;
    // End of variables declaration//GEN-END:variables

  
}

