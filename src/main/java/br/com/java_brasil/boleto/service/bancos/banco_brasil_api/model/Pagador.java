package br.com.java_brasil.boleto.service.bancos.banco_brasil_api.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pagador {
    private Integer tipoInscricao;
    private Long numeroInscricao;
    private String nome;
    private String endereco;
    private Integer cep;
    private String cidade;
    private String bairro;
    private String uf;
    private String telefone;
}
