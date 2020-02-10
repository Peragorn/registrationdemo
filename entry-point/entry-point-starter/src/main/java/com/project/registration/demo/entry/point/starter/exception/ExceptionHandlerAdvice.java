package com.project.registration.demo.entry.point.starter.exception;

import static com.project.registration.demo.entry.point.api.response.ResponseStatus.DELETE_EXCEPTION;
import static com.project.registration.demo.entry.point.api.response.ResponseStatus.USER_NOT_FOUND;
import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Predicates.instanceOf;
import static org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.project.registration.demo.entry.point.api.response.InfoResponse;
import com.project.registration.demo.entry.point.api.response.ResponseStatus;
import com.project.registration.demo.system.user.service.exception.SystemUserDeleteException;
import com.project.registration.demo.system.user.service.exception.SystemUserNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    ResponseEntity<InfoResponse> exceptionProcessor(Exception ex) {
        return Match(ex).of(
                Case($(instanceOf(SystemUserDeleteException.class)), e -> createInfoResponse(DELETE_EXCEPTION, e, METHOD_NOT_ALLOWED)),
                Case($(instanceOf(SystemUserNotFoundException.class)), e -> createInfoResponse(USER_NOT_FOUND, e, NOT_FOUND))
        );
    }

    private ResponseEntity<InfoResponse> createInfoResponse(ResponseStatus status, Exception e, HttpStatus httpStatus) {
        log.error("Caught exception: {}", e.getMessage());

        return new ResponseEntity<>(new InfoResponse(status, e.getMessage()), httpStatus);
    }

}
