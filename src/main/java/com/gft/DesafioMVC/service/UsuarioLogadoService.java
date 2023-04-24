package com.gft.DesafioMVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gft.DesafioMVC.domain.UsuarioLogado;
import com.gft.DesafioMVC.repository.UsuarioLogadoRepository;

@Service
public class UsuarioLogadoService {

	@Autowired
	private UsuarioLogadoRepository repository;
	
	@Transactional(readOnly = true)
	public UsuarioLogado buscarPorUsuarioEmail(String email) {
		
		return repository.findByUsuarioEmail(email).orElse(new UsuarioLogado());
	}

	@Transactional(readOnly = false)
	public void salvar(UsuarioLogado usuarioLogado) {
		
		repository.save(usuarioLogado);		
	}

	@Transactional(readOnly = false)
	public void editar(UsuarioLogado usuarioLogado) {
		UsuarioLogado ul2 = repository.findById(usuarioLogado.getId()).get();
		ul2.setNome(usuarioLogado.getNome());
		ul2.setDtNascimento(usuarioLogado.getDtNascimento());		
	}
}
