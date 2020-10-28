package com.ariavbar.redditoperationsgw.config;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserAgentInterceptor implements ClientHttpRequestInterceptor {
	
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		
		request.getHeaders().add("User-Agent", "web:com.ariavbar.redditoperationsgw:v0.0.1 (by /u/AriavBar)");
		log.info(request.getURI().toString());
		ClientHttpResponse response = execution.execute(request, body);
		log.info(response.getStatusText());
		
		return response;
	}
	
}
