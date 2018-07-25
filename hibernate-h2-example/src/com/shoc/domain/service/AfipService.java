/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import com.shoc.afip.shoc.IPuntoDeVenta;
import com.shoc.afip.shoc.ServicioAfipEnum;
import com.shoc.afip.wsmtxca.ArrayItemsType;
import com.shoc.afip.wsmtxca.ArraySubtotalesIVAType;
import com.shoc.afip.wsmtxca.AutorizarComprobanteRequestType;
import com.shoc.afip.wsmtxca.CodigoDescripcionType;
import com.shoc.afip.wsmtxca.ComprobanteCAEResponseType;
import com.shoc.afip.wsmtxca.ComprobanteType;
import com.shoc.afip.wsmtxca.ExceptionFaultMsg;
import com.shoc.afip.wsmtxca.ItemType;
import com.shoc.afip.wsmtxca.SubtotalIVAType;
import com.shoc.afip.wsve.AlicIva;
import com.shoc.afip.wsve.ArrayOfAlicIva;
import com.shoc.afip.wsve.ArrayOfFECAEDetRequest;
import com.shoc.afip.wsve.FECAECabRequest;
import com.shoc.afip.wsve.FECAEDetRequest;
import com.shoc.afip.wsve.FECAERequest;
import com.shoc.afip.wsve.FECAEResponse;
import com.shoc.domain.Factura;
import com.shoc.domain.FacturaAfipEnum;
import com.shoc.domain.FacturaDetail;
import com.shoc.domain.SociedadEnum;
import com.shoc.domain.repository.AfipException;
import com.shoc.domain.repository.AfipTiposRepositoryFE;
import com.shoc.domain.repository.AfipTiposRepositoryTXCA;
import com.shoc.domain.utils.DateUtils;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    private final AfipTiposRepositoryTXCA repoTXCA = AfipTiposRepositoryTXCA.getInstance();
    private final AfipTiposRepositoryFE repoFEV = AfipTiposRepositoryFE.getInstance();
    
    
    private final FacturaService fService = FacturaService.getInstance();

    public List<CodigoDescripcionType> listarTiposComprobante(SociedadEnum sociedad) throws IOException {
        return this.repoTXCA.listarTiposFactura(sociedad);
    }

    public List<IPuntoDeVenta> listarPuntosVenta(SociedadEnum sociedad, ServicioAfipEnum servicio) throws IOException {
        if (servicio.equals(ServicioAfipEnum.WSMTXCA)) {
        
            return this.repoTXCA.listarPuntoVenta(sociedad);
        } else {
            return this.repoFEV.listarPuntoVenta(sociedad);
        }
    }

    private static final Short FACTURA_A_CODE = new Short("1");

    public void enviarFacturaAfipConDetalle(SociedadEnum sociedadEnum, FacturaAfipEnum codigoDescripcionType,
            IPuntoDeVenta puntoVentaType, Factura f) throws AfipException {
        try {
            AutorizarComprobanteRequestType parameters = new AutorizarComprobanteRequestType();

            ComprobanteType comprobante = new ComprobanteType();

            final short codigoTipoComprobante = codigoDescripcionType.getCodigo();
            final short numeroPuntoVenta = puntoVentaType.getNumero();
            final int codigoComprobante
                    = this.repoTXCA.consultarUltimoComprobante(sociedadEnum, codigoTipoComprobante, numeroPuntoVenta);

            comprobante.setCodigoTipoComprobante(codigoTipoComprobante);
            comprobante.setNumeroPuntoVenta(numeroPuntoVenta);
            comprobante.setNumeroComprobante(codigoComprobante + 1);

            ICliente cliente = f.getObraSocial() != null ? f.getObraSocial() : f.getPaciente();

            if (FacturaAfipEnum.FACTURA_A.equals(codigoDescripcionType)) {
                comprobante.setCodigoTipoDocumento(new Short("80"));
            } else {
                comprobante.setCodigoTipoDocumento(new Short("96"));
            }

            comprobante.setNumeroDocumento(new Long(cliente.getDocumento().replaceAll("[^0-9]", "")));

            if (FacturaAfipEnum.FACTURA_A.equals(codigoDescripcionType)) {
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
                if (!FacturaAfipEnum.FACTURA_A.equals(codigoDescripcionType)) {
                    precioUnitario = precioUnitario + (precioUnitario * detail.getAlicuota());
                }

                item.setPrecioUnitario(toPrecision(precioUnitario));

                if (detail.isGravado()) {
                    item.setCodigoCondicionIVA(new Short("4"));
                    if (FacturaAfipEnum.FACTURA_A.equals(codigoDescripcionType)) {
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

            ComprobanteCAEResponseType response = this.repoTXCA.enviarFactura(sociedadEnum, comprobante);

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
    
    private Double toPrecisionDouble(Double value) {
       BigDecimal a = new BigDecimal(value);
        return a.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    
    public void enviarFacturaAfipSinDetalle(SociedadEnum sociedadEnum, FacturaAfipEnum codigoDescripcionType, IPuntoDeVenta iPuntoDeVenta, Factura f) throws AfipException {
         try {
            AutorizarComprobanteRequestType parameters = new AutorizarComprobanteRequestType();

             FECAECabRequest comprobanteh = new FECAECabRequest();
            FECAEDetRequest comprobante = new FECAEDetRequest();

            final short codigoTipoComprobante = codigoDescripcionType.getCodigo();
            final short numeroPuntoVenta = iPuntoDeVenta.getNumero();
            final int codigoComprobante
                    = this.repoFEV.consultarUltimoComprobante(sociedadEnum, codigoTipoComprobante, numeroPuntoVenta) + 1;

            comprobanteh.setCbteTipo(codigoTipoComprobante);
            comprobanteh.setPtoVta(numeroPuntoVenta);
            comprobanteh.setCantReg(1);

            ICliente cliente = f.getObraSocial() != null ? f.getObraSocial() : f.getPaciente();

            if (FacturaAfipEnum.FACTURA_A.equals(codigoDescripcionType)) {
                comprobante.setDocTipo(new Short("80"));
            } else {
                comprobante.setDocTipo(new Short("96"));
            }
            
            comprobante.setDocNro(new Long(cliente.getDocumento().replaceAll("[^0-9]", "")));

            comprobante.setImpTotal(toPrecisionDouble(f.getTotal()));
            comprobante.setImpIVA(toPrecisionDouble(f.getMontoIva()));
            comprobante.setImpNeto(toPrecisionDouble(f.getSubtotal()));
            
            comprobante.setImpOpEx(0);
            comprobante.setImpTotConc(0);
            comprobante.setImpTrib(0);

            comprobante.setMonId("PES");
            comprobante.setMonCotiz(1D);

            comprobante.setConcepto(2);

            comprobante.setCbteFch(formatter.format(new Date()));
            
            comprobante.setCbteDesde(codigoComprobante);
            comprobante.setCbteHasta(codigoComprobante);
            
            GregorianCalendar gcDesde = new GregorianCalendar();
            gcDesde.setTime(DateUtils.getMinimaFecha(f.getFecha()).getTime());
            comprobante.setFchServDesde(formatter.format(DateUtils.getMinimaFecha(f.getFecha()).getTime()));

            GregorianCalendar gcHasta = new GregorianCalendar();
            gcHasta.setTime(DateUtils.getMaximaFecha(f.getFecha()).getTime());
            comprobante.setFchServHasta(formatter.format(DateUtils.getMaximaFecha(f.getFecha()).getTime()));

            GregorianCalendar gcVto = new GregorianCalendar();
            gcVto.setTime(DateUtils.getMaximaFecha(f.getFecha()).getTime());
            gcVto.add(GregorianCalendar.MONTH, 1);
            comprobante.setFchVtoPago(formatter.format(gcVto.getTime()));

//            ArrayItemsType items = new ArrayItemsType();
//            for (FacturaDetail detail : f.getDetails()) {
//                ItemType item = new ItemType();
//
//                item.setUnidadesMtx(1);
//                item.setCodigoMtx("1");
//                item.setDescripcion(detail.getDescripcion());
//                item.setCantidad(BigDecimal.valueOf(detail.getDias()));
//                item.setCodigoUnidadMedida(new Short("1"));
//
//                Double precioUnitario = detail.getCostoDispositivo();
//                if (!FacturaAfipEnum.FACTURA_A.equals(codigoDescripcionType)) {
//                    precioUnitario = precioUnitario + (precioUnitario * detail.getAlicuota());
//                }
//
//                item.setPrecioUnitario(toPrecision(precioUnitario));
//
//                if (detail.isGravado()) {
//                    item.setCodigoCondicionIVA(new Short("4"));
//                    if (FacturaAfipEnum.FACTURA_A.equals(codigoDescripcionType)) {
//                        item.setImporteIVA(toPrecision(detail.getMontoAlicuota()));
//                    }
//
//                } else {
//                    item.setCodigoCondicionIVA(new Short("1"));
//                    if (FACTURA_A_CODE.equals(codigoDescripcionType.getCodigo())) {
//                        item.setImporteIVA(BigDecimal.ZERO);
//                    }
//                }
//
//                item.setImporteItem(toPrecision(detail.getMontoFinal()));
//
//                items.getItem().add(item);
//            }
//            comprobante.setArrayItems(items);

            if (!FacturaAfipEnum.FACTURA_C.equals(codigoDescripcionType)) {
                ArrayOfAlicIva subtotalIVA = new ArrayOfAlicIva();

                if (f.getImporteNoGravado() != null && !f.getImporteNoGravado().equals(new Double("0"))) {
                    AlicIva ivaItemd = new AlicIva();

                    ivaItemd.setId(new Short("3"));
                    ivaItemd.setBaseImp(toPrecisionDouble(f.getImporteNoGravado()));
                    ivaItemd.setImporte(0);

                    subtotalIVA.getAlicIva().add(ivaItemd);
                }

                if (f.getImporteGravado() != null && !f.getImporteGravado().equals(new Double("0"))) {
                     AlicIva ivaItem = new AlicIva();

                    ivaItem.setId(new Short("4"));
                    ivaItem.setBaseImp(toPrecisionDouble(f.getImporteGravado()));
                    ivaItem.setImporte(toPrecisionDouble(f.getMontoIva()));

                    subtotalIVA.getAlicIva().add(ivaItem);
                } 

                comprobante.setIva(subtotalIVA);
            }
            

            Logger.getLogger(AfipService.class.getName()).log(Level.INFO, comprobante.toString());
             
            FECAERequest request = new FECAERequest();
            request.setFeCabReq(comprobanteh);
             ArrayOfFECAEDetRequest comprobantes = new ArrayOfFECAEDetRequest();
             comprobantes.getFECAEDetRequest().add(comprobante);
            request.setFeDetReq(comprobantes);

             FECAEResponse response = this.repoFEV.enviarFactura(sociedadEnum, request);

            Logger.getLogger(AfipService.class.getName()).log(Level.INFO, response.toString());

            fService.marcarFacturaComoEnviadaAfip(f, response, codigoDescripcionType, sociedadEnum);

        } catch (ExceptionFaultMsg | IOException ex) {
            Logger.getLogger(AfipService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
