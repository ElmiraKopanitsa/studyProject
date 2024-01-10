package kz.kopznitsa.web1.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Set;

@Data
@EqualsAndHashCode
public class CustomUser {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private LocalDate birthday;
    private String phone;
    private String login;
    private String password;
    private Set<Role> roles;
}
