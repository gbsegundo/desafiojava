package br.com.desafio.controler;

import br.com.desafio.controler.model.input.ProjetoForm;
import br.com.desafio.service.PessoaService;
import br.com.desafio.service.ProjetoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.text.ParseException;

@RequiredArgsConstructor
@Controller
public class ProjetoController {

	@Autowired
	ProjetoService service;

	@Autowired
	PessoaService pessoaService;

	@RequestMapping(value = "/listarProjeto", method = RequestMethod.GET)
	public String listarProjeto(ModelMap model) {
		model.put("projetos", service.listarProjeto());
    	return "projeto";
	}

	@RequestMapping(value = "/novoProjeto", method = RequestMethod.GET)
	public String novoProjeto(ModelMap model) {
		model.put("gerentes", pessoaService.listarGerente());
		return "novoProjeto";
	}

	@RequestMapping(value = "/salvarProjeto", method = RequestMethod.POST)
	public String salvarProjeto(ProjetoForm form, ModelMap model) throws ParseException {
		service.salvar(form);
		model.put("projetos", service.listarProjeto());
		return "projeto";
	}

	@RequestMapping(value = "/removerProjeto/{id}", method = RequestMethod.GET)
	public String removerProjeto(@PathVariable(value = "id") final Long id, ModelMap model)  {
		service.removeProjeto(id);
		model.put("projetos", service.listarProjeto());
		return "projeto";
	}

	@RequestMapping(value = "/editarProjeto/{id}", method = RequestMethod.GET)
	public String editarProjeto(@PathVariable(value = "id") final Long id, ModelMap model)  {
		model.put("projeto", service.carregaProjeto(id));
		model.put("gerentes", pessoaService.listarGerente());
		return "editarProjeto";
	}
}