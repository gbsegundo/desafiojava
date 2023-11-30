package br.com.desafio.service;

import br.com.desafio.model.Membros;
import br.com.desafio.repository.MembrosRepository;
import br.com.desafio.repository.PessoaRepository;
import br.com.desafio.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MembrosService {

    private final MembrosRepository repository;
    private final PessoaRepository pessoaRepository;
    private final ProjetoRepository projetoRepository;

    @Transactional
    public void salvar(String idPessoa, String idProjeto)  {
        Membros membros = new Membros();
        membros.setIdpessoa(Long.parseLong(idPessoa));
        membros.setIdprojeto(Long.parseLong(idProjeto));
        repository.save(membros);
    }


    public Boolean verificaFuncionario(String idPessoa, String idProjeto)  {
        return pessoaRepository.findById(Long.parseLong(idPessoa)).get().getFuncionario();
    }


}