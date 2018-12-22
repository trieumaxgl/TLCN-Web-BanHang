package hcmute.edu.vn.adservice.service;

import hcmute.edu.vn.adservice.model.Role;
import hcmute.edu.vn.adservice.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User deleteUser(int id);

    List<User> findAll(Role role);
}
