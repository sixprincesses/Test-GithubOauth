package com.devlog.github.client;

import com.devlog.github.mark.OAuthUserInfoResponse;

public interface OAuthClient {
    String getAccessToken(String code);

    OAuthUserInfoResponse getUserInfo(String accessToken);
}
