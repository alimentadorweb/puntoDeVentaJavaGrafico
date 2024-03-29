package paneles;

import clases.Cliente;
import clases.Pago;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author puntodeventa-jlat
 */
public class PnlNuevoPago extends javax.swing.JPanel {

    /**
     * Creates new form PnlNuevoPago
     */
    private Pago nuevoPago;
    private boolean esPagoNuevo = true;
    private boolean procesoOk = false;
    private JOptionPane op;
    public PnlNuevoPago() {
        initComponents();
        nuevoPago = new Pago();
        this.lbShow.setVisible(false);
        this.bntImprimir.setVisible(false);
    }
    
    
    public PnlNuevoPago(Pago nuevoPago) {
        initComponents();
        this.nuevoPago= nuevoPago;
        esPagoNuevo = false;
        this.lbShow.setVisible(false);
        //this.bntCancelar.setVisible(false);
        this.dcFechaRegistro.setDate(nuevoPago.getFechaDeRegistro());        
        setValoresCliente();
        this.dcFechaCubierta.setDate(nuevoPago.getFechaCubierta());
        this.spnMesesTranscurridos.setValue(nuevoPago.getMesesTranscurridos());
        this.dcFechaAPagar.setDate(nuevoPago.getFechaDePago());
        this.txtRezago.setValue(nuevoPago.getRezago());
        this.txtRecargo.setValue(nuevoPago.getRecargo());
        this.txtIva.setValue(nuevoPago.getPagoCalculado());
        this.txtTotal.setValue(nuevoPago.getTotal());
        this.bntImprimir.setEnabled(true);
    }
    
    public JLabel getLabelEscondido()
    {
        return this.lbShow;
    }
    
    private void setValoresCliente()
    {
        this.txtCodigoCliente.setText(""+nuevoPago.getNroCuenta().getNumeroCuenta());
        this.txtNombreCliente.setText(nuevoPago.getNroCuenta().getNombre());
        this.txtDireccion.setText(nuevoPago.getNroCuenta().getDireccion());
        this.txtColonia.setText(nuevoPago.getNroCuenta().getColonia());
        this.txtMunicipio.setText(nuevoPago.getNroCuenta().getMunicipio());
        this.txtTelefono.setText(nuevoPago.getNroCuenta().getTelefono());
        this.txtTarifa.setText(nuevoPago.getNroCuenta().getTarifa());
        this.txtRfc.setText(nuevoPago.getNroCuenta().getRfc());
    }
    
     public boolean IsProcesoOk()
    {
        return procesoOk;
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
        jLabel1 = new javax.swing.JLabel();
        dcFechaRegistro = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCodigoCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtColonia = new javax.swing.JTextField();
        txtMunicipio = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtRfc = new javax.swing.JTextField();
        txtTarifa = new javax.swing.JTextField();
        bntBuscarCliente = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        bntCalcular = new javax.swing.JButton();
        bntPagar = new javax.swing.JButton();
        bntImprimir = new javax.swing.JButton();
        bntCancelar = new javax.swing.JButton();
        lbShow = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        dcFechaCubierta = new com.toedter.calendar.JDateChooser();
        dcFechaAPagar = new com.toedter.calendar.JDateChooser();
        spnMesesTranscurridos = new javax.swing.JSpinner();
        txtRezago = new javax.swing.JFormattedTextField();
        txtTotal = new javax.swing.JFormattedTextField();
        txtIva = new javax.swing.JFormattedTextField();
        txtRecargo = new javax.swing.JFormattedTextField();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Fecha de Registro:");
        jPanel2.add(jLabel1);

        dcFechaRegistro.setDate(Calendar.getInstance().getTime());
        dcFechaRegistro.setDateFormatString("dd/MM/yyyy");
        dcFechaRegistro.setPreferredSize(new java.awt.Dimension(120, 20));
        jPanel2.add(dcFechaRegistro);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Codigo del Cliente:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 16, 0, 0);
        jPanel4.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(8, 16, 0, 0);
        jPanel4.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Direccion:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(8, 16, 0, 0);
        jPanel4.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Colonia:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(8, 16, 0, 0);
        jPanel4.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Municipio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(8, 7, 0, 0);
        jPanel4.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Telefono:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 16, 0, 0);
        jPanel4.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Rfc:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(8, 17, 0, 0);
        jPanel4.add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Tarifa:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(8, 16, 13, 0);
        jPanel4.add(jLabel9, gridBagConstraints);

        txtCodigoCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCodigoCliente.setPreferredSize(new java.awt.Dimension(120, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 12, 0, 0);
        jPanel4.add(txtCodigoCliente, gridBagConstraints);

        txtNombreCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombreCliente.setPreferredSize(new java.awt.Dimension(240, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 0, 6);
        jPanel4.add(txtNombreCliente, gridBagConstraints);

        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDireccion.setPreferredSize(new java.awt.Dimension(120, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 0, 6);
        jPanel4.add(txtDireccion, gridBagConstraints);

        txtColonia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtColonia.setPreferredSize(new java.awt.Dimension(120, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 0, 0);
        jPanel4.add(txtColonia, gridBagConstraints);

        txtMunicipio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMunicipio.setPreferredSize(new java.awt.Dimension(120, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 0, 9);
        jPanel4.add(txtMunicipio, gridBagConstraints);

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTelefono.setPreferredSize(new java.awt.Dimension(120, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 0, 0);
        jPanel4.add(txtTelefono, gridBagConstraints);

        txtRfc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRfc.setPreferredSize(new java.awt.Dimension(120, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 0, 9);
        jPanel4.add(txtRfc, gridBagConstraints);

        txtTarifa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTarifa.setPreferredSize(new java.awt.Dimension(120, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(8, 12, 13, 0);
        jPanel4.add(txtTarifa, gridBagConstraints);

        bntBuscarCliente.setText("Buscar Cliente");
        bntBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntBuscarClienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        jPanel4.add(bntBuscarCliente, gridBagConstraints);

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new java.awt.GridBagLayout());

        bntCalcular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bntCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/calculator.png"))); // NOI18N
        bntCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCalcularActionPerformed(evt);
            }
        });
        jPanel5.add(bntCalcular, new java.awt.GridBagConstraints());

        bntPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bntPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/coins.png"))); // NOI18N
        bntPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPagarActionPerformed(evt);
            }
        });
        jPanel5.add(bntPagar, new java.awt.GridBagConstraints());

        bntImprimir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bntImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/printer.png"))); // NOI18N
        bntImprimir.setEnabled(false);
        bntImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntImprimirActionPerformed(evt);
            }
        });
        jPanel5.add(bntImprimir, new java.awt.GridBagConstraints());

        bntCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bntCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/imagenes/cancel.png"))); // NOI18N
        bntCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntCancelarActionPerformed(evt);
            }
        });
        jPanel5.add(bntCancelar, new java.awt.GridBagConstraints());
        jPanel5.add(lbShow, new java.awt.GridBagConstraints());

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_END);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Fecha Cubierta:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 5);
        jPanel6.add(jLabel10, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Meses Transcurridos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 0, 5);
        jPanel6.add(jLabel11, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Fecha a Pagar:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 0, 5);
        jPanel6.add(jLabel12, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Rezagos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 7);
        jPanel6.add(jLabel13, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Recargos:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 7);
        jPanel6.add(jLabel14, gridBagConstraints);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("IVA:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 0, 7);
        jPanel6.add(jLabel15, gridBagConstraints);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Total:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 5, 7);
        jPanel6.add(jLabel16, gridBagConstraints);

        dcFechaCubierta.setDateFormatString("dd/MM/yyyy");
        dcFechaCubierta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dcFechaCubierta.setPreferredSize(new java.awt.Dimension(120, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 10);
        jPanel6.add(dcFechaCubierta, gridBagConstraints);

        dcFechaAPagar.setDateFormatString("dd/MM/yyyy");
        dcFechaAPagar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dcFechaAPagar.setPreferredSize(new java.awt.Dimension(120, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 0, 10);
        jPanel6.add(dcFechaAPagar, gridBagConstraints);

        spnMesesTranscurridos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spnMesesTranscurridos.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spnMesesTranscurridos.setPreferredSize(new java.awt.Dimension(120, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 0, 10);
        jPanel6.add(spnMesesTranscurridos, gridBagConstraints);

        txtRezago.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtRezago.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRezago.setPreferredSize(new java.awt.Dimension(80, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 6);
        jPanel6.add(txtRezago, gridBagConstraints);

        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTotal.setPreferredSize(new java.awt.Dimension(80, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 5, 6);
        jPanel6.add(txtTotal, gridBagConstraints);

        txtIva.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIva.setPreferredSize(new java.awt.Dimension(80, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 0, 6);
        jPanel6.add(txtIva, gridBagConstraints);

        txtRecargo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtRecargo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRecargo.setPreferredSize(new java.awt.Dimension(80, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(9, 0, 0, 6);
        jPanel6.add(txtRecargo, gridBagConstraints);

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void bntCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCalcularActionPerformed
       if(nuevoPago.getNroCuenta() == null)
       {
           JOptionPane.showInternalMessageDialog(this, "Porfavor seleccione un Cliente"
                    , "Debe seleccionar un cliente", JOptionPane.ERROR_MESSAGE);
           return;
       }
       
       if(this.dcFechaCubierta.getCalendar() == null)
       {
           JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fecha Cubierta"
                    , "Seleccione Fecha Cubierta", JOptionPane.ERROR_MESSAGE);
           return;
       }
       
       if(this.dcFechaAPagar.getCalendar() == null)
       {
           JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fecha a Pagar"
                    , "Seleccione Fecha a Pagar", JOptionPane.ERROR_MESSAGE);
           return;
       }
       
       Date fechaCubierta = this.dcFechaCubierta.getCalendar().getTime();
       Date fechaAPagar = this.dcFechaAPagar.getCalendar().getTime();
       if(fechaCubierta.after(fechaAPagar))
       {
           JOptionPane.showInternalMessageDialog(this, "Fecha Cubierta debe ser menor que Fecha a Pagar."
                    , "Error en Fechas!!", JOptionPane.ERROR_MESSAGE);
           return;
       }
       
       if(this.txtTarifa.getText().equalsIgnoreCase("Domestico"))
       {
          CalcularCostos(fechaCubierta,fechaAPagar,61.50F,0); 
       }
       
       if(this.txtTarifa.getText().equalsIgnoreCase("Comercial"))
       {
          CalcularCostos(fechaCubierta,fechaAPagar,202.00F,0.16F); 
       }
       
       if(this.txtTarifa.getText().equalsIgnoreCase("Industrial"))
       {
          CalcularCostos(fechaCubierta,fechaAPagar,790.00F,0.16F); 
       }
       
       if(this.txtTarifa.getText().equalsIgnoreCase("Publico"))
       {
          CalcularCostos(fechaCubierta,fechaAPagar,550.00F,0); 
       }
       
       if(this.txtTarifa.getText().equalsIgnoreCase("Insen"))
       {
          CalcularCostos(fechaCubierta,fechaAPagar,42.50F,0); 
       }
       
       if(this.txtTarifa.getText().equalsIgnoreCase("Baldio"))
       {
          CalcularCostos(fechaCubierta,fechaAPagar,20.00F,0); 
       }
       
       if(this.txtTarifa.getText().equalsIgnoreCase("Especial"))
       {
          CalcularCostos(fechaCubierta,fechaAPagar,1500.00F,0); 
       }
            
       
    }//GEN-LAST:event_bntCalcularActionPerformed

    private void bntCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntCancelarActionPerformed
       getOptionPane();
       op.setValue(1);
    }//GEN-LAST:event_bntCancelarActionPerformed

    private void bntBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntBuscarClienteActionPerformed
        PnlBuscarClientes pvc = new PnlBuscarClientes();
       JLabel aviso = pvc.getLabelEscondido();
        JOptionPane.showOptionDialog(this, pvc, "Registrar Seleccionar Cliente",JOptionPane.OK_CANCEL_OPTION,
                                            JOptionPane.QUESTION_MESSAGE, null, new Object[]{aviso},null);
       
        Cliente cl = pvc.getNuevoCliente();
        if(cl != null)
        {
            
            nuevoPago.setNroCuenta(cl);
            setValoresCliente();
        }
        
    }//GEN-LAST:event_bntBuscarClienteActionPerformed

    private void bntPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPagarActionPerformed
       
       if(nuevoPago.getNroCuenta() == null)
       {
           JOptionPane.showInternalMessageDialog(this, "Porfavor seleccione un Cliente"
                    , "Debe seleccionar un cliente", JOptionPane.ERROR_MESSAGE);
           return;
       }
       
       if(this.dcFechaCubierta.getCalendar() == null)
       {
           JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fecha Cubierta"
                    , "Seleccione Fecha Cubierta", JOptionPane.ERROR_MESSAGE);
           return;
       }
       
       if(this.dcFechaAPagar.getCalendar() == null)
       {
           JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fecha a Pagar"
                    , "Seleccione Fecha a Pagar", JOptionPane.ERROR_MESSAGE);
           return;
       } 
       nuevoPago.setFechaDeRegistro(this.dcFechaRegistro.getCalendar().getTime());
       nuevoPago.setFechaCubierta(this.dcFechaCubierta.getCalendar().getTime());
       nuevoPago.setMesesTranscurridos(Integer.parseInt(this.spnMesesTranscurridos.getValue().toString()));
       nuevoPago.setFechaDePago(this.dcFechaAPagar.getCalendar().getTime());
       nuevoPago.setRezago(Double.parseDouble(this.txtRezago.getValue().toString()));
       nuevoPago.setPagoCalculado(Double.parseDouble(this.txtIva.getValue().toString()));
       nuevoPago.setRecargo(Double.parseDouble(this.txtRecargo.getValue().toString()));
       nuevoPago.setTotal(Double.parseDouble(this.txtTotal.getValue().toString()));
       
        if(this.esPagoNuevo)
       {
           if(nuevoPago != null)
           {
               int grabar = nuevoPago.grabar();
               if(grabar != 0)
               {
                   procesoOk = true;
                   int confirmar = JOptionPane.showConfirmDialog(this, "Pago grabado correctamente.\n ¿Desea imprimir este pago", "Pago Realizado correctamente", JOptionPane.YES_NO_CANCEL_OPTION);
                   if(confirmar == JOptionPane.OK_OPTION)
                   {
                       
                       PnlImprimirPago pvc = new PnlImprimirPago(nuevoPago);
                        JLabel aviso = pvc.getLabelEscondido();
                         JOptionPane.showOptionDialog(this, pvc, "Imprimir Pago",JOptionPane.OK_CANCEL_OPTION,
                                                             JOptionPane.QUESTION_MESSAGE, null, new Object[]{aviso},null);


                         if(pvc.getProcesoOk())
                         {            
                           int inconfirm = JOptionPane.showConfirmDialog(this, "¿Desea registrar otro Pago?", "La Impresion se realizo corectamente",JOptionPane.INFORMATION_MESSAGE); 
                           if(inconfirm != JOptionPane.OK_OPTION)
                           {
                               getOptionPane();
                               op.setValue(1);
                           }
                         }else
                         {
                             getOptionPane();
                              op.setValue(1);
                         }
                       
                   }else
                   {
                       getOptionPane();
                       op.setValue(1);
                   }
               }else{
                   JOptionPane.showMessageDialog(this, "No fue posible grabar este Pago", "Error!", JOptionPane.ERROR_MESSAGE);
               }
           }
       }else{
           int grabar = nuevoPago.actualizar();
           if(grabar != 0)
           {
               procesoOk = true;
               JOptionPane.showMessageDialog(this, "Pago Actualizado Correctamente", "Actualizacion de Pago", JOptionPane.INFORMATION_MESSAGE);
               getOptionPane();
               op.setValue(1);
               this.bntImprimir.setEnabled(true); 
           }else
           {
               JOptionPane.showMessageDialog(this, "No fue posible actualizar este Pago", "Error!", JOptionPane.ERROR_MESSAGE);
           }
       }
    }//GEN-LAST:event_bntPagarActionPerformed

    private void bntImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntImprimirActionPerformed

              
        if(nuevoPago == null)
        {
            JOptionPane.showMessageDialog(this, "Imposible imprimir un pago sin datos", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(nuevoPago.getNroCuenta() == null)
        {
            JOptionPane.showMessageDialog(this, "Primero debe escoger un cliente", "Pago sin cliente!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(this.dcFechaCubierta.getCalendar() == null)
       {
           JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fecha Cubierta"
                    , "Seleccione Fecha Cubierta", JOptionPane.ERROR_MESSAGE);
           return;
       }
       
       if(this.dcFechaAPagar.getCalendar() == null)
       {
           JOptionPane.showInternalMessageDialog(this, "Debe seleccionar una fecha a Pagar"
                    , "Seleccione Fecha a Pagar", JOptionPane.ERROR_MESSAGE);
           return;
       }
        
       PnlImprimirPago pvc = new PnlImprimirPago(nuevoPago);
       JLabel aviso = pvc.getLabelEscondido();
        JOptionPane.showOptionDialog(this, pvc, "Imprimir Pago",JOptionPane.OK_CANCEL_OPTION,
                                            JOptionPane.QUESTION_MESSAGE, null, new Object[]{aviso},null);
       
        
        if(pvc.getProcesoOk())
        {            
            JOptionPane.showMessageDialog(this, "Pago Imprimido correctamente", "Registrar Seleccionar Cliente",JOptionPane.INFORMATION_MESSAGE);      
        }
        
    }//GEN-LAST:event_bntImprimirActionPerformed

    
    public void CalcularCostos(Date fechaMenor,Date fechaMayor,float costoBase,float tmpiva)
    {
        
         float costo=0,total=0;
         float recar=0,rec=0;
         int numero=0;
         int numero2=0;
         float iva=0;
         float total2=0;
        
       int mesesTranscurrido = 0; 
       SimpleDateFormat anioFechaMenor = new SimpleDateFormat("yyyy");
       int anioMenor = Integer.parseInt(anioFechaMenor.format(fechaMenor));
       
       SimpleDateFormat mesFechaMenor = new SimpleDateFormat("MM");
       int mesMenor = Integer.parseInt(mesFechaMenor.format(fechaMenor));
       
       SimpleDateFormat diaFechaMenor = new SimpleDateFormat("dd");
       int diaMenor = Integer.parseInt(diaFechaMenor.format(fechaMenor));
       
       SimpleDateFormat anioFechaMayor = new SimpleDateFormat("yyyy");
       int anioMayor = Integer.parseInt(anioFechaMayor.format(fechaMayor));
       
       SimpleDateFormat mesFechaMayor = new SimpleDateFormat("MM");
       int mesMayor = Integer.parseInt(mesFechaMayor.format(fechaMayor));
       
       SimpleDateFormat diaFechaMayor = new SimpleDateFormat("dd");
       int diaMayor = Integer.parseInt(diaFechaMayor.format(fechaMayor));
       
       if(anioMenor <= anioMayor)
       {          
           if(mesMenor < mesMayor || mesMenor == mesMayor)
           {
                int anios = anioMayor - anioMenor;
                int totalMeses = 0;
                if(anios>=1)
                {
                     totalMeses = (12*anios) - mesMenor;               
                     mesMenor = totalMeses;
                     mesesTranscurrido = mesMenor+mesMayor;
                }
                if(anios == 0)
                {
                    mesesTranscurrido = mesMayor - mesMenor; 
                }
               
               if(mesMenor == mesMayor && anioMenor == anioMayor)
               {
                  mesesTranscurrido = 1; 
               }
               
             costo=(float) (costoBase * mesesTranscurrido);
             recar=(float) (costoBase * mesesTranscurrido)*(float)0.03;
             numero = (int)(recar * 100);
             rec =(float)(numero/100.0);
             iva=tmpiva;
             total= costo+rec+iva;
             numero2= (int)(total*100);
             total2=(float)(numero2/100.0);
             if(mesMenor == mesMayor)
             {
               mesesTranscurrido = 0; 
             }
             this.spnMesesTranscurridos.setValue(mesesTranscurrido);
             this.txtRezago.setValue(costo);
             this.txtRecargo.setValue(rec);
             this.txtTotal.setValue(total2);
             this.txtIva.setValue(iva);
             
           }
       }
       
    }
    
    
     private void getOptionPane()
    {
        if(op != null)
        {
            return;
        }
        Component pdr =this.getParent(); 
        while(pdr.getParent() != null)
        {
            if(pdr instanceof JOptionPane)
            {
                op = (JOptionPane)pdr;
                break;
            }            
            pdr = pdr.getParent();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntBuscarCliente;
    private javax.swing.JButton bntCalcular;
    private javax.swing.JButton bntCancelar;
    private javax.swing.JButton bntImprimir;
    private javax.swing.JButton bntPagar;
    private com.toedter.calendar.JDateChooser dcFechaAPagar;
    private com.toedter.calendar.JDateChooser dcFechaCubierta;
    private com.toedter.calendar.JDateChooser dcFechaRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbShow;
    private javax.swing.JSpinner spnMesesTranscurridos;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JFormattedTextField txtIva;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JFormattedTextField txtRecargo;
    private javax.swing.JFormattedTextField txtRezago;
    private javax.swing.JTextField txtRfc;
    private javax.swing.JTextField txtTarifa;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JFormattedTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
