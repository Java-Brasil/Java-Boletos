package br.com.java_brasil.boleto.service.bancos.inter_api.test;

import br.com.java_brasil.boleto.model.*;
import br.com.java_brasil.boleto.service.BoletoService;
import br.com.java_brasil.boleto.service.bancos.inter_api.ConfiguracaoInterAPI;
import br.com.java_brasil.boleto.util.ValidaUtils;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.apache.commons.io.FileUtils;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class Test {

    private BoletoService boletoService;

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

    public static void main(String[] args) throws IOException, InterruptedException {
        ConfiguracaoInterAPI configuracao = new ConfiguracaoInterAPI();
        configuracao.setCaminhoCertificado("/inter/Certificado-BancoInter-smartfull_sistemas_ltda.jks");
        configuracao.setSenhaCertificado(FileUtils.readFileToString(new File("/inter/senha.txt")));
        configuracao.setClientId(FileUtils.readFileToString(new File("/inter/clientid.txt")));
        configuracao.setClientSecret(FileUtils.readFileToString(new File("/inter/clientsecret.txt")));
        BoletoService boletoService = new BoletoService(BoletoBanco.INTER_API, configuracao);

        final Logger logger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        logger.setLevel(Level.DEBUG);

        BoletoModel boletoModel = preencheBoleto();
        ValidaUtils.validaBoletoModel(boletoModel, boletoService.getConfiguracao().camposObrigatoriosBoleto());

        BoletoModel retorno = boletoService.enviarBoleto(boletoModel);
        System.out.println(retorno.getCodRetorno());
        System.out.println(retorno.getCodigoBarras());

        byte[] imprimirBoleto = boletoService.imprimirBoleto(retorno);
        FileUtils.writeByteArrayToFile(new File("/inter/boleto-inter-" + retorno.getCodigoBarras() + ".pdf"), imprimirBoleto);

        retorno = boletoService.consultaBoleto(retorno);
        System.out.println(retorno.getCodRetorno() + " - " + retorno.getMensagemRetorno());
        System.out.println(retorno.getCodigoBarras());

        retorno = boletoService.alteraBoleto(retorno);
        System.out.println(retorno.getCodRetorno() + " - " + retorno.getMensagemRetorno());
        System.out.println(retorno.getCodigoBarras());

        Thread.sleep(30000);

        retorno = boletoService.consultaBoleto(retorno);
        System.out.println(retorno.getCodRetorno() + " - " + retorno.getMensagemRetorno());
        System.out.println(retorno.getCodigoBarras());


    }


}
