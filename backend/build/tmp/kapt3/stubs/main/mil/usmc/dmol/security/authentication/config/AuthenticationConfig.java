package mil.usmc.dmol.security.authentication.config;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017\u00a8\u0006\u0007"}, d2 = {"Lmil/usmc/dmol/security/authentication/config/AuthenticationConfig;", "", "()V", "securityFilterChain", "Lorg/springframework/security/web/SecurityFilterChain;", "http", "Lorg/springframework/security/config/annotation/web/builders/HttpSecurity;", "backend"})
@org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
@org.springframework.context.annotation.Configuration
public class AuthenticationConfig {
    
    public AuthenticationConfig() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @org.springframework.context.annotation.Bean
    public org.springframework.security.web.SecurityFilterChain securityFilterChain(@org.jetbrains.annotations.NotNull
    org.springframework.security.config.annotation.web.builders.HttpSecurity http) {
        return null;
    }
}