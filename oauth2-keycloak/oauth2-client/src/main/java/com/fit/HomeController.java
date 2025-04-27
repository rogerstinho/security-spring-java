package com.fit;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/hello")
    public String home(
    ) {
        return "Welcome to the home page! ";
    }

    @GetMapping("/user")
    public Object userInfo(
            // @AuthenticationPrincipal OAuth2User principal,
            // @AuthenticationPrincipal Jwt jwt
             @AuthenticationPrincipal OidcUser oidcUser
            // @AuthenticationPrincipal Principal principal
            // @AuthenticationPrincipal UserDetails userDetails
            // @AuthenticationPrincipal OAuth2AuthenticationToken token
            // @AuthenticationPrincipal OAuth2AuthorizedClient client
            // @AuthenticationPrincipal OAuth2AccessToken accessToken
            // @AuthenticationPrincipal OAuth2RefreshToken refreshToken
    ) {
        return oidcUser;
    }

}
