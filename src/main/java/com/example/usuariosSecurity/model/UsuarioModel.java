package com.example.usuariosSecurity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuarioModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_usuario", length = 70, nullable = false)
    private String nome;

    @Column(name = "idade_usuario", length = 7, nullable = false)
    private String idade;

    @Column(name = "telefone_usuario", length = 12, nullable = false)
    private String telefone;

    @Column(name = "login_usuario", length = 20, nullable = false, unique = true)
    private String login;

    @Column(name = "senha_usuario", nullable = false)
    private String senha;


}

