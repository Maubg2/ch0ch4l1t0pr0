package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Reserva;
import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.TipoReserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

    @Query("SELECT r FROM Reserva r WHERE r.fkUsuario=?1")
    public List<Reserva> listarReservasUsuario(Long userId);

    //Sólo retorna el tipo de reserva asociado a la reserva en cuestión (No debería haber más de uno)
    @Query("SELECT tr FROM Reserva r JOIN TipoReserva tr ON r.fkTipoReserva = tr.id WHERE r.id =:reservaId")
    public TipoReserva listarTipoReservaReserva(Long reservaId);

}
