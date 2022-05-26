package br.com.java_brasil.boleto.util;

import br.com.java_brasil.boleto.exception.BoletoException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe Util para fornecer Boletos
 */
public class BoletoUtil {

    public static String converteData(LocalDateTime dataASerFormatada) {

        try {
            GregorianCalendar calendar = GregorianCalendar.from(Optional.ofNullable(dataASerFormatada).orElse(LocalDateTime.now()).atZone(ZoneId.of("Brazil/East")));
            XMLGregorianCalendar xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
            xmlCalendar.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);

            return (xmlCalendar.toString());

        } catch (DatatypeConfigurationException e) {
            throw new BoletoException(e.getMessage(), e);
        }
    }

    public static String getDataFormatoDDMMYYYY(LocalDate data){
        return data.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String valorSemPontos(BigDecimal valor, int casas){
        return valor.setScale(casas, RoundingMode.HALF_UP)
                .toString().replace(".", "");
    }

    /**
     * Retorna true se o bigDecimal informado é != de nulo e > que 0
     *
     * @param valor
     * @return
     */
    public static boolean isNotNullEMaiorQZero(BigDecimal valor) {
        return valor != null && maiorQZero(valor);
    }

    /**
     * Verifica se o valor passado em BigDecimal é maior que zero.
     *
     * @param valor
     * @return
     */
    public static boolean maiorQZero(BigDecimal valor) {
        return valor.compareTo(BigDecimal.ZERO) > 0;
    }


    /**
     * Retorna uma String do valor bigdecimal sem casas decimais
     *
     * @param valor
     * @return
     */
    public static String bigDecimalSemCasas(BigDecimal valor) {
        return formatarCasasDecimais(valor, 0);
    }

    /**
     * Retorna uma String do valor BigDecimal formatando o numero de casas decimais
     * de acordo com o scale informado.
     *
     * @param valor
     * @param scale
     * @return
     */
    public static String formatarCasasDecimais(BigDecimal valor, int scale) {
        if (valor != null) {
            return valor.setScale(scale, RoundingMode.HALF_UP).toString();
        } else {
            return BigDecimal.ZERO.setScale(scale, RoundingMode.HALF_UP).toString();
        }
    }

    /**
     * Limita o tamanho da String ate o limite passado.
     *
     * @param valor
     * @param limite
     * @return
     */
    public static String limitarTamanhoString(String valor, int limite) {
        if (StringUtils.isBlank(valor) || valor.length() <= limite) {
            return valor;
        }
        return valor.substring(0, limite);
    }

    /**
     * Remove tudo que não numeros de 0 a 9 da String passada.
     *
     * @param s
     * @return
     */
    public static String manterApenasNumeros(String s) {
        if (StringUtils.isBlank(s)) {
            return s;
        }
        return s.replaceAll("[^0-9]", "");
    }

    public static String formatarParaCodigoBarrasI25(String codigoBarra) {

        Map<String, String> i25Map = new HashMap<>();

        i25Map.put("00", "nnWWn");
        i25Map.put("01", "NnwwN");
        i25Map.put("02", "nNwwN");
        i25Map.put("03", "NNwwn");
        i25Map.put("04", "nnWwN");
        i25Map.put("05", "NnWwn");
        i25Map.put("06", "nNWwn");
        i25Map.put("07", "nnwWN");
        i25Map.put("08", "NnwWn");
        i25Map.put("09", "nNwWn");
        i25Map.put("10", "wnNNw");
        i25Map.put("11", "WnnnW");
        i25Map.put("12", "wNnnW");
        i25Map.put("13", "WNnnw");
        i25Map.put("14", "wnNnW");
        i25Map.put("15", "WnNnw");
        i25Map.put("16", "wNNnw");
        i25Map.put("17", "wnnNW");
        i25Map.put("18", "WnnNw");
        i25Map.put("19", "wNnNw");
        i25Map.put("20", "nwNNw");
        i25Map.put("21", "NwnnW");
        i25Map.put("22", "nWnnW");
        i25Map.put("23", "NWnnw");
        i25Map.put("24", "nwNnW");
        i25Map.put("25", "NwNnw");
        i25Map.put("26", "nWNnw");
        i25Map.put("27", "nwnNW");
        i25Map.put("28", "NwnNw");
        i25Map.put("29", "nWnNw");
        i25Map.put("30", "wwNNn");
        i25Map.put("31", "WwnnN");
        i25Map.put("32", "wWnnN");
        i25Map.put("33", "WWnnn");
        i25Map.put("34", "wwNnN");
        i25Map.put("35", "WwNnn");
        i25Map.put("36", "wWNnn");
        i25Map.put("37", "wwnNN");
        i25Map.put("38", "WwnNn");
        i25Map.put("39", "wWnNn");
        i25Map.put("40", "nnWNw");
        i25Map.put("41", "NnwnW");
        i25Map.put("42", "nNwnW");
        i25Map.put("43", "NNwnw");
        i25Map.put("44", "nnWnW");
        i25Map.put("45", "NnWnw");
        i25Map.put("46", "nNWnw");
        i25Map.put("47", "nnwNW");
        i25Map.put("48", "NnwNw");
        i25Map.put("49", "nNwNw");
        i25Map.put("50", "wnWNn");
        i25Map.put("51", "WnwnN");
        i25Map.put("52", "wNwnN");
        i25Map.put("53", "WNwnn");
        i25Map.put("54", "wnWnN");
        i25Map.put("55", "WnWnn");
        i25Map.put("56", "wNWnn");
        i25Map.put("57", "wnwNN");
        i25Map.put("58", "WnwNn");
        i25Map.put("59", "wNwNn");
        i25Map.put("60", "nwWNn");
        i25Map.put("61", "NwwnN");
        i25Map.put("62", "nWwnN");
        i25Map.put("63", "NWwnn");
        i25Map.put("64", "nwWnN");
        i25Map.put("65", "NwWnn");
        i25Map.put("66", "nWWnn");
        i25Map.put("67", "nwwNN");
        i25Map.put("68", "NwwNn");
        i25Map.put("69", "nWwNn");
        i25Map.put("70", "nnNWw");
        i25Map.put("71", "NnnwW");
        i25Map.put("72", "nNnwW");
        i25Map.put("73", "NNnww");
        i25Map.put("74", "nnNwW");
        i25Map.put("75", "NnNww");
        i25Map.put("76", "nNNww");
        i25Map.put("77", "nnnWW");
        i25Map.put("78", "NnnWw");
        i25Map.put("79", "nNnWw");
        i25Map.put("80", "wnNWn");
        i25Map.put("81", "WnnwN");
        i25Map.put("82", "wNnwN");
        i25Map.put("83", "WNnwn");
        i25Map.put("84", "wnNwN");
        i25Map.put("85", "WnNwn");
        i25Map.put("86", "wNNwn");
        i25Map.put("87", "wnnWN");
        i25Map.put("88", "WnnWn");
        i25Map.put("89", "wNnWn");
        i25Map.put("90", "nwNWn");
        i25Map.put("91", "NwnwN");
        i25Map.put("92", "nWnwN");
        i25Map.put("93", "NWnwn");
        i25Map.put("94", "nwNwN");
        i25Map.put("95", "NwNwn");
        i25Map.put("96", "nWNwn");
        i25Map.put("97", "nwnWN");
        i25Map.put("98", "NwnWn");
        i25Map.put("99", "nWnWn");

        StringBuilder codigoBarraI25 = new StringBuilder();

        for (String valor : codigoBarra.replace("<", "").replace(">", "")
                .split("(?<=\\G.{5})")) {
            codigoBarraI25.append(i25Map.entrySet()
                    .stream()
                    .filter(entry -> Objects.equals(entry.getValue(), valor))
                    .map(Map.Entry::getKey).findFirst().orElse(""));
        }

        return codigoBarraI25.toString();

    }

    public static String ajustaLimiteCaracter(String texto, int tamanhoMaximo) {
        String left = StringUtils.left(texto, tamanhoMaximo);
        return left;
    }

    public static byte[] downloadFile(String urlLink) throws IOException {
        byte[] toByteArray = new byte[0];
        try {
            URL url = new URL(urlLink);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.addRequestProperty("User-Agent", "Mozilla/4.76");
            InputStream inputStream = httpURLConnection.getInputStream();
            toByteArray = IOUtils.toByteArray(inputStream);
        } catch (IOException e) {
            URL url = new URL(urlLink.replace("https://", "http://"));
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.addRequestProperty("User-Agent", "Mozilla/4.76");
            InputStream inputStream = httpURLConnection.getInputStream();
            toByteArray = IOUtils.toByteArray(inputStream);
        }
        return toByteArray;
    }

}
