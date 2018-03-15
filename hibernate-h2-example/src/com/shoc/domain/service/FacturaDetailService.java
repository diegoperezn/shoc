/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shoc.domain.service;

import com.shoc.domain.FacturaDetail;
import com.shoc.domain.IFacturable;
import com.shoc.domain.IObraSocial;
import com.shoc.domain.ObraSocial;
import com.shoc.domain.Paciente;
import com.shoc.domain.repository.FacturaDetailRepository;
import java.util.ArrayList;
import java.util.Calendar;
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

    public Calendar getFechaDesde() {
        Date fecha = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.MONTH, -2);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);

        return cal;
    }

    public List<FacturaDetail> generarYlistarFacuraDetails() {
        Calendar desde = getFechaDesde();
        Date today = new Date();

        List<Paciente> pacientes = this.pacienteService.listarPacientesActivos(desde.getTime());

        while (desde.after(today)) {
            
            for (Paciente paciente : pacientes) {
                if (!this.repo.existInDetails(paciente, paciente.getDispositivoTerapia(), desde.getTime())) {
                    this.createFacturaDetail(ifd);
                }
            }
            
            desde.add(Calendar.MONTH, 1);
        }

        return new ArrayList<FacturaDetail>();
    }

}
