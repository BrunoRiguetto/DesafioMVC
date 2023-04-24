package com.gft.DesafioMVC.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gft.DesafioMVC.domain.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long>{
	
	@Query("select e from Receita e where e.nome like :search% ")
	Page<Receita> findAllByNome(String search, Pageable pageable);
}
