package hcmute.edu.vn.nuservice.api.v1.dto;

import  lombok.Data;

@Data
public class UserDto {
    private String email;
    private String password;
    private int role;
}
