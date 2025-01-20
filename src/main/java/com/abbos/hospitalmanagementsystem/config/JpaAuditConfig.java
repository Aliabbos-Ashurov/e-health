package com.abbos.hospitalmanagementsystem.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * @author Aliabbos Ashurov
 * @since 16/January/2025  10:46
 **/
@Configuration
@EnableJpaAuditing
@RequiredArgsConstructor
public class JpaAuditConfig {
    private final SessionUser sessionUser;

    @Bean
    public AuditorAware<Long> auditorAware() {
        return () -> Optional.of(sessionUser.getID());
    }
}
