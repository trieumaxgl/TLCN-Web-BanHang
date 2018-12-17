package hcmute.edu.vn.nuservice.api.v1.dto;

import hcmute.edu.vn.nuservice.model.Role;
import  lombok.Data;

@Data
public class UserDto {
    private String email;
    private String password;
    private Role role;
}
