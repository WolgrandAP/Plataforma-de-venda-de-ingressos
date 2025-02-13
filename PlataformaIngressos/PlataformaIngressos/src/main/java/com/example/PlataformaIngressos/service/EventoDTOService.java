package com.example.PlataformaIngressos.service;

import com.example.PlataformaIngressos.dto.EventoDTO;
import com.example.PlataformaIngressos.repository.EventoDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoDTOService {

    @Autowired
    private EventoDTORepository eventoDTO;

    public List<EventoDTO> listarEvento() {
        return ;
    }

}
