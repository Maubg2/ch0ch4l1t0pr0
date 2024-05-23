package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Mesa;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Sede;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.TipoReserva;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories.SedeRepository;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.AuditoriaService;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.MesaService;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.SedeService;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.TipoReservaService;

@Controller
public class ControllerTestEmpleado {

    @Autowired
    private SedeService sedeService;

    @Autowired
    private AuditoriaService auditoriaService;

    @Autowired
    private MesaService mesaService;

    @Autowired
    private TipoReservaService tipoReservaService;

    @GetMapping("/menuAdmin")
    public String test(){
        return "menuAdmin";
    }
//////////////////////////////////////////////////////////

@GetMapping("/sedesAdmin")
public String sedesAdmin(Model model) {
    List<Sede> sedes = sedeService.listarSedes();
    model.addAttribute("sedes", sedes);
    return "sedesAdmin";
}

@GetMapping("/modificarSedeAdmin/{idSede}")
public String mostrarFormularioModificarSede(@PathVariable Long idSede, Model model) {
    Optional<Sede> sede = sedeService.findById(idSede);
    if (sede.isPresent()) {
        model.addAttribute("sede", sede.get());
    } else {
        model.addAttribute("sede", new Sede());
    }
    return "modificarSedeAdmin";
}

@PostMapping("/modificarSedeAdmin/{idSede}")
public String modificarSedeAdmin(@PathVariable Long idSede, @ModelAttribute Sede sedeModificada) {
    sedeService.modificarSede(idSede, sedeModificada);
    return "redirect:/sedesAdmin";
}

@GetMapping("/crearSede")
public String mostrarFormularioCrearSede(Model model) {
    model.addAttribute("sede", new Sede());
    return "modificarSedeAdmin";
}

@PostMapping("/crearSede")
public String crearSede(@ModelAttribute Sede nuevaSede) {
    sedeService.guardar(nuevaSede);
    return "redirect:/sedesAdmin";
}

@GetMapping("/verMesas/{idSede}")
public String verMesas(@PathVariable Long idSede, Model model) {
    List<Mesa> mesas = mesaService.mesasPorSedeId(idSede);
    model.addAttribute("mesas", mesas);
    model.addAttribute("idSede", idSede);
    return "listadoMesasAdmin";
}

@GetMapping("/modificarMesa/{idMesa}/{idSede}")
public String mostrarFormularioModificarMesa(@PathVariable Long idMesa, @PathVariable Long idSede, Model model) {
    Optional<Mesa> mesa = mesaService.findById(idMesa);
    if (mesa.isPresent()) {
        model.addAttribute("mesa", mesa.get());
    } else {
        model.addAttribute("mesa", new Mesa());
    }
    model.addAttribute("idSede", idSede);
    return "modificarMesaAdmin";
}

@PostMapping("/modificarMesa/{idMesa}")
public String modificarMesa(@PathVariable Long idMesa, @ModelAttribute Mesa mesaModificada) {
    mesaService.modificarMesa(idMesa, mesaModificada);
    return "redirect:/verMesas/" + mesaModificada.getFkSede();
}

@GetMapping("/crearMesa/{idSede}")
public String mostrarFormularioCrearMesa(@PathVariable Long idSede, Model model) {
    Mesa nuevaMesa = new Mesa();
    nuevaMesa.setFkSede(idSede);
    model.addAttribute("mesa", nuevaMesa);
    model.addAttribute("idSede", idSede);
    return "modificarMesaAdmin";
}

@PostMapping("/crearMesa")
public String crearMesa(@ModelAttribute Mesa nuevaMesa) {
    mesaService.guardar(nuevaMesa);
    return "redirect:/verMesas/" + nuevaMesa.getFkSede();
}

//////////////////////////////////////////////////////////
@GetMapping("/reservasAdmin")
public String reservasAdmin(Model model) {
    model.addAttribute("tipoReservas", tipoReservaService.listarTodos());
    return "reservasAdmin";
}

@GetMapping("/crearTipoReserva")
public String mostrarFormularioCrearTipoReserva(Model model) {
    model.addAttribute("tipoReserva", new TipoReserva());
    model.addAttribute("actionUrl", "/crearTipoReserva");
    return "formularioTipoReservaAdmin";
}

@PostMapping("/crearTipoReserva")
public String crearTipoReserva(@ModelAttribute TipoReserva tipoReserva) {
    tipoReservaService.guardar(tipoReserva);
    return "redirect:/reservasAdmin";
}

@GetMapping("/modificarTipoReserva/{id}")
public String mostrarFormularioModificarTipoReserva(@PathVariable Long id, Model model) {
    Optional<TipoReserva> tipoReserva = tipoReservaService.findById(id);
    if (tipoReserva.isPresent()) {
        model.addAttribute("tipoReserva", tipoReserva.get());
        model.addAttribute("actionUrl", "/modificarTipoReserva/" + id);
    } else {
        return "redirect:/reservasAdmin";
    }
    return "formularioTipoReservaAdmin";
}

@PostMapping("/modificarTipoReserva/{id}")
public String modificarTipoReserva(@PathVariable Long id, @ModelAttribute TipoReserva tipoReservaModificada) {
    tipoReservaService.modificarTipoReserva(id, tipoReservaModificada);
    return "redirect:/reservasAdmin";
}

//////////////////////////////////////////////////////////
    @GetMapping("/verClientesAdmin")
    public String verClientesAdmin(){
        return "verClientesAdmin";
    }
//////////////////////////////////////////////////////////
    @GetMapping("/auditoriasAdmin")
    public String auditoriasAdmin(Model model){
        model.addAttribute("auditorias", auditoriaService.listarAuditorias());
        return "auditoriasAdmin";
    }


}
