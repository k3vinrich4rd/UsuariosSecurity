package com.example.usuariosSecurity.service;

import com.example.usuariosSecurity.model.UsuariosModel;
import com.example.usuariosSecurity.model.dto.UsuarioRequest;
import com.example.usuariosSecurity.model.dto.UsuarioResponse;
import com.example.usuariosSecurity.repository.IUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuariosService {

    @Autowired
    IUsuariosRepository iUsuariosRepository;

    //Criptografando a senha do usuário
    //Dentro desta classe tenho o salt usado para a criptografia da senha
    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //O que está dentro do parentes o que eu vou informar, e o que está dentro o que eu vou receber
    public UsuarioResponse cadastrarUsuarios(UsuarioRequest usuarioRequest) {
        //Sobrescreve a senha dando um get e passa essa senha na criptografia
        usuarioRequest.setSenha(passwordEncoder().encode(usuarioRequest.getSenha()));
        UsuariosModel usuariosModel = new UsuariosModel(null,
                usuarioRequest.getNome(),
                usuarioRequest.getIdade(),
                usuarioRequest.getTelefone(),
                usuarioRequest.getLogin(),
                usuarioRequest.getSenha());
        iUsuariosRepository.save(usuariosModel);

        return new UsuarioResponse(usuarioRequest.getNome(),
                usuarioRequest.getLogin(),
                usuarioRequest.getSenha());
    }

    public List<UsuarioResponse> exibirUsuariosCadastrados() {
        List<UsuariosModel> usuariosModelList = iUsuariosRepository.findAll();
        return usuariosModelList.stream().map(obj -> new UsuarioResponse(obj.getNome()
                ,obj.getLogin(),obj.getSenha())).collect(Collectors.toList());
        //stream — mapeando o fluxo no banco de dados e pegando os dados pré definidos na classe response
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
