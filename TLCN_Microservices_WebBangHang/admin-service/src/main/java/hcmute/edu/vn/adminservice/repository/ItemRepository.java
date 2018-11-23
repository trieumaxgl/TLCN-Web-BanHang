package hcmute.edu.vn.adminservice.repository;

import hcmute.edu.vn.adminservice.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Items, Integer>{
    Optional<Items> findByIdAndStatus(int id, int delFlag);

    List<Items> findAllByStatus(int delFlag);
}