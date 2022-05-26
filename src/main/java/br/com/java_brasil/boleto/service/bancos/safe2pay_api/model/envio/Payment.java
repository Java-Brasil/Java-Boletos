package br.com.java_brasil.boleto.service.bancos.safe2pay_api.model.envio;

import br.com.java_brasil.boleto.model.BoletoModel;

import java.util.ArrayList;
import java.util.List;

public class Payment {

    public Payment() {
    }

    public Payment(BoletoModel boletoModel, boolean sandbox) {

        setIsSandbox(sandbox);
        setApplication("java-boleto");
        setPaymentMethod("1");
        setReference("NossoNumero:" + boletoModel.getBeneficiario().getNossoNumero());

        Customer customer = new Customer(boletoModel);
        setCustomer(customer);

        Product product = new Product(boletoModel);
        getProducts().add(product);

        PaymentObject paymentBoleto = new PaymentObject(boletoModel);
        setPaymentObject(paymentBoleto);

    }

    private Boolean isSandbox;
    private String application;
    private String vendor;
    private String callbackUrl;
    private String paymentMethod;
    private String reference;
    private Customer customer;
    private List<Product> products = new ArrayList<>();
    private PaymentObject paymentObject;

    public Boolean getIsSandbox() {
        return isSandbox;
    }

    public void setIsSandbox(Boolean isSandbox) {
        this.isSandbox = isSandbox;
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

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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
        return "PagamentoBoleto{" + "isSandbox=" + isSandbox + ", application=" + application + ", vendor=" + vendor + ", callbackUrl=" + callbackUrl + ", paymentMethod=" + paymentMethod + ", reference=" + reference + ", customer=" + customer + ", products=" + products + ", paymentObject=" + paymentObject + '}';
    }

}
