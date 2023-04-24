package com.gft.DesafioMVC.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gft.DesafioMVC.datatables.Datatables;
import com.gft.DesafioMVC.datatables.DatatablesColunas;
import com.gft.DesafioMVC.domain.Ingrediente;
import com.gft.DesafioMVC.domain.Receita;
import com.gft.DesafioMVC.domain.ReceitaIngrediente;
import com.gft.DesafioMVC.domain.UnidadeMedida;
import com.gft.DesafioMVC.repository.ReceitaRepository;

@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository receitaRepository;
	
	@Autowired
	private Datatables datatables;
	
	@Transactional(readOnly = false)
	public void salvarReceita(Receita receita) {
		receitaRepository.save(receita);
	}

	@Transactional(readOnly = true)
	public Map<String, Object> buscarReceitas(HttpServletRequest request) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.RECEITAS);
		Page<?> page = datatables.getSearch().isEmpty()
				? receitaRepository.findAll(datatables.getPageable())
				: receitaRepository.findAllByNome(datatables.getSearch(), datatables.getPageable());
		return datatables.getResponse(page);
	}
	
	@Transactional(readOnly = true)
	public Receita buscarPorId(Long id) {
		
		return receitaRepository.findById(id).get();
	}

	@Transactional(readOnly = false)
	public void remover(Long id) {
		
		receitaRepository.deleteById(id);	
	}
	
	public void salvarIngredienteReceita(Long receitaId, Long ingredienteId, Long unidadeMedidaId, Double qtd) {
		Receita receita = receitaRepository.findById(receitaId).get();
		
		UnidadeMedida unidadeMedida = new UnidadeMedida();
		unidadeMedida.setId(unidadeMedidaId);
		
		Ingrediente ingrediente = new Ingrediente();
		ingrediente.setId(ingredienteId);
		
		ReceitaIngrediente receitaIngrediente = new ReceitaIngrediente();
		receitaIngrediente.setIngrediente(ingrediente);
		receitaIngrediente.setUnidadeMedida(unidadeMedida);
		receitaIngrediente.setReceita(receita);
		receitaIngrediente.setQuantidade(qtd);
		
		receita.getReceitaTemIngrediente().add(receitaIngrediente);
		
		receitaRepository.save(receita);						
	}	
}
