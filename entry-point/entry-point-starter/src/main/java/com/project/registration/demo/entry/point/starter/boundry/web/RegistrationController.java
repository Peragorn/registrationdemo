package com.project.registration.demo.entry.point.starter.boundry.web;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.registration.demo.entry.point.api.SystemUserApiService;
import com.project.registration.demo.system.user.api.request.SystemUserCreationRequest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/register", produces = APPLICATION_JSON_VALUE)
public class RegistrationController {

    private final SystemUserApiService systemUserApiService;

    @PostMapping()
    @ResponseStatus(CREATED)
    @ResponseBody
    public Long create(@Valid @NotNull SystemUserCreationRequest request) {
        log.info("Received request to create system user {request: {}}", request);
        return systemUserApiService.create(request);
    }
}

