package br.com.java_brasil.boleto.service.bancos.safe2pay_api.model.envio;

import br.com.java_brasil.boleto.model.BoletoModel;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.math.BigDecimal;

public class Product {

    @JsonAlias("Code")
    private String code;
    @JsonAlias("Description")
    private String description;
    @JsonAlias("UnitPrice")
    private BigDecimal unitPrice;
    @JsonAlias("Quantity")
    private Integer quantity;

    public Product() {
    }

    public Product(BoletoModel boletoModel) {
        setDescription("NossoNumero:" + boletoModel.getBeneficiario().getNossoNumero());
        setQuantity(1);
        setUnitPrice(boletoModel.getValorBoleto());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "code=" + code + ", description=" + description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + '}';
    }

}
