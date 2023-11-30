package br.com.desafio.controler;

import br.com.desafio.controler.model.input.MembrosRequest;
import br.com.desafio.controler.model.output.MembroResponse;
import br.com.desafio.service.MembrosService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/membros")
public class MembrosController {

	@Autowired
	MembrosService service;

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public MembroResponse cadastrar(@RequestBody final MembrosRequest membrosRequest)  {
		MembroResponse membroResponse = new MembroResponse();
		if(service.verificaFuncionario(membrosRequest.getIdPessoa(), membrosRequest.getIdProjeto())) {
			service.salvar(membrosRequest.getIdPessoa(), membrosRequest.getIdProjeto());
			membroResponse.setMensagem("Registro inserido com sucesso.");
		}else{
			membroResponse.setMensagem("Só é permitido associar funcionários.");
		}
		return membroResponse;
	}
}