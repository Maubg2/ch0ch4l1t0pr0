package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{

}
