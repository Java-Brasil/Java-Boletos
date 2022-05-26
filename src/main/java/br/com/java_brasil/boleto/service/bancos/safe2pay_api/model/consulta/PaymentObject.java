/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.java_brasil.boleto.service.bancos.safe2pay_api.model.consulta;


import com.fasterxml.jackson.annotation.JsonAlias;

public class PaymentObject {

    @JsonAlias("BankSlipNumber")
    private String bankSlipNumber;
    @JsonAlias("DueDate")
    private String dueDate;
    @JsonAlias("DigitableLine")
    private String digitableLine;
    @JsonAlias("Barcode")
    private String barcode;
    @JsonAlias("BankSlipUrl")
    private String bankSlipUrl;

    public String getBankSlipNumber() {
        return bankSlipNumber;
    }

    public void setBankSlipNumber(String bankSlipNumber) {
        this.bankSlipNumber = bankSlipNumber;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getDigitableLine() {
        return digitableLine;
    }

    public void setDigitableLine(String digitableLine) {
        this.digitableLine = digitableLine;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBankSlipUrl() {
        return bankSlipUrl;
    }

    public void setBankSlipUrl(String bankSlipUrl) {
        this.bankSlipUrl = bankSlipUrl;
    }

    @Override
    public String toString() {
        return "PaymentObjectConsultaBoleto{" + "bankSlipNumber=" + bankSlipNumber + ", dueDate=" + dueDate + ", digitableLine=" + digitableLine + ", barcode=" + barcode + ", bankSlipUrl=" + bankSlipUrl + '}';
    }

}
