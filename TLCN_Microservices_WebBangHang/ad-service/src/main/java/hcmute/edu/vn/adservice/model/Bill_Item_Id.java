package hcmute.edu.vn.adservice.model;

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
public class Bill_Item_Id implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Bill bill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Items items;


}
