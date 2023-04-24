package com.gft.DesafioMVC.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.DesafioMVC.domain.Ingrediente;
import com.gft.DesafioMVC.service.IngredienteService;

@Controller
@RequestMapping("ingredientes")
public class IngredienteController {
	
	@Autowired
	private IngredienteService ingredienteService;
	
	@GetMapping("/u/novo")
	public String abrir(Ingrediente ingrediente) {
		
		return "ingrediente/form";
	}
	
	@PostMapping("/salvar")
	public String salvar(Ingrediente ingrediente, RedirectAttributes attr) {
		ingredienteService.salvarIngrediente(ingrediente);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
		return "redirect:/ingredientes/u/novo";
	}
	
	@GetMapping("/datatables/server")
	public ResponseEntity<?> getIngredientes(HttpServletRequest request) {

		return ResponseEntity.ok(ingredienteService.buscarIngredientes(request));
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("ingrediente", ingredienteService.buscarPorId(id));
		return "ingrediente/form";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		ingredienteService.remover(id);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
		return "redirect:/ingredientes/u/novo";
	}
	
	@GetMapping("/titulo")
	public ResponseEntity<?> getIngredientesPorTermo(@RequestParam("termo") String termo) {
		List<String> ingredientes = ingredienteService.buscarIngredienteByTermo(termo);
		return ResponseEntity.ok(ingredientes);
	}
		
}
