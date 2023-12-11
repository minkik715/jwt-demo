package io.github.minkik715.jwtdemo.config;


import io.github.minkik715.jwtdemo.jwt.JwtTokenManager;
import io.github.minkik715.jwtdemo.jwt.YellowHouseJwtTokenAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtTokenManager jwtTokenManager;
    @Bean
    SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .anonymous(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .sessionManagement(AbstractHttpConfigurer::disable)
                .addFilterAfter(new YellowHouseJwtTokenAuthFilter(jwtTokenManager), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(
                        (request) -> {
                            request
                                    .requestMatchers("/api/auth/**").permitAll()
                                    .requestMatchers("/error/**").permitAll()
                                    .anyRequest().authenticated();
                        }
                );
        return http.build();
    }
}

