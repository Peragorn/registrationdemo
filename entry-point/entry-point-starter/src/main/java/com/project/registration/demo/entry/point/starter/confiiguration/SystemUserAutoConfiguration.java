package com.project.registration.demo.entry.point.starter.confiiguration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.project.registration.demo.entry.point.api.SystemUserApiService;
import com.project.registration.demo.entry.point.service.MainSystemUserService;

@Configuration
public class SystemUserAutoConfiguration {

    @ConditionalOnMissingBean(SystemUserApiService.class)
    @Import({MainSystemUserService.class})
    @Configuration
    public static class EmailConfiguration {
    }
}
