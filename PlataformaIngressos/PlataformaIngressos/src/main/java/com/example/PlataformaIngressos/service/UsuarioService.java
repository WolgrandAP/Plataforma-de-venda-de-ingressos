package com.example.PlataformaIngressos.service;

import com.example.PlataformaIngressos.model.Evento;
import com.example.PlataformaIngressos.model.Usuario;
import com.example.PlataformaIngressos.repository.EventoRepository;
import com.example.PlataformaIngressos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public String cadastrarUsuario(Usuario usuario) {

        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioExistente.isPresent()) {
            return "Já existe um usuário com este email";
        } else {
            usuarioRepository.save(usuario);
            return "Usuário cadastrado com sucesso.";
        }

    }


    public String login(Usuario usuario) {

        String email = usuario.getEmail();
        String senha = usuario.getSenha();

        Optional<Usuario> user = usuarioRepository.findByEmail(email);

        if (user.isPresent()) {
            Usuario usuarioEncontrado = user.get();

            if (usuarioEncontrado.getEmail().equals(email) && usuarioEncontrado.getSenha().equals(senha)) {
                return "Login bem-sucedido.";
            } else {
                return "Email/Senha incorretas.";
            }
        } else {
            return "Usuário não cadastrado.";
        }

    }


    public String editarPerfil(Long usuarioId, Usuario usuarioAtualizado) {

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (usuarioAtualizado.getNome()!=null) {
            usuario.setNome(usuarioAtualizado.getNome());
        }
        if (usuarioAtualizado.getEmail()!=null) {
            usuario.setEmail(usuarioAtualizado.getEmail());
        }
        if (usuarioAtualizado.getSenha()!=null) {
            usuario.setSenha(usuarioAtualizado.getSenha());
        }

        usuarioRepository.save(usuario);

        return "Perfil atualizado com sucesso";
    }

    public String deletarUsuario(Long usuarioId) {

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(()->new RuntimeException("Usuário não encontrado"));
        usuarioRepository.delete(usuario);
        return "Usuário deletado com sucesso!";
    }

    public List<Evento> listarEventosComprados(Long usuarioId) {

        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(()->new RuntimeException("Usuário não encontrado"));
        return usuario.getEventosComprados();

    }

    public Long buscarIdPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(()->new RuntimeException("Usuário não encontrado"));

        return usuario.getId();

    }


}
