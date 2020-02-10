package com.project.registration.demo.system.user.api;

import com.project.registration.demo.system.user.api.request.SystemUserCreationRequest;
import com.project.registration.demo.system.user.api.request.SystemUserUpdateRequest;
import com.project.registration.demo.system.user.api.response.SystemUserResponse;

public interface SystemUserService {

    Long create(SystemUserCreationRequest request);

    void update(SystemUserUpdateRequest request);

    void deleteById(Long id);

    SystemUserResponse getById(Long id);
}
