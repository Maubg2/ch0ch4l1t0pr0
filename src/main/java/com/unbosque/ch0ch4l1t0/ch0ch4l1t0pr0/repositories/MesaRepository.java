package com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unbosque.ch0ch4l1t0.ch0ch4l1t0pr0.entities.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long>{

    @Query("SELECT m FROM Mesa m WHERE m.fkSede=?1")
    List<Mesa> mesasPorSedeId(Long sedeId);

}
