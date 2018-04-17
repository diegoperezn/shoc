
package sr.puc.server.ws.soap.a5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para personaReturn complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="personaReturn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datosGenerales" type="{http://a5.soap.ws.server.puc.sr/}datosGenerales" minOccurs="0"/>
 *         &lt;element name="datosMonotributo" type="{http://a5.soap.ws.server.puc.sr/}datosMonotributo" minOccurs="0"/>
 *         &lt;element name="datosRegimenGeneral" type="{http://a5.soap.ws.server.puc.sr/}datosRegimenGeneral" minOccurs="0"/>
 *         &lt;element name="errorConstancia" type="{http://a5.soap.ws.server.puc.sr/}errorConstancia" minOccurs="0"/>
 *         &lt;element name="errorMonotributo" type="{http://a5.soap.ws.server.puc.sr/}errorMonotributo" minOccurs="0"/>
 *         &lt;element name="errorRegimenGeneral" type="{http://a5.soap.ws.server.puc.sr/}errorRegimenGeneral" minOccurs="0"/>
 *         &lt;element name="metadata" type="{http://a5.soap.ws.server.puc.sr/}metadata" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personaReturn", propOrder = {
    "datosGenerales",
    "datosMonotributo",
    "datosRegimenGeneral",
    "errorConstancia",
    "errorMonotributo",
    "errorRegimenGeneral",
    "metadata"
})
public class PersonaReturn {

    protected DatosGenerales datosGenerales;
    protected DatosMonotributo datosMonotributo;
    protected DatosRegimenGeneral datosRegimenGeneral;
    protected ErrorConstancia errorConstancia;
    protected ErrorMonotributo errorMonotributo;
    protected ErrorRegimenGeneral errorRegimenGeneral;
    protected Metadata metadata;

    /**
     * Obtiene el valor de la propiedad datosGenerales.
     * 
     * @return
     *     possible object is
     *     {@link DatosGenerales }
     *     
     */
    public DatosGenerales getDatosGenerales() {
        return datosGenerales;
    }

    /**
     * Define el valor de la propiedad datosGenerales.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosGenerales }
     *     
     */
    public void setDatosGenerales(DatosGenerales value) {
        this.datosGenerales = value;
    }

    /**
     * Obtiene el valor de la propiedad datosMonotributo.
     * 
     * @return
     *     possible object is
     *     {@link DatosMonotributo }
     *     
     */
    public DatosMonotributo getDatosMonotributo() {
        return datosMonotributo;
    }

    /**
     * Define el valor de la propiedad datosMonotributo.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosMonotributo }
     *     
     */
    public void setDatosMonotributo(DatosMonotributo value) {
        this.datosMonotributo = value;
    }

    /**
     * Obtiene el valor de la propiedad datosRegimenGeneral.
     * 
     * @return
     *     possible object is
     *     {@link DatosRegimenGeneral }
     *     
     */
    public DatosRegimenGeneral getDatosRegimenGeneral() {
        return datosRegimenGeneral;
    }

    /**
     * Define el valor de la propiedad datosRegimenGeneral.
     * 
     * @param value
     *     allowed object is
     *     {@link DatosRegimenGeneral }
     *     
     */
    public void setDatosRegimenGeneral(DatosRegimenGeneral value) {
        this.datosRegimenGeneral = value;
    }

    /**
     * Obtiene el valor de la propiedad errorConstancia.
     * 
     * @return
     *     possible object is
     *     {@link ErrorConstancia }
     *     
     */
    public ErrorConstancia getErrorConstancia() {
        return errorConstancia;
    }

    /**
     * Define el valor de la propiedad errorConstancia.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorConstancia }
     *     
     */
    public void setErrorConstancia(ErrorConstancia value) {
        this.errorConstancia = value;
    }

    /**
     * Obtiene el valor de la propiedad errorMonotributo.
     * 
     * @return
     *     possible object is
     *     {@link ErrorMonotributo }
     *     
     */
    public ErrorMonotributo getErrorMonotributo() {
        return errorMonotributo;
    }

    /**
     * Define el valor de la propiedad errorMonotributo.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorMonotributo }
     *     
     */
    public void setErrorMonotributo(ErrorMonotributo value) {
        this.errorMonotributo = value;
    }

    /**
     * Obtiene el valor de la propiedad errorRegimenGeneral.
     * 
     * @return
     *     possible object is
     *     {@link ErrorRegimenGeneral }
     *     
     */
    public ErrorRegimenGeneral getErrorRegimenGeneral() {
        return errorRegimenGeneral;
    }

    /**
     * Define el valor de la propiedad errorRegimenGeneral.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorRegimenGeneral }
     *     
     */
    public void setErrorRegimenGeneral(ErrorRegimenGeneral value) {
        this.errorRegimenGeneral = value;
    }

    /**
     * Obtiene el valor de la propiedad metadata.
     * 
     * @return
     *     possible object is
     *     {@link Metadata }
     *     
     */
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * Define el valor de la propiedad metadata.
     * 
     * @param value
     *     allowed object is
     *     {@link Metadata }
     *     
     */
    public void setMetadata(Metadata value) {
        this.metadata = value;
    }

}
