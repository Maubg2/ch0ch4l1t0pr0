package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Usuario;

import java.util.List;
import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Optional<Usuario> findByUsername(String username);

    @Query("SELECT u FROM Usuario u WHERE u.fkRol=1")
    List<Usuario> obtenerClientes();

}
