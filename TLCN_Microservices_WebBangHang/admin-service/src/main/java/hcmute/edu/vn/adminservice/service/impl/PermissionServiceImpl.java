package hcmute.edu.vn.adminservice.service.impl;

import hcmute.edu.vn.adminservice.model.Permission;
import hcmute.edu.vn.adminservice.repository.PermissionRepository;
import hcmute.edu.vn.adminservice.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionRepository permissionRepository;


    @Override
    public Optional<Permission> findById(int id) {
        return permissionRepository.findById(id);
    }

    @Override
    public Permission savePermission(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public Permission deletePermission(int id, int delFlag) {
        Permission permission = permissionRepository.findById(id).get();
        if(permission.getDelFlag() == 0){
            permission.setDelFlag(delFlag);
        }
        return permissionRepository.save(permission);
    }

    @Override
    public List<Permission> findAll(int delFlag) {
        return permissionRepository.findAllByDelFlag(delFlag);
    }
}
