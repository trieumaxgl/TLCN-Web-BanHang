package hcmute.edu.vn.userservice.service.impl;

import hcmute.edu.vn.userservice.repository.RoleRepository;
import hcmute.edu.vn.userservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleRepository getRepo() {
        return roleRepository;
    }
}
