package hcmute.edu.vn.uservice.repository;

import hcmute.edu.vn.uservice.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Items,Integer>{
    Optional<Items> findById(int id);
//    List<Product> findByCategory(long id);
}
