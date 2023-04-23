package com.usuario.usuario.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.usuario.usuario.model.Usuario;
import com.usuario.usuario.model.dto.UsuarioDTO;
import com.usuario.usuario.model.dto.UsuarioDTOUpdate;
import com.usuario.usuario.repository.UsuarioRepository;
import com.usuario.usuario.service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {
    
    @Autowired
    UsuarioRepository usuRepo;

    private void validaCpf(String cpf){
        String cpfString = cpf.replaceAll("\\D+", "");
         usuRepo.findByCpf(cpfString).isPresent();
        if(usuRepo.findByCpf(cpfString).isPresent()){
           throw new ResponseStatusException(HttpStatus.CONFLICT,
            "Erro ao Cadastrar ou Atualizar Usuário - CPF já Cadastrado: ");
        }

    }

    @Override
    public Usuario saveUsuario(UsuarioDTO dto) {
        Usuario usu = new Usuario();
       validaCpf(dto.getCpf());
       System.out.println("Aqui é um teste");       

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

    @Override
    public Usuario getById(Long id) {
     return usuRepo.findById(id)
     .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
     "Usuário não encontrado com o ID: " + id));
    
    }

    @Override
    public Usuario updateUsuario(Long id, UsuarioDTOUpdate dto) {

     Usuario usu = usuRepo.findById(id)
     .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
     "Usuário não encontrado com o ID: " + id));

     System.out.println("Entrou aqui no modelo");
        
        usu.setId(id);
        usu.setNome(dto.getNome());
        usu.setUsuario(dto.getUsuario());
        usu.setEmail(dto.getEmail());     

        usuRepo.save(usu);
        return usu;
       
    }

    @Override
    public Usuario getByCpf(String cpf) {
        Usuario usu = usuRepo.findByCpf(cpf)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
        "Usuário não encontrado com o Cpf: " + cpf));
       return usu;
    }
    
}
