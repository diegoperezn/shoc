/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import com.shoc.afip.authen.AfipAuthentificationService;
import com.shoc.domain.Factura;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import org.apache.log4j.Logger;

public class FacturaGenerator implements IParamentroFinder {

    final static Logger logger = Logger.getLogger(FacturaGenerator.class);

    private static FacturaGenerator instance;

    public static FacturaGenerator getInstance() {
        if (instance == null) {
            instance = new FacturaGenerator();
        }

        return instance;
    }

    static String sourceFileNameA = "/Users/diego/Dev/projects/shoc/Hibernate-H2-Example-master 10.49.48/hibernate-h2-example/src/FacturaA.jrxml";
    static String sourceFileNameB = "/Users/diego/Dev/projects/shoc/Hibernate-H2-Example-master 10.49.48/hibernate-h2-example/src/FacturaB.jrxml";
    static String facturaA = "/Users/diego/Dev/projects/shoc/Hibernate-H2-Example-master 10.49.48/hibernate-h2-example/src/FacturaA.jasper";
    static String facturaB = "/Users/diego/Dev/projects/shoc/Hibernate-H2-Example-master 10.49.48/hibernate-h2-example/src/FacturaB.jasper";
    //String printFileName = "/Users/diego/Dev/projects/shoc/Hibernate-H2-Example-master 10.49.48/hibernate-h2-example/src/Factura_1.jrprint";
    //String pdfFile = "/Users/diego/Dev/projects/shoc/Hibernate-H2-Example-master 10.49.48/hibernate-h2-example/src/{name}.pdf";

    /*
    String sourceFileName = "./Factura.jrxml";
    String facturaA = "./FacturaA.jasper";
    String facturaB = "./FacturaB.jasper";
    String printFileName = "./Factura.jrprint";
    String pdfFile = "./{name}.pdf";
     */
    //String facturaA = "./FacturaA.jasper";
    //String facturaB = "./FacturaB.jasper";
    private PropiedadService pService = PropiedadService.getInstance();
    private FacturaService fService = FacturaService.getInstance();

    public static void main(String[] args) throws JRException {
        JasperCompileManager.compileReportToFile(sourceFileNameA, facturaA);
        JasperCompileManager.compileReportToFile(sourceFileNameB, facturaB);
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

//        JasperCompileManager.compileReportToFile(sourceFileName, facturaA);
        final Factura factura = this.fService.get(id);

        String basePath = pService.getPropertyValue("base.dir");

        String facturaJasper = basePath + pService.getPropertyValue("facturaA.path");
        if (factura.getObraSocial() == null) {
            facturaJasper = basePath + pService.getPropertyValue("facturaB.path");
        }

        logger.info("Path para generar factura base :" + basePath + " resultado: " + facturaJasper);

        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(factura.getDetails());

        Map parameters = new HashMap();
        agregarShocValores(parameters, factura);

        JasperPrint report = JasperFillManager.fillReport(facturaJasper, parameters, beanColDataSource);

        //JasperExportManager.exportReportToPdfFile(report, pdfFile.replace("{name}", "factura_" + id));
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
