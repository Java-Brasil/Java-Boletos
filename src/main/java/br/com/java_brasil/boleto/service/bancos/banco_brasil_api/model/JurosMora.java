package br.com.java_brasil.boleto.service.bancos.banco_brasil_api.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JurosMora {
    private Integer tipo;
    private BigDecimal porcentagem;
    private BigDecimal valor;
}
