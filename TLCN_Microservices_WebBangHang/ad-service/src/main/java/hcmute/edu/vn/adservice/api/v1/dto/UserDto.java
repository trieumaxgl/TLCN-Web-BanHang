package hcmute.edu.vn.adservice.api.v1.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDto {
    private int id;
    private String email;
    private Date birthday;
    private int gender;
    private String avatar;
    private String address;
    private String phone;
    private String firstname;
    private String lastname;
    private String description;
    private int status;
    private int role;

}
