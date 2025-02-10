package com.example.PlataformaIngressos.controller;

import com.example.PlataformaIngressos.model.Evento;
import com.example.PlataformaIngressos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<Evento> listarEventos() {
        return eventoService.listarEventos();
    }

    @PostMapping("/{eventoId}/comprar/{usuarioId}")
    public String venderIngresso(@PathVariable Long eventoId, @PathVariable Long usuarioId) {
        return eventoService.venderIngresso(eventoId, usuarioId);
    }


}
