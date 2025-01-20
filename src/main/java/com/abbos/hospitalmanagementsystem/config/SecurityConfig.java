package com.abbos.hospitalmanagementsystem.config;

import com.abbos.hospitalmanagementsystem.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 * @author Aliabbos Ashurov
 * @since 16/January/2025  10:06
 **/
@Configuration
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final SecurityBeansConfiguration beansConfiguration;
    private final PasswordEncoder passwordEncoder;
    private final CorsProperty corsProperty;
    private final AuthenticationFilter authenticationFilter;
    private final CustomUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()))
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests.requestMatchers(Constants.OPEN_PAGES).permitAll()
                                .anyRequest().authenticated()
                )
                .exceptionHandling(exceptions -> {
                    exceptions.accessDeniedHandler(beansConfiguration.accessDeniedHandler());
                    exceptions.authenticationEntryPoint(beansConfiguration.authenticationEntryPoint());
                })
                .sessionManagement(sessionManagement ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(AbstractHttpConfigurer::disable)
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf(AbstractHttpConfigurer::disable)
                .build();

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(corsProperty.getAllowedOrigins());
        configuration.setAllowedMethods(corsProperty.getAllowedMethods());
        configuration.setAllowedHeaders(corsProperty.getAllowedHeaders());
        configuration.setAllowCredentials(corsProperty.isAllowCredentials());
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(corsProperty.getUrlPattern(), configuration);
        return source;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(authenticationProvider());
    }
}
