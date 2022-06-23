package br.com.java_brasil.boleto.service.bancos.safe2pay_api;

import br.com.java_brasil.boleto.model.*;
import br.com.java_brasil.boleto.service.BoletoService;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteSafe2Pay {

    private static BoletoService boletoService;

    public static void configuraTeste() throws IOException {
        Logger rootLog = Logger.getLogger("");
        rootLog.setLevel( Level.CONFIG );
        rootLog.getHandlers()[0].setLevel( Level.CONFIG );

        ConfiguracaoSafe2PayAPI configuracao = new ConfiguracaoSafe2PayAPI();
        configuracao.setSandbox(false);
        configuracao.setToken(FileUtils.readFileToString(new File("/safe2pay/token.txt")));
        boletoService = new BoletoService(BoletoBanco.SAFE2PAY_API, configuracao);
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

        boleto.setDescricoes(Arrays.asList(new InformacaoModel("Descrição 1"), new InformacaoModel("Descrição 2"), new InformacaoModel("Descrição 3"), new InformacaoModel("Descrição 4"), new InformacaoModel("Descrição 5")));

        boleto.setValorBoleto(BigDecimal.TEN);
        boleto.setDataVencimento(LocalDate.of(2022, 12, 30));

        return boleto;
    }

    public static void testaEnviaBoleto() throws IOException {
        configuraTeste();
        BoletoModel boletoModel = preencheBoleto();
        BoletoModel boletoResponse = boletoService.enviarBoleto(boletoModel);
        System.out.println(boletoResponse.getUrlPdf());
        byte[] bytes = boletoService.imprimirBoletoBanco(boletoModel);
        FileUtils.writeByteArrayToFile(new File("/safe2pay/boleto-safe2pay-" + boletoResponse.getCodigoBarras() + ".pdf"), bytes);

    }


    public static void main(String[] args) throws IOException {
        testaEnviaBoleto();
    }



}
