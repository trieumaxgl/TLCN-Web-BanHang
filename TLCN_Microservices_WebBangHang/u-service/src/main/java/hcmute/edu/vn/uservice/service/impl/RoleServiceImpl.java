package hcmute.edu.vn.uservice.service.impl;

import hcmute.edu.vn.uservice.repository.RoleRepository;
import hcmute.edu.vn.uservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleRepository getRepo() {
        return roleRepository;
    }
}
