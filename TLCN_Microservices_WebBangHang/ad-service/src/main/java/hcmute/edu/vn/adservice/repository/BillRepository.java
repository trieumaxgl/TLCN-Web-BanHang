package hcmute.edu.vn.adservice.repository;

import hcmute.edu.vn.adservice.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill,Integer> {
    Optional<Bill> findById(int id);
}
