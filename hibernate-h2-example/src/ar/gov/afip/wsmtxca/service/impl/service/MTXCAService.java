
package ar.gov.afip.wsmtxca.service.impl.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "MTXCAService", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", wsdlLocation = "https://fwshomo.afip.gov.ar/wsmtxca/services/MTXCAService?wsdl")
public class MTXCAService
    extends Service
{

    private final static URL MTXCASERVICE_WSDL_LOCATION;
    private final static WebServiceException MTXCASERVICE_EXCEPTION;
    private final static QName MTXCASERVICE_QNAME = new QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "MTXCAService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://fwshomo.afip.gov.ar/wsmtxca/services/MTXCAService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        MTXCASERVICE_WSDL_LOCATION = url;
        MTXCASERVICE_EXCEPTION = e;
    }

    public MTXCAService() {
        super(__getWsdlLocation(), MTXCASERVICE_QNAME);
    }

    public MTXCAService(WebServiceFeature... features) {
        super(__getWsdlLocation(), MTXCASERVICE_QNAME, features);
    }

    public MTXCAService(URL wsdlLocation) {
        super(wsdlLocation, MTXCASERVICE_QNAME);
    }

    public MTXCAService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, MTXCASERVICE_QNAME, features);
    }

    public MTXCAService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public MTXCAService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns MTXCAServicePortType
     */
    @WebEndpoint(name = "MTXCAServiceHttpSoap11Endpoint")
    public MTXCAServicePortType getMTXCAServiceHttpSoap11Endpoint() {
        return super.getPort(new QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "MTXCAServiceHttpSoap11Endpoint"), MTXCAServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns MTXCAServicePortType
     */
    @WebEndpoint(name = "MTXCAServiceHttpSoap11Endpoint")
    public MTXCAServicePortType getMTXCAServiceHttpSoap11Endpoint(WebServiceFeature... features) {
        return super.getPort(new QName("http://impl.service.wsmtxca.afip.gov.ar/service/", "MTXCAServiceHttpSoap11Endpoint"), MTXCAServicePortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (MTXCASERVICE_EXCEPTION!= null) {
            throw MTXCASERVICE_EXCEPTION;
        }
        return MTXCASERVICE_WSDL_LOCATION;
    }

}
