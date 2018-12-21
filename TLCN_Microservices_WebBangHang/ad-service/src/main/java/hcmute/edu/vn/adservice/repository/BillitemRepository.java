package hcmute.edu.vn.adservice.repository;

import hcmute.edu.vn.adservice.model.Bill_Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillitemRepository extends JpaRepository<Bill_Item,Long> {
    List<Bill_Item> findById_BillId(int id);
}
