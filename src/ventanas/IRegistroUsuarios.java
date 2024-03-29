/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventanas;

import clases.ModelTablaUsuarios;
import clases.Usuario;
import java.awt.Rectangle;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import paneles.PnlUsuarioNuevo;

/**
 *
 * @author puntodeventa-jlat
 */
public class IRegistroUsuarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form IRegistroUsuarios
     */
    private ModelTablaUsuarios mdlUsuario;
    public IRegistroUsuarios(JDesktopPane mainApp) {
        initComponents();
        mdlUsuario = new ModelTablaUsuarios();
        this.tblUsuario.setModel(mdlUsuario);
        Rectangle visibleRect = mainApp.getVisibleRect();       
        this.setSize(visibleRect.width, visibleRect.height);
        this.tblUsuario.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.txtNombreUsuario.getDocument().addDocumentListener(EscuchadorBuscar);
        
    }
    
    private void reiniciarTabla()
    {
         mdlUsuario = new ModelTablaUsuarios();
         this.tblUsuario.setModel(mdlUsuario);    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        bntActualizarUsuario = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        lbNoExiste = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuario = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Registro de Usuarios");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/page_add.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);

        bntActualizarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/page_edit.png"))); // NOI18N
        bntActualizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntActualizarUsuarioActionPerformed(evt);
            }
        });
        jPanel4.add(bntActualizarUsuario);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/page_delete.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nombre del Cliente:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 9, 12);
        jPanel5.add(jLabel1, gridBagConstraints);

        txtNombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombreUsuario.setPreferredSize(new java.awt.Dimension(120, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 9, 15);
        jPanel5.add(txtNombreUsuario, gridBagConstraints);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/page_find.png"))); // NOI18N
        jButton4.setPreferredSize(new java.awt.Dimension(30, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 9, 0);
        jPanel5.add(jButton4, gridBagConstraints);

        lbNoExiste.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNoExiste.setForeground(new java.awt.Color(255, 51, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 15, 4, 0);
        jPanel5.add(lbNoExiste, gridBagConstraints);

        jPanel2.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblUsuario.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tblUsuario);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       PnlUsuarioNuevo pvc = new PnlUsuarioNuevo();
       JLabel aviso = pvc.getLabelEscondido();
        JOptionPane.showInternalOptionDialog(this, pvc, "Registrar Nuevo Usuario",JOptionPane.OK_CANCEL_OPTION,
                                            JOptionPane.QUESTION_MESSAGE, null, new Object[]{aviso},null);
        if(pvc.IsProcesoOk())
        {
            this.reiniciarTabla();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bntActualizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntActualizarUsuarioActionPerformed
        int indice  = this.tblUsuario.getSelectedRow();
        if(indice != -1)
        {
            Usuario usuario = mdlUsuario.getUsuario(indice);
             PnlUsuarioNuevo pvc = new PnlUsuarioNuevo(usuario);
            JLabel aviso = pvc.getLabelEscondido();
           JOptionPane.showInternalOptionDialog(this, pvc, "Actualizar Datos de Usuario",JOptionPane.OK_CANCEL_OPTION,
                                            JOptionPane.QUESTION_MESSAGE, null, new Object[]{aviso},null);
            if(pvc.IsProcesoOk())
            {
                this.reiniciarTabla();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        }
    }//GEN-LAST:event_bntActualizarUsuarioActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int indice  = this.tblUsuario.getSelectedRow();
        if(indice != -1)
        {
            int confirmacion = JOptionPane.showConfirmDialog(null, "Eliminar usuario"
                    ,  "¿Desea Eliminar este Registro?",  JOptionPane.YES_NO_CANCEL_OPTION);
            if(confirmacion == JOptionPane.OK_OPTION)
            {
                int exito = mdlUsuario.Eliminar(indice);
                if(exito != 0)
                {
                    JOptionPane.showMessageDialog(null, "Registro Eliminado Correctamente");
                }else{
                    JOptionPane.showInternalMessageDialog(this, "No fue posible Borrar el registro."
                    , "Error!!", JOptionPane.ERROR_MESSAGE); 
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    DocumentListener EscuchadorBuscar = new DocumentListener(){
        @Override
        public void insertUpdate(DocumentEvent e) {
            mostrarRegistrosEncontrados(e);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            mostrarRegistrosEncontrados(e);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            mostrarRegistrosEncontrados(e);
        }
    };
    
    public void mostrarRegistrosEncontrados(DocumentEvent e)
    {
        try {
            String nombreBuscar = e.getDocument().getText(0, e.getDocument().getLength());
            ModelTablaUsuarios mtu = new ModelTablaUsuarios(nombreBuscar);
            if(!nombreBuscar.isEmpty())
            {
                if(mtu.estVacio())
                {
                    this.lbNoExiste.setText("El Usuario "+nombreBuscar+" no existe");
                    mdlUsuario = new ModelTablaUsuarios();                
                }else{
                    mdlUsuario = mtu;       
                    this.lbNoExiste.setText("");
                }               
            }else
            {
                mdlUsuario = new ModelTablaUsuarios();
            }
             this.tblUsuario.setModel(mdlUsuario);
            if(nombreBuscar.isEmpty())
            {
                this.lbNoExiste.setText("");
            }
            
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntActualizarUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNoExiste;
    private javax.swing.JTable tblUsuario;
    private javax.swing.JTextField txtNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
