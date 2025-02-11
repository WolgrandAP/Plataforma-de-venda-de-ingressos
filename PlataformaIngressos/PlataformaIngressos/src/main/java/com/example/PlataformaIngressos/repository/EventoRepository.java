package com.example.PlataformaIngressos.repository;

import com.example.PlataformaIngressos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventoRepository extends JpaRepository<Evento,Long> {

    Optional<Evento> findByNome(String nome);

}
