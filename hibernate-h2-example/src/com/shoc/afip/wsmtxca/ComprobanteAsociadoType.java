
package com.shoc.afip.wsmtxca;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ComprobanteAsociadoType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ComprobanteAsociadoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoTipoComprobante" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="numeroPuntoVenta" type="{http://impl.service.wsmtxca.afip.gov.ar/service/}NumeroPuntoVentaSimpleType"/>
 *         &lt;element name="numeroComprobante" type="{http://impl.service.wsmtxca.afip.gov.ar/service/}NumeroComprobanteSimpleType"/>
 *         &lt;element name="cuit" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComprobanteAsociadoType", propOrder = {
    "codigoTipoComprobante",
    "numeroPuntoVenta",
    "numeroComprobante",
    "cuit"
})
public class ComprobanteAsociadoType {

    protected short codigoTipoComprobante;
    protected short numeroPuntoVenta;
    @XmlSchemaType(name = "long")
    protected int numeroComprobante;
    protected Long cuit;

    /**
     * Obtiene el valor de la propiedad codigoTipoComprobante.
     * 
     */
    public short getCodigoTipoComprobante() {
        return codigoTipoComprobante;
    }

    /**
     * Define el valor de la propiedad codigoTipoComprobante.
     * 
     */
    public void setCodigoTipoComprobante(short value) {
        this.codigoTipoComprobante = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroPuntoVenta.
     * 
     */
    public short getNumeroPuntoVenta() {
        return numeroPuntoVenta;
    }

    /**
     * Define el valor de la propiedad numeroPuntoVenta.
     * 
     */
    public void setNumeroPuntoVenta(short value) {
        this.numeroPuntoVenta = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroComprobante.
     * 
     */
    public int getNumeroComprobante() {
        return numeroComprobante;
    }

    /**
     * Define el valor de la propiedad numeroComprobante.
     * 
     */
    public void setNumeroComprobante(int value) {
        this.numeroComprobante = value;
    }

    /**
     * Obtiene el valor de la propiedad cuit.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCuit() {
        return cuit;
    }

    /**
     * Define el valor de la propiedad cuit.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCuit(Long value) {
        this.cuit = value;
    }

}
