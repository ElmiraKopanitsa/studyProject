package dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RoleDto {

    @NotBlank
    @Size(max = 20)
    private String role;
}
