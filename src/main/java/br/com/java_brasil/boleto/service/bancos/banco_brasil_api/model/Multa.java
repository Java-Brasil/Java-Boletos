package br.com.java_brasil.boleto.service.bancos.banco_brasil_api.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Multa {
    private Integer tipo;
    private String data;
    private BigDecimal porcentagem;
    private BigDecimal valor;
}
