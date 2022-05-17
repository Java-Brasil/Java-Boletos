package br.com.java_brasil.boleto.service.bancos.banco_brasil_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoletoBancoBrasilAPIResponse {
    private String numero;
    private Integer numeroCarteira;
    private Integer numeroVariacaoCarteira;
    private Long codigoCliente;
    private String linhaDigitavel;
    private String codigoBarraNumerico;
    private Long numeroContratoCobranca;
    private Beneficiario beneficiario;
    private QrCode qrCode;
}