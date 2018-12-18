package hcmute.edu.vn.nuservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "bill")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private User user;

    private String address;

    private Long total;

    private Date date;

    private String phone;

    private int status;

    @OneToMany(mappedBy = "id.bill")
    @JsonBackReference
    private Set<Bill_Item> bill_items;

}
