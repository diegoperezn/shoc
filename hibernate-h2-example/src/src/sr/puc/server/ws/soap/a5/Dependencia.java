
package sr.puc.server.ws.soap.a5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dependencia complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dependencia">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codPostal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionDependencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcionProvincia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="direccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idDependencia" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idProvincia" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="localidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dependencia", propOrder = {
    "codPostal",
    "descripcionDependencia",
    "descripcionProvincia",
    "direccion",
    "idDependencia",
    "idProvincia",
    "localidad"
})
public class Dependencia {

    protected String codPostal;
    protected String descripcionDependencia;
    protected String descripcionProvincia;
    protected String direccion;
    protected Integer idDependencia;
    protected Integer idProvincia;
    protected String localidad;

    /**
     * Obtiene el valor de la propiedad codPostal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodPostal() {
        return codPostal;
    }

    /**
     * Define el valor de la propiedad codPostal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodPostal(String value) {
        this.codPostal = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionDependencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionDependencia() {
        return descripcionDependencia;
    }

    /**
     * Define el valor de la propiedad descripcionDependencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionDependencia(String value) {
        this.descripcionDependencia = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionProvincia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionProvincia() {
        return descripcionProvincia;
    }

    /**
     * Define el valor de la propiedad descripcionProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionProvincia(String value) {
        this.descripcionProvincia = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Define el valor de la propiedad direccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Obtiene el valor de la propiedad idDependencia.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdDependencia() {
        return idDependencia;
    }

    /**
     * Define el valor de la propiedad idDependencia.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdDependencia(Integer value) {
        this.idDependencia = value;
    }

    /**
     * Obtiene el valor de la propiedad idProvincia.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdProvincia() {
        return idProvincia;
    }

    /**
     * Define el valor de la propiedad idProvincia.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdProvincia(Integer value) {
        this.idProvincia = value;
    }

    /**
     * Obtiene el valor de la propiedad localidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * Define el valor de la propiedad localidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalidad(String value) {
        this.localidad = value;
    }

}
