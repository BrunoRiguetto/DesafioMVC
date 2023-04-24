package com.gft.DesafioMVC.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.DesafioMVC.domain.UnidadeMedida;
import com.gft.DesafioMVC.service.UnidadeMedidaService;

@Controller
@RequestMapping("unidadeMedida")
public class UnidadeMedidaController {

	@Autowired
	private UnidadeMedidaService unidadeMedidaService;

	@GetMapping("/u/novo")
	public String abrir(UnidadeMedida unidadeMedida) {
		
		return "unidadeMedida/form";
	}

	@PostMapping("/salvar")
	public String salvar(UnidadeMedida unidadeMedida, RedirectAttributes attr) {
		unidadeMedidaService.salvarUnidadeMedida(unidadeMedida);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
		return "redirect:/unidadeMedida/u/novo";
	}
	
	@GetMapping("/datatables/server")
	public ResponseEntity<?> getUnidadeMedidas(HttpServletRequest request) {

		return ResponseEntity.ok(unidadeMedidaService.buscarUnidadeMedidas(request));
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("unidadeMedida", unidadeMedidaService.buscarPorId(id));
		return "unidadeMedida/form";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		unidadeMedidaService.remover(id);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
		return "redirect:/unidadeMedida/u/novo";
	}	
}
