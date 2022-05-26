package br.com.java_brasil.boleto.service.bancos.inter_api;

import br.com.java_brasil.boleto.model.Configuracao;
import br.com.java_brasil.boleto.model.enums.AmbienteEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ConfiguracaoInterAPI implements Configuracao {

    @NotEmpty
    private String clientId;
    @NotEmpty
    private String clientSecret;
    @NotEmpty
    private String caminhoCertificado;
    @NotEmpty
    private String senhaCertificado;
    @NotEmpty
    private String urlCobranca = "/cobranca/v2";
    @NotEmpty
    private String urlToken = "/oauth/v2";
    @NotEmpty
    private String urlBaseProducao = "https://cdpj.partners.bancointer.com.br";

    @NotEmpty
    public String getURLBase() {
        return this.urlBaseProducao;
    }

    @Override
    public List<String> camposObrigatoriosBoleto() {
        return Arrays.asList(
                "beneficiario.documento",
                "beneficiario.nossoNumero",
                "pagador.nome",
                "pagador.documento",
                "pagador.endereco.logradouro",
                "pagador.endereco.numero",
                "pagador.endereco.bairro",
                "pagador.endereco.cep",
                "pagador.endereco.cidade",
                "pagador.endereco.uf",
                "descricoes",
                "valorBoleto",
                "dataVencimento",
                "beneficiario",
                "pagador");
    }

}
