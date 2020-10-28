package com.ariavbar.redditoperationsgw.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenProvider;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsAccessTokenProvider;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Configuration
@EnableOAuth2Client
public class RedditTemplate {
	
    @Bean
    public ClientCredentialsResourceDetails reddit() {
    	ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setId("AriavBar");
        details.setClientId("xHvF-hRD6mmEcQ");
        details.setClientSecret("GWHVKhndTGwMBTwjE19plgrjPmk");
        details.setAccessTokenUri("https://www.reddit.com/api/v1/access_token");
        details.setGrantType("client_credentials");
        details.setTokenName("access_token");
        details.setScope(Arrays.asList("identity"));
   
        return details;
    }
 
    @Bean
    public OAuth2RestTemplate redditRestTemplate(OAuth2ClientContext clientContext) {
        OAuth2RestTemplate template = new OAuth2RestTemplate(reddit(), clientContext);
		List<ClientHttpRequestInterceptor> interceptors = List.of(new UserAgentInterceptor());
        ClientCredentialsAccessTokenProvider tokenProvider = new ClientCredentialsAccessTokenProvider();
		tokenProvider.setInterceptors(interceptors);
        AccessTokenProvider accessTokenProvider = new AccessTokenProviderChain(List.of(tokenProvider));
        template.setAccessTokenProvider(accessTokenProvider);
        template.setInterceptors(interceptors);
        
        return template;
    }
 
}
    