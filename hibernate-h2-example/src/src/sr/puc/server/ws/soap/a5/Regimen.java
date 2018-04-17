
package sr.puc.server.ws.soap.a5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para regimen complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="regimen">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descripcionRegimen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idImpuesto" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idRegimen" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="periodo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tipoRegimen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "regimen", propOrder = {
    "descripcionRegimen",
    "idImpuesto",
    "idRegimen",
    "periodo",
    "tipoRegimen"
})
public class Regimen {

    protected String descripcionRegimen;
    protected Integer idImpuesto;
    protected Integer idRegimen;
    protected Integer periodo;
    protected String tipoRegimen;

    /**
     * Obtiene el valor de la propiedad descripcionRegimen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionRegimen() {
        return descripcionRegimen;
    }

    /**
     * Define el valor de la propiedad descripcionRegimen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionRegimen(String value) {
        this.descripcionRegimen = value;
    }

    /**
     * Obtiene el valor de la propiedad idImpuesto.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdImpuesto() {
        return idImpuesto;
    }

    /**
     * Define el valor de la propiedad idImpuesto.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdImpuesto(Integer value) {
        this.idImpuesto = value;
    }

    /**
     * Obtiene el valor de la propiedad idRegimen.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdRegimen() {
        return idRegimen;
    }

    /**
     * Define el valor de la propiedad idRegimen.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdRegimen(Integer value) {
        this.idRegimen = value;
    }

    /**
     * Obtiene el valor de la propiedad periodo.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPeriodo() {
        return periodo;
    }

    /**
     * Define el valor de la propiedad periodo.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPeriodo(Integer value) {
        this.periodo = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoRegimen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoRegimen() {
        return tipoRegimen;
    }

    /**
     * Define el valor de la propiedad tipoRegimen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoRegimen(String value) {
        this.tipoRegimen = value;
    }

}
