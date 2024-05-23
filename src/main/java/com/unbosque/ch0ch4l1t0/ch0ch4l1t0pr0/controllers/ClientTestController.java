package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Mesa;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Reserva;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.MesaService;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.ReservaService;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.SedeService;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.TipoReservaService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/testcliente")
public class ClientTestController {

    //Servicio de las sedes
    @Autowired
    private SedeService sedeService;

    //Servicio de los tipos de reserva
    @Autowired
    private TipoReservaService tipoReservaService;

    //Servicio de las reservas
    @Autowired
    private ReservaService reservaService;

    //Servicio de las mesas
    @Autowired
    private MesaService mesaService;


    //---------------------INICIO HACER RESERVA--------------------

    //Métodos para retornar las plantillas Thymeleaf
    @GetMapping("/reservaCliente")
    public String crearReserva(Model model){
        //System.out.println("Cargando sedes...");
        //Genera la lista de sedes usando el servicio
        model.addAttribute("sedes", sedeService.listarSedes());

        //System.out.println("Cargando tipos de reserva...");
        //Genera la lista de tipos de reserva usando el servicio
        model.addAttribute("tiposReserva", tipoReservaService.listarTodos());

        
        //Toca pasarle las mesas disponibles en la mesa
        //model.addAttribute("mesas", request.getAttribute("mesas"));
        //System.out.println("Cargando mesas de la sede...");

        //Creación del objeto que se va a popular en el formulario (Llega luego al POST)
        model.addAttribute("reserva", new Reserva());

        System.out.println("Carga exitosa, recuperando reservaCliente");
        return "reservaCliente";
    }

    //Este método recibe el formulario de crear una reserva
    //Método que se usa para guardar la reserva en la DB
    @PostMapping("/reservaCliente")
    public String verReserva(@ModelAttribute("reserva") Reserva reserva, Model model){
        //Verificar que la reserva esté disponible
        //Reserva reserva = reservaService.

        System.out.println("Operación exitosa");
        return "redirect:/testcliente/reservaCliente";
    }

    //Método para buscar las mesas disponibles antes de reservar
    @PostMapping("/cargarMesa")
    public String verificarMesa(@ModelAttribute("reserva") Reserva reserva, HttpSession session, Model model){
        //Guardar la reserva en la sesión
        session.setAttribute("reserva", reserva);
        System.out.println("Entra a cargarMesa");
        model.addAttribute("reserva", reserva);
        return "redirect:/testcliente/buscarMesa/" + reserva.getFkSede();
    }

    //Plantilla que muestra las mesas
    @GetMapping("/buscarMesa/{id}")
    public String buscarMesa(@PathVariable Long id, @ModelAttribute("reserva") Reserva reserva, Model model, HttpSession session){

        //Obtener reserva
        Reserva reservaRes = (Reserva) session.getAttribute("reserva");

        System.out.println("Recibida sede " + reservaRes.getFkSede());
        System.out.println("Buscando sede " + id);
        java.util.List<Mesa> mesasDeSede = mesaService.mesasPorSedeId(id);
        System.out.println("Encontradas " + mesasDeSede.size() + " mesas");
        //No envía las mesas encontradas
        model.addAttribute("mesas", mesasDeSede);

        return "buscarMesaCliente";
    }

    //----------------------FIN HACER RESERVA-------------------

    //Método para el formato de la fecha
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
