package com.gft.DesafioMVC.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gft.DesafioMVC.domain.UsuarioLogado;

public interface UsuarioLogadoRepository extends JpaRepository<UsuarioLogado, Long> {

	@Query("select p from UsuarioLogado p where p.usuario.email like :email")
	Optional<UsuarioLogado> findByUsuarioEmail(String email);
}
