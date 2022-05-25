
package br.com.java_brasil.boleto.service.bancos.inter_api.model;

import java.math.BigDecimal;

public class Multa {

    public Multa() {
    }

    public Multa(String codigoMulta, BigDecimal taxa, BigDecimal valor) {
        this.codigoMulta = codigoMulta;
        this.taxa = taxa;
        this.valor = valor;
    }

    private String codigo;
    private String codigoMulta;
    private BigDecimal taxa;
    private BigDecimal valor;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoMulta() {
        return codigoMulta;
    }

    public void setCodigoMulta(String codigoMulta) {
        this.codigoMulta = codigoMulta;
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
