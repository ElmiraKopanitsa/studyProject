package dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomUserDto {

    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;
    @NotBlank
    @Size(max = 50)
    private String lastName;
    @NotNull
    @Min(value = 16, message = "Must be at least 16 years of age")
    @Max(value = 100, message = "Must be no more than 100 years old")
    private Integer age;
    @NotBlank
    @Email
    @Size(max = 50)
    private String email;
    @NotBlank
    @Pattern(regexp = "^\\+\\d{20}$",
            message = "Enter the telephone number in the format +ХХХХХХХХХХ")
    private String phone;
    @NotBlank
    @Size(max = 50)
    private String login;
    @NotBlank
    @Size(max = 50)
    private String password;

    private List<RoleDto> roles;
}