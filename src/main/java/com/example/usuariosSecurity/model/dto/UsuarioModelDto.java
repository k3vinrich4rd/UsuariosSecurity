package com.example.usuariosSecurity.model.dto;

import com.example.usuariosSecurity.model.UsuariosModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModelDto {

    private String nome;
    private String login;
    private String senha;

    public UsuarioModelDto(UsuariosModel obj) {
        this.nome = obj.getNome();
        this.login = obj.getLogin();
        this.senha = obj.getSenha();
    }
}
