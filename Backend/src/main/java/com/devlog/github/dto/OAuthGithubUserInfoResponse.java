package com.devlog.github.dto;

import com.devlog.github.mark.OAuthUserInfoResponse;
import com.fasterxml.jackson.annotation.JsonProperty;

public record OAuthGithubUserInfoResponse(
        @JsonProperty("id") Long id,
        @JsonProperty("login") String login
) implements OAuthUserInfoResponse {
}
