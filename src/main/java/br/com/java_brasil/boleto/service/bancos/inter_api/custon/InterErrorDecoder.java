package br.com.java_brasil.boleto.service.bancos.inter_api.custon;

import br.com.java_brasil.boleto.service.bancos.inter_api.exception.InterApiException;
import br.com.java_brasil.boleto.service.bancos.inter_api.model.ErrorResponse;
import br.com.java_brasil.boleto.service.bancos.inter_api.model.ErrorResponseNovo;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;

import static feign.FeignException.errorStatus;

public class InterErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        String toString = null;
        try {
            toString = IOUtils.toString(response.body().asInputStream());
        } catch (Exception ignored) {
        }
        try {
            Genson genson = new GensonBuilder().setSkipNull(true).useDateAsTimestamp(false).create();
            ErrorResponse errorResponse = genson.deserialize(toString, ErrorResponse.class);
            if (errorResponse != null && errorResponse.getMessage() != null) {
                String message = errorResponse.getMessage();
                InterApiException interApiException = new InterApiException(message);
                interApiException.setErrorResponse(errorResponse);
                return interApiException;
            }
        } catch (Exception ignored2) {
            try {
                Genson genson = new GensonBuilder().setSkipNull(true).useDateAsTimestamp(false).create();
                ErrorResponseNovo errorResponseNovo = genson.deserialize(toString, ErrorResponseNovo.class);
                if (errorResponseNovo != null && errorResponseNovo.getMessage() != null && !errorResponseNovo.getMessage().isEmpty()) {
                    String message = errorResponseNovo.getMessage().get(0);
                    InterApiException interApiException = new InterApiException(message);
                    interApiException.setErrorResponseNovo(errorResponseNovo);
                    return interApiException;
                }
            } catch (Exception ignored3) {
            }
        }
        return errorStatus(methodKey, response);
    }
}
