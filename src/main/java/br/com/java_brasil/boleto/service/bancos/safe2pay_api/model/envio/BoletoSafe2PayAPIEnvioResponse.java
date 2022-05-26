/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.java_brasil.boleto.service.bancos.safe2pay_api.model.envio;

import com.fasterxml.jackson.annotation.JsonAlias;

public class BoletoSafe2PayAPIEnvioResponse {

    @JsonAlias("ResponseDetail")
    private ResponseDetail responseDetail;
    @JsonAlias("HasError")
    private Boolean hasError;
    @JsonAlias("Error")
    private String error;
    @JsonAlias("ErrorCode")
    private String errorCode;

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
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "ResponseBoleto{" + "responseDetail=" + responseDetail + ", hasError=" + hasError + ", error=" + error + ", errorCode=" + errorCode + '}';
    }

}
