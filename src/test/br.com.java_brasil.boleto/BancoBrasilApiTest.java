package br.com.java_brasil.boleto;

import br.com.java_brasil.boleto.exception.BoletoException;
import br.com.java_brasil.boleto.model.BoletoBanco;
import br.com.java_brasil.boleto.model.BoletoModel;
import br.com.java_brasil.boleto.model.Endereco;
import br.com.java_brasil.boleto.model.Pagador;
import br.com.java_brasil.boleto.model.enums.AmbienteEnum;
import br.com.java_brasil.boleto.service.BoletoService;
import br.com.java_brasil.boleto.service.bancos.banco_brasil_api.ConfiguracaoBancoBrasilAPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class BancoBrasilApiTest {
    private BoletoService boletoService;
    private BoletoBanco boletoBanco;

    @BeforeEach
    public void configuraTeste() {
        ConfiguracaoBancoBrasilAPI configuracao = new ConfiguracaoBancoBrasilAPI();
        configuracao.setClientId("");
        configuracao.setClientSecret("");
        configuracao.setDeveloperKey("");
        configuracao.setAuthorization("");
        configuracao.setAmbiente(AmbienteEnum.HOMOLOGACAO);
        boletoBanco = BoletoBanco.BANCO_BRASIL_API;
        boletoService = new BoletoService(boletoBanco, configuracao);
    }

    @Test
    @DisplayName("Testa Configuracoes")
    void testeConfiguracoes() {
        //Configuracao Sucesso
        ConfiguracaoBancoBrasilAPI configuracao = new ConfiguracaoBancoBrasilAPI();
        configuracao.setClientId("");
        configuracao.setClientSecret("");
        configuracao.setDeveloperKey("");
        configuracao.setAuthorization("");
        configuracao.setAmbiente(AmbienteEnum.HOMOLOGACAO);
        configuracao.verificaConfiguracoes();

        //Configuracao Erro
        configuracao.setClientId(null);
        Throwable exception =
                assertThrows(BoletoException.class, configuracao::verificaConfiguracoes);
        assertEquals("Configuracoes invalidas.", exception.getMessage());
    }

    @Test
    void testaConsumo() {
        final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        logger.setLevel(Level.DEBUG);

        ConfiguracaoBancoBrasilAPI configuracao = new ConfiguracaoBancoBrasilAPI();
        configuracao.setClientId("");
        configuracao.setClientSecret("");
        configuracao.setDeveloperKey("");
        configuracao.setAuthorization("");
        configuracao.setAmbiente(AmbienteEnum.HOMOLOGACAO);

        BoletoService boletoService = new BoletoService(BoletoBanco.BANCO_BRASIL_API, configuracao);
        BoletoModel retorno = boletoService.enviarBoleto(preencheBoleto());

        System.out.println(retorno.getLinhaDigitavel());
        System.out.println(retorno.getCodigoBarras());
    }

    private BoletoModel preencheBoleto() {
        BoletoModel boleto = new BoletoModel();
        boleto.setNumeroConvenio(3128557L);
        boleto.setNumeroCarteira(17);
        boleto.setNumeroVariacaoCarteira(35);
        boleto.setCodigoModalidade(1);
        boleto.setDataVencimento(LocalDate.of(2022, 06, 20));
        boleto.setValorBoleto(BigDecimal.TEN);
        boleto.setCodigoAceite("A");
        boleto.setCodigoTipoTituloCobranca(2);
        boleto.setIndicadorPermissaoRecebimentoParcial("S");
        boleto.setNumeroTituloCliente("00031285579912795299");
        Pagador pagador = new Pagador();
        pagador.setTipoInscricao(1);
        pagador.setNumeroInscricao(97965940132L);
        pagador.setNome("Odorico Paraguassu");
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Avenida Dias Gomes 1970");
        endereco.setCep("77458000");
        endereco.setCidade("Sucupira");
        endereco.setBairro("Centro");
        endereco.setUf("TO");

        pagador.setEndereco(endereco);
        boleto.setPagador(pagador);

        return boleto;
    }
}
