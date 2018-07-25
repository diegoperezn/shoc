/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.controller.Panels;

import com.shoc.afip.shoc.IPuntoDeVenta;
import com.shoc.afip.shoc.ServicioAfipEnum;
import com.shoc.domain.Factura;
import com.shoc.domain.FacturaAfipEnum;
import com.shoc.domain.FacturaDetail;
import com.shoc.domain.SociedadEnum;
import com.shoc.domain.repository.AfipException;
import com.shoc.domain.service.AfipService;
import com.shoc.domain.service.FacturaGenerator;
import com.shoc.domain.service.FacturaService;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author diego
 */
public class FacturaDetails extends javax.swing.JPanel {

    FacturaService fService = FacturaService.getInstance();
    AfipService aService = AfipService.getInstance();

    Factura f = null;

    SimpleDateFormat format = new SimpleDateFormat("MM/yyyy");
    SimpleDateFormat completeFormat = new SimpleDateFormat("dd/MM/yyyy");

    DecimalFormat df = new DecimalFormat("##.##%");

    /**
     * Creates new form ObraSocialList
     */
    public FacturaDetails(Long id) {
        initComponents();

        //cbComprobantes.setVisible(false);
        //jLabel3.setVisible(false);
        f = fService.get(id);

        if (!f.eviadaAfip()) {
            FacturaAfipEnum[] list = FacturaAfipEnum.values();
            DefaultComboBoxModel<FacturaAfipEnum> model = new DefaultComboBoxModel<>();
            for (FacturaAfipEnum facturaAfipEnum : list) {
                model.addElement(facturaAfipEnum);
            }

            if (f.getObraSocial() != null) {
                cbSociedad1.setSelectedItem(SociedadEnum.CENTRO_SHOC);
            } else {
                cbSociedad1.setSelectedItem(SociedadEnum.TIZZIANO);
            }
            cbSociedad1ItemStateChanged(null);

            cbComprobantes.setModel(model);
        }

        popularPanel();
    }

    private void popularPanel() {

        if (f.getObraSocial() == null) {
            pObraSocial.setVisible(false);
        } else {
            obLabel.setText(f.getObraSocial().getRazonSocial());
        }

        if (f.getPaciente() == null) {
            pPaciente.setVisible(false);
        } else {
            pLabel.setText(f.getPaciente().getNombre());
        }

        fLabel.setText(f.getFecha().toString());

        lNoGrav.setText(NumberFormat.getCurrencyInstance(new Locale("es", "AR")).format(f.getImporteNoGravado()));
        lGrav.setText(NumberFormat.getCurrencyInstance(new Locale("es", "AR")).format(f.getImporteGravado()));
        lSubTotal.setText(NumberFormat.getCurrencyInstance(new Locale("es", "AR")).format(f.getSubtotal()));
        lIva.setText(NumberFormat.getCurrencyInstance(new Locale("es", "AR")).format(f.getMontoIva()));
        lTotal.setText(NumberFormat.getCurrencyInstance(new Locale("es", "AR")).format(f.getTotal()));

        panelEnvioAfip.setVisible(!f.eviadaAfip());
        panelDetalleAfip.setVisible(f.eviadaAfip());

        if (f.eviadaAfip()) {
            lTipoComp.setText(f.getTipoComprobante());
            lSociedad.setText(f.getSociedad().getDetail());
            lPtoVenta.setText(f.getPuntoDeVenta());
            lNroComprobante.setText(f.getNumeroComprobante().toString());
            lCAE.setText(f.getCae());
            lFechaEmision.setText(completeFormat.format(f.getFechaEmision()));
        }

        fillTable(f.getDetails());
    }

    private void fillTable(List<FacturaDetail> list) {
        DefaultTableModel model = (DefaultTableModel) tableCuentas.getModel();
        model.setRowCount(0);

        list.forEach((cuenta) -> {
            final String obraSocial = cuenta.getPaciente().getObraSocial() != null
                    ? cuenta.getPaciente().getObraSocial().getRazonSocial() : "Particular";
            model.addRow(new Object[]{cuenta.getPaciente().getNombre(),
                format.format(cuenta.getFecha()), obraSocial, cuenta.getDispositivo(),
                cuenta.getDias(), NumberFormat.getCurrencyInstance(new Locale("es", "AR")).format(cuenta.getCostoDispositivo()),
                df.format(cuenta.getAlicuota()), NumberFormat.getCurrencyInstance(new Locale("es", "AR")).format(cuenta.getMontoAlicuota()),
                NumberFormat.getCurrencyInstance(new Locale("es", "AR")).format(cuenta.getMonto()), NumberFormat.getCurrencyInstance(new Locale("es", "AR")).format(cuenta.getMontoFinal())
            }
            );
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCuentas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        pObraSocial = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        obLabel = new javax.swing.JLabel();
        pPaciente = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pLabel = new javax.swing.JLabel();
        fLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        lSubTotal = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lGrav = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lNoGrav = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lTotal = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lIva = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelEnvioAfip = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cbSociedad1 = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbServicio = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        cbComprobantes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbPtoVenta = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        panelDetalleAfip = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lSociedad = new javax.swing.JLabel();
        lPtoVenta = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lNroComprobante = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lCAE = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lFechaEmision = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lTipoComp = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        bCuentaCorriente = new javax.swing.JButton();

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tableCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paciente", "Fecha", "Obra Social", "Dispositivo", "Días", "Costo dipositivo", "Alícuota", "Monto Alícuota", "Monto", "Monto final"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCuentas.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(tableCuentas);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles"));

        jLabel7.setText("Obra Social:");

        obLabel.setText("obLabel");

        javax.swing.GroupLayout pObraSocialLayout = new javax.swing.GroupLayout(pObraSocial);
        pObraSocial.setLayout(pObraSocialLayout);
        pObraSocialLayout.setHorizontalGroup(
            pObraSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pObraSocialLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(obLabel)
                .addGap(0, 0, 0))
        );
        pObraSocialLayout.setVerticalGroup(
            pObraSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pObraSocialLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pObraSocialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pObraSocialLayout.createSequentialGroup()
                        .addComponent(obLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jLabel5.setText("Paciente:");

        pLabel.setText("pacienteLabel");

        javax.swing.GroupLayout pPacienteLayout = new javax.swing.GroupLayout(pPaciente);
        pPaciente.setLayout(pPacienteLayout);
        pPacienteLayout.setHorizontalGroup(
            pPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPacienteLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pLabel)
                .addContainerGap())
        );
        pPacienteLayout.setVerticalGroup(
            pPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPacienteLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pPacienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPacienteLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        fLabel.setText("fechaLabel");

        jLabel2.setText("Fecha creación:");

        jLabel18.setText("Subtotal:");

        lSubTotal.setText("lSubTotal");

        jLabel19.setText("Importe gravado:");

        lGrav.setText("lGrav");

        jLabel16.setText("Importe no grabado:");

        lNoGrav.setText("lNoGrav");

        jLabel20.setText("Total:");

        lTotal.setText("lTotal");

        jLabel21.setText("IVA:");

        lIva.setText("lIVA");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel16))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lSubTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lGrav, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lNoGrav, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lIva, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lGrav, lIva, lNoGrav, lSubTotal, lTotal});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lNoGrav))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lGrav)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lSubTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lIva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lTotal))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fLabel))
                    .addComponent(pObraSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pObraSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Detalles de Factura");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panelEnvioAfip.setBorder(javax.swing.BorderFactory.createTitledBorder("Afip"));

        jLabel9.setText("Sociedad:");

        cbSociedad1.setModel(new DefaultComboBoxModel<>(SociedadEnum.values()));
        cbSociedad1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSociedad1ItemStateChanged(evt);
            }
        });
        cbSociedad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSociedad1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbSociedad1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSociedad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setText("Afip:");

        cbServicio.setModel(new DefaultComboBoxModel<>(ServicioAfipEnum.values()));
        cbServicio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbServicioItemStateChanged(evt);
            }
        });
        cbServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbServicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(43, 43, 43)
                .addComponent(cbServicio, 0, 295, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbComprobantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbComprobantesActionPerformed(evt);
            }
        });

        jLabel3.setText("Factura tipo:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(30, 30, 30)
                .addComponent(cbComprobantes, 0, 220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbComprobantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jLabel6.setText("Punto de venta:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPtoVenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbPtoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setText("Enviar Afip");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEnvioAfipLayout = new javax.swing.GroupLayout(panelEnvioAfip);
        panelEnvioAfip.setLayout(panelEnvioAfipLayout);
        panelEnvioAfipLayout.setHorizontalGroup(
            panelEnvioAfipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnvioAfipLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEnvioAfipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEnvioAfipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEnvioAfipLayout.setVerticalGroup(
            panelEnvioAfipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnvioAfipLayout.createSequentialGroup()
                .addGroup(panelEnvioAfipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEnvioAfipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelEnvioAfipLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEnvioAfipLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton2)))
                .addContainerGap())
        );

        panelDetalleAfip.setBorder(javax.swing.BorderFactory.createTitledBorder("Afip"));

        jLabel8.setText("Sociedad:");

        lSociedad.setText("lSociedad");

        lPtoVenta.setText("lPtoVenta");

        jLabel10.setText("Punto de venta:");

        jLabel11.setText("Nro Comprobante:");

        lNroComprobante.setText("lNroCompro");

        jLabel12.setText("CAE:");

        lCAE.setText("lCAE");

        jLabel13.setText("Fecha Emisión:");

        lFechaEmision.setText("lFechaEmision");

        jLabel14.setText("Tipo comprobante:");

        lTipoComp.setText("lTipoComp");

        javax.swing.GroupLayout panelDetalleAfipLayout = new javax.swing.GroupLayout(panelDetalleAfip);
        panelDetalleAfip.setLayout(panelDetalleAfipLayout);
        panelDetalleAfipLayout.setHorizontalGroup(
            panelDetalleAfipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetalleAfipLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDetalleAfipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDetalleAfipLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lTipoComp, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                        .addGap(639, 639, 639))
                    .addGroup(panelDetalleAfipLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lSociedad)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lPtoVenta)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lNroComprobante)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lCAE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lFechaEmision)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelDetalleAfipLayout.setVerticalGroup(
            panelDetalleAfipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetalleAfipLayout.createSequentialGroup()
                .addGroup(panelDetalleAfipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lTipoComp, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDetalleAfipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lSociedad)
                    .addComponent(jLabel10)
                    .addComponent(lPtoVenta)
                    .addComponent(jLabel11)
                    .addComponent(lNroComprobante)
                    .addComponent(jLabel12)
                    .addComponent(lCAE)
                    .addComponent(jLabel13)
                    .addComponent(lFechaEmision))
                .addGap(10, 10, 10))
        );

        jButton1.setText("Ver factura");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bCuentaCorriente.setText("Ver cuenta corriente");
        bCuentaCorriente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCuentaCorrienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bCuentaCorriente)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(bCuentaCorriente))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelDetalleAfip, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelEnvioAfip, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEnvioAfip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDetalleAfip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bCuentaCorrienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCuentaCorrienteActionPerformed
        mainFrame topFrame = (mainFrame) SwingUtilities.getWindowAncestor(this);
        final Long cuentaId = f.getObraSocial() != null ? f.getObraSocial().getCuenta().getId() : f.getPaciente().getCuenta().getId();
        topFrame.changePanel(new MovimientosCuentaList(cuentaId), this);
    }//GEN-LAST:event_bCuentaCorrienteActionPerformed

    FacturaGenerator service = FacturaGenerator.getInstance();

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*
        mainFrame topFrame = (mainFrame) SwingUtilities.getWindowAncestor(this);
        try {
            topFrame.changePanel(this.service.generatePdfReport(f.getId()), this);
            //topFrame.changePanel(new FacturaPanel(f.getId()), this);
        } catch (JRException ex) {
            Logger.getLogger(FacturaDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
        try {
            mainFrame topFrame = (mainFrame) SwingUtilities.getWindowAncestor(this);
            final JDialog frame = new JDialog(topFrame, "Factura", true);
            final JRViewer generatePdfReport = this.service.generatePdfReport(f.getId());

            frame.getContentPane().add(generatePdfReport);
            frame.pack();
            frame.setSize(1000, 1000);
            frame.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(FacturaDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbServicioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbServicioItemStateChanged
        cbComprobantes.setEnabled(false);

        try {
            final SociedadEnum sociedad = (SociedadEnum) cbSociedad1.getSelectedItem();

            //this.aService.listarTiposComprobante(sociedad)
            //        .parallelStream().forEach(i -> cbComprobantes.addItem(i));
            cbPtoVenta.removeAllItems();

            this.aService.listarPuntosVenta(sociedad, (ServicioAfipEnum) cbServicio.getSelectedItem())
                    .parallelStream().forEach(i -> cbPtoVenta.addItem(i));

            Logger.getLogger(FacturaDetails.class.getName()).log(Level.INFO, "Buscando comprobantes para " + sociedad);
        } catch (IOException ex) {
            Logger.getLogger(FacturaDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

        cbComprobantes.setEnabled(true);
    }//GEN-LAST:event_cbServicioItemStateChanged

    private void cbServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbServicioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {

            Factura factura = fService.get(f.getId());
            if (!factura.eviadaAfip()) {

                if (((ServicioAfipEnum) cbServicio.getSelectedItem()).equals(ServicioAfipEnum.WSMTXCA)) {
                    aService.enviarFacturaAfipConDetalle(
                            (SociedadEnum) cbSociedad1.getSelectedItem(),
                            (FacturaAfipEnum) cbComprobantes.getSelectedItem(),
                            (IPuntoDeVenta) cbPtoVenta.getSelectedItem(),
                            f);
                } else {
                    aService.enviarFacturaAfipSinDetalle(
                            (SociedadEnum) cbSociedad1.getSelectedItem(),
                            (FacturaAfipEnum) cbComprobantes.getSelectedItem(),
                            (IPuntoDeVenta) cbPtoVenta.getSelectedItem(),
                            f);
                }

                this.f = f;
            } else {
                this.f = factura;
            }

            popularPanel();

            JOptionPane.showMessageDialog(this, "La factura se ha enviado a la AFIP con numero de comprobante: " + f.getNumeroComprobante(), "", JOptionPane.INFORMATION_MESSAGE);

        } catch (AfipException ex) {
            String errores = new String();

            String error = new String();
            for (String e : ex.getErrores()) {
                error += e + "\n";
            }

            JOptionPane.showMessageDialog(this,
                    error,
                    "AFIP errores", JOptionPane.ERROR_MESSAGE);

            Logger.getLogger(FacturaDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbComprobantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbComprobantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbComprobantesActionPerformed

    private void cbSociedad1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSociedad1ItemStateChanged
        cbComprobantes.setEnabled(false);

        try {
            final SociedadEnum sociedad = (SociedadEnum) cbSociedad1.getSelectedItem();

            //this.aService.listarTiposComprobante(sociedad)
            //        .parallelStream().forEach(i -> cbComprobantes.addItem(i));
            this.aService.listarPuntosVenta(sociedad, (ServicioAfipEnum) cbServicio.getSelectedItem())
                    .parallelStream().forEach(i -> cbPtoVenta.addItem(i));

            Logger.getLogger(FacturaDetails.class.getName()).log(Level.INFO, "Buscando comprobantes para " + sociedad);
        } catch (IOException ex) {
            Logger.getLogger(FacturaDetails.class.getName()).log(Level.SEVERE, null, ex);
        }

        cbComprobantes.setEnabled(true);
    }//GEN-LAST:event_cbSociedad1ItemStateChanged

    private void cbSociedad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSociedad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSociedad1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCuentaCorriente;
    private javax.swing.JComboBox<FacturaAfipEnum> cbComprobantes;
    private javax.swing.JComboBox<IPuntoDeVenta> cbPtoVenta;
    private javax.swing.JComboBox<ServicioAfipEnum> cbServicio;
    private javax.swing.JComboBox<SociedadEnum> cbSociedad1;
    private javax.swing.JLabel fLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lCAE;
    private javax.swing.JLabel lFechaEmision;
    private javax.swing.JLabel lGrav;
    private javax.swing.JLabel lIva;
    private javax.swing.JLabel lNoGrav;
    private javax.swing.JLabel lNroComprobante;
    private javax.swing.JLabel lPtoVenta;
    private javax.swing.JLabel lSociedad;
    private javax.swing.JLabel lSubTotal;
    private javax.swing.JLabel lTipoComp;
    private javax.swing.JLabel lTotal;
    private javax.swing.JLabel obLabel;
    private javax.swing.JLabel pLabel;
    private javax.swing.JPanel pObraSocial;
    private javax.swing.JPanel pPaciente;
    private javax.swing.JPanel panelDetalleAfip;
    private javax.swing.JPanel panelEnvioAfip;
    private javax.swing.JTable tableCuentas;
    // End of variables declaration//GEN-END:variables

}
