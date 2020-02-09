package com.project.registration.demo.system.user.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.registration.demo.system.user.api.SystemUserService;
import com.project.registration.demo.system.user.api.request.SystemUserCreationRequest;
import com.project.registration.demo.system.user.mapping.SystemUser;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service
@Transactional
public class SystemUserServiceImpl implements SystemUserService {

    private final SystemUserRepository systemUserRepository;
    private final SystemUserMapper systemUserMapper;

    @Override
    public Long create(SystemUserCreationRequest request) {
        log.debug("Creating new system user {request: {}}", request);

        SystemUser newSystemUser = systemUserMapper.toSystemUser(request);
        SystemUser savedSystemUser = systemUserRepository.save(newSystemUser);

        log.info("System user created {systemUserId: {}}", savedSystemUser.getId());
        return savedSystemUser.getId();
    }
}
