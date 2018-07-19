
package src.sr.puc.server.ws.soap.a5;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para datosMonotributo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="datosMonotributo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="actividadMonotributista" type="{http://a5.soap.ws.server.puc.sr/}actividad" minOccurs="0"/>
 *         &lt;element name="categoriaMonotributo" type="{http://a5.soap.ws.server.puc.sr/}categoria" minOccurs="0"/>
 *         &lt;element name="componenteDeSociedad" type="{http://a5.soap.ws.server.puc.sr/}relacion" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="impuesto" type="{http://a5.soap.ws.server.puc.sr/}impuesto" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datosMonotributo", propOrder = {
    "actividadMonotributista",
    "categoriaMonotributo",
    "componenteDeSociedad",
    "impuesto"
})
public class DatosMonotributo {

    protected Actividad actividadMonotributista;
    protected Categoria categoriaMonotributo;
    @XmlElement(nillable = true)
    protected List<Relacion> componenteDeSociedad;
    @XmlElement(nillable = true)
    protected List<Impuesto> impuesto;

    /**
     * Obtiene el valor de la propiedad actividadMonotributista.
     * 
     * @return
     *     possible object is
     *     {@link Actividad }
     *     
     */
    public Actividad getActividadMonotributista() {
        return actividadMonotributista;
    }

    /**
     * Define el valor de la propiedad actividadMonotributista.
     * 
     * @param value
     *     allowed object is
     *     {@link Actividad }
     *     
     */
    public void setActividadMonotributista(Actividad value) {
        this.actividadMonotributista = value;
    }

    /**
     * Obtiene el valor de la propiedad categoriaMonotributo.
     * 
     * @return
     *     possible object is
     *     {@link Categoria }
     *     
     */
    public Categoria getCategoriaMonotributo() {
        return categoriaMonotributo;
    }

    /**
     * Define el valor de la propiedad categoriaMonotributo.
     * 
     * @param value
     *     allowed object is
     *     {@link Categoria }
     *     
     */
    public void setCategoriaMonotributo(Categoria value) {
        this.categoriaMonotributo = value;
    }

    /**
     * Gets the value of the componenteDeSociedad property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the componenteDeSociedad property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComponenteDeSociedad().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Relacion }
     * 
     * 
     */
    public List<Relacion> getComponenteDeSociedad() {
        if (componenteDeSociedad == null) {
            componenteDeSociedad = new ArrayList<Relacion>();
        }
        return this.componenteDeSociedad;
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

}
