package hcmute.edu.vn.nuservice.repository;

import hcmute.edu.vn.nuservice.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{
    Optional<Cart> findById(Long id);
}
