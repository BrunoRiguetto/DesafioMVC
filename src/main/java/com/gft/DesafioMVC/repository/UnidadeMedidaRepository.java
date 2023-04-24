package com.gft.DesafioMVC.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gft.DesafioMVC.domain.UnidadeMedida;

@Repository
public interface UnidadeMedidaRepository extends JpaRepository<UnidadeMedida, Long>{

	@Query("select e from UnidadeMedida e where e.nome like :search% ")
	Page<UnidadeMedida> findAllByNome(String search, Pageable pageable);
}
