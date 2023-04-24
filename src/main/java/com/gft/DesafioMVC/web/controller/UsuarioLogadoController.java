package com.gft.DesafioMVC.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gft.DesafioMVC.domain.Usuario;
import com.gft.DesafioMVC.domain.UsuarioLogado;
import com.gft.DesafioMVC.service.UsuarioLogadoService;
import com.gft.DesafioMVC.service.UsuarioService;

@Controller
@RequestMapping("usuarios_logados")
public class UsuarioLogadoController {
	
	@Autowired
	private UsuarioLogadoService service;
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/dados")
	public String cadastrar(UsuarioLogado usuarioLogado, ModelMap model, @AuthenticationPrincipal User user) {
		usuarioLogado = service.buscarPorUsuarioEmail(user.getUsername());
		if (usuarioLogado.hasNotId()) {
			usuarioLogado.setUsuario(new Usuario(user.getUsername()));
		}
		model.addAttribute("usuarioLogado", usuarioLogado);
		return "usuarioLogado/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(UsuarioLogado usuarioLogado, ModelMap model, @AuthenticationPrincipal User user) {
		Usuario u = usuarioService.buscarPorEmail(user.getUsername());
		if (UsuarioService.isSenhaCorreta(usuarioLogado.getUsuario().getSenha(), u.getSenha())) {
			usuarioLogado.setUsuario(u);
			service.salvar(usuarioLogado);
			model.addAttribute("sucesso", "Seus dados foram inseridos com sucesso.");
		} else {
			model.addAttribute("falha", "Sua senha não confere, tente novamente.");
		}
		return "usuarioLogado/cadastro";
	}	
		
	@PostMapping("/editar")
	public String editar(UsuarioLogado usuarioLogado, ModelMap model, @AuthenticationPrincipal User user) {
		Usuario u = usuarioService.buscarPorEmail(user.getUsername());
		if (UsuarioService.isSenhaCorreta(usuarioLogado.getUsuario().getSenha(), u.getSenha())) {
			service.editar(usuarioLogado);
			model.addAttribute("sucesso", "Seus dados foram editados com sucesso.");
		} else {
			model.addAttribute("falha", "Sua senha não confere, tente novamente.");
		}
		return "usuarioLogado/cadastro";
	}	
}