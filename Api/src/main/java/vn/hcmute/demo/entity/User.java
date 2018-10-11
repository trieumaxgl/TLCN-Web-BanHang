package vn.hcmute.demo.entity;

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

    private int status;

    private Date dateCreated;

    private String userCreated;

    private Date dateUpdated;

    private String userUpdated;

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    private Account account;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ne_user_role",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id")
    )
    private Set<Role> roles;


}


