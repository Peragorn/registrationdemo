package com.project.registration.demo.entry.point.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.registration.demo.entry.point.api.SystemUserApiService;
import com.project.registration.demo.system.user.api.SystemUserService;
import com.project.registration.demo.system.user.api.request.SystemUserCreationRequest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Transactional
@Service
public class MainSystemUserService implements SystemUserApiService {

    private final SystemUserService systemUserService;

    @Override
    public Long create(SystemUserCreationRequest request) {

        return systemUserService.create(request);
    }
}