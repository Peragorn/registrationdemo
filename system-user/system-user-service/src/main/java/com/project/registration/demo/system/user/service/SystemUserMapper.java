package com.project.registration.demo.system.user.service;

import com.project.registration.demo.system.user.api.request.SystemUserCreationRequest;
import com.project.registration.demo.system.user.api.request.SystemUserUpdateRequest;
import com.project.registration.demo.system.user.api.response.SystemUserResponse;
import com.project.registration.demo.system.user.mapping.SystemUser;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public abstract class SystemUserMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Mappings({
            @Mapping(target = "password", expression = "java(passwordEncoder.encode(request.getPassword()))"),
    })
    abstract SystemUser toSystemUser(SystemUserCreationRequest request);

    @Mappings({
            @Mapping(target = "password", expression = "java(passwordEncoder.encode(request.getPassword()))"),
    })
    abstract SystemUser toSystemUser(SystemUserUpdateRequest request, @MappingTarget SystemUser systemUser);

    public abstract SystemUserResponse toSystemUserResponse(SystemUser user);
}
