
package com.shoc.afip.wsmtxca;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AutorizarComprobanteRequestType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AutorizarComprobanteRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authRequest" type="{http://impl.service.wsmtxca.afip.gov.ar/service/}AuthRequestType"/>
 *         &lt;element name="comprobanteCAERequest" type="{http://impl.service.wsmtxca.afip.gov.ar/service/}ComprobanteType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AutorizarComprobanteRequestType", propOrder = {
    "authRequest",
    "comprobanteCAERequest"
})
public class AutorizarComprobanteRequestType {

    @XmlElement(required = true)
    protected AuthRequestType authRequest;
    @XmlElement(required = true)
    protected ComprobanteType comprobanteCAERequest;

    /**
     * Obtiene el valor de la propiedad authRequest.
     * 
     * @return
     *     possible object is
     *     {@link AuthRequestType }
     *     
     */
    public AuthRequestType getAuthRequest() {
        return authRequest;
    }

    /**
     * Define el valor de la propiedad authRequest.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthRequestType }
     *     
     */
    public void setAuthRequest(AuthRequestType value) {
        this.authRequest = value;
    }

    /**
     * Obtiene el valor de la propiedad comprobanteCAERequest.
     * 
     * @return
     *     possible object is
     *     {@link ComprobanteType }
     *     
     */
    public ComprobanteType getComprobanteCAERequest() {
        return comprobanteCAERequest;
    }

    /**
     * Define el valor de la propiedad comprobanteCAERequest.
     * 
     * @param value
     *     allowed object is
     *     {@link ComprobanteType }
     *     
     */
    public void setComprobanteCAERequest(ComprobanteType value) {
        this.comprobanteCAERequest = value;
    }

}
