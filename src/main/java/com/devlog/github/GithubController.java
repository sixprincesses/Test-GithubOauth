package com.devlog.github;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GithubController {

    private final GithubOAuthClient githubOAuthClient;

    // https://github.com/login/oauth/authorize?client_id={client_id}
    @GetMapping("/users/github/callback")
    public ResponseEntity<Object> authorize(@RequestParam String code) {
        return ResponseEntity.ok(githubOAuthClient.getUserInfo(githubOAuthClient.getAccessToken(code)));
    }
}
