package hcmute.edu.vn.dbservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "ne_roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToMany(mappedBy = "roles")
    private Set<User> user_role;
    @ManyToMany(mappedBy = "roles")
    private Set<Permission> permissions;
}

