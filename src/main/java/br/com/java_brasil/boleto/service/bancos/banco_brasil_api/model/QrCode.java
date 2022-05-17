package br.com.java_brasil.boleto.service.bancos.banco_brasil_api.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QrCode {
    private String url;
    private String txId;
    private String emv;
}
