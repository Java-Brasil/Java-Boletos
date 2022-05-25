package br.com.java_brasil.boleto.service.bancos.inter_api.test;

import br.com.java_brasil.boleto.exception.BoletoException;
import br.com.java_brasil.boleto.model.*;
import br.com.java_brasil.boleto.model.enums.AmbienteEnum;
import br.com.java_brasil.boleto.service.BoletoService;
import br.com.java_brasil.boleto.service.bancos.bradesco_api.ConfiguracaoBradescoAPI;
import br.com.java_brasil.boleto.service.bancos.inter_api.ConfiguracaoInterAPI;
import br.com.java_brasil.boleto.util.ValidaUtils;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class InterApiTest {

    private BoletoService boletoService;

    @BeforeEach
    public void configuraTeste() {
        ConfiguracaoInterAPI configuracao = new ConfiguracaoInterAPI();
        configuracao.setCaminhoCertificado("/smartfull/inter/Certificado-BancoInter-smartfull_sistemas_ltda-Conta-11905352-Senha-123456.jks");
        configuracao.setSenhaCertificado("123456");
        boletoService = new BoletoService(BoletoBanco.INTER_API, configuracao);
    }

    @Test
    @DisplayName("Testa Erro Configuracoes")
    void testaErroConfiguracoes() {
        ConfiguracaoInterAPI configuracao = (ConfiguracaoInterAPI) boletoService.getConfiguracao();
        configuracao.setSenhaCertificado(null);
        Throwable exception = assertThrows(BoletoException.class, () -> ValidaUtils.validaConfiguracao(configuracao));
        assertEquals("Campo senha não pode estar vazio.", exception.getMessage());
    }

    @Test
    @DisplayName("Testa Impressão Boleto")
    void testeImprimirBoleto() {
        // Model Null
        assertThrows(NullPointerException.class, () -> boletoService.imprimirBoleto(null));

        // teste Sucesso (Não implementado)
        Throwable exception =
                assertThrows(BoletoException.class, () -> boletoService.imprimirBoleto(new BoletoModel()));
        assertEquals("Não implementado!", exception.getMessage());

    }

    @Test
    @DisplayName("Testa Valida e Envia Boleto")
    void testaEnvioBoleto() {
        final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        logger.setLevel(Level.DEBUG);
        BoletoModel boletoModel = preencheBoleto();
        ValidaUtils.validaBoletoModel(boletoModel, this.boletoService.getConfiguracao().camposObrigatoriosBoleto());
        BoletoModel retorno = boletoService.enviarBoleto(boletoModel);
        System.out.println(retorno.getCodRetorno() + " - " + retorno.getMensagemRetorno());
        System.out.println(retorno.getCodigoBarras());

        byte[] bytes = boletoService.imprimirBoleto(retorno);
        //FileUtils.writeByteArrayToFile(new File("/inter/boleto-inter-" + retorno.getCodigoBarras() + ".pdf"), bytes);

    }

    private static BoletoModel preencheBoleto() {
        BoletoModel boleto = new BoletoModel();
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setDocumento("29422426000115");
        beneficiario.setNossoNumero("0");
        boleto.setBeneficiario(beneficiario);

        Pagador pagador = new Pagador();
        pagador.setNome("SAMUEL BORGES DE OLIVEIRA");
        pagador.setDocumento("01713390108"); // <- PIX
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Endereco Teste");
        endereco.setNumero("0");
        endereco.setBairro("Centro");
        endereco.setComplemento("Qd 0 Lote 0");
        endereco.setCep("75120683");
        endereco.setCidade("ANAPOLIS");
        endereco.setUf("GO");
        pagador.setEndereco(endereco);
        boleto.setPagador(pagador);

        boleto.setDescricoes(Arrays.asList("Descrição 1", "Descrição 2", "Descrição 3", "Descrição 4", "Descrição 5"));

        boleto.setValorBoleto(BigDecimal.TEN);
        boleto.setDataVencimento(LocalDate.of(2022, 5, 30));

        return boleto;
    }


}
