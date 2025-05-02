package com.fit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.method.PrePostTemplateDefaults;
import org.springframework.security.core.annotation.AnnotationTemplateExpressionDefaults;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    UserDetailsService userDetailsService() {
        var roger = User.withUsername("roger")
                .password("{noop}password")
                .build();
        var ali = User.withUsername("ali")
                .password("{noop}password")
                .build();
        var accountant = User.withUsername("accountant")
                .password("{noop}password")
                .roles("ACCOUNTANT")
                .build();

        return new InMemoryUserDetailsManager(roger, ali, accountant);
    }

    @Bean
    AnnotationTemplateExpressionDefaults prePostTemplateDefaults() {
        return new AnnotationTemplateExpressionDefaults();
    }
}
