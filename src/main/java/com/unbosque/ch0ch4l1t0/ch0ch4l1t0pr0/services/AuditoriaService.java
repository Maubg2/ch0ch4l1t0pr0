package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import java.util.List;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Auditoria;

public interface AuditoriaService {
    
    public void crearAuditoria(Auditoria auditoria);

    public List<Auditoria> listarAuditorias();

}
