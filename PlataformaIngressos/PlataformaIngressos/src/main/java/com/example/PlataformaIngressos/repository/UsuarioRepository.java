package com.example.PlataformaIngressos.repository;

import com.example.PlataformaIngressos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
