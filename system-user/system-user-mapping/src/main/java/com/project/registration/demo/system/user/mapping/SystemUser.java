package com.project.registration.demo.system.user.mapping;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "password")
@Builder
@Entity
@Table(schema = "system_users")
public class SystemUser {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Version
    private Long version;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Size(min = 1, max = 100)
    private String surname;

    @NotNull
    @Size(min = 1, max = 50)
    private String login;

    @NotNull
    @Size(min = 5, max = 255)
    private String email;

    @NotNull
    @Size(min = 8, max = 60)
    private String password;
}
