package com.ariavbar.redditoperationsgw.controller;

import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/v1")
@RestController
public class RedditOperationsController {
	
	private static final String BASE_URL = "https://www.reddit.com";
	private final OAuth2RestTemplate redditTemplate;
	
	@GetMapping("/me")
	public String getUserIdentity() {
		return redditTemplate.getForObject(BASE_URL + "/api/v1/scopes", String.class);
	}
	
}
