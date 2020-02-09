package com.project.registration.demo.system.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.registration.demo.system.user.api.SystemUserService;
import com.project.registration.demo.system.user.api.request.SystemUserCreationRequest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
@Transactional
public class SystemUserServiceImpl implements SystemUserService {

    @Override
    public Long create(SystemUserCreationRequest request) {
        return null;
    }
}
