package com.example.PlataformaIngressos.service;

import com.example.PlataformaIngressos.model.Compra;
import com.example.PlataformaIngressos.model.Evento;
import com.example.PlataformaIngressos.model.Usuario;
import com.example.PlataformaIngressos.repository.CompraRepository;
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

    @Autowired
    private CompraRepository compraRepository;

    public String adicionarEvento(Evento evento) {
        if (eventoRepository.findByNome(evento.getNome()).isPresent()) {
            return "Evento já existente";
        }
        eventoRepository.save(evento);
        return "Evento adicionado";
    }

    public List<Evento> listarEventos() {
        return eventoRepository.findAll();
    }

    public Evento buscarNomeDoEvento(String nomeEvento) {
        return eventoRepository.findByNome(nomeEvento)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));
    }

    public String venderIngresso(Long eventoId, Long usuarioId) {
        Evento evento = eventoRepository.findById(eventoId).orElseThrow(() -> new RuntimeException("Evento não encontrado"));

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (evento.getIngressosDisponiveis() > 0) {
            usuario.getEventosComprados().add(evento);

            Compra compra = new Compra();
            compra.setUsuario(usuario);
            compra.setEvento(evento);


            compraRepository.save(compra);

            evento.setIngressosDisponiveis(evento.getIngressosDisponiveis() - 1);
            eventoRepository.save(evento);

            return "Compra realizada com sucesso para o evento: " + evento.getNome();
        } else {
            return "Ingressos esgotados";
        }
    }

    public String cancelarCompra(Long eventoId, Long usuarioId) {
        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Buscar a última compra desse usuário para o evento
        Compra compra = compraRepository.findTopByUsuarioAndEventoOrderByDataCompraDesc(usuario, evento);

        if (compra != null) {
            usuario.getEventosComprados().remove(evento);

            compraRepository.delete(compra);
            evento.setIngressosDisponiveis(evento.getIngressosDisponiveis() + 1);
            eventoRepository.save(evento);

            return "Compra cancelada com sucesso para o evento: " + evento.getNome();
        } else {
            return "Você não tem compras para este evento";
        }
    }

    public String atualizarEvento(String nomeEvento, Evento eventoAtualizado) {
        Evento evento = eventoRepository.findByNome(nomeEvento)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado"));

        evento.setNome(eventoAtualizado.getNome());
        evento.setData(eventoAtualizado.getData());
        evento.setPrecoIngresso(eventoAtualizado.getPrecoIngresso());
        evento.setIngressosDisponiveis(eventoAtualizado.getIngressosDisponiveis());

        eventoRepository.save(evento);
        return "Evento atualizado com sucesso";
    }
}
