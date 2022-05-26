/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.java_brasil.boleto.service.bancos.safe2pay_api.model.consulta;


import com.fasterxml.jackson.annotation.JsonAlias;

public class BoletoSafe2PayAPIConsultaResponse {

    @JsonAlias("ResponseDetail")
    private ResponseDetail responseDetail;
    @JsonAlias("HasError")
    private Boolean hasError;
    @JsonAlias("Error")
    private String Error;
    @JsonAlias("ErrorCode")
    private String ErrorCode;

    public ResponseDetail getResponseDetail() {
        return responseDetail;
    }

    public void setResponseDetail(ResponseDetail responseDetail) {
        this.responseDetail = responseDetail;
    }

    public Boolean getHasError() {
        return hasError;
    }

    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    @Override
    public String toString() {
        return "ConsultaTransacaoResponse{" + "responseDetail=" + responseDetail + ", hasError=" + hasError + ", Error=" + Error + ", ErrorCode=" + ErrorCode + '}';
    }

}
