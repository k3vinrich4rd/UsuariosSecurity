package com.example.usuariosSecurity.service;

import com.example.usuariosSecurity.model.UsuariosModel;
import com.example.usuariosSecurity.repository.IUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    IUsuariosRepository iUsuariosRepository;

    //Criptografando a senha do usuário
    //Dentro desta classe tenho o salt usado para a criptografia da senha
    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public UsuariosModel cadastrarUsuarios(UsuariosModel usuariosModel) {
        //Sobrescreve a senha dando um get e passa essa senha na criptografia
        usuariosModel.setSenha(passwordEncoder().encode(usuariosModel.getSenha()));
        return iUsuariosRepository.save(usuariosModel);
    }

    public List<UsuariosModel> exibirUsuariosCadastrados() {
        return iUsuariosRepository.findAll();
    }

    public Optional<UsuariosModel> exibirUsuariosViaId(Long id) {
        return iUsuariosRepository.findById(id);
    }

    public UsuariosModel alterarUsuariosCadastrados(UsuariosModel usuariosModel) {
        return iUsuariosRepository.save(usuariosModel);
    }

    public void deletarUsuarios(Long id) {
        iUsuariosRepository.deleteById(id);
    }
}
