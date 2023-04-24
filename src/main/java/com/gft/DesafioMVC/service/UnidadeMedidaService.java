package com.gft.DesafioMVC.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gft.DesafioMVC.datatables.Datatables;
import com.gft.DesafioMVC.datatables.DatatablesColunas;
import com.gft.DesafioMVC.domain.UnidadeMedida;
import com.gft.DesafioMVC.repository.UnidadeMedidaRepository;

@Service
public class UnidadeMedidaService {

	@Autowired
	private UnidadeMedidaRepository unidadeMedidaRepository;
	
	@Autowired
	private Datatables datatables;

	@Transactional(readOnly = false)
	public void salvarUnidadeMedida(UnidadeMedida unidadeMedida) {
		 unidadeMedidaRepository.save(unidadeMedida);
	}

	@Transactional(readOnly = true)
	public Map<String, Object> buscarUnidadeMedidas(HttpServletRequest request) {
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.UNIDADEMEDIDA);
		Page<?> page = datatables.getSearch().isEmpty()
				? unidadeMedidaRepository.findAll(datatables.getPageable())
				: unidadeMedidaRepository.findAllByNome(datatables.getSearch(), datatables.getPageable());
		return datatables.getResponse(page);
	}

	@Transactional(readOnly = true)
	public UnidadeMedida buscarPorId(Long id) {
		
		return unidadeMedidaRepository.findById(id).get();
	}

	@Transactional(readOnly = false)
	public void remover(Long id) {
		
		unidadeMedidaRepository.deleteById(id);	
	}
}
