package com.project.registration.demo.entry.point.service;

import com.project.registration.demo.entry.point.api.SystemUserApiService;
import com.project.registration.demo.system.user.api.SystemUserService;
import com.project.registration.demo.system.user.api.request.SystemUserCreationRequest;
import com.project.registration.demo.system.user.api.request.SystemUserUpdateRequest;
import com.project.registration.demo.system.user.api.response.SystemUserResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public void update(SystemUserUpdateRequest request) {
        systemUserService.update(request);
    }

    @Override
    public void delete(Long id) {
        systemUserService.deleteById(id);
    }

    @Override
    public SystemUserResponse getById(Long id) {
        return systemUserService.getById(id);
    }
}
