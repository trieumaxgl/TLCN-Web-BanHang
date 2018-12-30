package hcmute.edu.vn.nuservice.repository;

import hcmute.edu.vn.nuservice.model.Items;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Items,Integer>{
    Optional<Items> findById(int id);
//    List<Product> findByCategory(long id);
    @Query(value = "SELECT p FROM items p WHERE UPPER(p.name)  LIKE UPPER(CONCAT ('%',:keyword,'%')) and p.status = 1")
    List<Items> findAllByName(@Param("keyword") String keyword);
}
