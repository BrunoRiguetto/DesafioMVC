package com.gft.DesafioMVC.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gft.DesafioMVC.domain.Ingrediente;
import com.gft.DesafioMVC.domain.IngredienteReceitaModel;
import com.gft.DesafioMVC.domain.Receita;
import com.gft.DesafioMVC.domain.UnidadeMedida;
import com.gft.DesafioMVC.repository.IngredienteRepository;
import com.gft.DesafioMVC.repository.UnidadeMedidaRepository;
import com.gft.DesafioMVC.service.ReceitaService;

@Controller
@RequestMapping("receitas")
public class ReceitaController {

	@Autowired
	private ReceitaService receitaService;
	
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	@Autowired
	private UnidadeMedidaRepository unidadeMedidaRepository;

	@GetMapping("/u/novo")
	public String abrir(Receita receita) {

		return "receita/form";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/salvar")
	public String salvar(Receita receita, RedirectAttributes attr) {
		receitaService.salvarReceita(receita);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso!");
		return "redirect:/receitas/u/novo";
	}

	@GetMapping("/datatables/server")
	public ResponseEntity<?> getReceitas(HttpServletRequest request) {

		return ResponseEntity.ok(receitaService.buscarReceitas(request));
	}


	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("receita", receitaService.buscarPorId(id));
		return "receita/form";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		receitaService.remover(id);
		attr.addFlashAttribute("sucesso", "Operação realizada com sucesso.");
		return "redirect:/receitas/u/novo";
	}

	@GetMapping("/cadastroIngrediente")
	public String cadastrarIngredientes(@RequestParam("receita") Long id) {

		return "receita/cadastroIngrediente";
	}

	@PostMapping("/cadastroIngrediente")
	public String salvarIngrediente(@ModelAttribute IngredienteReceitaModel model, @RequestParam("receita") Long id) {				
		receitaService.salvarIngredienteReceita(
			model.getReceita(), 
			model.getIngrediente(), 
			model.getUnidadeMedida(),
			model.getQuantidade()
		);
		return ("redirect:/receitas/cadastroIngrediente?receita=" + id);
	}

	@ModelAttribute("selectIngredientes")
	public List<Ingrediente> selectIngredientes() {
		
		List<Ingrediente> ingredientesList = ingredienteRepository.findAll();
		return ingredientesList;
	}
	
	@ModelAttribute("selectUnidadesMedida")
	public List<UnidadeMedida> selectUnidadesMedida() {
		
		List<UnidadeMedida> unidadesMedidaList = unidadeMedidaRepository.findAll();
		return unidadesMedidaList;
	}
}
