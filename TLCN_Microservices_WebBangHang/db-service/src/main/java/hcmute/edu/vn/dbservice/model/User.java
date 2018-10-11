package hcmute.edu.vn.dbservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "ne_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date birthday;

    private int gender;

    private byte[] avatar;

    private String address;

    private String phone;

    private String email;

    private String password;

    private String firstname;

    private String lastname;

    private int status;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role roles;

    @OneToMany(mappedBy = "user")
    private Set<Bill> bills;

}


