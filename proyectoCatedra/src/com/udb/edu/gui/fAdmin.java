/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udb.edu.gui;

import com.udb.edu.clases.administrador;
import com.udb.edu.clases.usuariosAdmin;
import com.udb.edu.conexion.conexion;
import java.util.ArrayList;
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

public class fAdmin extends javax.swing.JFrame {
DefaultTableModel modeloU =  new DefaultTableModel(); //se instancia un modelo para las tablas
DefaultTableModel modeloD =  new DefaultTableModel();//se instancia un modelo para las tablas
conexion con = new conexion();
    /**
     * Creates new form fAdmin
     */
    public fAdmin() {
     initComponents();
        mostrarEmpleados();
        mostrarAdministradores();
    
    }

    private  void mostrarEmpleados(){
    modeloU.addColumn("Nombre"); //al modelo  pre instanciado se le agrega la  columna nombre
    modeloU.addColumn("Apellido"); //al modelo  pre instanciado se le agrega la  columna apellido
    modeloU.addColumn("Telefono");//al modelo  pre instanciado se le agrega la  columna telefono
    modeloU.addColumn("Departamento");//al modelo  pre instanciado se le agrega la  columna departamento
    
    ArrayList<administrador> lista =  con.obtenerUsuarios();//se instancia una lista con todos los datos del metodo obtenerUsuario de la conexion
    int numeroUsuarios = lista.size(); //se cuentan los caracteres de la la lista 
    modeloU.setNumRows(numeroUsuarios); //se definen el numero de filas  del conteo anterior
    
    for(int i = 0;i < numeroUsuarios;i++){ //se crea un for 
    administrador ad = lista.get(i); //se obtiene la posicion uno o cero la que primero este de la clase administrador
    String nombre = ad.getNombre(); //se obtiene el nombre 
    String apellido = ad.getApellido(); //se obtiene el apellido
    String telefono = ad.getTelefono(); //se obtiene  el telefono
    String Departamento = ad.getDepartamento(); //y se obtiene el departaamento al que pertenece
    
    modeloU.setValueAt(nombre,i,0); //se inserta el valor nombre en la posicion 0
      modeloU.setValueAt(apellido,i,1); //se inserta el valor apellido en la posicion 1
        modeloU.setValueAt(telefono,i,2); //se inserta el valor telefono en la posicion 2
          modeloU.setValueAt(Departamento,i,3); //se inserta el valor departamento en la posicion 3
    }
    
    }
    
    private void mostrarAdministradores(){
    
    modeloD.addColumn("Nombre");
    modeloD.addColumn("Contra");
    modeloD.addColumn("Cargo");
    
    ArrayList<usuariosAdmin> deleT =  con.obtenerAdministradores();
    int numeroAdministradores = deleT.size();
    modeloD.setNumRows(numeroAdministradores);
    
    for(int i = 0;i<numeroAdministradores;i++){
   usuariosAdmin ad = deleT.get(i);
   String nombre = ad.getNombre();
   String contra = ad.getContra();
   String cargo = ad.getCargo();
   
   modeloD.setValueAt(nombre, i,0);
   modeloD.setValueAt(contra, i,1);
   modeloD.setValueAt(cargo, i,2);
    
    }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();
        btnDel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnMod = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnDelU = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAdmin = new javax.swing.JTable();
        btnAddU = new javax.swing.JButton();
        btnModU = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblUsuario.setModel(modeloU);
        jScrollPane1.setViewportView(tblUsuario);

        btnDel.setText("Eliminar");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jButton5.setText("Cerrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnMod.setText("Modificar");
        btnMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMod, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(185, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(86, 86, 86)
                            .addComponent(btnAdd)
                            .addGap(42, 42, 42)
                            .addComponent(btnMod)
                            .addGap(43, 43, 43)
                            .addComponent(btnDel))))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Empleados", jPanel1);

        btnDelU.setText("Eliminar");
        btnDelU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelUActionPerformed(evt);
            }
        });

        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tblAdmin.setModel(modeloD);
        jScrollPane2.setViewportView(tblAdmin);

        btnAddU.setText("Agregar");
        btnAddU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUActionPerformed(evt);
            }
        });

        btnModU.setText("Modificar");
        btnModU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jButton2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnDelU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnModU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddU, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(btnAddU)
                .addGap(43, 43, 43)
                .addComponent(btnModU)
                .addGap(28, 28, 28)
                .addComponent(btnDelU)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jTabbedPane1.addTab("Gefes", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModUActionPerformed
        int index = this.tblAdmin.getSelectedRow();

        if(index == -1){

            JOptionPane.showMessageDialog(null, "No hay datos para modificar.\n"
                + "Por favor, seleccione un registro de la tabla.", "Error en la operación",
                JOptionPane.ERROR_MESSAGE);

        }else{

            new fModificarAdmin(index).setVisible(true);

        }
    }//GEN-LAST:event_btnModUActionPerformed

    private void btnAddUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUActionPerformed
        new ingresarAdmin().setVisible(true);
    }//GEN-LAST:event_btnAddUActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        new login().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnDelUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelUActionPerformed
        int mensaje = JOptionPane.showConfirmDialog(this, "Estas seguro de eliminar este administrador?");

        if(mensaje == 0){
            int fila = tblAdmin.getSelectedRow();
            String nombre = tblAdmin.getValueAt(fila, 0).toString();
            con.borrarAdministrador(nombre);
            modeloD.removeRow(this.tblAdmin.getSelectedRow());
        }
    }//GEN-LAST:event_btnDelUActionPerformed

    private void btnModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModActionPerformed
        int index = this.tblUsuario.getSelectedRow();

        if(index == -1){

            JOptionPane.showMessageDialog(null, "No hay datos para modificar.\n"
                + "Por favor, seleccione un registro de la tabla.", "Error en la operación",
                JOptionPane.ERROR_MESSAGE);

        }else{

            new fModificarTrabajador(index).setVisible(true);

        }
    }//GEN-LAST:event_btnModActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();
        new login().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        new ingresarEmp().setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        int mensaje = JOptionPane.showConfirmDialog(this, "Estas seguro de eliminar este trabajador?");

        if(mensaje == 0){
            int fila = tblUsuario.getSelectedRow();
            String nombre = tblUsuario.getValueAt(fila, 0).toString();
            con.borrarUsuario(nombre);
            modeloU.removeRow(this.tblUsuario.getSelectedRow());

        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnDelActionPerformed

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
            java.util.logging.Logger.getLogger(fAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fAdmin().setVisible(false); //se define el frame en escondido para que no se vea
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddU;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnDelU;
    private javax.swing.JButton btnMod;
    private javax.swing.JButton btnModU;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblAdmin;
    private javax.swing.JTable tblUsuario;
    // End of variables declaration//GEN-END:variables
}
