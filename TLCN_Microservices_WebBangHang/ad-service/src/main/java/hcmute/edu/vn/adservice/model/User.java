package hcmute.edu.vn.adservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date birthday;

    private int gender;

    @Size(max=2000000)
    private String avatar;

    private String address;

    private String phone;

    private String email;

    private String password;

    private String firstname;

    private String lastname;

    private int status;

    private String description;

    @OneToOne( fetch = FetchType.LAZY)
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Role roles;
    
    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private Set<Bill> bills;

}


