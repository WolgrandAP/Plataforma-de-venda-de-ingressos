package com.example.PlataformaIngressos.service;

import com.example.PlataformaIngressos.model.Usuario;
import com.example.PlataformaIngressos.repository.EventoRepository;
import com.example.PlataformaIngressos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public String cadastrarUsuario(Usuario usuario) {

        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());

        if (usuarioExistente.isPresent()) {
            return "Já existe um usuário com este email";
        } else {
            usuarioRepository.save(usuario);
            return "Usuário cadastrado com sucecsso.";
        }

    }


    public String login(String email, String senha) {

        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (usuario.getSenha().equals(senha)) {
            return "Login bem-sucedido para o usuário: " + usuario.getNome();
        } else {
            return "Senha incorreta";
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

    public String deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()->new RuntimeException("Usuário não encontrado"));
        usuarioRepository.delete(usuario);
        return "Usuário deletado com sucesso!";
    }


}
