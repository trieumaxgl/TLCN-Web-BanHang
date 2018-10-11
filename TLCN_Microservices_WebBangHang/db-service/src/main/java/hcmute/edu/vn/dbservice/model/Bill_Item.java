package hcmute.edu.vn.dbservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "ne_bill_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill_Item {

    @EmbeddedId
    private Bill_Item_Id id;

    private int quantity;

    private Long total;

    private int status;
}
