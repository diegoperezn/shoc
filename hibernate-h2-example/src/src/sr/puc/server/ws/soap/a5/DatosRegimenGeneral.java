
package sr.puc.server.ws.soap.a5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para datosRegimenGeneral complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="datosRegimenGeneral">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actividad" type="{http://a5.soap.ws.server.puc.sr/}actividad" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="categoriaAutonomo" type="{http://a5.soap.ws.server.puc.sr/}categoria" minOccurs="0"/>
 *         &lt;element name="impuesto" type="{http://a5.soap.ws.server.puc.sr/}impuesto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="regimen" type="{http://a5.soap.ws.server.puc.sr/}regimen" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosRegimenGeneral", propOrder = {
    "actividad",
    "categoriaAutonomo",
    "impuesto",
    "regimen"
})
public class DatosRegimenGeneral {

    @XmlElement(nillable = true)
    protected List<Actividad> actividad;
    protected Categoria categoriaAutonomo;
    @XmlElement(nillable = true)
    protected List<Impuesto> impuesto;
    @XmlElement(nillable = true)
    protected List<Regimen> regimen;

    /**
     * Gets the value of the actividad property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actividad property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActividad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Actividad }
     * 
     * 
     */
    public List<Actividad> getActividad() {
        if (actividad == null) {
            actividad = new ArrayList<Actividad>();
        }
        return this.actividad;
    }

    /**
     * Obtiene el valor de la propiedad categoriaAutonomo.
     * 
     * @return
     *     possible object is
     *     {@link Categoria }
     *     
     */
    public Categoria getCategoriaAutonomo() {
        return categoriaAutonomo;
    }

    /**
     * Define el valor de la propiedad categoriaAutonomo.
     * 
     * @param value
     *     allowed object is
     *     {@link Categoria }
     *     
     */
    public void setCategoriaAutonomo(Categoria value) {
        this.categoriaAutonomo = value;
    }

    /**
     * Gets the value of the impuesto property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the impuesto property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImpuesto().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Impuesto }
     * 
     * 
     */
    public List<Impuesto> getImpuesto() {
        if (impuesto == null) {
            impuesto = new ArrayList<Impuesto>();
        }
        return this.impuesto;
    }

    /**
     * Gets the value of the regimen property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regimen property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegimen().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Regimen }
     * 
     * 
     */
    public List<Regimen> getRegimen() {
        if (regimen == null) {
            regimen = new ArrayList<Regimen>();
        }
        return this.regimen;
    }

}
