
package br.com.java_brasil.boleto.service.bancos.safe2pay_api.model.consulta;


import com.fasterxml.jackson.annotation.JsonAlias;

public class Customer {
 
    
    @JsonAlias("Name")
    private String name; 
    @JsonAlias("Identity")
    private String identity; 
    @JsonAlias("Phone")
    private String phone; 
    @JsonAlias("Email")
    private String email; 
    @JsonAlias("Address")
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", identity=" + identity + ", phone=" + phone + ", email=" + email + ", address=" + address + '}';
    }
    
    

}
