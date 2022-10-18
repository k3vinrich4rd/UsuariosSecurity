package com.example.usuariosSecurity.model.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponse {

    private String nome;
    private String login;
    private String senha;


}
