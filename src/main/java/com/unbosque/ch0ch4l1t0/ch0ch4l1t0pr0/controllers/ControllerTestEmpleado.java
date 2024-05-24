package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.DetalleReserva;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Mesa;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Reserva;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Sede;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.TipoReserva;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Usuario;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.dto.ReservaDetalladaDTO;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.dto.ReservaDetalladaDTO2;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories.SedeRepository;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.AuditoriaService;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.DetalleReservaService;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.MesaService;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.ReservaService;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.SedeService;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.TipoReservaService;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.UsuarioService;

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

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private DetalleReservaService detalleReservaService;

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
    public String verClientesAdmin(Model model){
        List<Usuario> usuarios = usuarioService.obtenerClientes();
        usuarios.forEach(System.out::println);
        model.addAttribute("usuarios", usuarios);
        return "verClientesAdmin";
    }
    @GetMapping("/verReservas/{idUsuario}")
    public String verReservas(@PathVariable Long idUsuario, Model model) {
        List<Reserva> reservasUsuario = reservaService.listarReservasUsuario(idUsuario);

        if (reservasUsuario.isEmpty()) {
            // TODO: Agregar la alerta de que no hay reservas
            return "redirect:/verClientesAdmin";
        }

        List<ReservaDetalladaDTO2> reservasDetalladas = new ArrayList<>();
        for (Reserva reserva : reservasUsuario) {
            ReservaDetalladaDTO2 dto = new ReservaDetalladaDTO2();
            dto.setReserva(reserva);
            dto.setSede(reservaService.listarSedeReserva(reserva.getId()));
            dto.setTipoReserva(reservaService.listarTipoReservaReserva(reserva.getId()));
            dto.setMesa(reservaService.listarMesaReserva(reserva.getId()));
            dto.setUsuario(reservaService.listarUsuarioReserva(reserva.getId()));
            List<DetalleReserva> detalles = detalleReservaService.obtenerDetallesPorReserva(reserva.getId());
            if (!detalles.isEmpty()) {
                dto.setDetalleReserva(detalles.get(0));  // Asumiendo que hay solo un detalle por reserva
            }
            reservasDetalladas.add(dto);
        }

        model.addAttribute("reservas", reservasDetalladas);
        return "verReservas";
    }

    @GetMapping("/cambiarEstado/{detalleReservaId}")
    public String cambiarEstado(@PathVariable Long detalleReservaId) {
        detalleReservaService.cambiarEstado(detalleReservaId);
        return "redirect:/reservas/verReservas/{idUsuario}";
    }
/*
    @GetMapping("/verReservas/{idUsuario}")
    public String verReservas(@PathVariable Long idUsuario, Model model) {
        List<Reserva> reservasUsuario = reservaService.listarReservasUsuario(idUsuario);

        if(reservasUsuario.size() == 0){
            //TODO: Agregar la alerta de que no hay reservas
            return "redirect:/verClientesAdmin";
        }
        List<ReservaDetalladaDTO> reservasDetalladas = new ArrayList<>();
        for(Reserva reserva : reservasUsuario){
            ReservaDetalladaDTO dto = new ReservaDetalladaDTO();
            dto.setReserva(reserva);
            dto.setSede(reservaService.listarSedeReserva(reserva.getId()));
            dto.setTipoReserva(reservaService.listarTipoReservaReserva(reserva.getId()));
            dto.setMesa(reservaService.listarMesaReserva(reserva.getId()));
            dto.setUsuario(reservaService.listarUsuarioReserva(reserva.getId()));
            reservasDetalladas.add(dto);
        }

        model.addAttribute("reservas", reservasDetalladas);
        return "verReservas";
    }
 */

//////////////////////////////////////////////////////////
    @GetMapping("/auditoriasAdmin")
    public String auditoriasAdmin(Model model){
        model.addAttribute("auditorias", auditoriaService.listarAuditorias());
        return "auditoriasAdmin";
    }

}
