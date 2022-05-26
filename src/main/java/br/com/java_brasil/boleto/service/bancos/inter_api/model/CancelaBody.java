package br.com.java_brasil.boleto.service.bancos.inter_api.model;

public class CancelaBody {

//    ACERTOS (cancelado por acertos)
//    APEDIDODOCLIENTE (cancelado a pedido do cliente)
//    DEVOLUCAO (cancelado por devolução)
//    PAGODIRETOAOCLIENTE (cancelado por ter sido pago direto ao cliente)
//    SUBSTITUICAO (cancelado por substituição)

    public CancelaBody() {
        this.motivoCancelamento = "APEDIDODOCLIENTE";
    }

    public CancelaBody(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

    private String motivoCancelamento;

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.motivoCancelamento = motivoCancelamento;
    }

}
