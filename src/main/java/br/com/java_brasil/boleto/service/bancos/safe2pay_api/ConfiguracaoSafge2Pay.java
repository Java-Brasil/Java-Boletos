package br.com.java_brasil.boleto.service.bancos.safe2pay_api;

import br.com.java_brasil.boleto.model.Configuracao;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ConfiguracaoSafge2Pay implements Configuracao {

    @NotEmpty
    private String token;
    @NotEmpty
    private String urlBaseBoleto = "https://payment.safe2pay.com.br";
    @NotEmpty
    private String urlBaseTransacao = "https://api.safe2pay.com.br";
    @NotEmpty
    private String urlBoleto = "/v2/Payment";
    @NotEmpty
    private String urlTransacao = "/v2/transaction";
    @NotEmpty
    private String urlCancelamento = "/v2/BankSlip/WriteOffBankSlip";
    @NotNull
    private boolean sandbox;

    @Override
    public List<String> camposObrigatoriosBoleto() {
        return new ArrayList<>();
    }
}
