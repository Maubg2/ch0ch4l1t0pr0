package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Usuario;

public interface UsuarioService {

    public Usuario obtenerPorUsername(String username);

    public Usuario guardarUsuario(Usuario usuario);

    public boolean validarCredenciales(String username, String contrasena);

}
