/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.java_brasil.boleto.service.bancos.safe2pay_api.model.envio;

import br.com.java_brasil.boleto.model.BoletoModel;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
    @JsonAlias("Instruction")
    private String instruction;
    @JsonAlias("Message")
    private List<String> message = new ArrayList<>();
    @JsonAlias("PenaltyRate")
    private Float penaltyRate;
    @JsonAlias("InterestRate")
    private Float interestRate;
    @JsonAlias("CancelAfterDue")
    private Boolean cancelAfterDue;
    @JsonAlias("IsEnablePartialPayment")
    private Boolean isEnablePartialPayment;
    @JsonAlias("DiscountType")
    private String discountType;
    @JsonAlias("DiscountAmount")
    private Integer discountAmount;
    @JsonAlias("DiscountDue")
    private String discountDue;

    public PaymentObject() {
    }

    public PaymentObject(BoletoModel boletoModel) {
        setDueDate(boletoModel.getDataVencimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        boletoModel.getDescricoes().forEach(s -> getMessage().add(s));
    }

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

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public Float getPenaltyRate() {
        return penaltyRate;
    }

    public void setPenaltyRate(Float penaltyRate) {
        this.penaltyRate = penaltyRate;
    }

    public Float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Float interestRate) {
        this.interestRate = interestRate;
    }

    public Boolean getCancelAfterDue() {
        return cancelAfterDue;
    }

    public void setCancelAfterDue(Boolean cancelAfterDue) {
        this.cancelAfterDue = cancelAfterDue;
    }

    public Boolean getIsEnablePartialPayment() {
        return isEnablePartialPayment;
    }

    public void setIsEnablePartialPayment(Boolean isEnablePartialPayment) {
        this.isEnablePartialPayment = isEnablePartialPayment;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDiscountDue() {
        return discountDue;
    }

    public void setDiscountDue(String discountDue) {
        this.discountDue = discountDue;
    }

    @Override
    public String toString() {
        return "PaymentObjectBoleto{" + "bankSlipNumber=" + bankSlipNumber + ", dueDate=" + dueDate + ", digitableLine=" + digitableLine + ", barcode=" + barcode + ", bankSlipUrl=" + bankSlipUrl + ", instruction=" + instruction + ", message=" + message + ", penaltyRate=" + penaltyRate + ", interestRate=" + interestRate + ", cancelAfterDue=" + cancelAfterDue + ", isEnablePartialPayment=" + isEnablePartialPayment + ", discountType=" + discountType + ", discountAmount=" + discountAmount + ", discountDue=" + discountDue + '}';
    }

}
