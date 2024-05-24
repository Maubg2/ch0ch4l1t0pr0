package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Auditoria;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Usuario;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.dto.AuditoriaDTO;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories.AuditoriaRepository;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class AuditoriaServiceImpl implements AuditoriaService{

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public void crearAuditoria(Auditoria auditoria) {
        auditoriaRepository.save(auditoria);
    }

    @Override
    public List<AuditoriaDTO> listarAuditorias() {
        List<Auditoria> auditorias = auditoriaRepository.findAll();
        List<AuditoriaDTO> auditoriaDTOs = new ArrayList<>();

        for (Auditoria auditoria : auditorias) {
            Usuario usuario = usuarioRepository.findById(auditoria.getFkUsuario()).orElse(null);
            String nombreUsuario = usuario != null ? usuario.getNombres() + " " + usuario.getApellidos() : "Usuario no encontrado";

            AuditoriaDTO auditoriaDTO = new AuditoriaDTO();
            auditoriaDTO.setDescripcion(auditoria.getDescripcion());
            auditoriaDTO.setFecha(auditoria.getFecha());
            auditoriaDTO.setTablaAfectada(auditoria.getTablaAfectada());
            auditoriaDTO.setNombreUsuario(nombreUsuario);

            auditoriaDTOs.add(auditoriaDTO);
        }

        return auditoriaDTOs;
    }

}
