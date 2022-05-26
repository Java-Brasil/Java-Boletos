
package br.com.java_brasil.boleto.service.bancos.inter_api.model;

import java.math.BigDecimal;

public class Desconto2 {

    public Desconto2() {
    }

    public Desconto2(String codigoDesconto, BigDecimal taxa, BigDecimal valor) {
        this.codigoDesconto = codigoDesconto;
        this.taxa = taxa;
        this.valor = valor;
    }

    private String codigo;
    private String codigoDesconto;
    private BigDecimal taxa;
    private BigDecimal valor;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoDesconto() {
        return codigoDesconto;
    }

    public void setCodigoDesconto(String codigoDesconto) {
        this.codigoDesconto = codigoDesconto;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }



}
