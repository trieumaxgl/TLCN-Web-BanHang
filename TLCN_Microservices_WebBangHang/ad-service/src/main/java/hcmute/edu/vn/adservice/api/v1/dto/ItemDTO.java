package hcmute.edu.vn.adservice.api.v1.dto;

import lombok.Data;

@Data
public class ItemDTO {

    private int id;

    private int typesId;

    private String name;

    private String description;

    private String status;

    private Long price;

}
