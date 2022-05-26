package br.com.java_brasil.boleto.service.bancos.safe2pay_api.model.consulta;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ResponseDetail {

    @JsonAlias("IdTransaction")
    private String idTransaction;
    @JsonAlias("Status")
    private String status;
    @JsonAlias("Message")
    private String message;
    @JsonAlias("Application")
    private String application;
    @JsonAlias("Vendor")
    private String vendor;
    @JsonAlias("Reference")
    private String reference;
    @JsonAlias("CallbackUrl")
    private String callbackUrl;
    @JsonAlias("CreatedDate")
    private String createdDate;
    @JsonAlias("Amount")
    private Float amount;
    @JsonAlias("NetValue")
    private Float netValue;
    @JsonAlias("TaxValue")
    private BigDecimal taxValue;
    @JsonAlias("NegotiationTax")
    private Float negotiationTax;
    @JsonAlias("PaymentMethod")
    private String paymentMethod;
    @JsonAlias("PaymentDate")
    private LocalDate paymentDate;
    @JsonAlias("Customer")
    private Customer customer;
    @JsonAlias("Products")
    private List<Product> products;
    @JsonAlias("PaymentObject")
    private PaymentObject paymentObject;

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

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getNetValue() {
        return netValue;
    }

    public void setNetValue(Float netValue) {
        this.netValue = netValue;
    }

    public BigDecimal getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(BigDecimal taxValue) {
        this.taxValue = taxValue;
    }

    public Float getNegotiationTax() {
        return negotiationTax;
    }

    public void setNegotiationTax(Float negotiationTax) {
        this.negotiationTax = negotiationTax;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public PaymentObject getPaymentObject() {
        return paymentObject;
    }

    public void setPaymentObject(PaymentObject paymentObject) {
        this.paymentObject = paymentObject;
    }

    @Override
    public String toString() {
        return "ResponseDetail{" + "idTransaction=" + idTransaction + ", status=" + status + ", message=" + message + ", application=" + application + ", vendor=" + vendor + ", reference=" + reference + ", callbackUrl=" + callbackUrl + ", createdDate=" + createdDate + ", amount=" + amount + ", netValue=" + netValue + ", taxValue=" + taxValue + ", negotiationTax=" + negotiationTax + ", paymentMethod=" + paymentMethod + ", paymentDate=" + paymentDate + ", customer=" + customer + ", products=" + products + ", paymentObject=" + paymentObject + '}';
    }

}
