package br.com.java_brasil.boleto.model;

import br.com.java_brasil.boleto.service.bancos.bradesco_api.BancoBradescoAPI;
import br.com.java_brasil.boleto.service.bancos.exemplo.BancoExemplo;
import br.com.java_brasil.boleto.service.bancos.inter_api.BancoInterAPI;
import br.com.java_brasil.boleto.service.bancos.safe2pay_api.BancoSafe2PayAPI;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public enum BoletoBanco {

    EXEMPLO("Exemplo", BancoExemplo.class),
    BRADESCO_API("Bradesco API", BancoBradescoAPI.class),
    INTER_API("Inter API", BancoInterAPI.class),
    SAFE2PAY_API("Safe2Pay API", BancoSafe2PayAPI.class);

    private final String descricao;
    private final Class<? extends BoletoController> controller;

    BoletoBanco(String descricao,
                Class<? extends BoletoController> controller) {
        this.descricao = descricao;
        this.controller = controller;
    }

    @SneakyThrows
    public BoletoController getController() {
        return controller.getConstructor().newInstance();
    }
}