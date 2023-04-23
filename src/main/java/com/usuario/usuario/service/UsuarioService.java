package com.usuario.usuario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usuario.usuario.model.Usuario;
import com.usuario.usuario.model.dto.UsuarioDTO;


public interface UsuarioService {
    Usuario saveUsuario(UsuarioDTO dto);

    List<Usuario> getAll();



   
    
}
