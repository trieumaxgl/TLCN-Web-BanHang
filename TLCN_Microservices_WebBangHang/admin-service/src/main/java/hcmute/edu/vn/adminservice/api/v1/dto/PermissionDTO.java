package hcmute.edu.vn.adminservice.api.v1.dto;

import lombok.Data;


@Data
public class PermissionDTO {
    private Long id;

    private String name;

    private int delFlag;

}
