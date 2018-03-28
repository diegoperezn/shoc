/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import org.apache.commons.collections.map.ReferenceMap;

public class GenerateReport {

    public static void main(String[] args) throws JRException {
        GenerateReport r = new GenerateReport();

        r.generatePdfReport(new String());
    }

    //private static final Logger logger = LoggerFactory;
    // This method generates a PDF report 
    public void generatePdfReport(String jrxml) throws JRException {
        String sourceFileName = "/Users/diego/Dev/projects/shoc/Hibernate-H2-Example-master 10.49.48/hibernate-h2-example/src/Factura.jrxml";
        String destFileName = "/Users/diego/Dev/projects/shoc/Hibernate-H2-Example-master 10.49.48/hibernate-h2-example/src/Factura.jasper";
        String printFileName = "/Users/diego/Dev/projects/shoc/Hibernate-H2-Example-master 10.49.48/hibernate-h2-example/src/Factura.jrprint";
        String pdfFile = "/Users/diego/Dev/projects/shoc/Hibernate-H2-Example-master 10.49.48/hibernate-h2-example/src/factura.pdf";
        
        JasperCompileManager.compileReportToFile(sourceFileName, destFileName);

        DataBeanList DataBeanList = new DataBeanList();
        ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();

        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);
        Map parameters = new HashMap();
        parameters.put("test", "anda? ;)");
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

    public class DataBeanList {

        public ArrayList<DataBean> getDataBeanList() {
            ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();

            dataBeanList.add(produce("Manisha", "India"));
            dataBeanList.add(produce("Dennis Ritchie", "USA"));
            dataBeanList.add(produce("V.Anand", "India"));
            dataBeanList.add(produce("Shrinath", "California"));

            return dataBeanList;
        }

        /**
         * This method returns a DataBean object, with name and country set in
         * it.
         */
        private DataBean produce(String name, String country) {
            DataBean dataBean = new DataBean();
            dataBean.setName(name);
            dataBean.setCountry(country);

            return dataBean;
        }
    }

    public class DataBean {

        private String name;
        private String country;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }
}
