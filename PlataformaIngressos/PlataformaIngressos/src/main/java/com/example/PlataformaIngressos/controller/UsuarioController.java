package com.example.PlataformaIngressos.controller;

import com.example.PlataformaIngressos.model.Evento;
import com.example.PlataformaIngressos.model.Usuario;
import com.example.PlataformaIngressos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listarUsuarios")
    public List<Usuario> listarUsuario() {
        return usuarioService.listarUsuarios();
    }

    //TESTE
    @GetMapping("/{nome}")
    public String mostarNome(@PathVariable String nome) {
        return nome;
    }

    @PostMapping("/cadastrarUsuario")
    public String cadastrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        return usuarioService.login(usuario);
    }

    @PutMapping("/editar/{usuarioId}")
    public String editarPerfi(@PathVariable Long usuarioId, @RequestBody Usuario usuarioAtualizado) {
        return usuarioService.editarPerfil(usuarioId, usuarioAtualizado);
    }

    @DeleteMapping("/deletarUsuario/{usuarioId}")
    public String deletarUsuario(@PathVariable Long usuarioId) {
        return usuarioService.deletarUsuario(usuarioId);
    }

    @GetMapping("/listarEventosComprados/{usuarioId}")
    public List<Evento> listarEventosComprados(@PathVariable Long usuarioId) { return usuarioService.listarEventosComprados(usuarioId); }

}
