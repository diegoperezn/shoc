/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import com.shoc.domain.Factura;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class FacturaGenerator implements IParamentroFinder {

    private static FacturaGenerator instance;

    public static FacturaGenerator getInstance() {
        if (instance == null) {
            instance = new FacturaGenerator();
        }

        return instance;
    }

    String sourceFileName = "/Users/diego/Dev/projects/shoc/Hibernate-H2-Example-master 10.49.48/hibernate-h2-example/src/Factura.jrxml";
    String destFileName = "/Users/diego/Dev/projects/shoc/Hibernate-H2-Example-master 10.49.48/hibernate-h2-example/src/Factura.jasper";
    String printFileName = "/Users/diego/Dev/projects/shoc/Hibernate-H2-Example-master 10.49.48/hibernate-h2-example/src/Factura.jrprint";
    String pdfFile = "/Users/diego/Dev/projects/shoc/Hibernate-H2-Example-master 10.49.48/hibernate-h2-example/src/{name}.pdf";

    private PropiedadService pService = PropiedadService.getInstance();
    private FacturaService fService = FacturaService.getInstance();

    public static void main(String[] args) throws JRException {
        FacturaGenerator r = new FacturaGenerator();

        r.generatePdfReport(Long.valueOf("47"));
    }

    //private static final Logger logger = LoggerFactory;
    // This method generates a PDF report
    /*
    public void generatePdfReport(String jrxml) throws JRException {

        JasperCompileManager.compileReportToFile(sourceFileName, destFileName);

        final Factura factura = this.fService.listAll().get(0);

        List<FacturaDetail> dataList = factura.getDetails();

        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);

        Map parameters = new HashMap();
        agregarShocValores(parameters, factura);

        try {
            JasperFillManager.fillReportToFile(
                    destFileName, printFileName, parameters, beanColDataSource);
            JasperPrint jrPrint = JasperFillManager.fillReport(
                    destFileName, parameters, beanColDataSource);

            if (printFileName != null) {
                JasperExportManager.exportReportToPdfFile(printFileName,
                        pdfFile);
            }

            JRViewer viewer = new JRViewer(jrPrint);
        } catch (JRException e) {
            e.printStackTrace();
        }

    }
     */
    //private static final Logger logger = LoggerFactory;
    // This method generates a PDF report 
    public JRViewer generatePdfReport(Long id) throws JRException {

        JasperCompileManager.compileReportToFile(sourceFileName, destFileName);
        
        final Factura factura = this.fService.get(id);

        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(factura.getDetails());

        Map parameters = new HashMap();
        agregarShocValores(parameters, factura);

        JasperPrint report = JasperFillManager.fillReport(destFileName, parameters, beanColDataSource);

        JasperExportManager.exportReportToPdfFile(report,
                pdfFile.replace("{name}", "factura_" + id));

        return new JRViewer(report);
    }

    private void agregarShocValores(Map parameters, Factura factura) {

        ICliente cliente = factura.getObraSocial();
        if (cliente == null) {
            cliente = factura.getPaciente();
        }

        parameters.put("finder", this);
        parameters.put("cliente", cliente);
        parameters.put("factura", factura);
    }

    @Override
    public String find(String name) {
        return pService.getPropertyValue(name);
    }
}
