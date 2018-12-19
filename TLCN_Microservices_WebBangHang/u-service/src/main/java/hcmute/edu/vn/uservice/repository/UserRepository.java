package hcmute.edu.vn.uservice.repository;

import hcmute.edu.vn.uservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmailAndPassword(String email, String pass);
    Optional<User> findByFirstnameAndLastname(String firstname, String lastname);
    Optional<User> findByEmailAndStatus(String email, int status);
}
