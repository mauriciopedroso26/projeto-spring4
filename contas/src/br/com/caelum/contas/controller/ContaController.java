package br.com.caelum.contas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {
	
	@RequestMapping("/form")
	public String formulario() {
		return "formulario";
	}
	
	@RequestMapping("/adicionaConta")
	public String diciona(@Valid Conta conta, BindingResult result) {
		
		if(result.hasErrors()){
			return "formulario";
		}
		
		System.out.println("Conta adicionada é " + conta.getDescricao());
		ContaDAO contaDao = new ContaDAO();
		contaDao.adiciona(conta);
		
		return "conta-adicionada";
	}
	
	@RequestMapping("/listaContas")
	public ModelAndView lista() {
		
		ContaDAO contaDAO = new ContaDAO();
		List<Conta> contas = contaDAO.lista();
		
		ModelAndView mv = new ModelAndView("conta/lista");
		mv.addObject("todasContas", contas);
		
		return mv;
	}
	
	@RequestMapping("/removeConta")
	public String remove(Conta conta) {
		ContaDAO contaDAO = new ContaDAO();
		contaDAO.remove(conta);
		
		return "redirect:listaContas";
	}
	
	@RequestMapping("/pagaConta")
	public void paga(Conta conta, HttpServletResponse response) {
		ContaDAO contaDAO = new ContaDAO();
		contaDAO.paga(conta.getId());
		
		response.setStatus(200);
	}
}