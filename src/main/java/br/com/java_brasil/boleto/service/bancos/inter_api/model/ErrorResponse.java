package br.com.java_brasil.boleto.service.bancos.inter_api.model;

public class ErrorResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "message='" + message + '\'' +
                '}';
    }
}
