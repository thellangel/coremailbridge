package com.hdsoft.coremailbridge.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    private final Logger logger = LoggerFactory.getLogger(RestTemplateResponseErrorHandler.class);
    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {
        return (
                httpResponse.getStatusCode().series() == CLIENT_ERROR
                        || httpResponse.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse) throws IOException {
        if (httpResponse.getStatusCode().series() == SERVER_ERROR) {
            // handle SERVER_ERROR
            logger.error("------- http server error, status {} -------", httpResponse.getStatusCode());
        } else if (httpResponse.getStatusCode().series() == CLIENT_ERROR) {
            // handle CLIENT_ERROR
            if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                logger.error("------- http client error, status {} -------", httpResponse.getStatusCode());
            }
            else if (httpResponse.getStatusCode() == HttpStatus.BAD_REQUEST) {
                logger.error("------- http client error, status {} -------", httpResponse.getStatusCode());
            }
        }
    }
}
