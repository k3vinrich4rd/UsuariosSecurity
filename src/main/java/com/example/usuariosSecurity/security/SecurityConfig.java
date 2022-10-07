package com.example.usuariosSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
    @EnableWebSecurity — Quando utilizamos essa anotação estamos desabilitando as configurações default do (web) security
    considerando as configurações personalizadas feitas
     */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //Trata da parte de Http, não tem nada a ver com autenticação de usuário
    @Override
    protected void configure(HttpSecurity http) throws Exception { // /usuarios — também cadastra
        http.csrf().disable().authorizeRequests().antMatchers("/usuarios/create").
                permitAll().and().httpBasic();
    }


    //Quando utilizamos uma autenticação mocada, ela está salva em memória
    @Override // AuthenticationManagerBuilder - Construtor do Gerenciador de Autenticação
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { //throws - lança
        //autenticação em memória com usuário, senha e papel
        auth.inMemoryAuthentication()
                .withUser("kevin").password(passwordEncoder().encode("1234")).roles("ADMIN").and()
                .withUser("kevin2").password(passwordEncoder().encode("5678")).roles("USER");
    }

    @Bean // Configuração
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

//Mais para testes (Não em produção)
//Se voltar um retorno robusto, é por conta que está sendo em memória
