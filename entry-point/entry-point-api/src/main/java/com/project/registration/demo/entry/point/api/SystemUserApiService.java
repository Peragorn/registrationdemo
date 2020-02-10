package com.project.registration.demo.entry.point.api;

import com.project.registration.demo.system.user.api.request.SystemUserCreationRequest;
import com.project.registration.demo.system.user.api.request.SystemUserUpdateRequest;
import com.project.registration.demo.system.user.api.response.SystemUserResponse;

public interface SystemUserApiService {

    Long create(SystemUserCreationRequest request);

    void update(SystemUserUpdateRequest request);

    void delete(Long id);

    SystemUserResponse getById(Long id);
}
