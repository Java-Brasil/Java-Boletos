//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.05.26 às 10:12:45 PM BRT 
//


package br.com.java_brasil.boleto.service.bancos.banrisul_api.xsd.consultar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de baixa complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="baixa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="codigo" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="prazo" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baixa")
public class Baixa {

    @XmlAttribute(name = "codigo", required = true)
    protected short codigo;
    @XmlAttribute(name = "prazo", required = true)
    protected short prazo;

    /**
     * Obtém o valor da propriedade codigo.
     * 
     */
    public short getCodigo() {
        return codigo;
    }

    /**
     * Define o valor da propriedade codigo.
     * 
     */
    public void setCodigo(short value) {
        this.codigo = value;
    }

    /**
     * Obtém o valor da propriedade prazo.
     * 
     */
    public short getPrazo() {
        return prazo;
    }

    /**
     * Define o valor da propriedade prazo.
     * 
     */
    public void setPrazo(short value) {
        this.prazo = value;
    }

}
