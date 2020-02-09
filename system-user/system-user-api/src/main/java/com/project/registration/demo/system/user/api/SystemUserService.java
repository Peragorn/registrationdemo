package com.project.registration.demo.system.user.api;

import com.project.registration.demo.system.user.api.request.SystemUserCreationRequest;

public interface SystemUserService {

    Long create(SystemUserCreationRequest request);
}
