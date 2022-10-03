package mil.usmc.dmol.security.authentication.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.csrf.CookieCsrfTokenRepository

@Configuration
@EnableWebSecurity
class AuthenticationConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests()
            .mvcMatchers(
                "/favicon*",
                "/landing-page-*.png",
                "/android-chrome-*.png",
                "/mstile-150x150",
                "/site.webmanifest",
                "/safari-pinned-tab.svg",
                "/actuator/health",
                "/apple-touch-icon.png",
                "/static/css/**",
                "/static/js/**",
                "/static/media/**",
            )
            .permitAll()
            .mvcMatchers("/api/v1/home/title").permitAll()
            .mvcMatchers(
                "/landing",
            )
            .authenticated()
            .anyRequest().authenticated()

        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())

        return http.build()
    }

}