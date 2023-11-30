package br.com.desafio.service;

import br.com.desafio.controler.model.input.ProjetoForm;
import br.com.desafio.controler.model.output.ProjetoResponse;
import br.com.desafio.model.Projeto;
import br.com.desafio.repository.PessoaRepository;
import br.com.desafio.repository.ProjetoRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.*;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository repository;

    private final PessoaRepository pessoaRepository;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Transactional
    public void salvar(ProjetoForm form)  throws ParseException {
        Projeto projeto = new Projeto();
        if(form.getId() != null) {
            projeto.setId(Long.parseLong(form.getId()));
        }
        projeto.setNome(form.getNome());
        projeto.setDescricao(form.getDescricao());
        projeto.setRisco(form.getRisco());
        projeto.setStatus(form.getStatus());
        projeto.setPessoa(pessoaRepository.getById(Long.parseLong(form.getIdgerente())));
        projeto.setDataInicio(DateUtils.parseDate(form.getDataInicio(), new String[]{"dd/MM/yyyy"}));
        projeto.setDataPrevisaoFim(DateUtils.parseDate(form.getDataPrevisaoFim(), new String[]{"dd/MM/yyyy"}));
        projeto.setDataFim(DateUtils.parseDate(form.getDataFim(), new String[]{"dd/MM/yyyy"}));
        projeto.setOrcamento(parse(form.getOrcamento(), Locale.US).doubleValue());
        repository.save(projeto);
    }

    public List<Projeto> listarProjeto() {
        return repository.findAll();
    }

    public ProjetoResponse carregaProjeto(Long id) {
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        DecimalFormat dfNumber = new DecimalFormat();
        dfNumber.applyPattern("R$ #,##0.00");

        Projeto projeto = repository.findById(id).get();
        ProjetoResponse projetoResponse = new ProjetoResponse();
        projetoResponse.setNome(projeto.getNome());
        projetoResponse.setId(projeto.getId());
        projetoResponse.setDescricao(projeto.getDescricao());
        projetoResponse.setDataInicio(df.format(projeto.getDataInicio()));
        projetoResponse.setDataPrevisaoFim(df.format(projeto.getDataPrevisaoFim()));
        projetoResponse.setDataFim(df.format(projeto.getDataFim()));
        projetoResponse.setOrcamento(dfNumber.format(projeto.getOrcamento()));
        projetoResponse.setRisco(projeto.getRisco());
        projetoResponse.setStatus(projeto.getStatus());
        projetoResponse.setIdgerente(projeto.getPessoa().getId().toString());
        return projetoResponse;
    }

    public void removeProjeto(Long id) {
        repository.deleteById(id);
    }

    public  static BigDecimal parse(final String amount, final Locale locale) throws ParseException {
        final NumberFormat format = NumberFormat.getNumberInstance(locale);
        if (format instanceof DecimalFormat) {
            ((DecimalFormat) format).setParseBigDecimal(true);
        }
        String real = "";
        for(int i=0 ; i < amount.length(); i++) {
            if(!amount.substring(i , i+1).equals(".")){
                real = real +  amount.substring(i , i+1);
            }
        }
        real = real.replaceAll(",", ".");
        real = real.substring(3,real.length()).trim();
        return (BigDecimal) format.parse(real);
    }

}