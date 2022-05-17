package br.com.java_brasil.boleto.model;

import br.com.java_brasil.boleto.service.bancos.banco_brasil_api.BancoBrasilAPI;
import br.com.java_brasil.boleto.service.bancos.bradesco_api.BancoBradescoAPI;
import br.com.java_brasil.boleto.service.bancos.exemplo.BancoExemplo;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public enum BoletoBanco {

    EXEMPLO("Exemplo", BancoExemplo.class),
    BRADESCO_API("Bradesco API", BancoBradescoAPI.class),
    BANCO_BRASIL_API("Banco do Brasil API", BancoBrasilAPI.class);

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