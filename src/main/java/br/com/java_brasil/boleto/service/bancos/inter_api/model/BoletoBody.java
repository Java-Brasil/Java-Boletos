
package br.com.java_brasil.boleto.service.bancos.inter_api.model;

import br.com.java_brasil.boleto.model.BoletoModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BoletoBody {

    public BoletoBody(BoletoModel boletoModel) {
        this.pagador = new Pagador(boletoModel.getPagador());
        this.dataEmissao = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.seuNumero = boletoModel.getBeneficiario().getNossoNumero();
        this.dataLimite = "SESSENTA";
        this.dataVencimento = boletoModel.getDataVencimento().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.mensagem = new Mensagem(boletoModel.getDescricoes());
        this.desconto1 = new Desconto1("NAOTEMDESCONTO", new BigDecimal("0"), new BigDecimal("0"));
        this.desconto2 = new Desconto2("NAOTEMDESCONTO", new BigDecimal("0"), new BigDecimal("0"));
        this.desconto3 = new Desconto3("NAOTEMDESCONTO", new BigDecimal("0"), new BigDecimal("0"));
        this.valorNominal = boletoModel.getValorBoleto();
        this.valorAbatimento = new BigDecimal("0");
        this.multa = new Multa("NAOTEMMULTA", new BigDecimal("0"), new BigDecimal("0"));
        this.mora = new Mora("ISENTO", new BigDecimal("0"), new BigDecimal("0"));
        this.cnpjCPFBeneficiario = boletoModel.getBeneficiario().getDocumento();
        this.numDiasAgenda = 60;
    }

    public BoletoBody(Pagador pagador, LocalDate dataEmissao, String seuNumero, String dataLimite, LocalDate dataVencimento,
                      Mensagem mensagem, Desconto1 desconto1, Desconto2 desconto2, Desconto3 desconto3, BigDecimal valorNominal,
                      BigDecimal valorAbatimento, Multa multa, Mora mora, String cnpjCPFBeneficiario, Integer numDiasAgenda) {
        this.pagador = pagador;
        this.dataEmissao = dataEmissao.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.seuNumero = seuNumero;
        this.dataLimite = dataLimite;
        this.dataVencimento = dataVencimento.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.mensagem = mensagem;
        this.desconto1 = desconto1;
        this.desconto2 = desconto2;
        this.desconto3 = desconto3;
        this.valorNominal = valorNominal;
        this.valorAbatimento = valorAbatimento;
        this.multa = multa;
        this.mora = mora;
        this.cnpjCPFBeneficiario = cnpjCPFBeneficiario;
        this.numDiasAgenda = numDiasAgenda;
    }

    private Pagador pagador;
    private String dataEmissao;
    private String seuNumero;
    private String dataLimite;
    private String dataVencimento;
    private Mensagem mensagem;
    private Desconto1 desconto1;
    private Desconto2 desconto2;
    private Desconto3 desconto3;
    private BigDecimal valorNominal;
    private BigDecimal valorAbatimento;
    private Multa multa;
    private Mora mora;
    private String cnpjCPFBeneficiario;
    private Integer numDiasAgenda;

    public Pagador getPagador() {
        return pagador;
    }

    public void setPagador(Pagador pagador) {
        this.pagador = pagador;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getSeuNumero() {
        return seuNumero;
    }

    public void setSeuNumero(String seuNumero) {
        this.seuNumero = seuNumero;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public Desconto1 getDesconto1() {
        return desconto1;
    }

    public void setDesconto1(Desconto1 desconto1) {
        this.desconto1 = desconto1;
    }

    public Desconto2 getDesconto2() {
        return desconto2;
    }

    public void setDesconto2(Desconto2 desconto2) {
        this.desconto2 = desconto2;
    }

    public Desconto3 getDesconto3() {
        return desconto3;
    }

    public void setDesconto3(Desconto3 desconto3) {
        this.desconto3 = desconto3;
    }

    public BigDecimal getValorNominal() {
        return valorNominal;
    }

    public void setValorNominal(BigDecimal valorNominal) {
        this.valorNominal = valorNominal;
    }

    public BigDecimal getValorAbatimento() {
        return valorAbatimento;
    }

    public void setValorAbatimento(BigDecimal valorAbatimento) {
        this.valorAbatimento = valorAbatimento;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    public Mora getMora() {
        return mora;
    }

    public void setMora(Mora mora) {
        this.mora = mora;
    }

    public String getCnpjCPFBeneficiario() {
        return cnpjCPFBeneficiario;
    }

    public void setCnpjCPFBeneficiario(String cnpjCPFBeneficiario) {
        this.cnpjCPFBeneficiario = cnpjCPFBeneficiario;
    }

    public Integer getNumDiasAgenda() {
        return numDiasAgenda;
    }

    public void setNumDiasAgenda(Integer numDiasAgenda) {
        this.numDiasAgenda = numDiasAgenda;
    }


}
