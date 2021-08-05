package com.inter.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inter.teste.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
