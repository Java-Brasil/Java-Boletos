/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.java_brasil.boleto.service.bancos.safe2pay_api.model.cancelamento;


import com.fasterxml.jackson.annotation.JsonAlias;

/**
 *
 * @author Willian Resplandes
 */
public class BoletoSafe2PayAPICancelarResponse {

    @JsonAlias("ResponseDetail")
    private boolean ResponseDetail;
    @JsonAlias("HasError")
    private boolean HasError;
    @JsonAlias("Error")
    private String Error;

    public boolean isResponseDetail() {
        return ResponseDetail;
    }

    public void setResponseDetail(boolean ResponseDetail) {
        this.ResponseDetail = ResponseDetail;
    }

    public boolean isHasError() {
        return HasError;
    }

    public void setHasError(boolean HasError) {
        this.HasError = HasError;
    }

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }

    @Override
    public String toString() {
        return "Response{" + "ResponseDetail=" + ResponseDetail + ", HasError=" + HasError + ", Error=" + Error + '}';
    }
    
    
}
