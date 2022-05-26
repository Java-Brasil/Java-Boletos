package br.com.java_brasil.boleto.service.bancos.inter_api.exception;

public class InterApiNaoAutorizadoException extends Exception {

    public InterApiNaoAutorizadoException() {
        super("Autenticação não autorizada, verifique a configuração!");
    }

}
