package hcmute.edu.vn.adservice.repository;

import hcmute.edu.vn.adservice.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Items, Integer>{
    Optional<Items> findByIdAndStatus(int id, int status);
    Optional<Items> findById(int id);
    List<Items> findAllByStatus(int status);
}