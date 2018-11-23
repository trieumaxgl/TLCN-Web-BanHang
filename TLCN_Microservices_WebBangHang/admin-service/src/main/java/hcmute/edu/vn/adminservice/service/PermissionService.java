package hcmute.edu.vn.adminservice.service;

import hcmute.edu.vn.adminservice.model.Permission;

import java.util.List;
import java.util.Optional;

public interface PermissionService {

    Optional<Permission> findById(int id, int delFlag);

    Permission savePermission(Permission permission);

    Permission deletePermission(int id, int delFlag);

    List<Permission> findAll(int delFlag);
}