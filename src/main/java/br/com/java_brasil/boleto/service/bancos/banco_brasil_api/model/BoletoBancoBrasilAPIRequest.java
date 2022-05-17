package br.com.java_brasil.boleto.service.bancos.banco_brasil_api.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoletoBancoBrasilAPIRequest {
    private Long numeroConvenio;
    private Integer numeroCarteira;
    private Integer numeroVariacaoCarteira;
    private Integer codigoModalidade;
    private String dataEmissao;
    private String dataVencimento;
    private BigDecimal valorOriginal;
    private BigDecimal valorAbatimento;
    private Integer quantidadeDiasProtesto;
    private Integer quantidadeDiasNegativacao;
    private Integer orgaoNegativador;
    private String indicadorAceiteTituloVencido;
    private Integer numeroDiasLimiteRecebimento;
    private String codigoAceite;
    private Integer codigoTipoTituloCobranca;
    private String descricaoTipoTitulo;
    private String indicadorPermissaoRecebimentoParcial;
    private String numeroTituloBeneficiario;
    private String campoUtilizacaoBeneficiario;
    private String numeroTituloCliente;
    private String mensagemBloquetoOcorrencia;
    private Desconto desconto;
    private SegundoDesconto segundoDesconto;
    private TerceiroDesconto terceiroDesconto;
    private JurosMora jurosMora;
    private Multa multa;
    private Pagador pagador;
    private BeneficiarioFinal beneficiarioFinal;
    private String indicadorPix;
}
