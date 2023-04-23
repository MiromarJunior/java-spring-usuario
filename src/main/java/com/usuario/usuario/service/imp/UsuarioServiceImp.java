package com.usuario.usuario.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usuario.usuario.model.Usuario;
import com.usuario.usuario.model.dto.UsuarioDTO;
import com.usuario.usuario.repository.UsuarioRepository;
import com.usuario.usuario.service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {
    
    @Autowired
    UsuarioRepository usuRepo;

    @Override
    public Usuario saveUsuario(UsuarioDTO dto) {
        Usuario usu = new Usuario();
        usu.setNome(dto.getNome());
        usu.setUsuario(dto.getUsuario());
        usu.setEmail(dto.getEmail());
        usu.setCpf(dto.getCpf());

        usuRepo.save(usu);
        return usu;
    }

    @Override
    public List<Usuario> getAll() {
       return usuRepo.findAll();       
    }
    
}
