package com.mapProject.server.config;


import com.mapProject.server.entity.User;
import com.mapProject.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomTokenEnhancer implements TokenEnhancer {

        @Autowired
        UserService userService;

        public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
            final Map<String, Object> additionalInfo = new HashMap<String, Object>();
            Object principal = oAuth2Authentication.getPrincipal();
            if (principal instanceof org.springframework.security.core.userdetails.User) {
                String userName = ((User) principal).getUsername();
                additionalInfo.put("status", "ok");
            }
            ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(additionalInfo);
            return oAuth2AccessToken;
        }
    }
