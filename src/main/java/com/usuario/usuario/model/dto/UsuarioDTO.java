package com.usuario.usuario.model.dto;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDTO {
    

    @NotBlank(message ="Campo obrigatório")
    @Size(min = 3, max = 128, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String nome;
    
    @NotBlank(message ="Campo obrigatório")
    @Size(min = 3, max = 64, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String usuario;

    @NotBlank(message ="Campo obrigatório")
    @CPF(message = "'${validatedValue}' é inválido.")
    private String cpf;

    @NotBlank(message ="Campo obrigatório")
    @Email(message = "Email inválido")
    private String email;
    
}
