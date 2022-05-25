package br.com.java_brasil.boleto.service.bancos.inter_api.exception;

import br.com.java_brasil.boleto.service.bancos.inter_api.model.ErrorResponse;
import br.com.java_brasil.boleto.service.bancos.inter_api.model.ErrorResponseNovo;

public class InterApiException extends Exception {

    public InterApiException(String texto) {
        super(texto);
    }

    private ErrorResponse errorResponse;

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    private ErrorResponseNovo errorResponseNovo;

    public ErrorResponseNovo getErrorResponseNovo() {
        return errorResponseNovo;
    }

    public void setErrorResponseNovo(ErrorResponseNovo errorResponseNovo) {
        this.errorResponseNovo = errorResponseNovo;
    }
}
