package com.mytoshika.auth.exception;

import java.io.IOException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {
	@Override
	public void handleError(ClientHttpResponse httpResponse) throws IOException {
		
		if (httpResponse.getStatusCode()
				.series() == HttpStatus.Series.SERVER_ERROR) {
			throw new ServiceException("SERVER_ERROR");
		} else if (httpResponse.getStatusCode()
				.series() == HttpStatus.Series.CLIENT_ERROR) {
				
			if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new NotFoundException("Not found");
			}else {
				throw new ServiceException("CLIENT_ERROR");
			}
		}
	}

	@Override
	public boolean hasError(ClientHttpResponse httpResponse) throws IOException {

		return (
				httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR 
				|| httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
	}
}