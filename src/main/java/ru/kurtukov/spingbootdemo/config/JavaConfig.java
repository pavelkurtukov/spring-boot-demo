package ru.kurtukov.spingbootdemo.config;

import org.springframework.context.annotation.Bean;
import ru.kurtukov.spingbootdemo.profile.DevProfile;
import ru.kurtukov.spingbootdemo.profile.SystemProfile;
import ru.kurtukov.spingbootdemo.profile.ProductionProfile;

public class JavaConfig {
    @Bean
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
