package hcmute.edu.vn.uservice.repository;

import hcmute.edu.vn.uservice.model.Cart_Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<Cart_Item, Long> {
    List<Cart_Item> findById_CartId(Long id);
}

