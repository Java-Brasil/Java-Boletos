package br.com.java_brasil.boleto.service.bancos.inter_api;

import br.com.java_brasil.boleto.exception.BoletoException;
import br.com.java_brasil.boleto.model.BoletoController;
import br.com.java_brasil.boleto.model.BoletoModel;
import br.com.java_brasil.boleto.service.bancos.inter_api.custon.InterCustonDecoder;
import br.com.java_brasil.boleto.service.bancos.inter_api.custon.InterCustonEncoder;
import br.com.java_brasil.boleto.service.bancos.inter_api.custon.InterErrorDecoder;
import br.com.java_brasil.boleto.service.bancos.inter_api.exception.InterApiException;
import br.com.java_brasil.boleto.service.bancos.inter_api.model.*;
import br.com.java_brasil.boleto.util.ZipUtils;
import feign.Client;
import feign.Feign;
import feign.FeignException;
import feign.Request;
import feign.form.FormEncoder;
import lombok.NonNull;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.conn.ssl.NoopHostnameVerifier;

import javax.net.ssl.*;
import java.io.*;
import java.lang.reflect.UndeclaredThrowableException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.List;

/**
 * Classe Generica para servir como base de Implementação
 */
public class BancoInterAPI extends BoletoController {

    @Override
    public byte[] imprimirBoleto(@NonNull BoletoModel boletoModel) {
        try {
            ConfiguracaoInterAPI configuracao = (ConfiguracaoInterAPI) this.getConfiguracao();

            String caminhoCertificado = configuracao.getCaminhoCertificado();
            String senhaCertificado = configuracao.getSenhaCertificado();
            Client client = getFeignClient(true, caminhoCertificado, senhaCertificado);

            String urlBase = configuracao.getURLBase();
            String urlToken = configuracao.getUrlToken();
            String clientId = configuracao.getClientId();
            String clientSecret = configuracao.getClientSecret();

            TokenResponse v2Token = token(client, urlBase + urlToken, clientId, clientSecret);
            String accessToken = v2Token.getAccessToken();

            String nossoNumero = boletoModel.getCodRetorno();
            String urlCobranca = configuracao.getUrlCobranca();

            byte[] decode = pdfBase64Get(client, urlBase + urlCobranca, accessToken, nossoNumero);
            return decode;

        } catch (Exception e) {
            throw new BoletoException(e.getMessage(), e);
        }
    }

    @Override
    public BoletoModel enviarBoleto(@NonNull BoletoModel boletoModel) {
        try {
            ConfiguracaoInterAPI configuracao = (ConfiguracaoInterAPI) this.getConfiguracao();

            String caminhoCertificado = configuracao.getCaminhoCertificado();
            String senhaCertificado = configuracao.getSenhaCertificado();
            Client client = getFeignClient(true, caminhoCertificado, senhaCertificado);

            String urlBase = configuracao.getURLBase();
            String urlToken = configuracao.getUrlToken();
            String clientId = configuracao.getClientId();
            String clientSecret = configuracao.getClientSecret();

            TokenResponse v2Token = token(client, urlBase + urlToken, clientId, clientSecret);
            String accessToken = v2Token.getAccessToken();

            String urlCobranca = configuracao.getUrlCobranca();
            BoletoBody boletoBody = new BoletoBody(boletoModel);
            BoletoResponse boletoResponse = boletoPost(client, urlBase + urlCobranca, accessToken, boletoBody);

            return montaBoletoResponse(boletoModel, boletoResponse);

        } catch (Exception e) {
            throw new BoletoException(e.getMessage(), e);
        }

    }

    @Override
    public BoletoModel alteraBoleto(@NonNull BoletoModel boletoModel) {
        try {
            ConfiguracaoInterAPI configuracao = (ConfiguracaoInterAPI) this.getConfiguracao();

            String caminhoCertificado = configuracao.getCaminhoCertificado();
            String senhaCertificado = configuracao.getSenhaCertificado();
            Client client = getFeignClient(true, caminhoCertificado, senhaCertificado);

            String urlBase = configuracao.getURLBase();
            String urlToken = configuracao.getUrlToken();
            String clientId = configuracao.getClientId();
            String clientSecret = configuracao.getClientSecret();

            TokenResponse v2Token = token(client, urlBase + urlToken, clientId, clientSecret);
            String accessToken = v2Token.getAccessToken();

            String nossoNumero = boletoModel.getCodRetorno();
            String urlCobranca = configuracao.getUrlCobranca();

            cancelarPost(client, urlBase + urlCobranca, accessToken, nossoNumero, new CancelaBody());

            boletoModel.setMensagemRetorno("EM PROCESSO DE CANCELAMENTO, AGUARDE 30 SEGUNDOS");

            return boletoModel;

        } catch (Exception e) {
            throw new BoletoException(e.getMessage(), e);
        }
    }

    @Override
    public BoletoModel consultaBoleto(@NonNull BoletoModel boletoModel) {
        try {
            ConfiguracaoInterAPI configuracao = (ConfiguracaoInterAPI) this.getConfiguracao();

            String caminhoCertificado = configuracao.getCaminhoCertificado();
            String senhaCertificado = configuracao.getSenhaCertificado();
            Client client = getFeignClient(true, caminhoCertificado, senhaCertificado);

            String urlBase = configuracao.getURLBase();
            String urlToken = configuracao.getUrlToken();
            String clientId = configuracao.getClientId();
            String clientSecret = configuracao.getClientSecret();

            TokenResponse v2Token = token(client, urlBase + urlToken, clientId, clientSecret);
            String accessToken = v2Token.getAccessToken();

            String nossoNumero = boletoModel.getCodRetorno();
            String urlCobranca = configuracao.getUrlCobranca();

            BoletoResponse boletoResponse = boletoGet(client, urlBase + urlCobranca, accessToken, nossoNumero);

            return montaBoletoResponse(boletoModel, boletoResponse);

        } catch (Exception e) {
            throw new BoletoException(e.getMessage(), e);
        }
    }

    private BoletoModel montaBoletoResponse(BoletoModel boletoModel, BoletoResponse boletoResponse) {
        boletoModel.setCodRetorno(boletoResponse.getNossoNumero());
        boletoModel.setMensagemRetorno(boletoResponse.getSituacao());
        boletoModel.setCodigoBarras(boletoResponse.getCodigoBarras());
        return boletoModel;
    }

    private static SSLContext initializeSSLContext(final byte[] keyStoreByteArray, final String pwKeyStore, final boolean trustall) throws Exception {

        TrustManager[] trustAllCerts = null;
        trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }};

        String keymanageralgorithm = "SunX509";

        char[] keyStorePw = pwKeyStore.toCharArray();
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextInt();
        KeyStore ks = null;
        try {
            ks = KeyStore.getInstance("JKS");
        } catch (KeyStoreException exp) {
            throw new Exception("KeyStoreException exception occurred while reading the config file : " + exp.getMessage());
        }

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(keyStoreByteArray);
        try {
            ks.load(byteArrayInputStream, keyStorePw);
        } catch (NoSuchAlgorithmException exp) {
            throw new Exception("NoSuchAlgorithmException exception occurred " + exp.getMessage());
        } catch (CertificateException | IOException exp) {
            if (exp.getMessage().contains("password was incorrect")) {
                throw new Exception("Senha incorreta!");
            } else {
                throw new Exception("CertificateException exception occurred " + exp.getMessage());
            }
        }

        KeyManagerFactory kmf = null;
        try {
            kmf = KeyManagerFactory.getInstance(keymanageralgorithm);
        } catch (NoSuchAlgorithmException exp) {
            throw new Exception("IOException exception occurred " + exp.getMessage());
        }
        try {
            kmf.init(ks, keyStorePw);
        } catch (UnrecoverableKeyException exp) {
            throw new Exception("UnrecoverableKeyException exception occurred " + exp.getMessage());
        } catch (KeyStoreException exp) {
            throw new Exception("KeyStoreException exception occurred " + exp.getMessage());
        } catch (NoSuchAlgorithmException exp) {
            throw new Exception("NoSuchAlgorithmException exception occurred " + exp.getMessage());
        }
        KeyStore ts = null;
        try {
            ts = KeyStore.getInstance("JKS");
        } catch (KeyStoreException exp) {
            throw new Exception("NoSuchAlgorithmException exception occurred " + exp.getMessage());
        }
        SSLContext sslContext = null;
        try {
            ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(keyStoreByteArray);
            ts.load(byteArrayInputStream2, keyStorePw);
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(keymanageralgorithm);
            tmf.init(ts);
            sslContext = SSLContext.getInstance("TLS");

            if (trustall) {
                sslContext.init(kmf.getKeyManagers(), trustAllCerts, secureRandom);
            } else {
                sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), secureRandom);
            }

        } catch (NoSuchAlgorithmException | CertificateException | IOException | KeyStoreException | KeyManagementException exp) {
            throw new Exception("NoSuchAlgorithmException exception occurred " + exp.getMessage());
        }
        return sslContext;
    }

    private static SSLContext setupSslContext(boolean trustAllCertificate, byte[] keyStoreByteArray, String keyStorePassword) throws Exception {
        SSLContext sslContext = initializeSSLContext(keyStoreByteArray, keyStorePassword, trustAllCertificate);
        return sslContext;

    }

    private static Client getFeignClient(boolean trustAllCertificate, String caminhoCertificado, String jksKeyStoreSenha) throws Exception {

        File file = new File(caminhoCertificado);
        byte[] readFileToByteArray = FileUtils.readFileToByteArray(file);

        SSLContext sslContext = setupSslContext(trustAllCertificate, readFileToByteArray, jksKeyStoreSenha);
        SSLSocketFactory socketFactory = sslContext.getSocketFactory();
        Client trustSSLSockets = new Client.Default(socketFactory, new NoopHostnameVerifier());
        return trustSSLSockets;
    }

    private static TokenResponse token(Client client, String WS_URL_OAUTH, String client_id, String client_secret) throws InterApiException {

        try {

            TokenResponse tokenPost = Feign.builder()
                    .client(client)
                    .encoder(new FormEncoder())
                    .decoder(new InterCustonDecoder())
                    .options(new Request.Options(3000, 3000))
                    .target(InterWS.class, WS_URL_OAUTH)
                    .tokenPost(client_id, client_secret, "client_credentials", "boleto-cobranca.read boleto-cobranca.write");

            return tokenPost;

        } catch (UndeclaredThrowableException undeclaredThrowableException) {
            Throwable undeclaredThrowable = undeclaredThrowableException.getUndeclaredThrowable();
            if (undeclaredThrowable instanceof InterApiException) {
                InterApiException interApiException = (InterApiException) undeclaredThrowable;
                throw interApiException;
            } else {
                throw new InterApiException(undeclaredThrowable.getMessage());
            }
        } catch (FeignException exception) {
            exception.printStackTrace();
            if (exception.status() == 401) {
                throw new InterApiException("Autenticação não autorizada, verifique o certificado da conta!");
            } else {
                throw new InterApiException(exception.getMessage());
            }
        }

    }

    private static BoletoResponse boletoGet(Client client, String WS_URL_COBRANCA, String token, String nossoNumero) throws InterApiException {

        try {
            BoletoResponse boletoResponse = Feign.builder()
                    .client(client)
                    .encoder(new InterCustonEncoder())
                    .decoder(new InterCustonDecoder())
                    .options(new Request.Options(3000, 3000))
                    .target(InterWS.class, WS_URL_COBRANCA)
                    .boletoGet(token, nossoNumero);
            return boletoResponse;
        } catch (UndeclaredThrowableException undeclaredThrowableException) {
            Throwable undeclaredThrowable = undeclaredThrowableException.getUndeclaredThrowable();
            if (undeclaredThrowable instanceof InterApiException) {
                InterApiException interApiException = (InterApiException) undeclaredThrowable;
                throw interApiException;
            } else {
                throw new InterApiException(undeclaredThrowable.getMessage());
            }
        } catch (FeignException exception) {
            if (exception.status() == 401) {
                throw new InterApiException("Autenticação não autorizada, verifique o certificado da conta!");
            } else {
                throw new InterApiException(exception.getMessage());
            }
        }

    }

    private static byte[] pdfBase64Get(Client client, String WS_URL_COBRANCA, String token, String nossoNumero) throws InterApiException {

        try {
            PdfBase64GetResponse pdfBase64GetResponse = Feign.builder()
                    .client(client)
                    .encoder(new InterCustonEncoder())
                    .decoder(new InterCustonDecoder())
                    .options(new Request.Options(3000, 3000))
                    .target(InterWS.class, WS_URL_COBRANCA)
                    .pdfBase64Get(token, nossoNumero);
            byte[] decode = Base64.getDecoder().decode(pdfBase64GetResponse.getPdf());
            return decode;
        } catch (UndeclaredThrowableException undeclaredThrowableException) {
            Throwable undeclaredThrowable = undeclaredThrowableException.getUndeclaredThrowable();
            if (undeclaredThrowable instanceof InterApiException) {
                InterApiException interApiException = (InterApiException) undeclaredThrowable;
                throw interApiException;
            } else {
                throw new InterApiException(undeclaredThrowable.getMessage());
            }
        } catch (FeignException exception) {
            if (exception.status() == 401) {
                throw new InterApiException("Autenticação não autorizada, verifique o certificado da conta!");
            } else {
                throw new InterApiException(exception.getMessage());
            }
        }

    }

    private static BoletoResponse boletoPost(Client client, String WS_URL_COBRANCA, String token, BoletoBody boletoBody) throws InterApiException {

        try {
            BoletoResponse boletoResponse = Feign.builder()
                    .client(client)
                    .encoder(new InterCustonEncoder())
                    .decoder(new InterCustonDecoder())
                    .errorDecoder(new InterErrorDecoder())
                    .options(new Request.Options(3000, 3000))
                    .target(InterWS.class, WS_URL_COBRANCA)
                    .boletoPost(token, boletoBody);
            return boletoResponse;
        } catch (UndeclaredThrowableException undeclaredThrowableException) {
            Throwable undeclaredThrowable = undeclaredThrowableException.getUndeclaredThrowable();
            if (undeclaredThrowable instanceof InterApiException) {
                InterApiException interApiException = (InterApiException) undeclaredThrowable;
                throw interApiException;
            } else {
                throw new InterApiException(undeclaredThrowable.getMessage());
            }
        } catch (FeignException exception) {
            if (exception.status() == 401) {
                throw new InterApiException("Autenticação não autorizada, verifique o certificado da conta!");
            } else {
                throw new InterApiException(exception.getMessage());
            }
        }

    }

    private static void cancelarPost(Client client, String WS_URL_COBRANCA, String token, String nossoNumero, CancelaBody cancelaBody) throws InterApiException {

        try {
            Feign.builder()
                    .client(client)
                    .encoder(new InterCustonEncoder())
                    .decoder(new InterCustonDecoder())
                    .errorDecoder(new InterErrorDecoder())
                    .options(new Request.Options(3000, 3000))
                    .target(InterWS.class, WS_URL_COBRANCA)
                    .cancelarPost(token, nossoNumero, cancelaBody);
        } catch (UndeclaredThrowableException undeclaredThrowableException) {
            Throwable undeclaredThrowable = undeclaredThrowableException.getUndeclaredThrowable();
            if (undeclaredThrowable instanceof InterApiException) {
                InterApiException interApiException = (InterApiException) undeclaredThrowable;
                throw interApiException;
            } else {
                throw new InterApiException(undeclaredThrowable.getMessage());
            }
        } catch (FeignException exception) {
            if (exception.status() == 401) {
                throw new InterApiException("Autenticação não autorizada, verifique o certificado da conta!");
            } else {
                throw new InterApiException(exception.getMessage());
            }
        }

    }

    private byte[] convertZipToJks(String cnpj, byte[] arquivoZip) throws Exception {

        String inicio = "/";
        if (ZipUtils.isWindows()) {
            inicio = "D:/";
        }

        String nomeDir = inicio.concat("smartfull/certificadosInter/").concat(cnpj);
        File fileDir = new File(nomeDir);
        FileUtils.forceMkdir(fileDir);

        List<ZipUtils.Zip> zipList = ZipUtils.unzip(arquivoZip);
        for (ZipUtils.Zip zip : zipList) {
            ByteArrayOutputStream conteudo = zip.getConteudo();
            String nome = zip.getNome();
            String extencao = StringUtils.substringAfterLast(nome, ".");
            String nomeZip = nomeDir.concat("/").concat(cnpj).concat(".").concat(extencao);
            File fileZip = new File(nomeZip);
            FileUtils.writeByteArrayToFile(fileZip, conteudo.toByteArray());
        }

        String nomeP12 = nomeDir.concat("/").concat(cnpj).concat(".p12");
        String nomeKey = nomeDir.concat("/").concat(cnpj).concat(".key");
        String nomeCrt = nomeDir.concat("/").concat(cnpj).concat(".crt");
        String nomeJks = nomeDir.concat("/").concat(cnpj).concat(".jks");

        String openssl = "openssl pkcs12 -export -out " + nomeP12 + " -name \"" + cnpj + "\" -inkey " + nomeKey + " -in " + nomeCrt + " -passout pass:123456";
        System.out.println(openssl);
        Process execOpenssl = Runtime.getRuntime().exec(openssl);

        String keyTool = "keytool -importkeystore -srckeystore " + nomeP12 + " -srcstorepass 123456 -srcstoretype PKCS12 -destkeystore " + nomeJks + " -deststoretype JKS -deststorepass 123456 -noprompt";
        System.out.println(keyTool);
        Process execKeyTool = Runtime.getRuntime().exec(keyTool);

        File fileJks = new File(nomeJks);
        if (fileJks.exists()) {
            byte[] bytesJks = FileUtils.readFileToByteArray(fileJks);
            return bytesJks;
        } else {
            throw new Exception("Arquivo Jks não encontrado!");
        }

    }

}
