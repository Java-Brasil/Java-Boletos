package br.com.java_brasil.boleto.service.bancos.inter_api.model;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponseNovo {

    private List<String> message = new ArrayList<>();

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorResponseNovo{" +
                "message=" + message +
                '}';
    }
}
