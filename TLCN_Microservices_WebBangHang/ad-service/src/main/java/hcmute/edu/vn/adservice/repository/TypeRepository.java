package hcmute.edu.vn.adservice.repository;

import hcmute.edu.vn.adservice.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface TypeRepository extends JpaRepository<Type, Integer>{
    Optional<Type> findByIdAndStatus(int id, int status);
}
