package com.gft.DesafioMVC.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gft.DesafioMVC.domain.Ingrediente;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long>{
	
	@Query("select e from Ingrediente e where e.nome like :search% ")
	Page<Ingrediente> findAllByNome(String search, Pageable pageable);
	
	@Query("select e from Ingrediente e where e.nome like :search%")
	Page<Ingrediente> findAllByTitulo(String search, Pageable pageable);

	@Query("select e.nome from Ingrediente e where e.nome like :termo%")
	List<String> findIngredientesByTermo(String termo);

	@Query("select e from Ingrediente e where e.nome IN :nomes")
	Set<Ingrediente> findByNomes(String[] nomes);

}
