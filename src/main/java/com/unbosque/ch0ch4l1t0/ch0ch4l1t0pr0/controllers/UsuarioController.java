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

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Auditoria;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Usuario;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.AuditoriaService;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services.UsuarioService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired 
    private AuditoriaService auditoriaService;

    private static Usuario currentUser;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("usuario", new Usuario());
        return "login";
    }
    @PostMapping("/login")
    public String validarCredenciales(@ModelAttribute("usuario") Usuario usuario, Model model, HttpSession session){
        Usuario usuarioBD = usuarioService.obtenerPorUsername(usuario.getUsername());
        if(usuarioService.validarCredenciales(usuario.getUsername(), usuario.getContrasena())){
            if(usuarioBD.getFkRol() == 1){
                session.setAttribute("user", usuarioBD);
                auditoriaService.crearAuditoria(new Auditoria("Inicio de sesión cliente", new Date(), "Ninguna", usuarioBD.getId()));
                //System.out.println("currentUser " + currentUser);
                return "redirect:/testcliente/reservaCliente";
            }else{
                auditoriaService.crearAuditoria(new Auditoria("Inicio de sesión admin", new Date(), "Ninguna", usuarioBD.getId()));
                return "redirect:/menuAdmin";
            }
        }else{
        //    auditoriaService.crearAuditoria(new Auditoria("Inicio de sesión fallido", new Date(), "Ninguna", 0L));
            model.addAttribute("mensajeError", "Usuario y/o contraseña incorrectos");
            return "login";
        }
    }

    @GetMapping("/registrar")
    public String registrar(Model model){
        model.addAttribute("usuario", new Usuario());
        return "registrar";
    }
    @PostMapping("/index")
    public String index(@ModelAttribute("usuario") Usuario usuario, Model model){
        try{
            Usuario comprobarUsuario = usuarioService.obtenerPorUsername(usuario.getUsername());
            if(comprobarUsuario == null){
                //auditoriaService.crearAuditoria(new Auditoria("Registro exitoso", new Date(), "Usuario", usuario.getId()));
                usuario.setFkRol(1L);
                usuarioService.guardarUsuario(usuario);
                return "redirect:/login";
            }else{
                //auditoriaService.crearAuditoria(new Auditoria("Registro fallido", new Date(), "Ninguna", usuario.getId()));
                model.addAttribute("mensajeError", "Usuario ya existe");
                return "registrar";
            }
        }catch(Exception e){
            model.addAttribute("error", "Error, intente de nuevo");
            return "registrar";
        }
    }

    @GetMapping("/menu")
    public String menu(){
        return "menu";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    public Usuario getCurrentUser() {
        return currentUser;
    }

}
