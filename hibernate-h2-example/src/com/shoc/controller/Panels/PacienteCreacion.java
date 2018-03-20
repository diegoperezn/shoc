/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.controller.Panels;

import com.shoc.domain.DispositivosEnum;
import com.shoc.domain.IPaciente;
import com.shoc.domain.ObraSocial;
import com.shoc.domain.Paciente;
import com.shoc.domain.service.ObraSocialService;
import com.shoc.domain.service.PacienteService;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;

/**
 *
 * @author diego
 */
public class PacienteCreacion extends javax.swing.JPanel implements IPaciente {
    
    ObraSocialService obService = ObraSocialService.getInstance();
    PacienteService pService = PacienteService.getInstance();

    /**
     * Creates new form PacienteCreacion
     */
    public PacienteCreacion() {
        initComponents();
        initFields();
    }
    
    public PacienteCreacion(Long id, Boolean editable) {
        initComponents();
        initFields();
        
        Paciente p = this.pService.get(id);
        this.tfHistoriaClinica.setText(id.toString());
        this.tfNombre.setText(p.getNombre());
        this.tfDocumento.setText(p.getDocumento());
        this.taObservaciones.setText(p.getObservaciones());
        
        this.tfCelular.setText(p.getCelular());
        this.tfTelefono.setText(p.getTelefono());
        this.tfEmail.setText(p.getEmail());
        this.tfResponsable.setText(p.getResponsable());
        
        this.tfDireccion.setText(p.getDireccion());
        this.tfProvincia.setText(p.getProvincia());
        this.tfLocalidad.setText(p.getLocalidad());
        
        this.dpIngreso.setDate(p.getIngreso());
        this.dpVencimientoBeca.setDate(p.getVencimientoBeca());
        this.tfTerapista.setText(p.getTerapista());
        this.cbObraSocial.setSelectedItem(p.getObraSocial());
        this.tfDispositivo.setText(p.getDispositivo());
        this.dpCambioDispositivo.setDate(p.getCambioDispositivo());
        this.cbDispositivoTerapia.setSelectedItem(p.getDispositivoTerapia());
        this.tfFase.setText(p.getFase());
        this.dpAusencia.setDate(p.getAusencia());
        this.dpEgreso.setDate(p.getEgreso());
        this.taEgreso.setText(p.getCausalEgreso());        
    }
    
    public void initFields() {
        List<ObraSocial> obraSociales = obService.listAll();
        
        cbObraSocial.addItem(null);
        for (ObraSocial obraSociale : obraSociales) {
            cbObraSocial.addItem(obraSociale);
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

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        cbGravado = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taObservaciones = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        tfDocumento = new javax.swing.JTextField();
        tfHistoriaClinica = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tfCelular = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfTelefono = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfResponsable = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tfLocalidad = new javax.swing.JTextField();
        tfDireccion = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tfProvincia = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        dpVencimientoBeca = new org.jdesktop.swingx.JXDatePicker();
        jLabel13 = new javax.swing.JLabel();
        cbObraSocial = new javax.swing.JComboBox<>();
        tfFase = new javax.swing.JTextField();
        dpAusencia = new org.jdesktop.swingx.JXDatePicker();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dpEgreso = new org.jdesktop.swingx.JXDatePicker();
        jScrollPane2 = new javax.swing.JScrollPane();
        taEgreso = new javax.swing.JTextArea();
        dpIngreso = new org.jdesktop.swingx.JXDatePicker();
        dpCambioDispositivo = new org.jdesktop.swingx.JXDatePicker();
        tfDispositivo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        tfTerapista = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cbDispositivoTerapia = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("General"));

        jLabel10.setText("Historia clinica:");

        cbGravado.setText("Gravado");

        jLabel7.setText("Observaciones:");

        taObservaciones.setColumns(10);
        taObservaciones.setRows(5);
        jScrollPane1.setViewportView(taObservaciones);

        jLabel3.setText("Documento:");

        tfHistoriaClinica.setEditable(false);

        jLabel1.setText("Nombre y apellido:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfHistoriaClinica, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbGravado)
                        .addGap(85, 85, 85))
                    .addComponent(tfNombre)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addComponent(tfDocumento, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfHistoriaClinica)
                    .addComponent(cbGravado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfDocumento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        tfDocumento.getAccessibleContext().setAccessibleName("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Contacto"));

        jLabel6.setText("Responsable:");

        jLabel4.setText("Celular:");

        jLabel5.setText("Telefono:");

        jLabel8.setText("Email:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfCelular)
                    .addComponent(tfTelefono)
                    .addComponent(tfResponsable))
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCelular)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTelefono)
                    .addComponent(jLabel5))
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEmail)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfResponsable)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Domicilio"));

        jLabel23.setText("Provincia:");

        jLabel20.setText("Localidad:");

        jLabel22.setText("Direccion:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(73, 73, 73)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfLocalidad, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                    .addComponent(tfProvincia)
                    .addComponent(tfDireccion))
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDireccion)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfProvincia)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLocalidad)
                    .addComponent(jLabel20))
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tratamiento"));

        jLabel13.setText("Vencimiento Beca:");

        jLabel17.setText("Fecha de Egreso:");

        jLabel16.setText("Terapista:");

        jLabel12.setText("Fecha de ingreso:");

        taEgreso.setColumns(10);
        taEgreso.setRows(5);
        jScrollPane2.setViewportView(taEgreso);

        jLabel19.setText("Fecha cambio Disp.:");

        jLabel18.setText("Fecha Ausencia:");

        jLabel14.setText("Obra Social:");

        jLabel28.setText("Disp. terapia:");

        jLabel15.setText("Dispositivo:");

        jLabel27.setText("Causales egreso:");

        jLabel25.setText("Fase:");

        cbDispositivoTerapia.setModel(new DefaultComboBoxModel<>(DispositivosEnum.values()));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel13)
                    .addComponent(jLabel19)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel12)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dpIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfFase)
                    .addComponent(dpVencimientoBeca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfDispositivo)
                    .addComponent(jScrollPane2)
                    .addComponent(tfTerapista)
                    .addComponent(dpEgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dpAusencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dpCambioDispositivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbObraSocial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbDispositivoTerapia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(dpIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(dpVencimientoBeca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tfTerapista))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cbObraSocial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tfDispositivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(dpCambioDispositivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(cbDispositivoTerapia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFase)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpAusencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpEgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel27))
                .addContainerGap())
        );

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Grabar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        pService.createPaciente(this);
        
        mainFrame topFrame = (mainFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.changePanel(new PacienteList(), this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mainFrame topFrame = (mainFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.changePanel(new PacienteList(), this);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<DispositivosEnum> cbDispositivoTerapia;
    private javax.swing.JCheckBox cbGravado;
    private javax.swing.JComboBox<ObraSocial> cbObraSocial;
    private org.jdesktop.swingx.JXDatePicker dpAusencia;
    private org.jdesktop.swingx.JXDatePicker dpCambioDispositivo;
    private org.jdesktop.swingx.JXDatePicker dpEgreso;
    private org.jdesktop.swingx.JXDatePicker dpIngreso;
    private org.jdesktop.swingx.JXDatePicker dpVencimientoBeca;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taEgreso;
    private javax.swing.JTextArea taObservaciones;
    private javax.swing.JTextField tfCelular;
    private javax.swing.JTextField tfDireccion;
    private javax.swing.JTextField tfDispositivo;
    private javax.swing.JTextField tfDocumento;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFase;
    private javax.swing.JTextField tfHistoriaClinica;
    private javax.swing.JTextField tfLocalidad;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfProvincia;
    private javax.swing.JTextField tfResponsable;
    private javax.swing.JTextField tfTelefono;
    private javax.swing.JTextField tfTerapista;
    // End of variables declaration//GEN-END:variables

    @Override
    public Date getAusencia() {
        return dpAusencia.getDate();
    }
    
    @Override
    public Date getCambioDispositivo() {
        return dpCambioDispositivo.getDate();
    }
    
    @Override
    public String getCausalEgreso() {
        return taEgreso.getText();
    }
    
    @Override
    public String getCelular() {
        return tfCelular.getText();
    }
    
    @Override
    public String getCodigoPostal() {
        return null;
    }
    
    @Override
    public String getDireccion() {
        return tfDireccion.getText();
    }
    
    @Override
    public String getDispositivo() {
        return tfDispositivo.getText();
    }
    
    @Override
    public DispositivosEnum getDispositivoTerapia() {
        return (DispositivosEnum) cbDispositivoTerapia.getSelectedItem();
    }
    
    @Override
    public String getDocumento() {
        return tfDocumento.getText();
    }
    
    @Override
    public Date getEgreso() {
        return dpEgreso.getDate();
    }
    
    @Override
    public String getEmail() {
        return tfEmail.getText();
    }
    
    @Override
    public String getFase() {
        return tfFase.getText();
    }
    
    @Override
    public Boolean getGravado() {
        return cbGravado.isSelected();
    }
    
    @Override
    public Long getId() {
        return !tfHistoriaClinica.getText().isEmpty() ? Long.valueOf(tfHistoriaClinica.getText()) : null;
    }
    
    @Override
    public Date getIngreso() {
        return dpIngreso.getDate();
    }
    
    @Override
    public String getLocalidad() {
        return tfLocalidad.getText();
    }
    
    @Override
    public String getNombre() {
        return tfNombre.getText();
    }
    
    @Override
    public ObraSocial getObraSocial() {
        return (ObraSocial) cbObraSocial.getSelectedItem();
    }
    
    @Override
    public String getObservaciones() {
        return taObservaciones.getText();
    }
    
    @Override
    public String getProvincia() {
        return tfProvincia.getText();
    }
    
    @Override
    public String getResponsable() {
        return tfResponsable.getText();
    }
    
    @Override
    public String getTelefono() {
        return tfTelefono.getText();
    }
    
    @Override
    public String getTerapista() {
        return tfTerapista.getText();
    }
    
    @Override
    public Date getVencimientoBeca() {
        return dpVencimientoBeca.getDate();
    }
    
}
