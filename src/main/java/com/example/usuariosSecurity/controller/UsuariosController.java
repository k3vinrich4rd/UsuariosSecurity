package com.example.usuariosSecurity.controller;

import com.example.usuariosSecurity.model.UsuarioModel;
import com.example.usuariosSecurity.model.dto.UsuarioRequest;
import com.example.usuariosSecurity.model.dto.UsuarioResponse;
import com.example.usuariosSecurity.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@Valid
@RequestMapping(path = "/usuarios")
public class UsuariosController {

    @Autowired
    UsuariosService usuariosService;

    @PostMapping(path = "/create")
    public ResponseEntity<UsuarioResponse> cadastrarUsuarios(@Valid @RequestBody UsuarioRequest usuarioRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuariosService.cadastrarUsuarios(usuarioRequest));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> exibirUsuariosCadastrados() {
        return ResponseEntity.ok().body(usuariosService.exibirUsuariosCadastrados());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<UsuarioModel>> exibirUsuariosCadastradosViaId(@PathVariable Long id) {
        return ResponseEntity.ok(usuariosService.exibirUsuariosViaId(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UsuarioModel> alterarUsuariosCadastrados(@RequestBody UsuarioModel usuarioModel) {
        return ResponseEntity.ok(usuariosService.alterarUsuariosCadastrados(usuarioModel));
    }

    @DeleteMapping(path = "/{id}")
    public void deletarUsuariosCadastrados(@PathVariable Long id) {
        usuariosService.deletarUsuarios(id);
    }

}

