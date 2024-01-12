package com.devlog.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OAuthGithubAccessTokenRequest(
        @JsonProperty("client_id") String clientId,
        @JsonProperty("client_secret") String clientSecret,
        @JsonProperty("code") String code
) {
}
