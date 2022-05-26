/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.java_brasil.boleto.service.bancos.safe2pay_api.model.envio;

import com.fasterxml.jackson.annotation.JsonAlias;

public class ResponseDetail {

    @JsonAlias("IdTransaction")
    private String idTransaction;
    @JsonAlias("Status")
    private String status;
    @JsonAlias("Message")
    private String message;
    @JsonAlias("Description")
    private String description;
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
    @JsonAlias("OperationDate")
    private String operationDate;
    @JsonAlias("BankName")
    private String bankName;
    @JsonAlias("CodeBank")
    private String codeBank;
    @JsonAlias("Wallet")
    private String wallet;
    @JsonAlias("WalletDescription")
    private String walletDescription;
    @JsonAlias("Agency")
    private String agency;
    @JsonAlias("Account")
    private String account;
    @JsonAlias("CodeAssignor")
    private String codeAssignor;
    @JsonAlias("AgencyDV")
    private String agencyDV;
    @JsonAlias("AccountDV")
    private String accountDV;
    @JsonAlias("DocType")
    private String docType;
    @JsonAlias("Accept")
    private String accept;
    @JsonAlias("Currency")
    private String currency;
    @JsonAlias("CuarantorName")
    private String guarantorName;
    @JsonAlias("GuarantorIdentity")
    private String guarantorIdentity;
 

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCodeBank() {
        return codeBank;
    }

    public void setCodeBank(String codeBank) {
        this.codeBank = codeBank;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public String getWalletDescription() {
        return walletDescription;
    }

    public void setWalletDescription(String walletDescription) {
        this.walletDescription = walletDescription;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCodeAssignor() {
        return codeAssignor;
    }

    public void setCodeAssignor(String codeAssignor) {
        this.codeAssignor = codeAssignor;
    }

    public String getAgencyDV() {
        return agencyDV;
    }

    public void setAgencyDV(String agencyDV) {
        this.agencyDV = agencyDV;
    }

    public String getAccountDV() {
        return accountDV;
    }

    public void setAccountDV(String accountDV) {
        this.accountDV = accountDV;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getGuarantorName() {
        return guarantorName;
    }

    public void setGuarantorName(String guarantorName) {
        this.guarantorName = guarantorName;
    }

    public String getGuarantorIdentity() {
        return guarantorIdentity;
    }

    public void setGuarantorIdentity(String guarantorIdentity) {
        this.guarantorIdentity = guarantorIdentity;
    }

    @Override
    public String toString() {
        return "ResponseDetailBoleto{" + "idTransaction=" + idTransaction + ", status=" + status + ", message=" + message + ", description=" + description + ", bankSlipNumber=" + bankSlipNumber + ", dueDate=" + dueDate + ", digitableLine=" + digitableLine + ", barcode=" + barcode + ", bankSlipUrl=" + bankSlipUrl + ", operationDate=" + operationDate + ", bankName=" + bankName + ", codeBank=" + codeBank + ", wallet=" + wallet + ", walletDescription=" + walletDescription + ", agency=" + agency + ", account=" + account + ", codeAssignor=" + codeAssignor + ", agencyDV=" + agencyDV + ", accountDV=" + accountDV + ", docType=" + docType + ", accept=" + accept + ", currency=" + currency + ", guarantorName=" + guarantorName + ", guarantorIdentity=" + guarantorIdentity + '}';
    }
    
    
}
