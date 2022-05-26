
package br.com.java_brasil.boleto.service.bancos.inter_api.model;

import java.math.BigDecimal;

public class BoletoResponse {

    private String cnpjCpfBeneficiario;
    private String nomeBeneficiario;
    private String tipoPessoaBeneficiario;
    private String contaCorrente;
    private String nossoNumero;
    private String seuNumero;
    private Pagador pagador;
    private String situacao;
    private String dataHoraSituacao;
    private String dataVencimento;
    private BigDecimal valorNominal;
    private BigDecimal valorTotalRecebimento;
    private String dataEmissao;
    private String dataLimite;
    private String codigoEspecie;
    private String codigoBarras;
    private String linhaDigitavel;
    private String origem;
    private Mensagem mensagem;
    private Desconto1 desconto1;
    private Desconto2 desconto2;
    private Desconto3 desconto3;
    private Multa multa;
    private Mora mora;

    public String getCnpjCpfBeneficiario() {
        return cnpjCpfBeneficiario;
    }

    public void setCnpjCpfBeneficiario(String cnpjCpfBeneficiario) {
        this.cnpjCpfBeneficiario = cnpjCpfBeneficiario;
    }

    public String getNomeBeneficiario() {
        return nomeBeneficiario;
    }

    public void setNomeBeneficiario(String nomeBeneficiario) {
        this.nomeBeneficiario = nomeBeneficiario;
    }

    public String getTipoPessoaBeneficiario() {
        return tipoPessoaBeneficiario;
    }

    public void setTipoPessoaBeneficiario(String tipoPessoaBeneficiario) {
        this.tipoPessoaBeneficiario = tipoPessoaBeneficiario;
    }

    public String getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(String contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public String getNossoNumero() {
        return nossoNumero;
    }

    public void setNossoNumero(String nossoNumero) {
        this.nossoNumero = nossoNumero;
    }

    public String getSeuNumero() {
        return seuNumero;
    }

    public void setSeuNumero(String seuNumero) {
        this.seuNumero = seuNumero;
    }

    public Pagador getPagador() {
        return pagador;
    }

    public void setPagador(Pagador pagador) {
        this.pagador = pagador;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDataHoraSituacao() {
        return dataHoraSituacao;
    }

    public void setDataHoraSituacao(String dataHoraSituacao) {
        this.dataHoraSituacao = dataHoraSituacao;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValorNominal() {
        return valorNominal;
    }

    public void setValorNominal(BigDecimal valorNominal) {
        this.valorNominal = valorNominal;
    }

    public BigDecimal getValorTotalRecebimento() {
        return valorTotalRecebimento;
    }

    public void setValorTotalRecebimento(BigDecimal valorTotalRecebimento) {
        this.valorTotalRecebimento = valorTotalRecebimento;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getCodigoEspecie() {
        return codigoEspecie;
    }

    public void setCodigoEspecie(String codigoEspecie) {
        this.codigoEspecie = codigoEspecie;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getLinhaDigitavel() {
        return linhaDigitavel;
    }

    public void setLinhaDigitavel(String linhaDigitavel) {
        this.linhaDigitavel = linhaDigitavel;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
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
}
