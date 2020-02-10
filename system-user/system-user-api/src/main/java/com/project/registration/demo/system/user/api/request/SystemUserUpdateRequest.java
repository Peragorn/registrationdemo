package com.project.registration.demo.system.user.api.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
public class SystemUserUpdateRequest {

    @NotNull
    private Long id;

    @Size(max = 100)
    private String name;

    @Size(max = 100)
    private String surname;

    @Size(max = 255)
    private String email;

    @Size(max = 60)
    private String password;
}
