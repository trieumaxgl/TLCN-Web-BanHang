package hcmute.edu.vn.adservice.service.impl;

import hcmute.edu.vn.adservice.model.Role;
import hcmute.edu.vn.adservice.repository.RoleRepository;
import hcmute.edu.vn.adservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findById(int id){
        Optional<Role> role = roleRepository.findById(id);
        return role.get();
    }
}
