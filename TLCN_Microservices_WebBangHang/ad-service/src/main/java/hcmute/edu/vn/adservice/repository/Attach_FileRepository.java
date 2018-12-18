package hcmute.edu.vn.adservice.repository;

import hcmute.edu.vn.adservice.model.Attach_File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Attach_FileRepository extends JpaRepository<Attach_File,Integer>{
    //Optional<Attach_File> findByItemId(int itemId);
}
