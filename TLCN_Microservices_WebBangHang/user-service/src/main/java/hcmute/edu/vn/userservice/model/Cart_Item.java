package hcmute.edu.vn.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="cart_item")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart_Item {

    @EmbeddedId
    private Cart_Item_Id id;

    private Long quantity;
}
