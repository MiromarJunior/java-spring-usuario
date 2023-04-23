package com.usuario.usuario.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.usuario.usuario.model.Usuario;
import com.usuario.usuario.model.dto.UsuarioDTO;
import com.usuario.usuario.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuService;

    @GetMapping()
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> usuarios = usuService.getAll();
        return new ResponseEntity<>(usuarios,HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Usuario> saveUsu(@Valid @RequestBody  UsuarioDTO dto){
       Usuario usu = usuService.saveUsuario(dto);
       URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(usu.getId())
        .toUri();
      return  ResponseEntity.created(uri).body(usu);

    }
    
}
