
package br.com.java_brasil.boleto.service.bancos.inter_api.model;

import br.com.java_brasil.boleto.util.BoletoUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class Mensagem {

    public Mensagem() {
    }

    public Mensagem(String linha1, String linha2, String linha3, String linha4, String linha5) {
        this.linha1 = linha1;
        this.linha2 = linha2;
        this.linha3 = linha3;
        this.linha4 = linha4;
        this.linha5 = linha5;
    }

    public Mensagem(List<String> descricoes) {
        if (!descricoes.isEmpty()) {

            this.linha1 = descricoes.get(0);

            if (descricoes.size() >= 2) {
                this.linha2 = descricoes.get(1);
            }
            if (descricoes.size() >= 3) {
                this.linha3 = descricoes.get(2);
            }
            if (descricoes.size() >= 4) {
                this.linha4 = descricoes.get(3);
            }
            if (descricoes.size() >= 5) {
                this.linha5 = descricoes.get(4);
            }

        }
    }

    private String linha1;
    private String linha2;
    private String linha3;
    private String linha4;
    private String linha5;

    public String getLinha1() {
        return linha1;
    }

    public void setLinha1(String linha1) {
        this.linha1 = linha1;
    }

    public String getLinha2() {
        return linha2;
    }

    public void setLinha2(String linha2) {
        this.linha2 = linha2;
    }

    public String getLinha3() {
        return linha3;
    }

    public void setLinha3(String linha3) {
        this.linha3 = linha3;
    }

    public String getLinha4() {
        return linha4;
    }

    public void setLinha4(String linha4) {
        this.linha4 = linha4;
    }

    public String getLinha5() {
        return linha5;
    }

    public void setLinha5(String linha5) {
        this.linha5 = linha5;
    }


}
