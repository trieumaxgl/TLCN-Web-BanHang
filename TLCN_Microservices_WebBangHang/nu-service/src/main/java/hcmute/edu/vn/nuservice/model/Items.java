package hcmute.edu.vn.nuservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Type types;

    private String name;

    private String description;

    private String status;

    private Long price;

    @OneToMany(mappedBy = "items")
    private Set<Attach_File> attachFiles;

    @ManyToMany(mappedBy = "items")
    private Set<Sale> sales;

    @OneToMany(mappedBy = "id.items")
    private Set<Bill_Item> bill_items;

    @OneToMany(mappedBy = "id.items")
    private Set<Cart_Item> cart_items;
}