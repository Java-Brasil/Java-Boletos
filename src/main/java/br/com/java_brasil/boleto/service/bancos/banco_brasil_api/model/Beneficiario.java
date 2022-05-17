package br.com.java_brasil.boleto.service.bancos.banco_brasil_api.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Beneficiario {
    private Integer agencia;
    private Long contaCorrente;
    private Integer tipoEndereco;
    private String logradouro;
    private String bairro;
    private String cidade;
    private Integer codigoCidade;
    private String uf;
    private Integer cep;
    private String indicadorComprovacao;
}
