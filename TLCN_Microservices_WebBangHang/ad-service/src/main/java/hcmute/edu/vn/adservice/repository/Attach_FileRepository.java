package hcmute.edu.vn.adservice.repository;

import hcmute.edu.vn.adservice.model.Attach_File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Attach_FileRepository extends JpaRepository<Attach_File,Integer>{
    @Query(value = "SELECT s FROM attach_file s " +
            "INNER JOIN s.items c " +
            "WHERE c.id = :id"
    )
    List<Attach_File> findItemByAttachFile(@Param("id") int id);
}
