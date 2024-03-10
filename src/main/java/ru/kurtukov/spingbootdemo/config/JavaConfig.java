package ru.kurtukov.spingbootdemo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import ru.kurtukov.spingbootdemo.profile.DevProfile;
import ru.kurtukov.spingbootdemo.profile.SystemProfile;
import ru.kurtukov.spingbootdemo.profile.ProductionProfile;

public class JavaConfig {
    @Bean
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "true", matchIfMissing = true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(prefix = "netology.profile", name = "dev", havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
