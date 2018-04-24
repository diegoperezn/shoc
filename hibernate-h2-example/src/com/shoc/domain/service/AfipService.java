/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import ar.gov.afip.wsmtxca.service.impl.service.ArrayItemsType;
import ar.gov.afip.wsmtxca.service.impl.service.ArraySubtotalesIVAType;
import ar.gov.afip.wsmtxca.service.impl.service.AutorizarComprobanteRequestType;
import ar.gov.afip.wsmtxca.service.impl.service.CodigoDescripcionType;
import ar.gov.afip.wsmtxca.service.impl.service.ComprobanteCAEResponseType;
import ar.gov.afip.wsmtxca.service.impl.service.ComprobanteType;
import ar.gov.afip.wsmtxca.service.impl.service.ExceptionFaultMsg;
import ar.gov.afip.wsmtxca.service.impl.service.ItemType;
import ar.gov.afip.wsmtxca.service.impl.service.PuntoVentaType;
import ar.gov.afip.wsmtxca.service.impl.service.SubtotalIVAType;
import com.shoc.domain.Factura;
import com.shoc.domain.FacturaDetail;
import com.shoc.domain.SociedadEnum;
import com.shoc.domain.repository.AfipException;
import com.shoc.domain.repository.AfipTiposRepository;
import com.shoc.domain.utils.DateUtils;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

/**
 *
 * @author diego
 */
public class AfipService {

    private static AfipService instance;

    public static AfipService getInstance() {
        if (instance == null) {
            instance = new AfipService();
        }

        return instance;
    }

    private final AfipTiposRepository repo = AfipTiposRepository.getInstance();
    private final FacturaService fService = FacturaService.getInstance();

    public List<CodigoDescripcionType> listarTiposComprobante(SociedadEnum sociedad) throws IOException {
        return this.repo.listarTiposFactura(sociedad);
    }

    public List<PuntoVentaType> listarPuntosVenta(SociedadEnum sociedad) throws IOException {
        return this.repo.listarPuntoVenta(sociedad);
    }

    private static final Short FACTURA_A_CODE = new Short("1");

    public void enviarFacturaAfip(SociedadEnum sociedadEnum, CodigoDescripcionType codigoDescripcionType,
            PuntoVentaType puntoVentaType, Factura f) throws AfipException {
        try {
            AutorizarComprobanteRequestType parameters = new AutorizarComprobanteRequestType();

            ComprobanteType comprobante = new ComprobanteType();

            final short codigoTipoComprobante = codigoDescripcionType.getCodigo();
            final short numeroPuntoVenta = new Short("1"); //puntoVentaType.getNumeroPuntoVenta();
            final int codigoComprobante
                    = this.repo.consultarUltimoComprobante(sociedadEnum, codigoTipoComprobante, numeroPuntoVenta);

            comprobante.setCodigoTipoComprobante(codigoTipoComprobante);
            comprobante.setNumeroPuntoVenta(numeroPuntoVenta);
            comprobante.setNumeroComprobante(codigoComprobante + 1);

            ICliente cliente = f.getObraSocial() != null ? f.getObraSocial() : f.getPaciente();

            if (FACTURA_A_CODE.equals(codigoDescripcionType.getCodigo())) {
                comprobante.setCodigoTipoDocumento(new Short("80"));
            } else {
                comprobante.setCodigoTipoDocumento(new Short("96"));
            }

            comprobante.setNumeroDocumento(new Long(cliente.getDocumento()));

            if (FACTURA_A_CODE.equals(codigoDescripcionType.getCodigo())) {
                comprobante.setCodigoTipoDocumento(new Short("80"));
            } else {
                comprobante.setCodigoTipoDocumento(new Short("96"));
            }

            comprobante.setImporteGravado(toPrecision(f.getImporteGravado()));
            comprobante.setImporteNoGravado(toPrecision(f.getImporteNoGravado()));
            comprobante.setImporteTotal(toPrecision(f.getTotal()));
            comprobante.setImporteSubtotal(toPrecision(f.getSubtotal()));

            comprobante.setCodigoMoneda("PES");
            comprobante.setCotizacionMoneda(new BigDecimal(BigInteger.ONE));

            comprobante.setCodigoConcepto(new Short("2"));

            GregorianCalendar gcDesde = new GregorianCalendar();
            gcDesde.setTime(DateUtils.getMinimaFecha(f.getFecha()).getTime());
            comprobante.setFechaServicioDesde(DatatypeFactory.newInstance().newXMLGregorianCalendar(gcDesde));

            GregorianCalendar gcHasta = new GregorianCalendar();
            gcHasta.setTime(DateUtils.getMaximaFecha(f.getFecha()).getTime());
            comprobante.setFechaServicioHasta(DatatypeFactory.newInstance().newXMLGregorianCalendar(gcHasta));

            GregorianCalendar gcVto = new GregorianCalendar();
            gcVto.setTime(DateUtils.getMaximaFecha(f.getFecha()).getTime());
            gcVto.add(GregorianCalendar.MONTH, 1);
            comprobante.setFechaVencimientoPago(DatatypeFactory.newInstance().newXMLGregorianCalendar(gcVto));

            ArrayItemsType items = new ArrayItemsType();
            for (FacturaDetail detail : f.getDetails()) {
                ItemType item = new ItemType();

                item.setUnidadesMtx(1);
                item.setCodigoMtx("1");
                item.setDescripcion(detail.getDescripcion());
                item.setCantidad(BigDecimal.valueOf(detail.getDias()));
                item.setCodigoUnidadMedida(new Short("1"));

                Double precioUnitario = detail.getCostoDispositivo();
                if (!FACTURA_A_CODE.equals(codigoDescripcionType.getCodigo())) {
                    precioUnitario = precioUnitario + (precioUnitario * detail.getAlicuota());
                }

                item.setPrecioUnitario(toPrecision(precioUnitario));

                if (detail.isGravado()) {
                    item.setCodigoCondicionIVA(new Short("4"));
                    if (FACTURA_A_CODE.equals(codigoDescripcionType.getCodigo())) {
                        item.setImporteIVA(toPrecision(detail.getMontoAlicuota()));
                    }

                } else {
                    item.setCodigoCondicionIVA(new Short("1"));
                    if (FACTURA_A_CODE.equals(codigoDescripcionType.getCodigo())) {
                        item.setImporteIVA(BigDecimal.ZERO);
                    }
                }

                item.setImporteItem(toPrecision(detail.getMontoFinal()));

                items.getItem().add(item);
            }
            comprobante.setArrayItems(items);

            if (f.getImporteGravado() != null && !f.getImporteGravado().equals(new Double("0"))) {
                ArraySubtotalesIVAType subtotalIVA = new ArraySubtotalesIVAType();

                SubtotalIVAType ivaItem = new SubtotalIVAType();
                ivaItem.setCodigo(new Short("4"));
                ivaItem.setImporte(toPrecision(f.getMontoIva()));

                subtotalIVA.getSubtotalIVA().add(ivaItem);
                comprobante.setArraySubtotalesIVA(subtotalIVA);
            }

            Logger.getLogger(AfipService.class.getName()).log(Level.INFO, comprobante.toString());

            ComprobanteCAEResponseType response = this.repo.enviarFactura(sociedadEnum, comprobante);

            Logger.getLogger(AfipService.class.getName()).log(Level.INFO, response.toString());

            fService.marcarFacturaComoEnviadaAfip(f, response, codigoDescripcionType, sociedadEnum);

        } catch (ExceptionFaultMsg ex) {
            Logger.getLogger(AfipService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AfipService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(AfipService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private BigDecimal toPrecision(Double value) {
        BigDecimal a = new BigDecimal(value);
        return a.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

}
