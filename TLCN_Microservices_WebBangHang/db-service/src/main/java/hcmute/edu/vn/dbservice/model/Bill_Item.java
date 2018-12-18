package hcmute.edu.vn.dbservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "bill_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill_Item {

    @EmbeddedId
    private Bill_Item_Id id;

    private Long quantity;

    private Long total;

    private int status;
}
