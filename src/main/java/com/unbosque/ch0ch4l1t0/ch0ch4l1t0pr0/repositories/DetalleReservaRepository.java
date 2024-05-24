package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.DetalleReserva;

@Repository
public interface DetalleReservaRepository extends JpaRepository<DetalleReserva, Long>{

    @Query("SELECT d FROM DetalleReserva d WHERE d.fkReserva = :reservaId")
    List<DetalleReserva> findByReservaId(@Param("reservaId") Long reservaId);

}
