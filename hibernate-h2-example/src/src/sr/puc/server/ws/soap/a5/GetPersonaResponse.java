
package src.sr.puc.server.ws.soap.a5;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para getPersonaResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="getPersonaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="personaReturn" type="{http://a5.soap.ws.server.puc.sr/}personaReturn" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPersonaResponse", propOrder = {
    "personaReturn"
})
public class GetPersonaResponse {

    protected PersonaReturn personaReturn;

    /**
     * Obtiene el valor de la propiedad personaReturn.
     * 
     * @return
     *     possible object is
     *     {@link PersonaReturn }
     *     
     */
    public PersonaReturn getPersonaReturn() {
        return personaReturn;
    }

    /**
     * Define el valor de la propiedad personaReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonaReturn }
     *     
     */
    public void setPersonaReturn(PersonaReturn value) {
        this.personaReturn = value;
    }

}
