package hcmute.edu.vn.nuservice.api.v1.dto;

import  lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Date birthday;
    private int role;
}
