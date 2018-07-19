
package src.sr.puc.server.ws.soap.a5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para datosGenerales complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="datosGenerales">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="apellido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dependencia" type="{http://a5.soap.ws.server.puc.sr/}dependencia" minOccurs="0"/>
 *         &lt;element name="domicilioFiscal" type="{http://a5.soap.ws.server.puc.sr/}domicilio" minOccurs="0"/>
 *         &lt;element name="estadoClave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaContratoSocial" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="idPersona" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="mesCierre" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="razonSocial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoClave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoPersona" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosGenerales", propOrder = {
    "apellido",
    "dependencia",
    "domicilioFiscal",
    "estadoClave",
    "fechaContratoSocial",
    "idPersona",
    "mesCierre",
    "nombre",
    "razonSocial",
    "tipoClave",
    "tipoPersona"
})
public class DatosGenerales {

    protected String apellido;
    protected Dependencia dependencia;
    protected Domicilio domicilioFiscal;
    protected String estadoClave;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaContratoSocial;
    protected Long idPersona;
    protected Integer mesCierre;
    protected String nombre;
    protected String razonSocial;
    protected String tipoClave;
    protected String tipoPersona;

    /**
     * Obtiene el valor de la propiedad apellido.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Define el valor de la propiedad apellido.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellido(String value) {
        this.apellido = value;
    }

    /**
     * Obtiene el valor de la propiedad dependencia.
     * 
     * @return
     *     possible object is
     *     {@link Dependencia }
     *     
     */
    public Dependencia getDependencia() {
        return dependencia;
    }

    /**
     * Define el valor de la propiedad dependencia.
     * 
     * @param value
     *     allowed object is
     *     {@link Dependencia }
     *     
     */
    public void setDependencia(Dependencia value) {
        this.dependencia = value;
    }

    /**
     * Obtiene el valor de la propiedad domicilioFiscal.
     * 
     * @return
     *     possible object is
     *     {@link Domicilio }
     *     
     */
    public Domicilio getDomicilioFiscal() {
        return domicilioFiscal;
    }

    /**
     * Define el valor de la propiedad domicilioFiscal.
     * 
     * @param value
     *     allowed object is
     *     {@link Domicilio }
     *     
     */
    public void setDomicilioFiscal(Domicilio value) {
        this.domicilioFiscal = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoClave.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoClave() {
        return estadoClave;
    }

    /**
     * Define el valor de la propiedad estadoClave.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoClave(String value) {
        this.estadoClave = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaContratoSocial.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaContratoSocial() {
        return fechaContratoSocial;
    }

    /**
     * Define el valor de la propiedad fechaContratoSocial.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaContratoSocial(XMLGregorianCalendar value) {
        this.fechaContratoSocial = value;
    }

    /**
     * Obtiene el valor de la propiedad idPersona.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdPersona() {
        return idPersona;
    }

    /**
     * Define el valor de la propiedad idPersona.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdPersona(Long value) {
        this.idPersona = value;
    }

    /**
     * Obtiene el valor de la propiedad mesCierre.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMesCierre() {
        return mesCierre;
    }

    /**
     * Define el valor de la propiedad mesCierre.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMesCierre(Integer value) {
        this.mesCierre = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad razonSocial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Define el valor de la propiedad razonSocial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRazonSocial(String value) {
        this.razonSocial = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoClave.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoClave() {
        return tipoClave;
    }

    /**
     * Define el valor de la propiedad tipoClave.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoClave(String value) {
        this.tipoClave = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoPersona.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoPersona() {
        return tipoPersona;
    }

    /**
     * Define el valor de la propiedad tipoPersona.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoPersona(String value) {
        this.tipoPersona = value;
    }

}
