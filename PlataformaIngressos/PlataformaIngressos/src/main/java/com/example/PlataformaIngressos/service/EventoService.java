package com.example.PlataformaIngressos.service;

import com.example.PlataformaIngressos.dto.EventoDTO;
import com.example.PlataformaIngressos.model.Evento;
import com.example.PlataformaIngressos.model.Usuario;
import com.example.PlataformaIngressos.repository.EventoDTORepository;
import com.example.PlataformaIngressos.repository.EventoRepository;
import com.example.PlataformaIngressos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public String adicionarEvento(Evento evento) {

        Optional<Evento> eventoExistente = eventoRepository.findByNome(evento.getNome());

        if (eventoExistente.isPresent()) {
            return "Evento já existente";
        } else {
            eventoRepository.save(evento);
            return "Evento adicionado";
        }
    }

    public Evento buscarNomeDoEvento(String nomeEvento) {
        return eventoRepository.findByNome(nomeEvento).orElseThrow(()->new RuntimeException("Evento não encontrado"));
    }

    public String venderIngresso(Long eventoId, Long usuarioId) {
        Evento evento = eventoRepository.findById(eventoId).orElseThrow(() -> new RuntimeException("Evento não encontrado"));

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (usuario.getEventosComprados().contains(evento)) {
            return "Você já comprou ingressos para este evento.";
        }

        if (evento.getIngressosDisponiveis() > 0) {
            evento.getParticipantes().add(usuario);
            usuario.getEventosComprados().add(evento);
            evento.setIngressosDisponiveis(evento.getIngressosDisponiveis()-1);
            eventoRepository.save(evento);
            usuarioRepository.save(usuario);
            return "Compra realizada com sucesso para o evento: " + evento.getNome();

        } else {
            return "Ingressos esgotados";
        }
    }

    public String cancelarCompra(Long eventoId, Long usuarioId) {
        Evento evento = eventoRepository.findById(eventoId).orElseThrow(() -> new RuntimeException("Evento não encontrado"));

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (usuario.getEventosComprados().contains(evento)) {
            usuario.getEventosComprados().remove(evento);
            evento.setIngressosDisponiveis(evento.getIngressosDisponiveis() + 1);

            eventoRepository.save(evento);
            usuarioRepository.save(usuario);

            return "Compra cancelada com sucesso para o evento: " + evento.getNome();
        } else {
            return "Você não comprou ingresso para este evento";
        }
    }

    public String atualizarEvento(String nomeEvento, Evento eventoAtualizado) {

        Evento evento = eventoRepository.findByNome(nomeEvento).orElseThrow(()->new RuntimeException("Evento não encontrado"));

        evento.setNome(eventoAtualizado.getNome());
        evento.setDescricao(eventoAtualizado.getDescricao());
        evento.setPrecoIngresso(eventoAtualizado.getPrecoIngresso());
        evento.setQuantidadeIngresso(eventoAtualizado.getQuantidadeIngresso());
        evento.setIngressosDisponiveis(eventoAtualizado.getIngressosDisponiveis());

        eventoRepository.save(evento);

        return "Evento atualizado com sucecsso";
    }

}

