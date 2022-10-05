package com.example.usuariosSecurity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuariosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_usuario", length = 70, nullable = false)
    private String nome;

    @Column(name = "idade_usuario", length = 8, nullable = false)
    private String idade;

    @Column(name = "telefone_usuario", length = 12, nullable = false)
    private String telefone;

    @Column(name = "login_usuario", length = 70, nullable = false)
    private String login;

    @Column(name = "senha_usuario", length = 70, nullable = false, unique = true)
    private String senha;

}

