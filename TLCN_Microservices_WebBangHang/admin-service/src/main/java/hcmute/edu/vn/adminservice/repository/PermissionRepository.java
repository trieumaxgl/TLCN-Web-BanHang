package hcmute.edu.vn.adminservice.repository;

import hcmute.edu.vn.adminservice.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

    Optional<Permission> findById(int id);


}
