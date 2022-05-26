package br.com.java_brasil.boleto.service.bancos.safe2pay_api.model.consulta;


import com.fasterxml.jackson.annotation.JsonAlias;

public class Product {

    @JsonAlias("Code")
    private String code;
    @JsonAlias("Description")
    private String description;
    @JsonAlias("UnitPrice")
    private Float unitPrice;
    @JsonAlias("Quantity")
    private Integer quantity;

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

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
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
