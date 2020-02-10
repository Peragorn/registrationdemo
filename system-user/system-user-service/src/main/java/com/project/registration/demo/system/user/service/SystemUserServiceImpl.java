package com.project.registration.demo.system.user.service;

import com.project.registration.demo.system.user.api.SystemUserService;
import com.project.registration.demo.system.user.api.request.SystemUserCreationRequest;
import com.project.registration.demo.system.user.api.request.SystemUserUpdateRequest;
import com.project.registration.demo.system.user.api.response.SystemUserResponse;
import com.project.registration.demo.system.user.mapping.SystemUser;
import com.project.registration.demo.system.user.service.exception.SystemUserDeleteException;
import com.project.registration.demo.system.user.service.exception.SystemUserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;

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

    @Override
    public void update(SystemUserUpdateRequest request) {
        log.debug("Updating system user {request: {}}", request);

        SystemUser systemUser = findById(request.getId());
        systemUserMapper.toSystemUser(request, systemUser);

        log.info("Updated system user {request: {}}", request);
    }

    @Override
    public void deleteById(Long id) {
        log.debug("Deleting system user {id: {}}", id);

        if (systemUserRepository.existsById(id)) {
            systemUserRepository.deleteById(id);
        } else {
            throw new SystemUserDeleteException("Problem during deleting system user by id");
        }

        log.debug("Deleted system user {id: {}}", id);
    }

    @Override
    public SystemUserResponse getById(Long id) {
        SystemUser user = findById(id);
        return systemUserMapper.toSystemUserResponse(user);
    }

    private SystemUser findById(Long id) {
        return ofNullable(systemUserRepository.findById(id))
                .orElseThrow(() -> new SystemUserNotFoundException(
                        format("Cannot find user by id {systemUserId: %s}", id))).get();
    }
}
