package br.com.desafio;


import br.com.desafio.controler.model.output.ProjetoResponse;
import br.com.desafio.model.Projeto;
import br.com.desafio.service.ProjetoService;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.DecimalFormat;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class ProjetoServiceTests {

    @Mock
    private ProjetoService service;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    private static EasyRandom easyRandom;

    @BeforeAll
    public static void beforeTests(){
        easyRandom = new EasyRandom();
    }

    @Test
    public void listarProjeto(){
        List<Projeto> expectedList = easyRandom.nextObject(List.class);
        Mockito.when(service.listarProjeto()).thenReturn(expectedList);
        List<Projeto> list = service.listarProjeto();

        Assertions.assertTrue(list.isEmpty());
     }

    @Test
    public void carregaProjeto(){
        ProjetoResponse expectedProjeto = easyRandom.nextObject(ProjetoResponse.class);
        Mockito.when(service.carregaProjeto(ArgumentMatchers.any())).thenReturn(expectedProjeto);
        ProjetoResponse projeto = service.carregaProjeto(ArgumentMatchers.any());

        Assertions.assertNotNull(projeto);
        Assertions.assertEquals(projeto.getId(), expectedProjeto.getId());
    }


}
