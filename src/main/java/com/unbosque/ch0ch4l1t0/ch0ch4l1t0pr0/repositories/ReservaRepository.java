package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Mesa;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Reserva;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Sede;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.TipoReserva;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Usuario;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

    @Query("SELECT r FROM Reserva r WHERE r.fkUsuario=?1")
    public List<Reserva> listarReservasUsuario(Long userId);

    //--------------MÉTODOS PARA OBTENER OBJETOS POR LA FK-----------------

    //Sólo retorna el tipo de reserva asociado a la reserva en cuestión (No debería haber más de uno)
    @Query("SELECT tr FROM Reserva r JOIN TipoReserva tr ON r.fkTipoReserva = tr.id WHERE r.id =:reservaId")
    public TipoReserva listarTipoReservaReserva(Long reservaId);

    //Sólo retorna la sede asociada a la reserva en cuestión
    @Query("SELECT s FROM Reserva r JOIN Sede s ON r.fkSede = s.id WHERE r.id =:reservaId")
    public Sede listarSedeReserva(Long reservaId);

    //Sólo retorna la mesa asociada a la sede en cuestión
    @Query("SELECT m FROM Reserva r JOIN Mesa m ON r.fkMesa = m.id WHERE r.id =:reservaId")
    public Mesa listarMesaReserva(Long reservaId);

    //Sólo retorna el usuario asociado a una reserva
    @Query("SELECT u FROM Reserva r JOIN Usuario u ON r.fkUsuario = u.id WHERE r.id =:reservaId")
    public Usuario listarUsuarioReserva(Long reservaId);

    List<Reserva> findByFkUsuario(Long fkUsuario);

}
