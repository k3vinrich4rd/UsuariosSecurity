package com.example.usuariosSecurity.controller;

import com.example.usuariosSecurity.model.UsuariosModel;
import com.example.usuariosSecurity.model.dto.UsuarioModelDto;
import com.example.usuariosSecurity.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuariosController {

    @Autowired
    UsuariosService usuariosService;

    @PostMapping(path = "/create")
    public ResponseEntity<UsuariosModel> cadastrarUsuarios(@RequestBody UsuariosModel usuariosModel) {
        UsuariosModel usuario = usuariosService.cadastrarUsuarios(usuariosModel);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioModelDto>> exibirUsuariosCadastrados() {
        List<UsuariosModel> usuariosModelList = usuariosService.exibirUsuariosCadastrados();
        List<UsuarioModelDto> usuarioModelDtoList = usuariosModelList.stream().map(obj -> new UsuarioModelDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(usuarioModelDtoList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<UsuariosModel>> exibirUsuariosCadastradosViaId(@PathVariable Long id) {
        return ResponseEntity.ok(usuariosService.exibirUsuariosViaId(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UsuariosModel> alterarUsuariosCadastrados(@RequestBody UsuariosModel usuariosModel) {
        return ResponseEntity.ok(usuariosService.alterarUsuariosCadastrados(usuariosModel));
    }

    @DeleteMapping(path = "/{id}")
    public void deletarUsuariosCadastrados(@PathVariable Long id) {
        usuariosService.deletarUsuarios(id);
    }

}

