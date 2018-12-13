package hcmute.edu.vn.adservice.service;

import hcmute.edu.vn.adservice.model.Permission;

import java.util.List;
import java.util.Optional;

public interface PermissionService {

    Optional<Permission> findById(int id,int status);

    Permission savePermission(Permission permission);

    Permission deletePermission(int id, int status);

    List<Permission> findAll(int status);
}