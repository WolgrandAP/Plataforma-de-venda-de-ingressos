package com.example.PlataformaIngressos.repository;

import com.example.PlataformaIngressos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento,Long> {

}
