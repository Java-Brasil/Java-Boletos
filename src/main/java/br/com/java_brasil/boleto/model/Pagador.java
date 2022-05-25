package br.com.java_brasil.boleto.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class Pagador {

    private String nome;
    private String codigo;
    private String documento;
    private String email;
    private Endereco endereco;

    private String ddd;
    private String telefone;

    public boolean isClienteCpf() {
        return StringUtils.isNotBlank(documento) && documento.length() <= 11;
    }
}
