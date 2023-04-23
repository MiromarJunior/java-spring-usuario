package com.usuario.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuario.usuario.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
    
}
