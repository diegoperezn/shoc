/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import com.shoc.domain.DispositivosEnum;
import com.shoc.domain.FacturaDetail;
import com.shoc.domain.HistoricoDispositivo;
import com.shoc.domain.IFacturable;
import com.shoc.domain.Paciente;
import com.shoc.domain.repository.FacturaDetailRepository;
import com.shoc.domain.utils.DateUtils;
import java.util.Date;
import java.util.List;

/**
 *
 * @author diego
 */
public class FacturaDetailService {

    private static FacturaDetailService instance;

    public static FacturaDetailService getInstance() {
        if (instance == null) {
            instance = new FacturaDetailService();
        }

        return instance;
    }

    private final FacturaDetailRepository repo = FacturaDetailRepository.getInstance();

    private final PacienteService pacienteService = PacienteService.getInstance();

    public void createFacturaDetail(IFacturable ifd) {
        FacturaDetail fd = new FacturaDetail(ifd);

        repo.save(fd);
    }

    public List<FacturaDetail> listAll() {
        return repo.listAll();
    }

    public FacturaDetail get(Long id) {
        return repo.get(id);
    }

    public void deleteById(Long selectedId) {
        this.repo.delete(selectedId);
    }

    public List<FacturaDetail> generarYlistarFacuraDetails() {
        return this.generarYlistarFacuraDetails(DateUtils.getMinimaFecha().getTime());
    }

    public List<FacturaDetail> generarYlistarFacuraDetails(Date desde) {
        List<Paciente> pacientes = this.pacienteService.listarPacientesActivos(desde);

        buildFacturaDetails(pacientes, desde);

        return this.repo.listAll();
    }

    public List<FacturaDetail> generarYlistarFacuraDetails(IFaturaDetailsSearch filter) throws Exception {
        List<Paciente> pacientes = this.pacienteService.listarPacientesActivos(filter);

        if (pacientes.isEmpty()) {
            throw new Exception("No hay pacientes activos para la busqueda realizada");
        }

        Date desde = filter.getMes();
        if (desde == null) {
            desde = DateUtils.getMinimaFecha().getTime();
        }
        Boolean seCreoAlguno = buildFacturaDetails(pacientes, desde);

        if (!seCreoAlguno) {
            throw new Exception("Los pacientes encontrados en la busquedas ya tiene los item de facturación creados");
        }

        return this.repo.search(filter);
    }

    private Boolean buildFacturaDetails(List<Paciente> pacientes, Date desde) {
        Boolean seCreoAlguno = false;

        for (Paciente paciente : pacientes) {
            for (HistoricoDispositivo hist : paciente.getHistoricoDispositivo()) {
                if (hist.getDispositivo().equals(paciente.getDispositivoTerapia())
                        || (!hist.getDispositivo().equals(paciente.getDispositivoTerapia())
                        && DateUtils.esMismoMes(hist.getFechaCambio(), desde))) {
                    if (!this.repo.existInDetails(paciente, hist.getDispositivo(), desde)) {
                        seCreoAlguno = true;
                        this.createFacturaDetail(new IFacturable() {

                            @Override
                            public Date getFecha() {
                                return desde;
                            }

                            @Override
                            public Paciente getPaciente() {
                                return paciente;
                            }

                            @Override
                            public DispositivosEnum getDispositivo() {
                                return hist.getDispositivo();
                            }

                        });
                    }
                }
            }
        }

        return seCreoAlguno;
    }

    public void actualizarDias(Long id, Integer dias, Double costo, Double totalMes) {
        FacturaDetail fd = this.repo.get(id);

        fd.setDias(dias);
        fd.setCostoDispositivo(costo);
        fd.setMonto(totalMes);

        this.repo.save(fd);
    }

    public List<FacturaDetail> search(IFaturaDetailsSearch filter) {
        return this.repo.search(filter);
    }

}
