package hcmute.edu.vn.nuservice.repository;

import hcmute.edu.vn.nuservice.model.Role;
import hcmute.edu.vn.nuservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findById(int uid);
    Optional<User> findByEmailAndPassword(String email, String pass);
}
