package com.project.registration.demo.system.user.starter.configuration;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

    private final int TIMEOUT = 5000;

    @Bean
    public RestOperations restOperations() {
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                if (!response.getStatusCode().is4xxClientError()) {
                    super.handleError(response);
                }
            }

        });
        return restTemplate;
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(TIMEOUT);
        factory.setConnectTimeout(TIMEOUT);
        return factory;
    }
}
