package com.example.usuariosSecurity.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class UsuarioRequest {


    @NotBlank(message = "Erro: o campo 'nome' não foi informado")
    private String nome;

    @NotBlank(message = "Erro: o campo 'idade' não foi informado")
    @Length(max = 7, message = "Erro, o campo 'idade' deve conter no maximo 7 digitos")
    @Length(min = 2, message = "Erro, o campo 'idade' deve conter no minimo 2 digitos")
    private String idade;

    @NotBlank(message = "Erro: o campo 'telefone' não foi informado")
    @Length(max = 12, message = "Erro, o campo 'telefone' deve conter no maximo 12 digitos")
    @Length(min = 9, message = "Erro, o campo 'telefone' deve conter no minimo 9 digitos")
    private String telefone;

    @NotBlank(message = "Erro: o campo 'login' não foi informado")
    @Length(max = 20, message = "Erro, o campo 'login' deve conter no maximo 20 digitos")
    @Length(min = 5, message = "Erro, o campo 'login' deve conter no minimo 5 digitos")
    private String login;

    @NotBlank(message = "Erro: o campo 'senha' não foi informado")
    @Length(max = 10, message = "Erro, o campo 'senha' deve conter no maximo 10 digitos")
    @Length(min = 5, message = "Erro, o campo 'senha' deve conter no minimo 5 digitos")
    private String senha;


}
