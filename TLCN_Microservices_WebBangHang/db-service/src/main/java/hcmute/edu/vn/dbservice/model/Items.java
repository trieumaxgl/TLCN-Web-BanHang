package hcmute.edu.vn.dbservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    private Type types;

    private String name;

    private String description;

    private int status;

    private Long price;

    @OneToMany(mappedBy = "items")
    @JsonBackReference
    private Set<Attach_File> attachFiles;

    @ManyToMany(mappedBy = "items")
    @JsonManagedReference
    private Set<Sale> sales;

    @OneToMany(mappedBy = "id.items")
    @JsonBackReference
    private Set<Bill_Item> bill_items;

    @OneToMany(mappedBy = "id.items")
    @JsonBackReference
    private Set<Cart_Item> cart_items;
}