package com.shoc.afip.wsmtxca;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 *
 */
@WebService(name = "MTXCAServicePortType", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MTXCAServicePortType {

    /**
     *
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.DummyResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/dummy")
    @WebResult(name = "dummyResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public DummyResponseType dummy()
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.AutorizarComprobanteResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/autorizarComprobante")
    @WebResult(name = "autorizarComprobanteResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public AutorizarComprobanteResponseType autorizarComprobante(
            @WebParam(name = "autorizarComprobanteRequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") AutorizarComprobanteRequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.SolicitarCAEAResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/solicitarCAEA")
    @WebResult(name = "solicitarCAEAResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public SolicitarCAEAResponseType solicitarCAEA(
            @WebParam(name = "solicitarCAEARequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") SolicitarCAEARequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.InformarComprobanteCAEAResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/informarComprobanteCAEA")
    @WebResult(name = "informarComprobanteCAEAResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public InformarComprobanteCAEAResponseType informarComprobanteCAEA(
            @WebParam(name = "informarComprobanteCAEARequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") InformarComprobanteCAEARequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.ConsultarUltimoComprobanteAutorizadoResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/consultarUltimoComprobanteAutorizado")
    @WebResult(name = "consultarUltimoComprobanteAutorizadoResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public ConsultarUltimoComprobanteAutorizadoResponseType consultarUltimoComprobanteAutorizado(
            @WebParam(name = "consultarUltimoComprobanteAutorizadoRequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") ConsultarUltimoComprobanteAutorizadoRequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.ConsultarComprobanteResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/consultarComprobante")
    @WebResult(name = "consultarComprobanteResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public ConsultarComprobanteResponseType consultarComprobante(
            @WebParam(name = "consultarComprobanteRequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") ConsultarComprobanteRequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposComprobanteResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/consultarTiposComprobante")
    @WebResult(name = "consultarTiposComprobanteResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public ConsultarTiposComprobanteResponseType consultarTiposComprobante(
            @WebParam(name = "consultarTiposComprobanteRequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") ConsultarTiposComprobanteRequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDocumentoResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/consultarTiposDocumento")
    @WebResult(name = "consultarTiposDocumentoResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public ConsultarTiposDocumentoResponseType consultarTiposDocumento(
            @WebParam(name = "consultarTiposDocumentoRequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") ConsultarTiposDocumentoRequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.ConsultarAlicuotasIVAResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/consultarAlicuotasIVA")
    @WebResult(name = "consultarAlicuotasIVAResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public ConsultarAlicuotasIVAResponseType consultarAlicuotasIVA(
            @WebParam(name = "consultarAlicuotasIVARequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") ConsultarAlicuotasIVARequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.ConsultarCondicionesIVAResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/consultarCondicionesIVA")
    @WebResult(name = "consultarCondicionesIVAResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public ConsultarCondicionesIVAResponseType consultarCondicionesIVA(
            @WebParam(name = "consultarCondicionesIVARequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") ConsultarCondicionesIVARequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.ConsultarMonedasResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/consultarMonedas")
    @WebResult(name = "consultarMonedasResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public ConsultarMonedasResponseType consultarMonedas(
            @WebParam(name = "consultarMonedasRequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") ConsultarMonedasRequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.ConsultarCotizacionMonedaResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/consultarCotizacionMoneda")
    @WebResult(name = "consultarCotizacionMonedaResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public ConsultarCotizacionMonedaResponseType consultarCotizacionMoneda(
            @WebParam(name = "consultarCotizacionMonedaRequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") ConsultarCotizacionMonedaRequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.ConsultarUnidadesMedidaResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/consultarUnidadesMedida")
    @WebResult(name = "consultarUnidadesMedidaResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public ConsultarUnidadesMedidaResponseType consultarUnidadesMedida(
            @WebParam(name = "consultarUnidadesMedidaRequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") ConsultarUnidadesMedidaRequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/consultarPuntosVenta")
    @WebResult(name = "consultarPuntosVentaResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public ConsultarPuntosVentaResponseType consultarPuntosVenta(
            @WebParam(name = "consultarPuntosVentaRequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") ConsultarPuntosVentaRequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/consultarPuntosVentaCAE")
    @WebResult(name = "consultarPuntosVentaCAEResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public ConsultarPuntosVentaResponseType consultarPuntosVentaCAE(
            @WebParam(name = "consultarPuntosVentaCAERequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") ConsultarPuntosVentaCAERequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.ConsultarPuntosVentaResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/consultarPuntosVentaCAEA")
    @WebResult(name = "consultarPuntosVentaCAEAResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public ConsultarPuntosVentaResponseType consultarPuntosVentaCAEA(
            @WebParam(name = "consultarPuntosVentaCAEARequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") ConsultarPuntosVentaCAEARequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/informarCAEANoUtilizado")
    @WebResult(name = "informarCAEANoUtilizadoResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public InformarCAEANoUtilizadoResponseType informarCAEANoUtilizado(
            @WebParam(name = "informarCAEANoUtilizadoRequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") InformarCAEANoUtilizadoRequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposTributoResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/consultarTiposTributo")
    @WebResult(name = "consultarTiposTributoResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public ConsultarTiposTributoResponseType consultarTiposTributo(
            @WebParam(name = "consultarTiposTributoRequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") ConsultarTiposTributoRequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.InformarCAEANoUtilizadoPtoVtaResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/informarCAEANoUtilizadoPtoVta")
    @WebResult(name = "informarCAEANoUtilizadoPtoVtaResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public InformarCAEANoUtilizadoPtoVtaResponseType informarCAEANoUtilizadoPtoVta(
            @WebParam(name = "informarCAEANoUtilizadoPtoVtaRequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") InformarCAEANoUtilizadoPtoVtaRequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEAResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/consultarCAEA")
    @WebResult(name = "consultarCAEAResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public ConsultarCAEAResponseType consultarCAEA(
            @WebParam(name = "consultarCAEARequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") ConsultarCAEARequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.ConsultarPtosVtaCAEANoInformadosResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/consultarPtosVtaCAEANoInformados")
    @WebResult(name = "consultarPtosVtaCAEANoInformadosResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public ConsultarPtosVtaCAEANoInformadosResponseType consultarPtosVtaCAEANoInformados(
            @WebParam(name = "consultarPtosVtaCAEANoInformadosRequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") ConsultarPtosVtaCAEANoInformadosRequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.ConsultarCAEAEntreFechasResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/consultarCAEAEntreFechas")
    @WebResult(name = "consultarCAEAEntreFechasResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public ConsultarCAEAEntreFechasResponseType consultarCAEAEntreFechas(
            @WebParam(name = "consultarCAEAEntreFechasRequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") ConsultarCAEAEntreFechasRequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.AutorizarAjusteIVAResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/autorizarAjusteIVA")
    @WebResult(name = "autorizarAjusteIVAResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public AutorizarAjusteIVAResponseType autorizarAjusteIVA(
            @WebParam(name = "autorizarAjusteIVARequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") AutorizarAjusteIVARequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.InformarAjusteIVACAEAResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/informarAjusteIVACAEA")
    @WebResult(name = "informarAjusteIVACAEAResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public InformarAjusteIVACAEAResponseType informarAjusteIVACAEA(
            @WebParam(name = "informarAjusteIVACAEARequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") InformarAjusteIVACAEARequestType parameters)
            throws ExceptionFaultMsg;

    /**
     *
     * @param parameters
     * @return returns
     * ar.gov.afip.wsmtxca.service.impl.service.ConsultarTiposDatosAdicionalesResponseType
     * @throws ExceptionFaultMsg
     */
    @WebMethod(action = "http://impl.service.wsmtxca.afip.gov.ar/service/consultarTiposDatosAdicionales")
    @WebResult(name = "consultarTiposDatosAdicionalesResponse", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters")
    public ConsultarTiposDatosAdicionalesResponseType consultarTiposDatosAdicionales(
            @WebParam(name = "consultarTiposDatosAdicionalesRequest", targetNamespace = "http://impl.service.wsmtxca.afip.gov.ar/service/", partName = "parameters") ConsultarTiposDatosAdicionalesRequestType parameters)
            throws ExceptionFaultMsg;

}
