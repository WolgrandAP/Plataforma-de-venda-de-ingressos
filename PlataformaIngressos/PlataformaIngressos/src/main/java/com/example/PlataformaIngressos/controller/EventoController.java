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

    @GetMapping("listarEventos")
    public List<Evento> listarEventos() {
        return eventoService.listarEventos();
    }

    @GetMapping("/{nomeEvento}")
    public Evento buscarNomeDoEvento(@PathVariable String nomeEvento) {
        return eventoService.buscarNomeDoEvento(nomeEvento);
    }

    @PostMapping("/{eventoId}/comprar/{usuarioId}")
    public String venderIngresso(@PathVariable Long eventoId, @PathVariable Long usuarioId) {
        return eventoService.venderIngresso(eventoId, usuarioId);
    }

    @DeleteMapping("/{eventoId}/cancelar/{usuarioId}")
    public String cancelarCompra(Long eventoId, Long usuarioId) {
        return eventoService.cancelarCompra(eventoId,usuarioId);
    }

    @PostMapping
    public String atualizarEvento(String nomeEvento, @RequestBody Evento eventoAtualizado) {
        return eventoService.atualizarEvento(nomeEvento, eventoAtualizado);
    }


}
