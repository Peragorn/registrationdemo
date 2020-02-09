package com.project.registration.demo.system.user.api.request;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemUserCreationRequest {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Size(max = 100)
    private String surname;

    @NotBlank
    @Size(max = 50)
    private String login;

    @NotBlank
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(max = 60)
    private String password;
}
