package hcmute.edu.vn.uservice.api.v1.dto;

import hcmute.edu.vn.uservice.model.Role;
import lombok.Data;

@Data
public class UserDto {
    private String email;
    private String password;
    private Role role;
}
