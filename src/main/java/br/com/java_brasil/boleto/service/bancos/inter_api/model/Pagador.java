
package br.com.java_brasil.boleto.service.bancos.inter_api.model;

import br.com.java_brasil.boleto.util.BoletoUtil;
import org.apache.commons.lang3.StringUtils;

public class Pagador {

    public Pagador(br.com.java_brasil.boleto.model.Pagador pagador) {
        this.cpfCnpj = pagador.getDocumento();
        this.nome = BoletoUtil.ajustaLimiteCaracter(pagador.getNome(), 100);
        this.email = StringUtils.isNotBlank(pagador.getEmail()) ? pagador.getEmail() : null;
        this.telefone = StringUtils.isNotBlank(pagador.getTelefone()) ? pagador.getTelefone() : null;
        this.cep = pagador.getEndereco().getCep();
        this.numero = BoletoUtil.ajustaLimiteCaracter(pagador.getEndereco().getNumero(), 10);
        this.complemento = StringUtils.isNotBlank(pagador.getEndereco().getComplemento()) ? BoletoUtil.ajustaLimiteCaracter(pagador.getEndereco().getComplemento(), 30) : "NÃO TEM";
        this.bairro = BoletoUtil.ajustaLimiteCaracter(pagador.getEndereco().getBairro(), 60);
        this.cidade = BoletoUtil.ajustaLimiteCaracter(pagador.getEndereco().getCidade(), 60);
        this.uf = pagador.getEndereco().getUf();
        this.endereco = BoletoUtil.ajustaLimiteCaracter(pagador.getEndereco().getLogradouro(), 90);
        this.ddd = StringUtils.isNotBlank(pagador.getDdd()) ? pagador.getDdd() : null;
        this.tipoPessoa = pagador.isClienteCpf() ? "FISICA" : "JURIDICA";
    }

    private String cpfCnpj;
    private String nome;
    private String email;
    private String telefone;
    private String cep;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String endereco;
    private String ddd;
    private String tipoPessoa;

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }



}
