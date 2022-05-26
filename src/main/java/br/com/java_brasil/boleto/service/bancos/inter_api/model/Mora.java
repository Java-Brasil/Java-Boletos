
package br.com.java_brasil.boleto.service.bancos.inter_api.model;

import java.math.BigDecimal;

public class Mora {

    public Mora() {
    }

    public Mora(String codigoMora, BigDecimal taxa, BigDecimal valor) {
        this.codigoMora = codigoMora;
        this.taxa = taxa;
        this.valor = valor;
    }

    private String codigo;
    private String codigoMora;
    private BigDecimal taxa;
    private BigDecimal valor;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoMora() {
        return codigoMora;
    }

    public void setCodigoMora(String codigoMora) {
        this.codigoMora = codigoMora;
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
