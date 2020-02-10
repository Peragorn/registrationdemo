package com.project.registration.demo.entry.point.starter.boundry.web;

import com.project.registration.demo.entry.point.api.SystemUserApiService;
import com.project.registration.demo.system.user.api.request.SystemUserUpdateRequest;
import com.project.registration.demo.system.user.api.response.SystemUserResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/system-user", produces = APPLICATION_JSON_VALUE)
public class SystemUserController {

    private final SystemUserApiService systemUserApiService;

    @PutMapping()
    @ResponseStatus(CREATED)
    @ResponseBody
    public void update(@Valid @NotNull SystemUserUpdateRequest request) {
        log.info("Received request to update system user {request: {}}", request);
        systemUserApiService.update(request);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(OK)
    @ResponseBody
    public void delete(@PathVariable("id") Long id) {
        log.info("Received request to delete system user {id: {}}", id);
        systemUserApiService.delete(id);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(OK)
    @ResponseBody
    public SystemUserResponse getById(@PathVariable("id") Long id) {
        log.info("Received request to find system user {id: {}}", id);
        return systemUserApiService.getById(id);
    }


}
