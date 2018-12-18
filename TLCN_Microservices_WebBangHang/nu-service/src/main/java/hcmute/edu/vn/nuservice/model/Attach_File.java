package hcmute.edu.vn.nuservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "attach_file")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attach_File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Items items;

    private String image;

}
