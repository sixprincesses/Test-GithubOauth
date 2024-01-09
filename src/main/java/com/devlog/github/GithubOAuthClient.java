package com.devlog.github;

import com.devlog.github.dto.OAuthGithubAccessTokenRequest;
import com.devlog.github.dto.OAuthGithubAccessTokenResponse;
import com.devlog.github.dto.OAuthGithubUserInfoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class GithubOAuthClient {

    private static final RestTemplate restTemplate = new RestTemplate();
    private final String clientId;
    private final String clientSecret;

    public GithubOAuthClient(@Value("${github.client_id}") String clientId, @Value("${github.client_secret}") String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getAccessToken(String code) {
        Optional<OAuthGithubAccessTokenResponse> optional = Optional.ofNullable(
                restTemplate.postForObject("https://github.com/login/oauth/access_token",
                        new OAuthGithubAccessTokenRequest(clientId, clientSecret, code),
                        OAuthGithubAccessTokenResponse.class));

        return optional
                .orElseThrow(RuntimeException::new)
                .accessToken();
    }

    public OAuthGithubUserInfoResponse getUserInfo(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<Void> request = new HttpEntity<>(headers);

        return restTemplate.exchange(
                "https://api.github.com/user",
                HttpMethod.GET,
                request,
                OAuthGithubUserInfoResponse.class
        ).getBody();
    }
}
