package com.project.registration.demo.system.user.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.registration.demo.system.user.api.request.SystemUserCreationRequest;
import com.project.registration.demo.system.user.mapping.SystemUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Mapper(componentModel = "spring")
public abstract class SystemUserMapper {

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Mappings({
            @Mapping(target = "password", expression = "java(passwordEncoder.encode(request.getPassword()))"),
    })
    abstract SystemUser toSystemUser(SystemUserCreationRequest request);

}
