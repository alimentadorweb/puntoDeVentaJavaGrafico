/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventanas;

import clases.Cliente;
import clases.ModelTablaClientes;
import clases.ModelTablaUsuarios;
import java.awt.Rectangle;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import paneles.PnlNuevoCliente;

/**
 *
 * @author puntodeventa-jlat
 */
public class IRegistroClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form IRegistroClientes
     */
    private ModelTablaClientes mdlCliente;
    public IRegistroClientes(JDesktopPane mainApp) {
        initComponents();
        mdlCliente = new ModelTablaClientes();
        this.tblClientes.setModel(mdlCliente);
        Rectangle visibleRect = mainApp.getVisibleRect();       
        this.setSize(visibleRect.width-160, visibleRect.height);
        this.tblClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.txtNombreCliente.getDocument().addDocumentListener(EscuchadorBuscar);
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
        jPanel3 = new javax.swing.JPanel();
        bntNuevo = new javax.swing.JButton();
        bntActualizar = new javax.swing.JButton();
        bntEliminar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        lbNoExiste = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clientes");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.GridLayout());

        bntNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/page_add.png"))); // NOI18N
        bntNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNuevoActionPerformed(evt);
            }
        });
        jPanel3.add(bntNuevo);

        bntActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/page_edit.png"))); // NOI18N
        bntActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntActualizarActionPerformed(evt);
            }
        });
        jPanel3.add(bntActualizar);

        bntEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/page_delete.png"))); // NOI18N
        bntEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(bntEliminar);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nombre del Cliente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 9, 10, 10);
        jPanel4.add(jLabel1, gridBagConstraints);

        txtNombreCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombreCliente.setPreferredSize(new java.awt.Dimension(120, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 8);
        jPanel4.add(txtNombreCliente, gridBagConstraints);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/page_find.png"))); // NOI18N
        jButton4.setPreferredSize(new java.awt.Dimension(33, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 12);
        jPanel4.add(jButton4, gridBagConstraints);

        lbNoExiste.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbNoExiste.setForeground(new java.awt.Color(255, 51, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 10, 6);
        jPanel4.add(lbNoExiste, gridBagConstraints);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        tblClientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblClientes);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNuevoActionPerformed
       PnlNuevoCliente pvc = new PnlNuevoCliente();
       JLabel aviso = pvc.getLabelEscondido();
        JOptionPane.showInternalOptionDialog(this, pvc, "Registrar Nuevo Usuario",JOptionPane.OK_CANCEL_OPTION,
                                            JOptionPane.QUESTION_MESSAGE, null, new Object[]{aviso},null);
        if(pvc.IsProcesoOk())
        {
            this.reiniciarTabla();
        }
    }//GEN-LAST:event_bntNuevoActionPerformed

    private void bntActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntActualizarActionPerformed
         int indice  = this.tblClientes.getSelectedRow();
        if(indice != -1)
        {
            Cliente cliente = mdlCliente.getCliente(indice);
            PnlNuevoCliente pvc = new PnlNuevoCliente(cliente);
            JLabel aviso = pvc.getLabelEscondido();
            JOptionPane.showInternalOptionDialog(this, pvc, "Actualizar Datos de Cliente",JOptionPane.OK_CANCEL_OPTION,
                                            JOptionPane.QUESTION_MESSAGE, null, new Object[]{aviso},null);
            if(pvc.IsProcesoOk())
            {
                this.reiniciarTabla();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        }
    }//GEN-LAST:event_bntActualizarActionPerformed

    private void bntEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntEliminarActionPerformed
      int indice  = this.tblClientes.getSelectedRow();
        if(indice != -1)
        {
            int confirmacion = JOptionPane.showConfirmDialog(null, "Eliminar Cliente"
                    ,  "¿Desea Eliminar este Registro?",  JOptionPane.YES_NO_CANCEL_OPTION);
            if(confirmacion == JOptionPane.OK_OPTION)
            {
                int exito = mdlCliente.Eliminar(indice);
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
    }//GEN-LAST:event_bntEliminarActionPerformed

    
     private void reiniciarTabla()
    {
         mdlCliente = new ModelTablaClientes(); 
         this.tblClientes.setModel(mdlCliente);   
    }

    
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
            ModelTablaClientes mtu = new ModelTablaClientes(nombreBuscar);
            if(!nombreBuscar.isEmpty())
            {
                if(mtu.estVacio())
                {
                    this.lbNoExiste.setText("El Cliente "+nombreBuscar+" no existe");
                    mdlCliente = new ModelTablaClientes();                
                }else{
                    mdlCliente = mtu;       
                    this.lbNoExiste.setText("");
                }               
            }else
            {
                mdlCliente = new ModelTablaClientes();
            }
             this.tblClientes.setModel(mdlCliente);
            if(nombreBuscar.isEmpty())
            {
                this.lbNoExiste.setText("");
            }
            
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntActualizar;
    private javax.swing.JButton bntEliminar;
    private javax.swing.JButton bntNuevo;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNoExiste;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables
}
