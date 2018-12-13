package hcmute.edu.vn.uservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int discount;

    private Date dateStart;

    private Date dateEnd;

    @ManyToMany
    @JoinTable(
            name = "sale_item",
            joinColumns = @JoinColumn(name = "saleId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "itemId", referencedColumnName = "id")
    )
    private Set<Items> items;

}