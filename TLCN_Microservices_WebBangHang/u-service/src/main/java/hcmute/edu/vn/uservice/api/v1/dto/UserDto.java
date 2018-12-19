package hcmute.edu.vn.uservice.api.v1.dto;

import hcmute.edu.vn.uservice.model.Role;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class UserDto {
    private String email;
    private String password;
    private Date birthday;
    private int gender;
    private String avatar;
    private String address;
    private String phone;
    private String firstname;
    private String lastname;
    private String description;
}
