package com.example.usuariosSecurity.repository;

import com.example.usuariosSecurity.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuariosRepository extends JpaRepository<UsuarioModel, Long> {
}
