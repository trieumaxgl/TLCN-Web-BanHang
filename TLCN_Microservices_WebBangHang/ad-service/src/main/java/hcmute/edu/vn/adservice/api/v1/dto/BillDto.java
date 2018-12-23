package hcmute.edu.vn.adservice.api.v1.dto;

import lombok.Data;
import java.util.Date;

@Data
public class BillDto {
    private int id;
    private String address;
    private Date date;
    private String phone;
    private int status;
    private Long total;
    private String email;
    private String firstname;
    private String lastname;
}
