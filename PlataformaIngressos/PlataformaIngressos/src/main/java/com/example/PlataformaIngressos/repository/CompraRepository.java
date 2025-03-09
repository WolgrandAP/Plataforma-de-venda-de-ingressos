package com.example.PlataformaIngressos.repository;

import com.example.PlataformaIngressos.model.Compra;
import com.example.PlataformaIngressos.model.Evento;
import com.example.PlataformaIngressos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    Compra findTopByUsuarioAndEventoOrderByDataCompraDesc(Usuario usuario, Evento evento);

}
