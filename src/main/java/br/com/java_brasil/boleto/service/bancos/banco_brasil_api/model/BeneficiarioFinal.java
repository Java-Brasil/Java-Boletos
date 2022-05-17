package br.com.java_brasil.boleto.service.bancos.banco_brasil_api.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BeneficiarioFinal {
    private Integer tipoInscricao;
    private Long numeroInscricao;
    private String nome;
}
