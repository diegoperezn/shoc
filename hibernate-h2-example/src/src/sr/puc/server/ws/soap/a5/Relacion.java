
package sr.puc.server.ws.soap.a5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para relacion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="relacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="apellidoPersonaAsociada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ffRelacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ffVencimiento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="idPersonaAsociada" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="nombrePersonaAsociada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="razonSocialPersonaAsociada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoComponente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relacion", propOrder = {
    "apellidoPersonaAsociada",
    "ffRelacion",
    "ffVencimiento",
    "idPersonaAsociada",
    "nombrePersonaAsociada",
    "razonSocialPersonaAsociada",
    "tipoComponente"
})
public class Relacion {

    protected String apellidoPersonaAsociada;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ffRelacion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar ffVencimiento;
    protected Long idPersonaAsociada;
    protected String nombrePersonaAsociada;
    protected String razonSocialPersonaAsociada;
    protected String tipoComponente;

    /**
     * Obtiene el valor de la propiedad apellidoPersonaAsociada.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoPersonaAsociada() {
        return apellidoPersonaAsociada;
    }

    /**
     * Define el valor de la propiedad apellidoPersonaAsociada.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoPersonaAsociada(String value) {
        this.apellidoPersonaAsociada = value;
    }

    /**
     * Obtiene el valor de la propiedad ffRelacion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFfRelacion() {
        return ffRelacion;
    }

    /**
     * Define el valor de la propiedad ffRelacion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFfRelacion(XMLGregorianCalendar value) {
        this.ffRelacion = value;
    }

    /**
     * Obtiene el valor de la propiedad ffVencimiento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFfVencimiento() {
        return ffVencimiento;
    }

    /**
     * Define el valor de la propiedad ffVencimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFfVencimiento(XMLGregorianCalendar value) {
        this.ffVencimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad idPersonaAsociada.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdPersonaAsociada() {
        return idPersonaAsociada;
    }

    /**
     * Define el valor de la propiedad idPersonaAsociada.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdPersonaAsociada(Long value) {
        this.idPersonaAsociada = value;
    }

    /**
     * Obtiene el valor de la propiedad nombrePersonaAsociada.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombrePersonaAsociada() {
        return nombrePersonaAsociada;
    }

    /**
     * Define el valor de la propiedad nombrePersonaAsociada.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombrePersonaAsociada(String value) {
        this.nombrePersonaAsociada = value;
    }

    /**
     * Obtiene el valor de la propiedad razonSocialPersonaAsociada.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazonSocialPersonaAsociada() {
        return razonSocialPersonaAsociada;
    }

    /**
     * Define el valor de la propiedad razonSocialPersonaAsociada.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazonSocialPersonaAsociada(String value) {
        this.razonSocialPersonaAsociada = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoComponente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoComponente() {
        return tipoComponente;
    }

    /**
     * Define el valor de la propiedad tipoComponente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoComponente(String value) {
        this.tipoComponente = value;
    }

}
