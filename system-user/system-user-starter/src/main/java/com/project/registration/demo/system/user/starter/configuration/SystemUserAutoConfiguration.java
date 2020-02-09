package com.project.registration.demo.system.user.starter.configuration;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.registration.demo.system.user.api.SystemUserService;
import com.project.registration.demo.system.user.mapping.SystemUser;
import com.project.registration.demo.system.user.service.SystemUserMapperImpl;
import com.project.registration.demo.system.user.service.SystemUserRepository;
import com.project.registration.demo.system.user.service.SystemUserServiceImpl;

@AutoConfigureBefore(JpaRepositoriesAutoConfiguration.class)
@Configuration
public class SystemUserAutoConfiguration {

    @ConditionalOnMissingBean(SystemUserService.class)
    @Import({SystemUserServiceImpl.class, SystemUserMapperImpl.class})
    @Configuration
    public static class SystemUserServiceConfiguration {
    }

    @EntityScan(basePackageClasses = SystemUser.class)
    @EnableJpaRepositories(basePackageClasses = SystemUserRepository.class)
    @Configuration
    public static class SystemUserRepositoryConfiguration {
    }

    @ConditionalOnMissingBean(PasswordEncoder.class)
    @Import(PasswordEncoderConfiguration.class)
    @Configuration
    public static class PasswordEncoderAutoConfiguration {
    }
}
