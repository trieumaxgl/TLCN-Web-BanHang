package hcmute.edu.vn.nuservice.api.v1.dto;

import lombok.Data;

@Data
public class CartDto {
    private String name;
    private String description;
    private Long price;
    private Long quantity;
}
