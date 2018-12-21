package hcmute.edu.vn.adservice.api.v1.dto;

import lombok.Data;

@Data
public class BillitemDto {
    private int id;
    private String name;
    private String description;
    private Long price;
    private Long quantity;
    private int type;
}
