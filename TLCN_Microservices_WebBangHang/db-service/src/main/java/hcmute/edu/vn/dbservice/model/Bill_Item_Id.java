package hcmute.edu.vn.dbservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Bill_Item_Id implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    private Bill bill;

    @ManyToOne(fetch = FetchType.LAZY)
    private Items items;


}
