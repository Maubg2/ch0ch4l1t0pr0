package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Sede;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories.SedeRepository;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.AuditoriaService;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.SedeService;

@Controller
public class ControllerTestEmpleado {

    @Autowired
    private SedeService sedeService;

    @Autowired
    private AuditoriaService auditoriaService;

    @GetMapping("/menuAdmin")
    public String test(){
        return "menuAdmin";
    }

    @GetMapping("/sedesAdmin")
    public String sedesAdmin(Model model){
        List<Sede> sedes = sedeService.listarSedes();
        model.addAttribute("sedes", sedes);
        return "sedesAdmin";
    }
    
    @GetMapping("/modificarSedeAdmin/{idSede}")
    public String mostrarFormularioModificarSede(@PathVariable Long idSede, Model model) {
        Optional<Sede> sede = sedeService.findById(idSede);
        model.addAttribute("sede", sede.get());
        return "modificarSedeAdmin";
    }

    @PostMapping("/modificarSedeAdmin/{idSede}")
    public String modificarSedeAdmin(@PathVariable Long idSede, Sede sedeModificada) {
        sedeService.modificarSede(idSede, sedeModificada);
        return "redirect:/sedesAdmin";
    }
/*  
    @GetMapping("/modificarSedeAmdin/{idSede}")
    public String FormularioModificarSede(@PathVariable Long idSede){
        return "modificarSedeAmdin";
    }*/

    @GetMapping("/reservasAdmin")
    public String reservasAdmin(){
        return "reservasAdmin";
    }
    @GetMapping("/verClientesAdmin")
    public String verClientesAdmin(){
        return "verClientesAdmin";
    }
    @GetMapping("/auditoriasAdmin")
    public String auditoriasAdmin(Model model){
        model.addAttribute("auditorias", auditoriaService.listarAuditorias());
        return "auditoriasAdmin";
    }


}
