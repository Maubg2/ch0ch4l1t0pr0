package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Reserva;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.MesaService;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.ReservaService;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.SedeService;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.TipoReservaService;

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

        //Creación del objeto que se va a popular en el formulario (Llega luego al POST)
        model.addAttribute("reserva", new Reserva());

        //Toca pasarle las mesas disponibles en la mesa
        //model.addAttribute("mesasSede")

        //System.out.println("Carga exitosa, recuperando reservaCliente");
        return "reservaCliente";
    }

    //Este método recibe el formulario de crear una reserva
    @PostMapping("/reservaCliente")
    public String verReserva(@ModelAttribute("reserva") Reserva reserva, Model model){
        //Verificar que la reserva esté disponible
        //Reserva reserva = reservaService.

        System.out.println("Operación exitosa");
        return "redirect:/testcliente/reservaCliente";
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
