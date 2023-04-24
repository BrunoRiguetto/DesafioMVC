package com.gft.DesafioMVC.web.conversor;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.gft.DesafioMVC.domain.Ingrediente;
import com.gft.DesafioMVC.service.IngredienteService;

@Component
public class IngredientesConverter implements Converter<String[], Set<Ingrediente>> {

	@Autowired
	private IngredienteService service;

	@Override
	public Set<Ingrediente> convert(String[] nomes) {
		
		Set<Ingrediente> ingredientes = new HashSet<>();
		if (nomes != null && nomes.length > 0) {
			ingredientes.addAll(service.buscarPorNomes(nomes));			
		}
		return ingredientes;
	}
}
