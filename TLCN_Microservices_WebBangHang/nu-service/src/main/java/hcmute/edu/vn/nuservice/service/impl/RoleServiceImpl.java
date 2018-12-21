package hcmute.edu.vn.nuservice.service.impl;

import hcmute.edu.vn.nuservice.exception.NotFoundException;
import hcmute.edu.vn.nuservice.model.Role;
import hcmute.edu.vn.nuservice.repository.RoleRepository;
import hcmute.edu.vn.nuservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findById(int id) {
        Optional<Role> role = roleRepository.findById(id);
        if(!role.isPresent())
            throw new NotFoundException("Role Not Found !!!");

        return role.get();
    }
}
