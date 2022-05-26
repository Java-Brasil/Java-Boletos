package br.com.java_brasil.boleto.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUtils implements Serializable {

    private static final long serialVersionUID = 1L;

    public static boolean isWindows() {
        String OS = System.getProperty("os.name").toLowerCase();
        return (OS.indexOf("win") >= 0);
    }

    public static class Zip implements Serializable {

        public Zip(ByteArrayOutputStream conteudo, String nome) {
            this.conteudo = conteudo;
            this.nome = nome;
        }

        private ByteArrayOutputStream conteudo;
        private String nome;

        public ByteArrayOutputStream getConteudo() {
            return conteudo;
        }

        public void setConteudo(ByteArrayOutputStream conteudo) {
            this.conteudo = conteudo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        @Override
        public String toString() {
            return "Zip{" +
                    "nome='" + nome + '\'' +
                    '}';
        }
    }

    private static ByteArrayOutputStream zipInputStreamToByteArrayOutputStream(ZipInputStream zipInputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(byteArrayOutputStream);
        int TAM_BUFFER = 1024;
        byte[] bytesIn = new byte[TAM_BUFFER];
        int read = 0;
        while ((read = zipInputStream.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
        return byteArrayOutputStream;
    }

    public static List<Zip> unzip(byte[] data) throws IOException {
        List<Zip> zipList = new ArrayList<>();
        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(data));
        ZipEntry zipEntry = zipInputStream.getNextEntry();
        while (zipEntry != null) {
            if (!zipEntry.isDirectory()) {
                ByteArrayOutputStream byteArrayOutputStream = zipInputStreamToByteArrayOutputStream(zipInputStream);
                String name = zipEntry.getName();
                boolean add = zipList.add(new Zip(byteArrayOutputStream, name));
            }
            zipInputStream.closeEntry();
            zipEntry = zipInputStream.getNextEntry();
        }
        zipInputStream.close();
        return zipList;
    }

}
