/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package presentacion;

import javax.swing.JOptionPane;
import negocio.CategoriaControl;
import entidades.Categoria;


/**
 *
 * @author Elizabeth
 */
public class FrmCategoria extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmCategoria
     */
    
    private final  CategoriaControl CONTROL;
    private String accion;
    
    
    public FrmCategoria() {
        initComponents();
        this.CONTROL = new  CategoriaControl();
        this.listar("");
        tabGeneral.setEnabledAt(1, false);
        this.accion = "Guardar";
    }
    
    private void listar(String texto){
    tablaListado.setModel(this.CONTROL.listar(texto));
    lblCantidadRegistro.setText("Mostra" +
            this.CONTROL.totalMostrados()   +
            "de un total de " +
            this.CONTROL.total()
                
    );
    
    }
    
    private void  limpiar(){
    txtNombre.setText("");
    txtDescripcion.setText("");
    this.accion = "Guardar";
    }
    
    private void mensajeError(String mensaje){
    JOptionPane.showMessageDialog(this,mensaje,"Sistema", JOptionPane.ERROR);
    
    }
    
    private void mensajeOk(String mensaje){
    JOptionPane.showMessageDialog(this,mensaje,"Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabGeneral = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bntBuscar = new javax.swing.JButton();
        tfBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        lblCantidadRegistro = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Categoria");

        jLabel1.setText("Nombre");

        bntBuscar.setText("Buscar");
        bntBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntBuscarActionPerformed(evt);
            }
        });

        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaListado);

        lblCantidadRegistro.setText("Registros");

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 65, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCantidadRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntBuscar)
                    .addComponent(btnNuevo)
                    .addComponent(btnEditar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCantidadRegistro)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        tabGeneral.addTab("Lista", jPanel1);

        jLabel2.setText("Nombre(*)");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("Descripcion");

        jLabel4.setText("(*) Campo Obligatorio");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(109, 109, 109)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                    .addComponent(txtNombre)))
                            .addComponent(jLabel4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(btnGuardar)
                        .addGap(34, 34, 34)
                        .addComponent(btnCancelar)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        tabGeneral.addTab("Mantenimiento", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabGeneral)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabGeneral))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        tabGeneral.setEnabledAt(1, true);
        tabGeneral.setEnabledAt(0, false);
        tabGeneral.setSelectedIndex(1);
        this.accion = "Guardar";
        btnGuardar.setText("Guardar");
        
        
           
//        tabGeneral.setEnabledAt(1, true);
//        tabGeneral.setEnabledAt(0, false);
//        tabGeneral.setSelectedIndex(1);
//        this.accion = "Guardar";
//        btnGuardar.setText("Guardar");
        // TODO add your handling codtabGeneral.setEnabledAt(1, true); e here:
    }//GEN-LAST:event_btnNuevoActionPerformed
    
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
//        if(tablaListado.getSelectedColumn() == 1){
//            String id = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 0));
//            String nombre = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
//            String descripcion = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 2));
//            nombreAnt = nombre = String.valueOf(tablaListado.getValueAt(tablaListado.getSelectedRow(), 1));
//
//            txtId.setText(id);
//            txtNombre.setText(descripcion);
//            txtDescripcion.setText(descripcion);
//
//            tabGeneral.setEnabledAt(0, false);
//            tabGeneral.setEnabledAt(1, true);
//            tabGeneral.setSelectedIndex(1);
//            this.accion = "editar";
//            btnGuardar.setText("Editar");
//        }else{
//            this.mensajeError("Selecciona un registro");
//        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void bntBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntBuscarActionPerformed
        this.listar(tfBuscar.getText());
    // TODO add your handling code here:
    }//GEN-LAST:event_bntBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        tabGeneral.setEnabledAt(0, true);
        tabGeneral.setEnabledAt(1, false);
        tabGeneral.setSelectedIndex(0);
        this.limpiar();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(txtNombre.getText().length() == 0){
            JOptionPane.showMessageDialog(this,"Nombre es obligatorio.",
                    "Systema", JOptionPane.WARNING_MESSAGE);
            txtNombre.requestFocus();
            return;
        }
        String respuesta;
        if(this.accion.equals("editar")){
            //Editar
        } else {
            //Guardar               //Guardar
            respuesta = this.CONTROL.Insertar(txtNombre.getText(), txtDescripcion.getText());
            
            if(respuesta.equals("Ok")){
            this.mensajeOk("Registro Correctamente");
            this.limpiar();
            this.listar("");
        } else{
            this.mensajeError(respuesta);
        }
            
        }
        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidadRegistro;
    private javax.swing.JTabbedPane tabGeneral;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTextField tfBuscar;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
