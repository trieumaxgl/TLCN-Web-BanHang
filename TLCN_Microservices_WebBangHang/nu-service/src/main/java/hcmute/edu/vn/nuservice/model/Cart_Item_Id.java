package hcmute.edu.vn.nuservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Cart_Item_Id implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Items items;
}
