package hcmute.edu.vn.adservice.repository;

import hcmute.edu.vn.adservice.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Items, Integer>{
    Optional<Items> findByIdAndStatus(int id, int status);
    Optional<Items> findById(int id);
    @Query(value = "SELECT s FROM items s " +
            "INNER JOIN s.types c " +
            "WHERE c.id = :typesId"
    )
    List<Items> findItemByType(@Param("typesId") int typesId);
    List<Items> findAllByStatus(int status);
}