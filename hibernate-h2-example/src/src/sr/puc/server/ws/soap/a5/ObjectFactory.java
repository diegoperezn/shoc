
package src.sr.puc.server.ws.soap.a5;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the src.sr.puc.server.ws.soap.a5 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetPersona_QNAME = new QName("http://a5.soap.ws.server.puc.sr/", "getPersona");
    private final static QName _GetPersonaResponse_QNAME = new QName("http://a5.soap.ws.server.puc.sr/", "getPersonaResponse");
    private final static QName _DummyResponse_QNAME = new QName("http://a5.soap.ws.server.puc.sr/", "dummyResponse");
    private final static QName _Dummy_QNAME = new QName("http://a5.soap.ws.server.puc.sr/", "dummy");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: src.sr.puc.server.ws.soap.a5
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Dummy }
     * 
     */
    public Dummy createDummy() {
        return new Dummy();
    }

    /**
     * Create an instance of {@link DummyResponse }
     * 
     */
    public DummyResponse createDummyResponse() {
        return new DummyResponse();
    }

    /**
     * Create an instance of {@link GetPersonaResponse }
     * 
     */
    public GetPersonaResponse createGetPersonaResponse() {
        return new GetPersonaResponse();
    }

    /**
     * Create an instance of {@link GetPersona }
     * 
     */
    public GetPersona createGetPersona() {
        return new GetPersona();
    }

    /**
     * Create an instance of {@link DatosGenerales }
     * 
     */
    public DatosGenerales createDatosGenerales() {
        return new DatosGenerales();
    }

    /**
     * Create an instance of {@link ErrorMonotributo }
     * 
     */
    public ErrorMonotributo createErrorMonotributo() {
        return new ErrorMonotributo();
    }

    /**
     * Create an instance of {@link Relacion }
     * 
     */
    public Relacion createRelacion() {
        return new Relacion();
    }

    /**
     * Create an instance of {@link Metadata }
     * 
     */
    public Metadata createMetadata() {
        return new Metadata();
    }

    /**
     * Create an instance of {@link PersonaReturn }
     * 
     */
    public PersonaReturn createPersonaReturn() {
        return new PersonaReturn();
    }

    /**
     * Create an instance of {@link Categoria }
     * 
     */
    public Categoria createCategoria() {
        return new Categoria();
    }

    /**
     * Create an instance of {@link ErrorConstancia }
     * 
     */
    public ErrorConstancia createErrorConstancia() {
        return new ErrorConstancia();
    }

    /**
     * Create an instance of {@link DatosMonotributo }
     * 
     */
    public DatosMonotributo createDatosMonotributo() {
        return new DatosMonotributo();
    }

    /**
     * Create an instance of {@link ErrorRegimenGeneral }
     * 
     */
    public ErrorRegimenGeneral createErrorRegimenGeneral() {
        return new ErrorRegimenGeneral();
    }

    /**
     * Create an instance of {@link Dependencia }
     * 
     */
    public Dependencia createDependencia() {
        return new Dependencia();
    }

    /**
     * Create an instance of {@link Actividad }
     * 
     */
    public Actividad createActividad() {
        return new Actividad();
    }

    /**
     * Create an instance of {@link Domicilio }
     * 
     */
    public Domicilio createDomicilio() {
        return new Domicilio();
    }

    /**
     * Create an instance of {@link Impuesto }
     * 
     */
    public Impuesto createImpuesto() {
        return new Impuesto();
    }

    /**
     * Create an instance of {@link DummyReturn }
     * 
     */
    public DummyReturn createDummyReturn() {
        return new DummyReturn();
    }

    /**
     * Create an instance of {@link DatosRegimenGeneral }
     * 
     */
    public DatosRegimenGeneral createDatosRegimenGeneral() {
        return new DatosRegimenGeneral();
    }

    /**
     * Create an instance of {@link Regimen }
     * 
     */
    public Regimen createRegimen() {
        return new Regimen();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersona }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://a5.soap.ws.server.puc.sr/", name = "getPersona")
    public JAXBElement<GetPersona> createGetPersona(GetPersona value) {
        return new JAXBElement<GetPersona>(_GetPersona_QNAME, GetPersona.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://a5.soap.ws.server.puc.sr/", name = "getPersonaResponse")
    public JAXBElement<GetPersonaResponse> createGetPersonaResponse(GetPersonaResponse value) {
        return new JAXBElement<GetPersonaResponse>(_GetPersonaResponse_QNAME, GetPersonaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DummyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://a5.soap.ws.server.puc.sr/", name = "dummyResponse")
    public JAXBElement<DummyResponse> createDummyResponse(DummyResponse value) {
        return new JAXBElement<DummyResponse>(_DummyResponse_QNAME, DummyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Dummy }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://a5.soap.ws.server.puc.sr/", name = "dummy")
    public JAXBElement<Dummy> createDummy(Dummy value) {
        return new JAXBElement<Dummy>(_Dummy_QNAME, Dummy.class, null, value);
    }

}
