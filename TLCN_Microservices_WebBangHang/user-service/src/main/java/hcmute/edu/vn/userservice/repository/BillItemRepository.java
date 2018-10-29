package hcmute.edu.vn.userservice.repository;

import hcmute.edu.vn.userservice.model.Bill_Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillItemRepository extends JpaRepository<Bill_Item, Long>{
}
