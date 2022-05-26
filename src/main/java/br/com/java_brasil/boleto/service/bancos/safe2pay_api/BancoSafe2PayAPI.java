package br.com.java_brasil.boleto.service.bancos.safe2pay_api;

import br.com.java_brasil.boleto.exception.BoletoException;
import br.com.java_brasil.boleto.model.BoletoController;
import br.com.java_brasil.boleto.model.BoletoModel;
import br.com.java_brasil.boleto.service.bancos.safe2pay_api.model.cancelamento.BoletoSafe2PayAPICancelarResponse;
import br.com.java_brasil.boleto.service.bancos.safe2pay_api.model.consulta.BoletoSafe2PayAPIConsultaResponse;
import br.com.java_brasil.boleto.service.bancos.safe2pay_api.model.envio.BoletoSafe2PayAPIEnvioResponse;
import br.com.java_brasil.boleto.service.bancos.safe2pay_api.model.envio.Payment;
import br.com.java_brasil.boleto.util.BoletoUtil;
import br.com.java_brasil.boleto.util.RestUtil;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.message.BasicHeader;

import java.io.IOException;

import static org.apache.http.HttpHeaders.*;

/**
 * Classe Generica para servir como base de Implementação
 */
@Slf4j
public class BancoSafe2PayAPI extends BoletoController {

    @Override
    public byte[] imprimirBoleto(@NonNull BoletoModel boletoModel) {
        try {
            String urlPdf = boletoModel.getUrlPdf();
            return BoletoUtil.downloadFile(urlPdf);
        } catch (IOException e) {
            throw new BoletoException(e.getMessage(), e);
        }
    }

    @Override
    public BoletoModel enviarBoleto(@NonNull BoletoModel boletoModel) {
        try {
            BoletoSafe2PayAPIEnvioResponse boletoSafe2PayAPIEnvioResponse = enviar(boletoModel);
            return montaBoletoResponse(boletoModel, boletoSafe2PayAPIEnvioResponse);
        } catch (Exception e) {
            throw new BoletoException(e.getMessage(), e);
        }
    }

    @Override
    public BoletoModel alteraBoleto(@NonNull BoletoModel boletoModel) {
        try {
            BoletoSafe2PayAPICancelarResponse boletoSafe2PayAPICancelarResponse = cancelar(boletoModel);
            return montaBoletoResponse(boletoModel, boletoSafe2PayAPICancelarResponse);
        } catch (Exception e) {
            throw new BoletoException(e.getMessage(), e);
        }
    }

    @Override
    public BoletoModel consultaBoleto(@NonNull BoletoModel boletoModel) {
        try {
            BoletoSafe2PayAPIConsultaResponse boletoSafe2PayAPIConsultaResponse = consultar(boletoModel);
            return montaBoletoResponse(boletoModel, boletoSafe2PayAPIConsultaResponse);
        } catch (Exception e) {
            throw new BoletoException(e.getMessage(), e);
        }
    }

    private BoletoSafe2PayAPICancelarResponse cancelar(BoletoModel boletoModel) throws IOException {
        ConfiguracaoSafge2Pay configuracao = (ConfiguracaoSafge2Pay) this.getConfiguracao();

        String urlBaseTransacao = configuracao.getUrlBaseTransacao();
        String urlCancelamento = configuracao.getUrlCancelamento();
        String token = configuracao.getToken();
        String codRetorno = boletoModel.getCodRetorno();
        String complementoUrl = "?idTransaction=" + codRetorno;

        String request = "DELETE\n" +
                urlCancelamento + "\n" +
                complementoUrl + "\n" +
                token;
        log.debug("Request Cancelamento Safe2Pay: " + request);

        Header[] headers = {
                new BasicHeader(USER_AGENT, "PostmanRuntime/7.26.8"),
                new BasicHeader(CONTENT_TYPE, "application/json"),
                new BasicHeader("x-api-key", token)
        };

        CloseableHttpResponse response1 = RestUtil.del(urlBaseTransacao + urlCancelamento + complementoUrl, headers);
        String retorno = RestUtil.validaResponseERetornaBody(response1);
        log.debug("Retorno Cancelamento Safe2Pay: " + retorno);

        BoletoSafe2PayAPICancelarResponse boletoSafe2PayAPICancelarResponse = RestUtil.JsonToObject(retorno, BoletoSafe2PayAPICancelarResponse.class);
        return boletoSafe2PayAPICancelarResponse;
    }

    private BoletoSafe2PayAPIConsultaResponse consultar(BoletoModel boletoModel) throws IOException {
        ConfiguracaoSafge2Pay configuracao = (ConfiguracaoSafge2Pay) this.getConfiguracao();

        String urlBaseTransacao = configuracao.getUrlBaseTransacao();
        String urlTransacao = configuracao.getUrlTransacao();
        String token = configuracao.getToken();
        String codRetorno = boletoModel.getCodRetorno();
        String complementoUrl = "/Get?Id=" + codRetorno;

        String request = "GET\n" +
                urlTransacao + "\n" +
                complementoUrl + "\n" +
                token;
        log.debug("Request Envio Safe2Pay: " + request);

        Header[] headers = {
                new BasicHeader(USER_AGENT, "PostmanRuntime/7.26.8"),
                new BasicHeader(CONTENT_TYPE, "application/json"),
                new BasicHeader("x-api-key", token)
        };

        CloseableHttpResponse response1 = RestUtil.get(urlBaseTransacao + urlTransacao + complementoUrl, headers);
        String retorno = RestUtil.validaResponseERetornaBody(response1);
        log.debug("Retorno Consulta Safe2Pay: " + retorno);

        BoletoSafe2PayAPIConsultaResponse boletoSafe2PayAPIConsultaResponse = RestUtil.JsonToObject(retorno, BoletoSafe2PayAPIConsultaResponse.class);
        return boletoSafe2PayAPIConsultaResponse;
    }

    private BoletoSafe2PayAPIEnvioResponse enviar(BoletoModel boletoModel) throws IOException {
        ConfiguracaoSafge2Pay configuracao = (ConfiguracaoSafge2Pay) this.getConfiguracao();

        boolean sandbox = configuracao.isSandbox();
        String urlBaseBoleto = configuracao.getUrlBaseBoleto();
        String urlBoleto = configuracao.getUrlBoleto();
        String token = configuracao.getToken();

        Payment payment = new Payment(boletoModel, sandbox);
        String json = RestUtil.ObjectToJson(payment);
        log.debug("Json Envio Safe2Pay: " + json);

        String request = "POST\n" +
                urlBoleto + "\n" +
                json + "\n" +
                token;
        log.debug("Request Envio Safe2Pay: " + request);

        Header[] headers = {
                new BasicHeader(USER_AGENT, "PostmanRuntime/7.26.8"),
                new BasicHeader(CONTENT_TYPE, "application/json"),
                new BasicHeader("x-api-key", token)
        };

        CloseableHttpResponse response = RestUtil.post(urlBaseBoleto + urlBoleto, headers, json);
        String retorno = RestUtil.validaResponseERetornaBody(response);
        log.debug("Retorno Envio Safe2Pay: " + retorno);

        return RestUtil.JsonToObject(retorno, BoletoSafe2PayAPIEnvioResponse.class);
    }

    private BoletoModel montaBoletoResponse(BoletoModel boletoModel, BoletoSafe2PayAPIEnvioResponse response) {
        boletoModel.setCodRetorno(response.getResponseDetail().getIdTransaction());
        boletoModel.setMensagemRetorno(response.getResponseDetail().getMessage());
        boletoModel.setCodigoBarras(response.getResponseDetail().getBarcode());
        boletoModel.setUrlPdf(response.getResponseDetail().getBankSlipUrl());
        return boletoModel;
    }

    private BoletoModel montaBoletoResponse(BoletoModel boletoModel, BoletoSafe2PayAPIConsultaResponse response) {
        boletoModel.setCodRetorno(response.getResponseDetail().getIdTransaction());
        boletoModel.setMensagemRetorno(response.getResponseDetail().getMessage());
        return boletoModel;
    }

    private BoletoModel montaBoletoResponse(BoletoModel boletoModel, BoletoSafe2PayAPICancelarResponse response) {
        if (!response.isHasError()) {
            boletoModel.setMensagemRetorno("Cancelamento Solicitado, consulte em alguns minutos");
        }
        return boletoModel;
    }


}
