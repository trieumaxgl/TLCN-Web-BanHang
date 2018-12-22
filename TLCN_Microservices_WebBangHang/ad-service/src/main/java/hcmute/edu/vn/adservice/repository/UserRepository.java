package hcmute.edu.vn.adservice.repository;

import hcmute.edu.vn.adservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByEmailAndStatus(String email, int status);

    List<User> findAllByStatus(int status);
}