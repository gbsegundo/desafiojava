package br.com.desafio.service;

import br.com.desafio.model.Pessoa;
import br.com.desafio.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;

    @Transactional
    public void salvar(Pessoa pessoa, String dataNascimento) throws ParseException {
        if(StringUtils.isNotBlank(dataNascimento)) {
            Date dtNascimento = DateUtils.parseDate(dataNascimento,
                    new String[]{"yyyy-MM-dd"});
            pessoa.setDataNascimento(dtNascimento);
        }
        repository.save(pessoa);
     }

    public List<Pessoa> listarGerente() {
        return repository.listarGerente();
    }
}