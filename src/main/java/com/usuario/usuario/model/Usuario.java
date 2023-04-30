package com.usuario.usuario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @Column(length = 128)
    private String usroNome;

    @Column(length = 64, unique = true)
    private String usroUsuario;

    @Column(length = 11, unique = true,nullable = false)
    private String usroCpf;

    
    private String usroEmail;
    
    
}
