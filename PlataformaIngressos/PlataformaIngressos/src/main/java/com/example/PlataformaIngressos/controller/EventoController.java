package com.example.PlataformaIngressos.controller;

import com.example.PlataformaIngressos.model.Evento;
import com.example.PlataformaIngressos.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping("/adicionar")
    public String adicionarEvento(@RequestBody Evento evento) {
        return eventoService.adicionarEvento(evento);
    }

    @GetMapping("/listarEventos")
    public List<Evento> listarEventos() {
        return eventoService.listarEventos();
    }

    @GetMapping("/buscarNome/{nomeEvento}")
    public Evento buscarNomeDoEvento(@PathVariable String nomeEvento) {
        return eventoService.buscarNomeDoEvento(nomeEvento);
    }

    @PostMapping("/vender/{eventoId}/comprar/{usuarioId}")
    public String venderIngresso(@PathVariable Long eventoId, @PathVariable Long usuarioId) {
        return eventoService.venderIngresso(eventoId, usuarioId);
    }

    @DeleteMapping("/cancelarCompra/{eventoId}/cancelar/{usuarioId}")
    public String cancelarCompra(@PathVariable Long eventoId, @PathVariable Long usuarioId) {
        return eventoService.cancelarCompra(eventoId,usuarioId);
    }

    @PutMapping("/atualizarEvento/{nomeEvento}")
    public String atualizarEvento(@PathVariable String nomeEvento, @RequestBody Evento eventoAtualizado) {
        return eventoService.atualizarEvento(nomeEvento, eventoAtualizado);
    }


}
