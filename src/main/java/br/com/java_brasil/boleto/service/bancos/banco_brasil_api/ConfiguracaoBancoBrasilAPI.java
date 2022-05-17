package br.com.java_brasil.boleto.service.bancos.banco_brasil_api;

import br.com.java_brasil.boleto.model.Configuracao;
import br.com.java_brasil.boleto.model.enums.AmbienteEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ConfiguracaoBancoBrasilAPI implements Configuracao {

    @NotEmpty
    private String clientId;
    @NotEmpty
    private String clientSecret;
    @NotEmpty
    private String developerKey;
    @NotEmpty
    private String authorization;
    @NotEmpty
    private AmbienteEnum ambiente;
    @NotEmpty
    private String urlRegistroBoleto = "/boletos?gw-dev-app-key=";
    @NotEmpty
    private String urlTokenProducao = "https://oauth.bb.com.br/oauth/token";
    @NotEmpty
    private String urlTokenHomologacao = "https://oauth.hm.bb.com.br/oauth/token";
    @NotEmpty
    private String urlBaseProducao = "https://api.bb.com.br/cobrancas/v2";
    @NotEmpty
    private String urlBaseHomologacao = "https://api.hm.bb.com.br/cobrancas/v2";

    @Override
    public List<String> camposObrigatoriosBoleto() {
        return Arrays.asList(
                "numeroConvenio",
                "numeroCarteira",
                "numeroVariacaoCarteira",
                "codigoModalidade",
                "dataVencimento",
                "valorOriginal",
                "codigoAceite",
                "codigoTipoTitulo",
                "indicadorPermissaoRecebimentoParcial",
                "numeroTituloCliente",
                "pagador.tipoInscricao",
                "pagador.numeroInscricao",
                "pagador.nome",
                "pagador.endereco.logradouro",
                "pagador.endereco.bairro",
                "pagador.endereco.cidade",
                "pagador.endereco.cep",
                "pagador.endereco.uf",
                "pagador");
    }

    public String getURLBase() {
        return this.ambiente.equals(AmbienteEnum.PRODUCAO) ? this.urlBaseProducao : this.urlBaseHomologacao;
    }

    public String getURLToken() {
        return this.ambiente.equals(AmbienteEnum.PRODUCAO) ? this.urlTokenProducao : this.urlTokenHomologacao;
    }
}
