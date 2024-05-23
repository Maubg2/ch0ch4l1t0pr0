package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Usuario;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<Usuario> obtenerClientes() {
        return repository.obtenerClientes();
    }

    @Override
    public Usuario obtenerPorUsername(String username){
        Optional<Usuario> optionalUsuario = repository.findByUsername(username);
        if(optionalUsuario.isPresent()){
            return optionalUsuario.get();
        }
        return null;
    }

    @Override
    @Transactional
    public Usuario guardarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public boolean validarCredenciales(String username, String contrasena) {
        Optional<Usuario> optionalUsuario = repository.findByUsername(username);
        return optionalUsuario.map(usuario -> usuario.getContrasena().equals(contrasena)).orElse(false);
    }

}
