package com.gft.DesafioMVC.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gft.DesafioMVC.datatables.Datatables;
import com.gft.DesafioMVC.datatables.DatatablesColunas;
import com.gft.DesafioMVC.domain.Ingrediente;
import com.gft.DesafioMVC.repository.IngredienteRepository;

@Service
public class IngredienteService {

	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	@Autowired
	private Datatables datatables;
	
	@Transactional(readOnly = false)
	public void salvarIngrediente(Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
	}

	@Transactional(readOnly = true)
	public Map<String, Object> buscarIngredientes(HttpServletRequest request) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.INGREDIENTES);
		Page<?> page = datatables.getSearch().isEmpty()
				? ingredienteRepository.findAll(datatables.getPageable())
				: ingredienteRepository.findAllByNome(datatables.getSearch(), datatables.getPageable());
		return datatables.getResponse(page);
	}
	
	@Transactional(readOnly = true)
	public Ingrediente buscarPorId(Long id) {
		
		return ingredienteRepository.findById(id).get();
	}

	@Transactional(readOnly = false)
	public void remover(Long id) {
		
		ingredienteRepository.deleteById(id);	
	}
	
	@Transactional(readOnly = true)
	public List<String> buscarIngredienteByTermo(String termo) {
		
		return ingredienteRepository.findIngredientesByTermo(termo);
	}

	@Transactional(readOnly = true)
	public Set<Ingrediente> buscarPorNomes(String[] nomes) {
		
		return ingredienteRepository.findByNomes(nomes);
	}

}
