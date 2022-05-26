package br.com.java_brasil.boleto.service.bancos.safe2pay_api.model.consulta;


import com.fasterxml.jackson.annotation.JsonAlias;

public class Address {

    @JsonAlias("ZipCode")
    private String zipCode;
    @JsonAlias("Street")
    private String street;
    @JsonAlias("Number")
    private String number;
    @JsonAlias("Complement")
    private String complement;
    @JsonAlias("District")
    private String district;
    @JsonAlias("State")
    private String state;
    @JsonAlias("City")
    private String city;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressResponseBoleto{" + "zipCode=" + zipCode + ", street=" + street + ", number=" + number + ", complement=" + complement + ", district=" + district + ", state=" + state + ", city=" + city + '}';
    }

}
