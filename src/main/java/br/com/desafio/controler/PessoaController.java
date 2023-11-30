package br.com.desafio.controler;

import br.com.desafio.controler.model.input.PessoaRequest;
import br.com.desafio.model.Pessoa;
import br.com.desafio.service.PessoaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/pessoa")
public class PessoaController {

	@Autowired
	PessoaService service;

	private final ObjectMapper objectMapper;

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void cadastrar(@RequestBody final PessoaRequest pessoaRequest) throws ParseException {
		Pessoa pessoa = objectMapper.convertValue(pessoaRequest, Pessoa.class);
		service.salvar(pessoa, pessoaRequest.getDataNascimento());
	}
}