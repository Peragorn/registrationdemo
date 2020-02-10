package com.project.registration.demo.system.user.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemUserResponse {

    private Long id;

    private Long version;

    private String name;

    private String surname;

    private String login;

    private String email;

}
