package com.project.registration.demo.entry.point.api;

import com.project.registration.demo.system.user.api.request.SystemUserCreationRequest;

public interface SystemUserApiService {

    Long create(SystemUserCreationRequest request);
}
