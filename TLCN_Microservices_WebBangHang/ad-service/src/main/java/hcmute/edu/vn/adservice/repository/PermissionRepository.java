package hcmute.edu.vn.adservice.repository;

import hcmute.edu.vn.adservice.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

    Optional<Permission> findByIdAndStatus(int id, int status);

    List<Permission> findAllByStatus(int status);
}
