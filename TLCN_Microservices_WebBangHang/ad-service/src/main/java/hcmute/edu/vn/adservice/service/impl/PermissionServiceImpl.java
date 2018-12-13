package hcmute.edu.vn.adservice.service.impl;

import hcmute.edu.vn.adservice.model.Permission;
import hcmute.edu.vn.adservice.repository.PermissionRepository;
import hcmute.edu.vn.adservice.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionRepository permissionRepository;


    @Override
    public Optional<Permission> findById(int id,int status)
    {
        return permissionRepository.findByIdAndStatus(id,status);
    }

    @Override
    public Permission savePermission(Permission permission)
    {
        return permissionRepository.save(permission);
    }

    @Override
    public Permission deletePermission(int id, int status) {
        Permission permission = permissionRepository.findById(id).get();
        if(permission.getStatus() == 0){
            permission.setStatus(status);
        }
        return permissionRepository.save(permission);
    }

    @Override
    public List<Permission> findAll(int status) {
        return permissionRepository.findAllByStatus(status);
    }
}
