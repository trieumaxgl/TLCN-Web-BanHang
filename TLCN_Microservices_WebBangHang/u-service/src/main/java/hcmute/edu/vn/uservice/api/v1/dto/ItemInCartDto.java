package hcmute.edu.vn.uservice.api.v1.dto;

import lombok.Data;

@Data
public class ItemInCartDto {
    private int id;
    private String name;
    private String description;
    private Long price;
    private Long quantity;
    private String type;
}

