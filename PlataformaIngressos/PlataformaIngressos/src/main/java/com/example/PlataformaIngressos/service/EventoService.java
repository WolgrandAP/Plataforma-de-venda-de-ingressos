package com.example.PlataformaIngressos.service;

import com.example.PlataformaIngressos.model.Evento;
import com.example.PlataformaIngressos.repository.EventoRepository;
import com.example.PlataformaIngressos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    /*public Evento venderIngresso(Long eventoId, Long usuarioId) {
        Evento evento = eventoRepository.findById(eventoId).get();
    }*/

}
