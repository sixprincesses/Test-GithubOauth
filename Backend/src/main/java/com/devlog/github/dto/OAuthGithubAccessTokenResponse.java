package com.devlog.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OAuthGithubAccessTokenResponse(
        @JsonProperty("access_token") String accessToken
) {
}
