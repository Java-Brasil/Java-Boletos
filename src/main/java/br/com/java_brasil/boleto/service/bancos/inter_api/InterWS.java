package br.com.java_brasil.boleto.service.bancos.inter_api;

import br.com.java_brasil.boleto.service.bancos.inter_api.model.*;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface InterWS {

    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    @RequestLine("POST /token")
    TokenResponse tokenPost(@Param("client_id") String client_id, @Param("client_secret") String client_secret, @Param("grant_type") String grant_type, @Param("scope") String scope);

    @Headers({"Authorization: Bearer {token}", "Content-Type: application/json"})
    @RequestLine("GET /boletos/{nossoNumero}")
    BoletoResponse boletoGet(@Param("token") String token, @Param("nossoNumero") String nossoNumero);

    @Headers({"Authorization: Bearer {token}", "Content-Type: application/json"})
    @RequestLine("GET /boletos/{nossoNumero}/pdf")
    PdfBase64GetResponse pdfBase64Get(@Param("token") String token, @Param("nossoNumero") String nossoNumero);

    @Headers({"Authorization: Bearer {token}", "Content-Type: application/json"})
    @RequestLine("POST /boletos")
    BoletoResponse boletoPost(@Param("token") String token, BoletoBody boletoBody);

    @Headers({"Authorization: Bearer {token}", "Content-Type: application/json"})
    @RequestLine("GET /boletos/{nossoNumero}/cancelar")
    void cancelarPost(@Param("token") String token, @Param("nossoNumero") String nossoNumero, CancelaBody cancelaBody);

}
